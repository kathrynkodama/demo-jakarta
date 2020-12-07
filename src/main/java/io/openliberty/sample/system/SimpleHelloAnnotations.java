package io.openliberty.sample.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.Priority;
import jakarta.annotation.Resource;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed(value = { "" })
@ManagedBean
public class SimpleHelloAnnotations {
 
	@Resource
	String mydb;
	
	int priority;
	
    
    @RolesAllowed(value = { "" })
    protected void doGet(@Priority(value = 2) HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("Hello Jakarta EE 9!");
    }
}