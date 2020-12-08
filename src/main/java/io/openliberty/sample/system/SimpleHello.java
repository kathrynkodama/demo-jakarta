package io.openliberty.sample.system;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSessionAttributeListener;

import java.io.IOException;

//@WebServlet(name = "hello", urlPatterns = { "/hello" })

//@WebFilter(filterName = "hello", urlPatterns = { "/hello" })

@WebListener
public abstract class SimpleHello implements HttpSessionAttributeListener {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("Hello Jakarta EE 9!");
    }
}