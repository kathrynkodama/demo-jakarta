package io.openliberty.sample.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.annotation.HandlesTypes;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import java.io.IOException;


// ?? Why HttpConstraint fine without value
@ServletSecurity(@HttpConstraint(rolesAllowed = "admin"))
public class SimpleHelloFilter implements MyInterface, Filter {
    
   
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