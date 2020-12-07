package io.openliberty.sample.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;


import java.io.IOException;

@ServerEndpoint(value = "")
public class SimpleHelloWebSocket {
 
    protected void doGet(@PathParam("guest-id") HttpServletResponse user, HttpServletResponse resp) throws ServletException, IOException {
 
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("Hello Jakarta EE 9!");
    }
}