package io.openliberty.sample.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Cat")
@NamedQuery(name="Cat.findAll", query="Select c FROM Cat c")
public class Cat {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="catId")
	private int id;

	@Column(name="Color")
	private String Color;

	public Cat() { 
	}
	
	public Cat(String color) {
		this.Color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String example) {
		this.Color = example;
	}
	
	public String toString() {
		return "Cat [color=" + Color + ", id=" + id
                + "]";
	}
}