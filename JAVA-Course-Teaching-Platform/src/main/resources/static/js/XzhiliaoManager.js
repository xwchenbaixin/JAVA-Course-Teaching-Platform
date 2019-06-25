/**
 * 
 */
$(document).ready(function() {
	initMainTable();
	initUpdate();
	initDelete();
	initSearch();
	initInsert();
	$("#fileForm").ajaxForm({
			async: true,
	        type: "POST",
	        //url:"",
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决中文乱码问题
	        //data: $('#form').serialize(),
	        dataType: "text",
	        success: function (data) { 
	        	if(data!=false){
	        		$("#insertFilePath").val(data);
	        		alert("上传成功")
	        	}
	        	else
	        		alert("上传失败")
	        },
	        error: function () {
	        	console.log("fff")
	        }
		})  
	
})
var $table;
//初始化bootstrap-table的内容
function initMainTable () {
    //记录页面bootstrap-table全局变量$table，方便应用
    var queryUrl = '/allStudentCourses-material/listZhiliao';
	//var rows= $("#table").bootstrapTable('getSelections');
	$table = $('#table').bootstrapTable({
        url: queryUrl,                      //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortName:"id",
        sortOrder: "asc",                   //排序方式
        singleSelect:"true",				//只能选一行
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        pageSize: 10,                      //每页的记录行数（*）
        pageList: [10, 15, 20, 50,100],        //可供选择的每页的行数（*）
        search: false,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列（选择显示的列）
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
        //cardView: false,                    //是否显示详细视图
        //detailView: false,                  //是否显示父子表
//        search:true,
//        searchAlign: 'left',
//        searchOnEnterKey:true,
        buttonsAlign:'left',				//buttons方向
        toolbarAlign:'right',				//自定义toolbar方向
        //得到查询的参数
        queryParams : function (params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        	console.log(params)
            var temp = {   
        		param:{
        			fileName:$("#searchCName").val(),
        			courseName:$("#searchCouName").val(),
        		},
                pageModel:{
                	limit: params.limit,                         //页面大小
                    page: (params.offset / params.limit) + 1,   //页码
                    offset:params.offset,
                    sort: params.sort,      //排序列名  
                    order: params.order //排位命令（desc，asc） 
                }
            	
            };
            return temp;
        },
        columns: [{
            checkbox: true,  
            visible: true                  //是否显示复选框  
        }, {
            field: 'id',
            title: 'ID',
            sortable: true
        }, {
            field: 'classNo',
            title: '班级'
            //sortable: true
        }, {
            field: 'courseName',
            title: '课程名称'
            //sortable: true
        },{
            field: 'type',
            title: '课件类别',
            sortable: true
            //formatter: linkFormatter
        }, {
            field: 'fileName',
            title: '课件名称',
            //formatter: dateFormatter
        }, {
            field: 'filePath',
            title: '课件地址'
        },
        {
            field: 'state',
            title: '状态'
        },
        {
            field: 'upDate',
            title: '状态'
        }, {
            field:'ID',
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter: "actionFormatter",
            events:"operateEvents"
        }],
        onLoadSuccess: function () {
        	
        },
        onLoadError: function () {
            alert("数据加载失败！");
        },
        /*onDblClickRow: function (row, $element) {
            var id = row.ID;
            console.log(id);
            //EditViewById(id, 'view');
        },*/
    });
    
};

function actionFormatter(value,row,index,field){
	return [
		'<button id="tableDelete" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteModal">删除</button>'
	].join("");
}
var operateEvents={
		"click #tableDelete":function(e,value,row,index){
			//设置隐藏域ID
			$("#deleteId").val(row.id);
			$("#deleteInfo").text("Id:"+row.id+",Name:"+row.name);
	}
}

function termFormatter(value,row,index,field){
	if(value==1)
		return "文档";
	else if(value==2)
		return "PPT";
}

//数据增加
function initInsert(){
	$("#insertBtn").click(function(){
		var file=$("#insertFilePath").val();
		if(file==""||file==null){
			alert("请选择文件");
			return;
		}
		$.ajax("/allStudentCourses-material/xzhiinsert",
		        {
		            dataType: "json", // 预期服务器返回的数据类型。
		            type: "POST", //  请求方式 POST或GET
		            crossDomain:true,  // 跨域请求
		            contentType: "application/json", //  发送信息至服务器时的内容编码类型
		            // 发送到服务器的数据
		            data:JSON.stringify({
		            	//"id"		:	$("#updateStuId").val(),
		    			"courseId"	:	$("#insertFilCourseId").val(),
		    			"type"		:	$("#insertFilType").val(),
		    			"fileName"	:	$("#insertFileName").val(),
		    			"filePath"	:	$("#insertFilePath").val(),
		    			"state"		:	$("#insertFileState").val(),
		    			"upDate"	:	$("#insertFileDate").val(),
		            }),
		            
		            async: false, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
		            // 请求成功后的回调函数。
		            success: function(data){
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
	})
}
//数据修改
function initUpdate(){
	
}
//数据删除
function initDelete(){
	$("#deleteBtn").click(function(){
		$.ajax("/allStudentCourses-material/xzhidelete",
		        {
		            dataType: "json", // 预期服务器返回的数据类型。
		            type: "POST", //  请求方式 POST或GET
		            crossDomain:true,  // 跨域请求
		            contentType: "application/json", //  发送信息至服务器时的内容编码类型
		            // 发送到服务器的数据
		            data:JSON.stringify({
		            	"id"		:	$("#deleteId").val()
		            }),
		          
		            async: false, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
		            // 请求成功后的回调函数。
		            success: function(data){
	               		$("#deleteModal").modal('hide');
		            	$("#resMsg").text(data.msg);
	               		$("#resInfoModal").modal('show');
		               	if(data.status==200){
		               		$('#table').bootstrapTable('refresh');
		               	}
		               	
		            },
		            error: function(){
		                alert("请求错误，请检查网络连接");
		           }
		    })
	})
}
function initSearch(){
	$("#search").click(function(){
		$('#table').bootstrapTable('refresh');
	})
}