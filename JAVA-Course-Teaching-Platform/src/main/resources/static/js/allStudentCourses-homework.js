/**
 * 
 */
$(document).ready(function(){
	initAllCourses();
})

function initAllCourses(){
	$.ajax("/student/listStudentJobs",
	        {
	            dataType: "json", // 预期服务器返回的数据类型。
	            type: "POST", //  请求方式 POST或GET
	            crossDomain:true,  // 跨域请求
	            contentType: "application/json", //  发送信息至服务器时的内容编码类型
	            async: false, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
	            data:JSON.stringify({
	            	//"id"		:	$("#updateStuId").val(),
	    			"param"	:	{
	    				"courseId":$("#cid").val(),
            			"state":-1
	    			}
	            }),
	            // 请求成功后的回调函数。
	            success: function(data){
	            	console.log(data);
	            	$.each(data.rows,function(index,row){
	            		var buttonHtml='';
	            		if(row.state==0)
	            			buttonHtml='<a href="/student/doJob?jid='+row.jobId+'" target="_blank"><button onclick="" type="button" class="btn btn-danger btn-sm" style="width: 100%;">做作业</button></a>';
	            		else if(row.state==1)
	            			buttonHtml='<a href="/student/doJob?jid='+row.jobId+'" target="_blank"><button onclick="" type="button" class="btn btn-success btn-sm" style="width: 100%;">重新编辑</button></a>';
	            		else if(row.state==2)
	            			buttonHtml='<button onclick="" type="button" class="btn btn-default btn-sm" style="width: 100%;">已过期</button>';
	            		else if(row.state==3)
	            			buttonHtml='<button onclick="" type="button" class="btn btn-info btn-sm" style="width: 100%;">待批阅</button>';
	            		var html=[
		            		'<div class="col-md-3 col-sm-3 col-xs-3">',
								'<div class="x_panel">',
									'<div class="x_title">',
										'<h2>',
											'<a href="/student/doJob?jid='+row.jobId+'" title="'+row.jobName+'">'+row.jobName+'</a>',
										'</h2>',
										'<div class="clearfix"></div>',
									'</div>',
									'<div class="x_content" id="content">',
										'<div class="content-info" id="testClick">',
											'<font size="3">开始时间：'+row.releaseDate+'</font> <br> <font size="3">截止时间：'+row.endDate+'</font>',
											'<br><font size="3">剩余时间：'+row.lastTime+'</font>',
										'</div>',
										'<div id="footer">',
											'<a>'+buttonHtml+'</a>',
										'</div>',
									'</div>',
								'</div>',
							'</div>'
		            	].join('');
	            		$("#rows").append(html);
	            	})
	            	
	            	
	            	/*$("#resMsg").text(data.msg);
               		$("#resInfoModal").modal('show');
	                if(data.status==200){
	                	
		            	$("#insertModal").modal('hide');
	                    $('#table').bootstrapTable('refresh');
	                }*/
	            },
	            error: function(){
	                alert("请求错误，请检查网络连接");
	           }
	    })
}