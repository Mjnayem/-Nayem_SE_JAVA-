<%@ page import="com.nayem.dao.ProductDao" %>
<%@ page import="com.nayem.database.JdbcDatabase" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.nayem.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 7/28/2018
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit Product</title>
</head>
<body>
    <%
        String id=request.getParameter("id");
        Product product=ProductDao.getOne((Connection) ((JdbcDatabase)(application.getAttribute(JdbcDatabase.JDBC_CONNECTION))).getConnection(),id);
    %>
    <form  method="post" action="/product-edit">
        <input type="hidden" value="<%=product.getId() %>" name="id"><br>
        Name:<input type="text" value="<%=product.getName() %>" name="name"><br>
        Price:<input type="text" value="<%=product.getPrice() %>" name="price"><br>
        Type:<input type="text" value="<%=product.getType() %>" name="type"><br>
        Percentage:<input type="text" value="<%=product.getPercentage() %>" name="percentage"><br>
        <input type="submit" value="Edit">
    </form>
</body>
</html>
