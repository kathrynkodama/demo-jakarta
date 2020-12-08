package io.openliberty.sample.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.ext.Provider;


import java.io.IOException;


@Provider
@Path()
public class SimpleHelloRestful {
 
    @POST
    protected void doGet(User user, @DefaultValue(value = "") HttpServletResponse resp) throws ServletException, IOException {
 
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("Hello Jakarta EE 9!");
    }
}