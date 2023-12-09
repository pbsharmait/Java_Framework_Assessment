<%@page import="com.dao.UserDao"%>
<%@page import="com.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">List of Employee</h1>
<table width="100%" cellpadding="10px" cellspacing="10px">
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Address</th>
<th>Gender</th>
<th>Password</th>
<th>EDIT</th>
<th>DELETE</th>


</tr>

<%
   List<User> list=UserDao.getAllUser();
for(User u:list )
{
%>
<tr>
<td><%=u.getId()%></td>
<td><%=u.getFname()%></td>
<td><%=u.getLname()%></td>
<td><%=u.getEmail()%></td>
<td><%=u.getMobile()%></td>
<td><%=u.getAddress()%></td>
<td><%=u.getGender()%></td>
<td><%=u.getPassword()%></td>
<td>
<form name="edit" method="post" action="UserController">
<input type="hidden" name="id" value="<%=u.getId()%>">
<input type="submit" name="action" value="EDIT" class="btn btn-primary" >
</form>
</td>
<td>
<form name="delete" method="post" action="UserController">
<input type="hidden" name="id" value="<%=u.getId()%>">
<input type="submit" name="action" value="DELETE" class="btn btn-danger">
</form>
</td>
</tr>
<%
}



%>

</table>
</body>
</html>