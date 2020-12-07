package io.openliberty.sample.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Constraint;
import jakarta.validation.*;

import java.io.IOException;
import java.lang.annotation.*;



@Target( { METHOD, FIELD, PARAMETER })
@Retention(value = null)
@Constraint(validatedBy = { null })
public @interface SimpleHelloConstraint {
    String message() default "{com.example.validation.constraints.email}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}