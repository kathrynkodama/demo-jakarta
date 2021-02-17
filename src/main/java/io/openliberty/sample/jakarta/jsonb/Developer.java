package io.openliberty.sample.jakarta.jsonb;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;

public class Developer {

    public LocalDateTime birthdate;

    @JsonbDateFormat(value = "yyyy-MM-dd")
    public LocalDate firstHack;
    
    @JsonbCreator
    public Developer() {
    	this.birthdate = null;
    	this.firstHack = null;
    }  
    
    @JsonbCreator
    public Developer(
            @JsonbProperty("birthdate") LocalDateTime birthdate, 
            @JsonbProperty("firstHack") LocalDate firstHack) {
        this.birthdate = birthdate;
        this.firstHack = firstHack;
    }
}
