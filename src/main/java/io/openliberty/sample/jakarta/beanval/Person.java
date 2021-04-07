package io.openliberty.sample.jakarta.beanval;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Person")
@NamedQuery(name="Person.findAll", query="Select p FROM Person p")
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    	
	@NotNull
    @Column(name="name")
	private String name;

    @Positive
    private int age;

    public long getId() {
        return id;
    }
        
    public String getName() {
    	return this.name;
    }

    public int getAge() {
    	return this.age;
    }

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


    public Person() {
    }

    public Person(String name, int age) {
    	this.name = name;
        this.age = age;
    }
}
