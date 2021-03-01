package io.openliberty.sample.jakarta.cdi;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Greeting {

    public String greet(String name) {
        return "Hello, " + name;
    }

}