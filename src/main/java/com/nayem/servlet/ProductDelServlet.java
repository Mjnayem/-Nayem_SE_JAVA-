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

@WebServlet("/product-del")
public class ProductDelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        try(Statement statement=((Connection)((JdbcDatabase)(getServletContext().getAttribute(JdbcDatabase.JDBC_CONNECTION))).getConnection()).createStatement()) {
            statement.execute("DELETE FROM product WHERE id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("user_home.jsp");
    }
}
