package com.nayem.servlet.listener;

import com.nayem.database.JdbcDatabase;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(JdbcDatabase.JDBC_CONNECTION,JdbcDatabase.getInstance());
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
