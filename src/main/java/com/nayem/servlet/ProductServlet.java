package com.nayem.servlet;

import com.nayem.database.JdbcDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/product-edit")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String price=req.getParameter("price");
        String type=req.getParameter("type");
        String percentage=req.getParameter("percentage");
        try(Statement statement=((Connection)((JdbcDatabase)(getServletContext().getAttribute(JdbcDatabase.JDBC_CONNECTION))).getConnection()).createStatement()) {
            statement.executeUpdate("UPDATE product SET name='"+name+"',price='"+price+"',type='"+type+"',percentage='"+percentage+"' WHERE id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("user_home.jsp");
    }
}
