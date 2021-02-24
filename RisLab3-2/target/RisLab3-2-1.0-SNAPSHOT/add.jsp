<%--
  Created by IntelliJ IDEA.
  User: vadim
  Date: 10.02.2021
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new one</title>
</head>
<body>
<form action="addNew" method="post">
    <h3>Введите название компании:</h3>
    <input type="text" name="name" value="" style = "width: 200px"/> <br>
    <h3>Введите стоимость курса:</h3>
    <input type="text" name="price" value="" style = "width: 200px"/> <br>
    <h3>Введите способ оплаты:</h3>
    <input type="text" name="wayToPay" value="" style = "width: 200px"/> <br>
    <input type="submit" value="Подтвердить" style="width: 150px;margin-top: 15px"/>
</form>
</body>
</html>
