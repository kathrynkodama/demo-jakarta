package io.openliberty.sample.system;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public static final String URL_PATTERN = "HelloServlet";

   public static final String MESSAGE = "Hello Jakarta EE 9 Servlet!";

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().append(MESSAGE);
   }
}