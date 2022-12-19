package com.jacaranda.prueba.model;

import java.util.Objects;

import jakarta.validation.constraints.Min;

public class Student {
	private String name;
	private String surname;
	@Min(value=0, message="La edad debe ser mayor que cero")
	private Integer age;
	
	
	public Student(String name, String surname, Integer age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	public Student() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(age, name, surname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}
	
	
}
