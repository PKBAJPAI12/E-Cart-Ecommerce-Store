<%@page import="helper.FactoryProvider" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="common_css_js.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="register.jsp">Register</a>



</body>
</html>