package io.openliberty.sample.system;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.UserTransaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "catViewer", urlPatterns = { "/cats" })
public class CatViewer extends HttpServlet {
	
	@Resource
	UserTransaction utx;
	
	@PersistenceContext(name="catctx")
	EntityManager em;
	
	// tag::createEvent[]
    public void createCat(Cat c) {
        // tag::Persist[]
        try {
            utx.begin();
            em.persist(c);
            utx.commit();
        } catch (Exception e) {
            System.out.println("Exception in create: " + e.getMessage());
        }
        
        // end::Persist[]
    }
    // end::createEvent[]

    // tag::readEvent[]
    public List<Cat> readAllCats() {
        return em.createNamedQuery("Cat.findAll", Cat.class).getResultList();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<String> cats = new ArrayList<String>();
		for (Cat c: this.readAllCats()) {
			cats.add(c.toString());
		}
		res.setContentType("text/html;charset=UTF-8");
		res.getWriter().println(cats.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String color = req.getParameter("color");
		if (color != null) {
			try {
				Cat c = new Cat(color);
				this.createCat(c);
				res.getWriter().println("Success! Cat Created!");
				
			} catch (Exception e){
				
			}
		}
		res.setContentType("text/html;charset=UTF-8");
		res.getWriter().println("Example HTTP GET request for HTTPServlet");
	}
	
	
	
}