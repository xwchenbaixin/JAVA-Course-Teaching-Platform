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