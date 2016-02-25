<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList,com.yodlee.DataBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSV WebUI</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Username</th>
				<th>Password</th>
			</tr>
		</thead>
		<tbody>
			<%
	for(DataBean bean:(ArrayList<DataBean>)request.getAttribute("data")){
%>
			<tr>
				<td><%=bean.getUsername() %></td>
				<td><%=bean.getPassword() %>
			</tr>
			<%
	}
%>
		</tbody>
	</table>
</body>
</html>