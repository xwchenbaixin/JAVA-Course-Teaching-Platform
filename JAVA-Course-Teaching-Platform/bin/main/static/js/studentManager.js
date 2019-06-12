/**
 * 
 */
$(document).ready(function() {
	InitMainTable();
	
	$("#updateBtn").click(function(){
		$.ajax("/studentManager/update",
		        {
		            dataType: "json", // 预期服务器返回的数据类型。
		            type: "POST", //  请求方式 POST或GET
		            crossDomain:true,  // 跨域请求
		            contentType: "application/json", //  发送信息至服务器时的内容编码类型
		            // 发送到服务器的数据
		            data:JSON.stringify({
		            	"id"		:	$("#stuId").val(),
		    			"workNo"	:	$("#stuWorkNo").val(),
		    			"name"		:	$("#stuName").val(),
		    			"sex"		:	$("#stuSex").val(),
		            }),
		          
		            async: false, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
		            // 请求成功后的回调函数。
		            success: function(data){
		                    alert(data.msg);
		                    $('#table').bootstrapTable('refresh');
		            },
		            error: function(){
		                alert("请求错误，请检查网络连接");
		           }
		    })
	})
})
var $table;
//初始化bootstrap-table的内容
function InitMainTable () {
    //记录页面bootstrap-table全局变量$table，方便应用
    var queryUrl = '/studentManager/listUsers';
	//var rows= $("#table").bootstrapTable('getSelections');
	$table = $('#table').bootstrapTable({
        url: queryUrl,                      //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
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
        //得到查询的参数
        queryParams : function (params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {   
                pageModel:{
                	pageSize: params.limit,                         //页面大小
                    pageIndex: (params.offset / params.limit) + 1,   //页码
                    sort: params.sort,      //排序列名  
                    sortOrder: params.order //排位命令（desc，asc） 
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
            field: 'name',
            title: '姓名'
            //sortable: true
        }, {
            field: 'sex',
            title: '性别',
            //sortable: true,
            //formatter: emailFormatter
        }, {
            field: 'workNo',
            title: '学号/工号',
            //formatter: linkFormatter
        }, {
            field: 'password',
            title: '密码',
            //formatter: dateFormatter
        }, {
            field: 'phone',
            title: '电话号码'
        }, {
            field: 'roleName',
            title: '角色名',
            //sortable: true
        }, {
            field: 'classId',
            title: '所在班级'
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
            showTips("数据加载失败！");
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
		'<button id="tableEditor" type="button" class="btn btn-info" data-toggle="modal" data-target="#editModal">编辑</button>',
		'<button id="tableDelete" type="button" class="btn btn-danger">删除</button>'
	].join("");
}
var operateEvents={
		"click #tableEditor":function(e,value,row,index){
			$("#stuId").val(row.id);
			$("#stuWorkNo").val(row.workNo);
			$("#stuName").val(row.name);
			$("#stuSex").val(row.sex);
		},
		"click #tableDelete":function(e,value,row,index){
			
		}
}
