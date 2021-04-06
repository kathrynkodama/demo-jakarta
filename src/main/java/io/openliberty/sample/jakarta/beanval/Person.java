package io.openliberty.sample.jakarta.beanval;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public class Person {
	
	@Positive
    private Integer studentId;
	
	@NotNull
	private String name;

    @Positive
    private int age;

//    @AssertTrue
//    private boolean isSubscribed;
//    
//    @AssertTrue
//    public boolean isHuman() {
//        return true;
//    }
    
//    @AssertFalse
//    public static boolean isCat() {
//        return false;
//    }
    
    public String getName() {
    	return this.name;
    }
    
    public Person(String name) {
    	this.name = name;
    }
}
