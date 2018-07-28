<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 7/28/2018
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
<h2>Insert Product</h2>
<form  method="post" action="/product-insert">
    Name:<input type="text" name="name"><br>
    Price:<input type="text"  name="price"><br>
    Type:<input type="text"  name="type"><br>
    Percentage:<input type="text" name="percentage"><br>
    <input type="submit" value="Edit">
</form>
</body>
</html>
