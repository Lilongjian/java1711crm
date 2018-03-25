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
		 url:"${ctx}/saleChance/pageList.action",
		  method:"get",
		  fit:true,
		  fitColumns:true,
		  pagination:true,
		  toolbar:"#toolbar",
		  columns:[[
                    {field:"cb",checkbox:true,align:"center"},
					{field:"id",title:"编号",width:80,align:"center"},
					{field:"customerName",title:"客户名称",width:80,align:"center"},
					{field:"overview",title:"概要",width:80,align:"center"},
					{field:"linkMan",title:"联系人",width:80,align:"center"},
					{field:"linkPhone",title:"联系电话",width:80,align:"center"},
					{field:"createMan",title:"创建人",width:80,align:"center"},
					{field:"createTime",title:"创建时间",width:80,align:"center"},
					{field:"status",title:"状态",width:80,align:"center",
						formatter:function(value,row,index){
		                  if(value=='1'){return '已分配'}  
		                  else if(value=='0'){return '未分配'}                        
		                 }
					},
		           ]],
	  });
        $("#dialog").dialog({
        	    closed:true,
        	    buttons:[
        	       {
        	    	   text:"保存",
        	    	   iconCls:"icon-ok",
        	    	   handler:function(){
        	    		   doAddOrUpdate();
        	    	   }
        	       },
        	       {
        	    	   text:"关闭",
        	    	   iconCls:"icon-cancel",
        	    	   handler:function(){
        	    		   $("#dialog").dialog("close");
        	    	   }
        	       }
        	             ]
        });
  });
  /* 搜索 */
 		function doSearch(){
 			$('#datagrid').datagrid('load', {    
 				saleChanceName : $("#s_saleChanceName").val(),    
 				saleChanceValue : $("#s_saleChanceValue").val(),   
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
 								url : "${ctx}/saleChance/delete.action",
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
 		var url;
 		function openAddDialog(){
 			url="${ctx}/saleChance/add.action";
 			$("#dialog").dialog("open").dialog("setTitle","添加信息");
 			$("#form").form("clear");
 		}
 	    function openUpdateDialog(){
 	    	url="${ctx}/saleChance/update.action";
 	    	var selections = $("#datagrid").datagrid("getSelections");
 	    	if(selections.length == 0){
 	    		$.messager.alert("系统提示","请选择要修改的行");
 	    		return;
 	    	}
 	    	var row = selections[0];
 	    	$("#dialog").dialog("open").dialog("setTitle","修改信息");
 	    	$("form").form("load",row);
 	    }
 	    function doAddOrUpdate(){
 	    	$("#form").form("submit",{
 	    		url:url,
 	    		onSubmit:function(){
 	    			/* if($("#roleName").combobox("getValue")==""){
 	    				$.messager.alert("系统提示","请选择用户角色");
 	    				return false; 
 	    			}*/
 	    			/* return true; */
 	    			return $(this).form('validate');//返回false终止表单提交
 	    		},
 	    		success:function(data){
 	    			console.log(data);
 	    			var jsonObj = eval("(" + data + ")");
 	    			$.messager.alert("系统提示",jsonObj.msg);
 	    			if(jsonObj.status==util.SUCCESS){
 	    				$("#dialog").dialog("close");
 	    				$("#datagrid").datagrid("reload");
 	    			}
 	    		}
 	    	})
 	    }
 	    
</script>
</head>
<body>
   <table id="datagrid"></table>
   <!-- toolbar开始 -->
	<div id="toolbar">
		<a href="javascript:openAddDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
		<a href="javascript:openUpdateDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
		<a href="javascript:doDelete()" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
		<div>
				数据字典名：<input class="easyui-combobox" name="dept" id="s_saleChanceName"
				    data-options="
				          url:'${ctx}/saleChance/selectDataDicName1.action',
				          valueField:'saleChanceName',
				          textField:'saleChanceName',
				          panelHeight:'auto', 
				          editable:false,"/>
				数据字典值：<input type="text" id="s_saleChanceValue"/>
			<a href=" javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
	</div>
 	<!-- toolbar结束 -->
 	
 	<!-- 添加和修改dialog结束 -->
 	<div id="dialog" style="width: 650;height:280,padding:10px 20px">
 	    <form action="" id="form" method="post">
 	         <input type="hidden" id="id" name="id"/>
 	         <table cellspacing="8px">
 	            <tr>
 	              <td>数据字典名：</td>
 	              <!-- <td><input type="text" id="saleChanceName" name="saleChanceName" class="easyui-validatebox" required="true"/><font color="red">*</font></td> -->
 	               <td><input class="easyui-combobox" name="saleChanceName" id="saleChanceName" required='true'
				      data-options="
				          url:'${ctx}/saleChance/selectDataDicName1.action',
				          valueField:'saleChanceName',
				          textField:'saleChanceName',
				          panelHeight:'auto', "/><font color="red">*<font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>数据字典值：</td>
 	              <td><input type="text" id="saleChanceValue" name="saleChanceValue" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
 	         </table>
 	    </form>
 	</div>
 	<!-- 添加和修改的dialog结束 -->
</body>
</html>