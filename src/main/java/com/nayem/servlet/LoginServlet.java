package com.nayem.servlet;

import com.nayem.database.JdbcDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String password=req.getParameter("password");
        JdbcDatabase database= (JdbcDatabase) getServletContext().getAttribute(JdbcDatabase.JDBC_CONNECTION);

        try {
            ResultSet resultSet=database.getConnection().createStatement().executeQuery("SELECT * FROM USER WHERE username='"+name+"' AND password='"+password+"'");
            if(resultSet.next()) {
                resp.sendRedirect("user_home.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
