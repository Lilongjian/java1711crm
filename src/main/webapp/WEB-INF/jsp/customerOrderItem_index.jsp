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
 	$(function(){
 		//查询指定id的销售机会
 		$.post("${ctx}/customer/selectById.action", 
 				{id : '${param.id}'}, 
 				function(result) {
 					/* if(result.status==util.SUCCESS) { */
 						$("#customernum").val(result.num);
 						$("#customername").val(result.name);
 					/* } */
 					
 				}, 
 				"json");
 		
 		/*展示数据的datagrid表格*/
 		$("#datagrid").edatagrid({
 			url:'${ctx}/customerOrderItem/selectById.action?id=${param.orderId}',//只查询已分配咨询师的
 			saveUrl:'${ctx}/customerOrder/add.action?customerId=${param.id}',
 			updateUrl:'${ctx}/customerOrder/update.action?customerId=${param.id}',
 			destroyUrl:'${ctx}/customerOrder/delete.action',
 			title:'开发计划项',
 			singleSelect:true,
 			toolbar:'#toolbar',
 			rownumbers:true,
 			fitColumns:true,
 			columns:[[ 
                 {field:"cb",checkbox:true,align:"center"},
 			     {field:'id',title:'编号',width:30,align:'center'},    
 			     {field:'productName',title:'商品名称',width:30,align:'center',editor:{type:'validatebox',options:{required:true}}},    
 			     {field:'productNum',title:'商品数量',width:30,align:'center',editor:{type:'datebox',options:{required:true}}},    
 			     {field:'unit',title:'单位',width:30,align:'center',editor:{type:'validatebox',options:{required:true}}},  
 			     {field:'price',title:'价格',width:30,align:'center',editor:{type:'validatebox',options:{required:true}}},
 			    {field:'sum',title:'总金额',width:30,align:'center',editor:{type:'validatebox',options:{required:true}}}
 			]],
 			onSuccess : function() {
 				$('#datagrid').edatagrid('reload');
 				console.log("onSuccess");
 			},
 			onDestroy : function() {
 				$('#datagrid').edatagrid('reload');
 				console.log("onDestroy");
 			}
 			
 		});
 	});
 	
 	//更新销售机会客户开发状态
 	function updateSaleChanceDevResult(devResult){
 		 $.post("${ctx}/saleChance/updateDevResult.action",
 				 {saleChanceId:'${param.saleChanceId}',devResult:devResult},
 				 function(result){
 					 if(result.status == util.SUCCESS){
 						 $.messager.alert("系统提示","执行成功！");
 						 //执行成功或失败后，隐藏工具条，因为不需要开发了
 						 $("#toolbar").hide();
 					 }else{
 						 $.messager.alert("系统提示","执行失败！");
 					 }
 		 		},
 		 		"json");
 	 }
 		
 </script>
 </head>
 <body>
 	<!-- 营销机会信息面板  开始 -->
 	<div id="p" class="easyui-panel" title="销售机会信息" style="width:700px;height: 100px">
 	 	<table cellspacing="8px">
 	   		<tr>
 	   			<td>编号：</td>
 	   			<td><input type="text" id="customernum"/></td>
 	   			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	   			<td>客户名称：</td>
 	   			<td><input type="text" id="customername"/></td>
 	   		</tr>
 	   	</table>
 	 </div>
 	 <!-- 营销机会信息面板  结束  -->
 	 
 	 <br/>
 	 
 	<!-- 客户开发计划项table -->
 	<table id="datagrid" style="width:900px;height:250px" idField="id"></table>
 	
 	<!-- toolbar 开始 -->
 	 <!-- <div id="toolbar">
 		 	<a href="javascript:$('#datagrid').edatagrid('addRow')" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加计划</a>
 		 	<a href="javascript:$('#datagrid').edatagrid('destroyRow')" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除计划</a>
 		 	<a href="javascript:$('#datagrid').edatagrid('cancelRow')" class="easyui-linkbutton" iconCls="icon-undo" plain="true">撤销行</a>
 		 	<a href="javascript:$('#datagrid').edatagrid('saveRow')" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存计划</a>
 	 </div> -->
 	<!-- toolbar 结束 -->
</body>
</html>