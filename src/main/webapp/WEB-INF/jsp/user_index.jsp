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
		  pagination:true,
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
</script>
</head>
<body>
   <table id="datagrid"></table>
</body>
</html>