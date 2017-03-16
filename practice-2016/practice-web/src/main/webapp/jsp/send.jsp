<%--
  Created by IntelliJ IDEA.
  User: Sophya
  Date: 29.11.2016
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<html>
<head>
    <title>Contact Us</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet">
    <link href="<c:url value="/resources/css/app.css"/> " rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>
</head>
<body>
<div class="feedback-form">
    <c:url var="sendUrl" value="/send" />
    <form:form action="${sendUrl}" method="post" class="form-horizontal">
        <div class="input-group input-sm">
            <label class="input-group-addon" for="theme"></label>
            <input type="text" class="form-control" id="theme" name="theme" placeholder="Theme" required>
        </div>
        <div class="input-group input-sm">
            <label class="input-group-addon" for="email"></label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Your e-mail" required>
        </div>
        <div class="input-group input-sm">
            <label class="input-group-addon" for="message"></label>
            <input type="text" class="form-control" id="message" name="message" placeholder="Your message" required>
        </div>
        <div class="form-actions">
            <input type="submit"
                   class="btn btn-block btn-primary btn-default" value="Send">
        </div>
    </form:form>
</div>
</body>
</html>
