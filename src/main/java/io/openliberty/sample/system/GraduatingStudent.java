package io.openliberty.sample.system;

import java.io.IOException;
import java.math.BigInteger;
import java.time.chrono.JapaneseDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;


public class GraduatingStudent {
	
	@Positive
	private Integer studentId;	
	
	@AssertTrue
	private boolean isHappy;
	
	@AssertFalse
	private boolean isSad;
	
	@FutureOrPresent
	private Calendar graduationDate;
	
	
	@Min(value = 50)
	@Max(value = 100)
	private Integer gpa;
	
	@Email
	private String emailAddress;
	
	
	
    public GraduatingStudent(Integer studentId, Boolean isHappy, boolean isSad, Calendar graduationDate, Integer gpa,
    		String emailAddress) {
    	
        this.studentId = studentId;
        this.isHappy = isHappy;
        this.isSad = isSad;
        this.graduationDate = graduationDate;
    	this.gpa = gpa;
        this.emailAddress = emailAddress;
        
        
    }
	
	
	
    public void PrintGraduationMessage() {

    	System.out.println("Congrats class of " /* +  graduationDate.toString() */);
    }

}
