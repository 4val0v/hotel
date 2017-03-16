<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Stat</title>
</head>
<body>
    <a>Текущая дата: ${date} </a> </br>
    <a>Количество записей в таблице статистики: ${stats} </a> </br>
    </br>
    <a>Количество занятых номеров: ${orders} </a> </br>
    <a>Общее количество номеров: ${roomsNumber} </a> </br>
    </br>
    <a>Количество гостей: ${guestsNumber} </a> </br>
    <a>Общая вместительность(возможное кол-во человек): ${allPlaces} </a> </br>
    </br>
    <a>Средний рейтинг по всем комнатам: ${avgRating} </a> </br>
    </br>
    </br>
    </br>
    </br>
    <a>Дата первого заказа: ${dateOrder} </a> </br>
    <a>Дата следующего дня первого заказа: ${nextDateOrder} </a> </br>


</body>
</html>