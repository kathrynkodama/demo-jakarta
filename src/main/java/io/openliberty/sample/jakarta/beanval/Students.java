package io.openliberty.sample.jakarta.beanval;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/Students")
public class Students {

	@Resource
	UserTransaction utx;

	@PersistenceContext(name="jpa-unit")
	EntityManager em;

	public void createStudent(Person s) {
		try {
			utx.begin();
			em.persist(s);
			utx.commit();
		} catch (Exception e) {
            System.out.println("Exception in create: " + e.getMessage());
        }
	}

	public List<Person> readAllStudents() {
		return em.createNamedQuery("Person.findAll", Person.class).getResultList();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getStudents() {
		List<Person> students = new ArrayList<Person>();
		for (Person p: this.readAllStudents()) {
			students.add(p);
		}
		return students;
	}
	
	@POST
	@Path("/{name}/{age}")
	public void createNewStudent(@PathParam("name") String name, @PathParam("age") int age) {
		System.out.println("Creating student: " + name + "; " + age);
		try {
			Person student = new Person(name, age);
			this.createStudent(student);
		} catch (Exception e) {
			System.out.println("Could not create a new student " + e.getMessage());
		}
		
	}
}