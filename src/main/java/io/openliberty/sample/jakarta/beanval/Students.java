package io.openliberty.sample.jakarta.beanval;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/Students")
public class Students {
	
	public static List<Person> students = new ArrayList<Person>();
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getStudents() {
		return this.students;
	}
	
	@POST
	@Path("/create")
	public void createStudent(String name) {
		System.out.println("Creating student: " + name);
		Person student = new Person(name);
		this.students.add(student);
	}
}