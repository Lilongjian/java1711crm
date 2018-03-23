<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Cell Editing in DataGrid</h2>
	<p>Click a cell to start editing.</p>
	<div style="margin:20px 0;"></div>
	
	<table id="dg" class="easyui-datagrid" title="Cell Editing in DataGrid" style="width:700px;height:auto"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				url: '${ctx}/customer/pageList.action',
				method:'get',
				onClickCell: onClickCell
			">
		<thead>
			<tr>
				<th data-options="field:'id',width:80,editor:'numberbox'">编号</th>
				<th data-options="field:'num',width:100,editor:'numberbox'">客户编号</th>
				<th data-options="field:'name',width:80,align:'right',editor:'text'">客户姓名</th>
				<th data-options="field:'region',width:80,align:'right',editor:'text'">客户地区</th>
				<th data-options="field:'managerName',width:250,editor:'text'">客户经理姓名</th>
			</tr>
		</thead>
	</table>
 
	<script type="text/javascript">
		$.extend($.fn.datagrid.methods, {
			editCell: function(jq,param){
				return jq.each(function(){
					var opts = $(this).datagrid('options');
					var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field){
							col.editor = null;
						}
					}
					$(this).datagrid('beginEdit', param.index);
					for(var i=0; i<fields.length; i++){
						var col = $(this).datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
		});
		
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (endEditing()){
				$('#dg').datagrid('selectRow', index)
						.datagrid('editCell', {index:index,field:field});
				editIndex = index;
			}
		}
	</script>
</body>
</html>