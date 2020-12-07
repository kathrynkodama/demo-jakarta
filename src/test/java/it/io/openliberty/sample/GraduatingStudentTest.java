package it.io.openliberty.sample;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import io.openliberty.sample.system.GraduatingStudent;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class GraduatingStudentTest {

  @Test
  public void testGraduatingStudent() {
	  
	  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	  Validator validator = factory.getValidator();
	  
	  
	  Integer studentId = 7834242;
	  boolean isHappy = true;
	  boolean isSad = false;
	  Calendar graduationDate = new GregorianCalendar(2021,5,1);
	  Integer gpa = 80;
	  String emailAddress = "Student@university.ca";
	  

	  GraduatingStudent student = new GraduatingStudent(studentId , isHappy, isSad, graduationDate, gpa, emailAddress);

	  Set<ConstraintViolation<GraduatingStudent>> constraintViolations = validator.validate(student);

	  if(constraintViolations.size() > 0 )
		  Assert.fail("Constraint Violated: " +  constraintViolations.iterator().next().getMessage());

	  assertEquals(0, constraintViolations.size());
  }
  
}
