package io.openliberty.sample.system;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionIdListener;

@WebListener()
public class SimpleHelloListener implements MyInterface {
     
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
  
    	response.setContentType("text/html;charset=UTF-8");

    	response.getWriter().println("Hello Jakarta EE 9!");
    }

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

}
