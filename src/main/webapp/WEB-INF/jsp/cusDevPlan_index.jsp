<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>Insert title here</title>
	<script type="text/javascript">
 		$(function() {
 			/* 渲染table */
 			$("#datagrid").datagrid({
 				url : "${ctx}/saleChance/pageList.action?status=1",//status=1是已经查询已经指派人的营销机会
 				method : "get",
 				fit : true,
 				fitColumns : true,
 				pagination : true,
 				toolbar: "#toolbar",
 				columns:[[    
 				     {field:'cb',checkbox:true,align:'center'},    
 				     {field:'id',title:'编号',width:50,align:'center'},    
 				     {field:'customerName',title:'客户名称',width:100,align:'center'},    
 				     {field:'overview',title:'概要',width:80,align:'center'},    
 				     {field:'linkMan',title:'联系人',width:80,align:'center'},    
 				     {field:'createMan',title:'创建人',width:80,align:'center'},    
 				     {field:'createTime',title:'创建时间',width:100,align:'center'},    
 				     {field:'assignMan',title:'指派人',width:80,align:'center'},    
 				     {field:'assignTime',title:'指派时间',width:100,align:'center'},    
 				     {field:'devResult',title:'客户开发状态',width:80,align:'center',formatter:function(value,row,index){
 				    	 //客户开发状态 0 未开发 1 开发中 2 开发成功 3 开发失败
 				    	 if(value==0){
 				    		 return "未开发";
 				    	 }else if(value==1){
 				    		 return "开发中";
 				    	 }else if(value==2){
 				    		 return "开发成功";
 				    	 }else if(value==3){
 				    		 return "开发失败";
 				    	 } else {
 				    		 return "未开发"
 				    	 }
 				     }},    
 				     {field:'a',title:'操作',width:80,align:'center',formatter:function(value,row,index){
 				    	 if(row.devResult==2||row.devResult==3){
 				    		 return "<a href='javascript:openCusDevPlanTab("+row.id+",false)'>查看详细信息</a>";
 				    	 }else{
 				    		 return "<a href='javascript:openCusDevPlanTab("+row.id+",true)'>开发</a>";
 				    	 }
 				     }},    
 				]] 
 			});
 		});
 		/* 搜索 */
		function doSearch(){
			$('#datagrid').datagrid('load', {    
				customerName : $("#s_customerName").val(),    
				linkMan : $("#s_linkMan").val(),   
				createMan : $("#s_createMan").val(),
				devResult : $("#s_devResult").val(),
				CreateTimeS : $("#s_createTimeS").val(),
				CreateTimeE : $("#s_createTimeE").val(),
			    
			});  
		}
 		//可以修改添加开发项
 		function openCusDevPlanTab(id,isShow){
 			 window.parent.openTab('客户开发计划项管理','${ctx}/cusDevPlan/index.action?saleChanceId='+id+'&show='+isShow,'icon-khkfjh');
 		}
 		 
 		//只能查看开发信息
 		/* function openCusDevPlanInfoTab(id){
 			window.parent.openTab('查看客户开发计划项','${ctx}/cusDevPlan/index.action?saleChanceId='+id,'icon-khkfjh');
 		} */
 	</script>
</head>
<body>
 <table id="datagrid"></table>
 <!-- toolbar开始 -->
 <div id="toolbar">
 <div>
        客户名称：<input type="text" id="s_customerName"/>
	联系人：<input type="text" id="s_linkMan"/>
	创建人：<input type="text" id="s_createMan"/>
	开发状态：<select id="s_devResult" class="easyui-combobox" 
			editable="false" panelHeight="auto">
			<option value="">请选择...</option>
			<option value="0">未开发</option>
			<option value="1">开发中</option>
			<option value="2">开发成功</option>
			<option value="3">开发失败</option>
		</select>
		<br/>
		开始时间：<input  id="s_createTimeS"  type= "text" class= "easyui-datebox"> </input> 
		结束时间：<input  id="s_createTimeE"  type= "text" class= "easyui-datebox"> </input>
		&nbsp;&nbsp;
	<a href="javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
 </div>
 </div>
</body>
</html>