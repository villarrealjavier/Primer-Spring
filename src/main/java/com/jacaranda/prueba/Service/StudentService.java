package com.jacaranda.prueba.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.prueba.model.Student;

@Service
public class StudentService {
	private List<Student> lista;
	
	

	public StudentService() {
		lista= new ArrayList<Student>();
		lista.add(new Student("Inma", "Olias", 50));
		lista.add(new Student("Juanma", "Garcia", 50));
		lista.add(new Student("Javi", "Leon", 50));
		lista.add(new Student("Sergio", "Romero", 20));
	}

	public List<Student> getLista() {
		return lista;
	}

	public void setLista(List<Student> lista) {
		this.lista = lista;
	}
	
	public boolean add(Student arg0) {
		return lista.add(arg0);
	}

	public Student get(String nombre, String apellido) {
		Iterator<Student> iterador = lista.iterator();
		boolean encontrado=false;
		Student u=null;
		while(iterador.hasNext()) {
			u= iterador.next();
			if(u.getName().equals(nombre) && u.getSurname().equals(apellido)) {
				encontrado=true;
			}
			
		}
		if(encontrado==true) {
			return u;
		}else {
			return null;
		}
		
	}
	
	public Student updateStudent(String nombre, String apellido,int edad) {
		Iterator<Student> iterador = lista.iterator();
		boolean encontrado=false;
		Student u=null;
		while(iterador.hasNext()) {
			u= iterador.next();
			if(u.getName().equals(nombre) && u.getSurname().equals(apellido)) {
				u.setAge(edad);
				encontrado=true;
			}
			
		}
		if(encontrado==true) {
			return u;
		}else {
			return null;
		}
		
	}

	public boolean remove(Student student) {
		return lista.remove(student);
	}
}
