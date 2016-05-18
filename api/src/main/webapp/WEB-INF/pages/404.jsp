<%--
  Created by IntelliJ IDEA.
  User: developer
  Date: 2016/4/29
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
    <title>云仓平台</title>
    <meta charset="utf-8">
    <base href="${pageContext.request.contextPath }/"/>
    <link type="text/css" rel="stylesheet" href="css/amazeui.min.css">
    <link type="text/css" rel="stylesheet" href="css/404.css">
    <script type="text/javascript" src="js/jquery/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/validate.js"></script>
</head>

<body style="text-align: center">
<div style="width: 990px; margin-left: auto; margin-right: auto;">
    <div class="error404">
        <button class="am-btn errorBtn" onclick="window.location.href='${pageContext.request.contextPath }/'">返回首页</button>
    </div>
</div>
</body>