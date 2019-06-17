/**
 * 
 */
$(document).ready(function(){
	initAllCourses();
})

function initAllCourses(){
	$.ajax("/student/listCourses",
	        {
	            dataType: "json", // 预期服务器返回的数据类型。
	            type: "POST", //  请求方式 POST或GET
	            crossDomain:true,  // 跨域请求
	            contentType: "application/json", //  发送信息至服务器时的内容编码类型
	            async: false, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
	            // 请求成功后的回调函数。
	            success: function(data){
	            	console.log(data);
	            	$.each(data.rows,function(index,row){
	            		
	            		var html=[
		            		'<div class="col-md-3 col-sm-3 col-xs-3">',
								'<div class="x_panel">',
									'<div class="x_title">',
										'<h2><a href="/turnPage?role=student&pn=allStudentCourses-index" title="'+row.courseName+'">'+row.courseName+'</a></h2>',
										'<ul class="nav navbar-right panel_toolbox">',
											'<li class="dropdown">',
												'<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">',
													'<i class="fa fa-wrench"></i>',
												'</a>',
												'<ul class="dropdown-menu" role="menu">',
													'<li><a href="#">Settings 1</a></li>',
													'<li><a href="#">Settings 2</a></li>',
												'</ul>',
											'</li>',
										'</ul>',
										'<div class="clearfix"></div>',
									'</div>',
									'<div class="x_content" id="content">',
										'<div class="content-img" id="testClick"><img src='+row.courseImg+'></div>',
										'<div class="course-footer">',
											'<p>任课教师：'+row.teacherName+'</p>',
											'<p>班级组：'+row.classNo+'</p>',
										'</div>',
									'</div>',
								'</div>',
							'</div>'
		            	].join('');
	            		$("#rows").append(html);
	            	})
	            	
	            	
	            	$("#resMsg").text(data.msg);
               		$("#resInfoModal").modal('show');
	                if(data.status==200){
	                	
		            	$("#insertModal").modal('hide');
	                    $('#table').bootstrapTable('refresh');
	                }
	            },
	            error: function(){
	                alert("请求错误，请检查网络连接");
	           }
	    })
}