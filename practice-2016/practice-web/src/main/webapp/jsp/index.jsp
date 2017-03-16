<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Relex Practice</title>

    <c:url value="/resources/css/bootstrap.css" var="bootstrapCss"/>
    <c:url value="/resources/css/app.css" var="appCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${appCss}" rel="stylesheet"/>
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Relex Practice</a>
        </div>
        <div class="navbar-collapse collapse pull-right">
            <form:form action="/logout" method="post">
                <button type="submit" class="btn btn-sm btn-info vertical">Logout</button>
            </form:form>
        </div>
    </div>
</nav>

<div class="container" style="padding-top: 7em">
    <div class="jumbotron">
        <h1>Sample</h1>
        <p>
            <c:if test="${not empty name}">
                Hello, ${name}
            </c:if>
            <c:if test="${empty name}">
                Welcome, Anonymous! Why are you there?
            </c:if>
        </p>
    </div>
    <div style="height: auto"></div>
    <div class="pull-right bottom-right">
        Relex, 2016
    </div>
</div>

</body>
</html>