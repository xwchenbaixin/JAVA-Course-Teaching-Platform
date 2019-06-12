<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh"><!--<![endif]--><!-- BEGIN HEAD -->
<head>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>人员管理</title>
    
    <%@include file="../taglib-css.jsp"%>
	<link href="${ctx}/css/basicDataSet.css" rel="stylesheet" type="text/css">
	
</head>
<body class="fixed-top">
   <c:import  url="/menu/loadMenu" charEncoding="utf-8"/>

    <div id="body" style="min-height: 703px;">
        <div id="widget-config" class="modal hide">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"></button>
                <h3>widget Settings</h3>
            </div>
            <div class="modal-body">
                <p>Here will be a configuration form</p>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <ul class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="#">首页</a></li>
                        <li><i class="fa fa-book"></i><a href="javascript:void(0)">基础数据设置</a></li>
                    </ul>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <div class="widget box light-grey">
                        <div class="widget-title">
                            <h4><i class="icon-globe"></i>人员管理</h4>
                            <div class="actions">
                               <button type="button" class="btn btn-primary team_entry" data-toggle="modal" data-target="#addModal" >&nbsp;新增</button> 
                               <button type="button" class="btn btn-primary manager_entry" id="update">&nbsp;修改</button>  <!-- <i class="fa fa-plus"></i> -->
                               <button type="button" class="btn btn-primary other_entry"  id="enable">&nbsp;删除</button>
                               <button type="button" class="btn btn-primary"  id="accountstate" data-toggle="modal" data-target="#changeModal">&nbsp;启用/禁用</button> 
                               <button type="button" class="btn btn-primary year_entry" id="reset">&nbsp;重置密码</button> 
                            </div>
                        </div>
                        <div class="widget-body" >

                            <div class="row-fluid">
                                <form class="form-horizontal" action="javascript:void(0)">
                                    <div class="control-group">
                                        <div class="controls controls-cus">   
                                            	姓名：
                                            <input id="personnelName_list" name="txtLocalName" class="input-medium" type="text" placeholder="关键字" />   
                                               	 所属专业：
                                            <select class="form-control" id="personnelMajor_list">
						                        <option>所有</option>
						                        <option>水工</option>
						                        <option>环工</option>
						                    </select> 
                                            <a id="gritter-remove-all" class="btn btn-info" href="javascript:void(0)" onclick="select()">
                                                <i class="fa fa-search"></i>&nbsp;查询</a>
                                        </div>
                                    </div>
                                </form>
                            </div>

                            <table id="userInfo-table"
                                data-toggle="table"
                                data-click-to-select="true"
                                data-pagination="true"
                                data-striped="true"
                                data-single-select="true"
                                data-page-number="1"
                                data-page-size="10"
                                data-page-list="[10,15,20, 50, 100]"
                                data-side-pagination="server"
                                data-response-handler="responseHandler"
                                >
                                <thead>
                                    <tr>
                                      <th data-field="false" data-checkbox="true"></th>
                                      <th data-field="seq">序号</th>
                                      <th data-field="name">姓名</th>
                                      <th data-field="phone">电话号码</th>
                                      <th data-field="workno">工号</th>
                                      <th data-field="major">所属专业</th>
                                      <th data-field="work_date">入职时间</th>
                                      <th data-field="role_name">角色名称</th>
                                      <th data-field="duty">职务</th>
                                      <th data-field="account_state" data-cell-style="actionCellStyle" data-formatter="actionformatter" data-width="5%">账号状态</th>
                                      <th data-field="note">备注</th>
                                    </tr>
                                </thead>
                            </table>
                            
                          
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<div id="footer">

    <div class="span pull-right">
        <span class="go-top"><i class="icon-arrow-up"></i></span>
    </div>
</div>

<!-- 新增模态框（Modal） -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"  data-backdrop="true" style="display: none;top: 5%;">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header" >
                <p class="modal-left-title">基础数据设置->人员管理->新增
                </p>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h5 class="modal-title" >
                    新增人员
                </h5>
            </div>
            <div class="modal-body teamModal" style="max-height: 550px;"> 
            <div class="row">
                    <label class="left">序号：</label>
                    <input type="text" value="" id='personnelSetSeq-add' class="form-control input" readonly="readonly" />  
                </div>
                <div class="row">
                    <label class="left">姓名：</label>
                    <input type="text" value="" id='personnelSetName-add' class="form-control input" />  
                </div>
                
                <div class="row">
                    <label class="left">密码：</label>
                    <input type="text" value="" id='personnelSetPassword-add' class="form-control input" />
                </div>
                
                <div class="row">
                    <label class="left">手机号码：</label>
                    <input type="text" value="" id='personnelSetPhone-add' class="form-control input" />
                </div>
                <div class="row">
                    <label class="left">工号：</label>
                    <input type="text" value="" id='personnelSetNumber-add' class="form-control input" />
                </div>
                <div class="row">
                    <label class="left">入职时间：</label>
                    <input size="16" id="personnelSetTime-add" name="txtBeginTime" class=" form-control input" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" autocomplete="off">
                </div>
                <div class="row">
                     <label class="left">所属专业：</label>
                     <select id="personnelSetMajor-add" name="ddlStorageName" class="input-medium">
                        <option>水工</option>
                        <option>环工</option>
                    </select> 
                </div>
                <div class="row">
                     <label class="left">职务：</label>
                     <select id="personnelSetPosition-add" name="ddlStorageName" class="input-medium">
                        <option>经理</option>
                        <option>员工</option>
                    </select> 
                </div>
                <div class="row">
                     <label class="left">角色名称：</label>
                     <select id="personnelSetRoleName-add" class="input-medium">
                     
                    </select>
                </div>
                <div class="row">
                     <label class="left">账号状态：</label>
                     <select id="personnelAccountState-add" class="input-medium">
                        <option>启用</option>
                        <option>禁用</option>
                    </select>
                </div>
               <div class="row"> 
               		<label class="left" >备注：</label> 
               		<textarea class="question" id="personnelSetNote-add"></textarea>
               </div>
                	
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary footer" onclick="addFunction()">提交</button>
                <button type="button" class="btn btn-default  footer " data-dismiss="modal" >关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div><!-- /#addModal -->

<!-- 修改模态框（Modal） -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="true" style="display: none;top: 5%;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" >
            	<p class="modal-left-title">基础数据设置->人员管理->修改
                </p>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h5 class="modal-title" id="myModaltitle">
                    信息修改
                </h5>
            </div>
            <div class="modal-body teamModal" style="max-height: 550px;"> 
            <div class="row">
                    <label class="left">序号：</label>
                    <input type="text" value="" id="personnelSetSeq-alter"' class="form-control input" />
                </div>
                <div class="row">
                    <label class="left">姓名：</label>
                    <input type="text" value="" id="personnelSetName-alter"' class="form-control input" />
                </div>
                <div class="row">
                    <label class="left">密码：</label>
                    <input disabled="disabled" type="text" value="" id="personnelSetPassword-alter"' class="form-control input" />
                </div>
                <div class="row">
                    <label class="left">手机号码：</label>
                    <input type="text" value="" id='personnelSetPhone-alter' class="form-control input" />
                </div>
                <div class="row">
                    <label class="left">工号：</label>
                    <input type="text" value="" id='personnelSetNumber-alter' class="form-control input" />
                </div>
                <div class="row">
                    <label class="left">入职时间：</label>
                    <input size="16" id="personnelSetTime-alter" name="txtBeginTime" class=" form-control input" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text">
                </div>
                <div class="row">
                     <label class="left">所属专业：</label>
                     <select id="personnelSetMajor-alter" name="ddlStorageName" class="input-medium">
                        <option>水工</option>
                        <option>环工</option>
                    </select> 
                </div>
                <div class="row">
                     <label class="left">角色名称：</label>
                     <select id="personnelSetRoleName-alter" class="input-medium">
                     
                    </select>
                </div>
                <div class="row">
                     <label class="left">职务：</label>
                     <select id="personnelSetPosition-alter" name="ddlStorageName" class="input-medium">
                        <option>经理</option>
                        <option>员工</option>
                    </select> 
                </div>
                <div class="row">
                     <label class="left">账号状态：</label>
                     <select id="personnelSetState-alter" name="ddlStorageName" class="input-medium">
                        <option>启用</option>
                        <option>禁用</option>
                    </select> 
                </div>
               	<div class="row">
               		<label class="left" >备注：</label> 
               		<textarea class="question" id="personnelSetNote-alter"></textarea>
               	</div>
                	
            	</div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary footer" onclick='UpdateCilck()'>提交</button>
                <button type="button" class="btn btn-default  footer" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div><!-- /#updateModal -->


<!-- 删除模态框（Modal） -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background: linear-gradient(to bottom, #FF4500, #FF6347);">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">禁用</h4>
            </div>
            <div class="modal-body">
                <p style="font-size: 24px;line-height: 30px;color: #FF0000">是否删除该选项?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default deleteInsure" onclick='DeleteCilck()'>是</button>
                <button type="button" class="btn btn-primary deleteInsure" data-dismiss="modal">否</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div><!-- /#deleteModal -->

<!-- 修改用户状态模态框（Modal） -->
<div class="modal fade" id="changeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background: linear-gradient(to bottom, #FF4500, #FF6347);">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改用户账号状态</h4>
            </div>
            <div class="modal-body">
                <p style="font-size: 24px;line-height: 30px;color: #FF0000">是否修改该选项?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default deleteInsure" onclick='ChangeAccountState()'>是</button>
                <button type="button" class="btn btn-primary deleteInsure" data-dismiss="modal">否</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div><!-- /#deleteModal -->


<!-- 重置密码模态框（Modal） -->
<div class="modal fade" id="resetModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background: linear-gradient(to bottom, #FF4500, #FF6347);">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">重置密码</h4>
            </div>
            <div class="modal-body">
                <p style="font-size: 24px;line-height: 30px;color: #FF0000">是否重置密码?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default deleteInsure" onclick='UpdatePassword()'>是</button>
                <button type="button" class="btn btn-primary deleteInsure" data-dismiss="modal">否</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div><!-- /#resetModal -->



<%@include file="../taglib-js.jsp"%>
<script type="text/javascript" src="${ctx}/js/manage_personnel.js"></script>

</body>
</html>