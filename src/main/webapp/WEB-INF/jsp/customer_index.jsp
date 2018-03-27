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
		 url:"${ctx}/customer/pageList.action",
		  method:"get",
		  fit:true,
		  fitColumns:true,
		  pagination:true,
		  toolbar:"#toolbar",
		  columns:[[
                    {field:"cb",checkbox:true,align:"center"},
					{field:"id",title:"编号",width:80,align:"center"},
					{field:"num",title:"客户编号",width:80,align:"center"},
					{field:"name",title:"客户姓名",width:80,align:"center"},
					{field:"managerName",title:"客户经理",width:80,align:"center"},
					{field:"level",title:"客户等级",width:80,align:"center"},
					{field:"phone",title:"联系电话",width:80,align:"center"},
					{field:"region",title:"客户地区",width:80,align:"center"},
					{field:"satisfy",title:"客户满意度",width:80,align:"center"},
					{field:"credit",title:"客户信用度",width:80,align:"center"},
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
 				num : $("#s_num").val(),    
 				name : $("#s_name").val(),   
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
 								url : "${ctx}/customer/delete.action",
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
 			url="${ctx}/customer/add.action";
 			$("#dialog").dialog("open").dialog("setTitle","添加信息");
 			$("#form").form("clear");
 		}
 	    function openUpdateDialog(){
 	    	url="${ctx}/customer/update.action";
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
				客户编号：<input type="text" id="s_num"/>
				客户名称：<input type="text" id="s_name"/>
			<a href=" javascript:doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
	</div>
 	<!-- toolbar结束 -->
 	
 	<!-- 添加和修改dialog结束 -->
 	<div id="dialog" style="width: 700;height:280,padding:10px 20px">
 	    <form action="" id="form" method="post">
 	         <input type="hidden" id="id" name="id"/>
 	         <table cellspacing="8px">
 	            <tr>
 	              <td>客户编号：</td>
 	              <td><input type="text" id="name" name="name" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>客户姓名：</td>
 	              <td><input type="text" id="model" name="model" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
 	            <tr>
 	              <td>客户地区：</td>
 	              <td><input type="text" id="unit" name="unit" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>客户经理姓名：</td>
 	              <td>
 	              <input class="easyui-combobox" name="dept" id="s_managerName"
				    data-options="
				          url:'${ctx}/customer/selectManagerName.action',
				          valueField:'managerName',
				          textField:'managerName',
				          panelHeight:'auto', 
				          editable:false,"/>
 	              <font color="red">*<font>
 	              </td>
 	            </tr>
 	            <tr>
 	              <td>客户等级：</td>
 	              <td>
 	              <input class="easyui-combobox" name="dept" id="s_level"
				    data-options="
				          url:'${ctx}/customer/selectLevel.action',
				          valueField:'customerName',
				          textField:'customerName',
				          panelHeight:'auto', 
				          editable:false,"/>
 	              <font color="red">*</font>
 	              </td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>客户满意度：</td>
 	              <td>
 	              <select id="s_satisfy" class="easyui-combobox" 
					editable="false" panelHeight="auto">      <!-- editable:控制不能输入。panelHeight：大小适应 -->
					<option value="">请选择...</option>
					<option value="☆">☆</option>
					<option value="☆☆">☆☆</option>
					<option value="☆☆☆">☆☆☆</option>
					<option value="☆☆☆☆">☆☆☆☆</option>
					<option value="☆☆☆☆☆">☆☆☆☆☆</option>
				 </select>
 	              <font color="red">*<font>
 	              </td>
 	            </tr>
 	             <tr>
 	              <td>客户信用度：</td>
 	              <td>
 	               <select id="s_credit" class="easyui-combobox" 
					editable="false" panelHeight="auto">      <!-- editable:控制不能输入。panelHeight：大小适应 -->
					<option value="">请选择...</option>
					<option value="☆">☆</option>
					<option value="☆☆">☆☆</option>
					<option value="☆☆☆">☆☆☆</option>
					<option value="☆☆☆☆">☆☆☆☆</option>
					<option value="☆☆☆☆☆">☆☆☆☆☆</option>
				 </select>
 	              <font color="red">*</font>
 	              </td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>客户地址：</td>
 	              <td><input type="text" id="remark" name="remark" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
 	             <tr>
 	              <td>邮政编码：</td>
 	              <td><input type="text" id="stock" name="stock" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>联系电话：</td>
 	              <td><input type="text" id="remark" name="remark" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
 	             <tr>
 	              <td>传真：</td>
 	              <td><input type="text" id="stock" name="stock" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>网址：</td>
 	              <td><input type="text" id="remark" name="remark" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
 	             <tr>
 	              <td>营业执照注册号：</td>
 	              <td><input type="text" id="stock" name="stock" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>法人：</td>
 	              <td><input type="text" id="remark" name="remark" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
  	            <tr>
 	              <td>注册资金(万元)：</td>
 	              <td><input type="text" id="stock" name="stock" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>年营业额：</td>
 	              <td><input type="text" id="remark" name="remark" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
 	            <tr>
 	              <td>开户银行：</td>
 	              <td><input type="text" id="stock" name="stock" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>开户帐号：</td>
 	              <td><input type="text" id="remark" name="remark" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
 	            <tr>
 	              <td>地税登记号：</td>
 	              <td><input type="text" id="stock" name="stock" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 	              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	              <td>国税登记号：</td>
 	              <td><input type="text" id="remark" name="remark" class="easyui-validatebox" required="true"/><font color="red">*<font></td>
 	            </tr>
 	         </table>
 	    </form>
 	</div>
 	<!-- 添加和修改的dialog结束 -->
</body>
</html>