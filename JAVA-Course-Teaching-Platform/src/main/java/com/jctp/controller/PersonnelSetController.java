/*
 * package nchu.monthreport.controller;
 * 
 * import java.util.List; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * 
 * import nchu.monthreport.common.ListPageModel; import
 * nchu.monthreport.common.ResponseModel; import
 * nchu.monthreport.common.ResponsePModel; import
 * nchu.monthreport.demo.MajorSet; import nchu.monthreport.demo.PersonnelSet;
 * import nchu.monthreport.demo.ProjectRole; import
 * nchu.monthreport.service.PersonnelSetService;
 * 
 * 
 * @Controller
 * 
 * @RequestMapping("/personnelset") public class PersonnelSetController {
 * 
 * @Autowired
 * 
 * @Qualifier(value = "personnelSetService") private PersonnelSetService
 * personnelSetService;
 * 
 * @RequestMapping("/insert")
 * 
 * @ResponseBody public ResponseModel insert(@RequestBody PersonnelSet
 * personnelSet) { personnelSetService.insert(personnelSet); return new
 * ResponseModel(1, "添加成功"); }
 * 
 * @RequestMapping("/update")
 * 
 * @ResponseBody public ResponseModel update(@RequestBody PersonnelSet
 * personnelSet) { int id = personnelSet.getId();
 * System.out.println("******************"+id+"*********************");
 * personnelSetService.update(personnelSet); return new ResponseModel(1,
 * "修改成功"); }
 * 
 * @RequestMapping("/delete")
 * 
 * @ResponseBody public ResponseModel delete(@RequestBody PersonnelSet
 * personnelSet) { int id = personnelSet.getId();
 * personnelSetService.deleteById(id); return new ResponseModel(1, "删除成功");
 * 
 * }
 * 
 * @RequestMapping("/changeAccount")
 * 
 * @ResponseBody public ResponseModel changeAccount(@RequestBody PersonnelSet
 * personnelSet){ int id=personnelSet.getId();
 * personnelSetService.changeAccountById(id); return new ResponseModel(1,
 * "修改成功"); }
 * 
 * 
 * @RequestMapping("/resetPassword")
 * 
 * @ResponseBody public ResponseModel resetPassword(@RequestBody PersonnelSet
 * personnelSet) { int id = personnelSet.getId();
 * personnelSetService.resetPassword(id); return new ResponseModel(1, "修改成功");
 * 
 * }
 * 
 * @RequestMapping("/listPage")
 * 
 * @ResponseBody public ResponsePModel<PersonnelSet> listPage(@RequestBody
 * ListPageModel<PersonnelSet> model) {
 * 
 * int recordCount = personnelSetService.intDyna(model); int
 * maxSeq=personnelSetService.getMaxSeq(); List<PersonnelSet> personnelSet =
 * personnelSetService.listPage(model); List<ProjectRole>
 * role=personnelSetService.getRoleList();//获取角色表相关数据，用于新增和修改中的“角色名称”
 * List<MajorSet> major=personnelSetService.getMajorList();//获取专业表相关数据
 * System.out.println(personnelSet.toString()); return new
 * ResponsePModel<PersonnelSet>(recordCount, personnelSet,maxSeq,role,major); }
 * }
 */