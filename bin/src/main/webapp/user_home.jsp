<%@ page import="com.nayem.database.JdbcDatabase" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nayem.model.Product" %>
<%@ page import="com.nayem.dao.ProductDao" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 7/28/2018
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="insert_product.jsp">Product Insert</a><br><br><br><br><br><br>
    <div>
        <%
            List<Product> products= ProductDao.getAll((Connection) ((JdbcDatabase)(application.getAttribute(JdbcDatabase.JDBC_CONNECTION))).getConnection());

            for(Product product:products) {
                out.println("<h4>"+product.getName()+"</h4>");
                out.println("<p>"+product.getPrice()+"</p>");
                out.println("<form>\n" +
                        "            <a href=edit_product.jsp?id="+product.getId()+">edit</a>\n" +
                        "        </form>\n" +
                        "        <form>\n" +
                        "            <a href=/product-del?id="+product.getId()+">Delete</a>\n" +
                        "        </form>");
            }
        %>

    </div>
</body>
</html>
