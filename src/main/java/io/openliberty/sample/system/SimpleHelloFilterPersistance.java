package io.openliberty.sample.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.annotation.HandlesTypes;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import java.io.IOException;


@EntityListeners(value = {})
@SecondaryTables(value = {})
@IdClass(value = ServletResponse)
public class SimpleHelloFilterPersistance implements MyInterface, Filter {
    
   
	@JoinColumns(value = { @JoinColumn })
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