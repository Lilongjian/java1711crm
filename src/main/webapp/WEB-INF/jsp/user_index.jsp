<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  $(function(){
	  $("#datagrid").datagrid({
		 url:"${ctx}/user/pageList.action",
		  method:"get",
		  fit:true,
		  fitColumns:true,
		  pagination:true,
		  toolbar:"#toolbar",
		  columns:[[
                    {field:"cb",checkbox:true,align:"center"},
					{field:"id",title:"编号",width:80,align:"center"},
					{field:"name",title:"用户名",width:80,align:"center"},
					{field:"trueName",title:"真实姓名",width:80,align:"center"},
					{field:"email",title:"邮箱",width:80,align:"center"},
					{field:"phone",title:"联系电话",width:80,align:"center"},
					{field:"roleName",title:"角色",width:80,align:"center"},
		           ]],
	  });
  });
  /* 搜索 */
 		function doSearch(){
 			$('#datagrid').datagrid('load', {    
 			    name : $("#s_name").val(),    
 			    email : $("#s_email").val(),   
 			    roleName : $("#s_roleName").val() 
 			});  
 		}
 		/* 删除 */
 				function doDelete() {
 					//getSelections none 返回所有被选中的行，当没有记录被选中的时候将返回一个空数组。 
 					console.log($("#datagrid").datagrid("getSelections"));
 					var ids = util.getSelectedIds($("#datagrid").datagrid("getSelections"));
 					console.log(ids.length);
 					//[1,2,3]
 					if (ids.length == 0) {
 						$.messager.alert("系统提示", "请选择要删除的数据");
 						return;
 					}
 					$.messager.confirm("系统提示", "您确认要删除这"+ids.length+"几条数据么", function(r){
 						if(r) {
 							ids = ids.join(',');// '1,2,3'
 							$.ajax({
 								url : "${ctx}/user/delete.action",
 								data : {ids : ids},
 								dataType : "json",
 								type : "POST",
 								success : function(jsonObj) {
 									$.messager.alert("系统提示", jsonObj.msg);
 									if(jsonObj.status == util.SUCCESS) {
 										$("#datagrid").datagrid("reload");
 									}
 								}
 							});
 						}
 					});
 				}
</script>
</head>
<body>
   <table id="datagrid"></table>
   <!-- toolbar开始 -->
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
		<a href="javascript:doDelete()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
		<div>
			用户名：<input type="text" id="s_name"/>
			邮箱：<input type="text" id="s_email"/>
			角色：<select id="s_roleName" class="easyui-combobox" 
					editable="false" panelHeight="auto">      <!-- editable:控制不能输入。panelHeight：大小适应 -->
					<option value="">请选择...</option>
					<option value="系统管理员">系统管理员</option>
					<option value="销售主管">销售主管</option>
					<option value="客户经理">客户经理</option>
					<option value="高管">高管</option>
				</select>
			<a href=" javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
	</div>
 	<!-- toolbar结束 -->
</body>
</html>