package io.openliberty.sample.jakarta.jsonp;

import java.time.LocalDate;

public class Developer {
	
	private String name;
	private LocalDate birthday;
	private String[] languages;
	
	public Developer() {
		
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}
