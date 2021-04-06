package io.openliberty.sample.jakarta.beanval;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/Students")
public class Students {
	
	List<PersonEntity> students;

	public Students() {
		students = new ArrayList<PersonEntity>();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<PersonEntity> getStudents() {
		System.out.println("getting student");
		return this.students;
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.TEXT_PLAIN)
	public void createStudent(String message) {
		PersonEntity student = new PersonEntity(message);
		this.students.add(student);
		System.out.println("creating student");
	}
}