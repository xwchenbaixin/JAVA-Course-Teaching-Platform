/**
 * 
 */

$(document).ready(function(){
	console.log("fff");
	initCourseJobsTable();
})

var $table;
//初始化bootstrap-table的内容
function initCourseJobsTable () {
    //记录页面bootstrap-table全局变量$table，方便应用
    var queryUrl = '/student/listStudentJobs';
	//var rows= $("#table").bootstrapTable('getSelections');
	$table = $('#courseJobsTable').bootstrapTable({
        url: queryUrl,                      //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        classes:'table table-hover',
        bordered:true,
        //toolbar: '#toolbar',                //工具按钮用哪个容器
        //striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        //pagination: true,                   //是否显示分页（*）
        //sortable: true,                     //是否启用排序
        //sortName:"id",
        //sortOrder: "asc",                   //排序方式
        //singleSelect:"true",				//只能选一行
        //sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        //pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        //pageSize: 10,                      //每页的记录行数（*）
        //pageList: [10, 15, 20, 50,100],        //可供选择的每页的行数（*）
        //search: false,                      //是否显示表格搜索
        //strictSearch: true,
        //showColumns: true,                  //是否显示所有的列（选择显示的列）
        //showRefresh: true,                  //是否显示刷新按钮
        //minimumCountColumns: 2,             //最少允许的列数
        //clickToSelect: true,                //是否启用点击选中行
        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        //uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        //showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
        //cardView: false,                    //是否显示详细视图
        //detailView: false,                  //是否显示父子表
//        search:true,
//        searchAlign: 'left',
//        searchOnEnterKey:true,
        //buttonsAlign:'left',				//buttons方向
        //toolbarAlign:'right',				//自定义toolbar方向
        //得到查询的参数
        queryParams : function (params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {   
            		param:{
            			courseId:$("#cid").val(),
            			state:0
            		}
                    
            };
            return temp;
        },
        columns: [{
            field: 'jobName',
            title: '作业名称'
            //sortable: true
        }, {
            field: 'description',
            title: '作业描述',
            //sortable: true,
            //formatter: emailFormatter
        }, {
            field: 'endDate',
            title: '截止时间'
        }, {
            field: 'lastTime',
            title: '剩余时间',
            //formatter: dateFormatter
        },{
            title: '操作',
            align: 'center',
            valign: 'middle',
            formatter: "actionFormatter"
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
		'<a href="/student/doJob?jid='+row.jobId+'" target="_blank"><button  id="tableEditor" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#updateModal">做作业</button></a>'
		
	].join("");
}
