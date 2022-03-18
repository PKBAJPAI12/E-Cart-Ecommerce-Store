<%@ page import="Model.User" %>
<% User user=(User)session.getAttribute("current-user");
if(user==null){
    session.setAttribute("message","You are not Logged In");
    response.sendRedirect("login.jsp");
    return;

}
else{
    if(user.getUserType().equals("normal")){
        session.setAttribute("message","You are not Admin Please Login with Admin");
        response.sendRedirect("login.jsp");
        return;
    }
    else{

    }
}
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mycart-Admin</title>
    <%@include file="common_css_js.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<h1>This is Admin Page</h1>
</body>
</html>
