package io.openliberty.sample.jakarta.beanval;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

@Entity
public class PersonEntity {
	
//	@Positive
	private String name;

//    @Email
    private int age;

//    @AssertTrue
//    private boolean isSubscribed;
//    
    @AssertTrue
    public boolean isHuman() {
        return true;
    }
    
//    @AssertFalse
//    public static boolean isCat() {
//        return false;
//    }
    
    public PersonEntity() {
    	// this constructor has args!
    }
    
    public PersonEntity(String name) {
    	this.name = name; 
    }
}
