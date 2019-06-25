package com.jctp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiAccessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.jctp.beans.Course;
import com.jctp.beans.CourseJob;
import com.jctp.beans.Question;
import com.jctp.beans.StudentJob;
import com.jctp.beans.StudentQuestions;
import com.jctp.beans.User;
import com.jctp.mapper.StudentMapper;
import com.jctp.model.JobModel;
import com.jctp.model.RequestModel;
import com.jctp.model.ResponseModel;
import com.jctp.service.StudentService;
import com.jctp.tools.JavaStringCompiler;
import com.jctp.tools.StringTools;
import com.jctp.tools.TextCosine;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private  TextCosine textCosine;
	
	@Autowired
	private JavaStringCompiler javaStringCompiler;
	
	@Override
	@Transactional
	public ResponseModel<Course> listCourses(int classId) {
		// TODO Auto-generated method stub
		int total=studentMapper.getCoursesTotal(classId);
		List<Course> courses=studentMapper.listCourses(classId);
		return new ResponseModel<Course>(courses, total);
	}
	
	@Override
	@Transactional
	public ResponseModel<StudentJob> listCourseJobs(RequestModel<StudentJob> reqModel,int studentId) {
		// TODO Auto-generated method stub
		int courseId=reqModel.getParam().getCourseId();
		String state=String.valueOf(reqModel.getParam().getState());
		//状态为-1则显示所有的数据
		if(state.equals("-1"))
			state="0,1,2,3";
		List<StudentJob> studentJobs=studentMapper.getStudentJobsList(courseId,studentId,state);
		for(StudentJob sj:studentJobs) {
			/*
			 * 	0-待做
				1-重新编辑
				2-已过期
				3-待批阅
			 */
			if(sj.getLastTime().equals("overtime")) {
				if(sj.getState()==0) {
					sj.setState(2);
					studentMapper.updateJobState(sj.getId(),sj.getState());
				}
				if(sj.getState()==1) {
					sj.setState(3);
					studentMapper.updateJobState(sj.getId(),sj.getState());
				}
			}
		}
		int total=studentJobs.size();
		return new ResponseModel<StudentJob>(studentJobs,total);
	}



	@Override
	public Map<String, List<StudentQuestions>> doJob(int jid, int userId,Model model) {
		
		// TODO Auto-generated method stub
		//获取学生当前作业的做题信息
		List<StudentQuestions> questions=studentMapper.getStudentQuestions(jid,userId);
		//对作业题目进行分类
		//分为5类，0-填空题，1-选择题，2-判断题，3-简答题，4-代码题
		Map<String, List<StudentQuestions>> questionsMap=new HashMap<String, List<StudentQuestions>>();
		//判断作业是否有效
		StudentJob sj=studentMapper.getStudentJob(jid,userId);
		if(sj.getLastTime().equals("overtime")) {
			if(sj.getState()==0) {
				sj.setState(2);
				studentMapper.updateJobState(sj.getId(),sj.getState());
			}
			if(sj.getState()==1) {
				sj.setState(3);
				studentMapper.updateJobState(sj.getId(),sj.getState());
			}
			return questionsMap;
		}
		
		questionsMap.put("type0", new ArrayList<StudentQuestions>());
		questionsMap.put("type1", new ArrayList<StudentQuestions>());
		questionsMap.put("type2", new ArrayList<StudentQuestions>());
		questionsMap.put("type3", new ArrayList<StudentQuestions>());
		questionsMap.put("type4", new ArrayList<StudentQuestions>());
		
		int index0=1,index1=1,index2=1,index3=1,index4=1;
		double sumScore0=0,sumScore1=0,sumScore2=0,sumScore3=0,sumScore4=0;
		for(StudentQuestions sq:questions) {
			sq.setAnswer(null);
			switch (sq.getQuestionType()) {
			case 0:
				sq.setSeq(index0++);
				sumScore0+=sq.getQuestionScore();
				break;
			case 1:
				sq.setSeq(index1++);
				sumScore1+=sq.getQuestionScore();
				break;
			case 2:
				sq.setSeq(index2++);
				sumScore2+=sq.getQuestionScore();
				break;
			case 3:
				sq.setSeq(index3++);
				sumScore3+=sq.getQuestionScore();
				break;
			case 4:
				sq.setSeq(index4++);
				sumScore4+=sq.getQuestionScore();
				break;

			default:
				break;
			}
			
			questionsMap.get("type"+sq.getQuestionType()).add(sq);
			
		}
		model.addAttribute("lastTime",sj.getLastTime());
		model.addAttribute("questions",questionsMap);
		model.addAttribute("sumScore0",sumScore0);
		model.addAttribute("sumScore1",sumScore1);
		model.addAttribute("sumScore2",sumScore2);
		model.addAttribute("sumScore3",sumScore3);
		model.addAttribute("sumScore4",sumScore4);
		
		return questionsMap;
	}

	@Override
	@Transactional
	public ResponseModel<StudentQuestions> submitJob(JobModel jm) {
		//studentMapper.updateJobSocre(StudentQuestions);
		ResponseModel<StudentQuestions> resModel=new ResponseModel<StudentQuestions>();
		
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//判断作业是否可提交
		System.out.println(jm.getJid()+"   "+user.getId());
		StudentJob sj=studentMapper.getStudentJob(jm.getJid(),user.getId());
		
		boolean flag=false;
		if(sj.getLastTime().equals("overtime")) {
			if(sj.getState()==0) {
				flag=true;
				sj.setState(2);
				studentMapper.updateJobState(sj.getId(),sj.getState());
			}
			if(sj.getState()==1) {
				flag=true;
				sj.setState(3);
				studentMapper.updateJobState(sj.getId(),sj.getState());
			}
		}
		if(flag) {
			resModel.setMsg("作业已过期无法提交");
			resModel.setStatus(403);
		}
		
		List<StudentQuestions> questions=studentMapper.getStudentQuestions(jm.getJid(),user.getId());
		Map<Integer, StudentQuestions> sqsMap=new HashMap<Integer, StudentQuestions>();
		for(StudentQuestions sq:questions) {
			sqsMap.put(sq.getId(), sq);
			//System.out.println(sq.getId());
		}
		double sumScore=0;
		for(StudentQuestions sq:jm.getQuestions()) {
			//更新StudentQuestion
			StudentQuestions rightSq=sqsMap.get(sq.getId());
			if(rightSq==null)
				continue;
			List<Map<String, String>> ansList=rightSq.getAnswer();
			Map<String, String> ans;
			switch (rightSq.getQuestionType()) {
			case 0:
				ans=ansList.get(0);
				System.out.println("upAns:"+sq.getUpAnswer()+",rightAns:"+ans.get("answer"));
				if(sq.getUpAnswer().equals(ans.get("answer"))) {
					System.out.println("答案正确");
					sumScore+=rightSq.getQuestionScore();
				}
				break;
			//填空题
			case 1:
				Map<String,String> type1AnsMap=StringTools.jsonStrToMap(sq.getUpAnswer());
				Map<String, String> type1RightAnsMap=ansList.get(0);
				int rightAns=0;
				for(int i=1;i<=type1RightAnsMap.size();i++) {
					String upAnsStr=type1AnsMap.get(String.valueOf(i));
					String rightAnsStr=type1RightAnsMap.get(String.valueOf(i));
					System.out.println("upAns:"+upAnsStr+",rightAns:"+rightAnsStr);
					//相似度大于0.8则表示正确
					if(textCosine.isRight(upAnsStr,rightAnsStr, 0.8)) {
						System.out.println("答案正确");
						rightAns++;
					}
				}
				sumScore+=rightSq.getQuestionScore()*((double)rightAns/type1RightAnsMap.size());
				
				break;
			case 2:
				ans=ansList.get(0);
				System.out.println("upAns:"+sq.getUpAnswer()+",rightAns:"+ans.get("answer"));
				if(sq.getUpAnswer().equals(ans.get("answer"))) {
					System.out.println("答案正确");
					sumScore+=rightSq.getQuestionScore();
				}
				break;
			case 3:
				ans=ansList.get(0);
				System.out.println("upAns:"+sq.getUpAnswer()+",rightAns:"+ans.get("answer"));
				//相似度来计算分数
				sumScore+=textCosine.getScore(sq.getUpAnswer(), ans.get("answer"))*rightSq.getQuestionScore();
				break;
			case 4:
				int i=1;
				boolean canRun=false;
				canRun=javaStringCompiler.compiler(sq.getUpAnswer());

				if(canRun) {
					//编译成功后则运行
					int rightNum=0;
					for(Map<String, String> map:ansList) {
						
						String input=map.get("input").trim();
						String output=map.get("output").trim();
						String result=javaStringCompiler.runMainMethod(input).trim();
						if(result.equals(output)) {
							System.out.println("答案正确");
							rightNum++;
						}
						System.out.println("right:"+result.equals(output)+",input:"+input+",output:"+output+",result:"+result);
						
					}
					sumScore+=((double)rightNum/ansList.size())*rightSq.getQuestionScore();
				}
				else {
					resModel.setMsg("第"+(i++)+"题编译失败,错误信息如下\r\n"+javaStringCompiler.getCompilerMessage());
				}
				break;

			default:
				break;
			}
			if(ansList==null)
				continue;
			
			
			//studentMapper.updateStudentQuestion(sq);
			
		}
		//更新作业状态
		//studentMapper.updateStudentJobStateByUserId(jm.getJid(),user.getId());
		sumScore=(double) Math.round(sumScore* 10) / 10;
		System.out.println(sumScore);
		resModel.setMsg("总分："+sj.getTotalScore()+",得分:"+sumScore);
		return resModel;
	}



}
