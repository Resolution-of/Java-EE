<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EJB 3.1</title>
</head>
<body>
<h3>Языковые компании</h3>
<form action="table" method="post">
    <input type="submit" value="Таблица компаний" id = "user" style = "width: 150px"/>
</form>
<table border="1" style = "margin-bottom: 50px">
    <tr>
        <th>Name</th><th>Price</th><th>Way to pay</th>
    </tr>
    <c:forEach items="${ requestScope.users}" var="company">
        <tr>
            <td><c:out value="${company.companyName }" /></td>
            <td><c:out value="${company.price }" /></td>
            <td><c:out value="${company.way_to_pay }" /></td>
        </tr>
    </c:forEach>
</table>
<form action="pay" method="post">
    Введите название компании : <input type="text" name="name" value="" style = "width: 300px"/>
    <input type="submit" value="Подтвердить" style="width: 150px"/>
</form>
<p>${answer}</p>
<form action = "price" method = "post">
    <input type ="submit" value="Наименьшая стоимость" style="width: 250px"/>
</form>
<p>${price}</p>
<form action="add" method="post">
    <input type ="submit" value="Добавить компанию" style="width: 250px"/>
</form>
</body>
</html>