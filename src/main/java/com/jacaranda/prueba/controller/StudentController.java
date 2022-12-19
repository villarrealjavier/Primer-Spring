package com.jacaranda.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.prueba.Service.StudentService;
import com.jacaranda.prueba.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentService repositorio;
	
	@GetMapping("listStudent")
	public String listStudent(Model model) {
		model.addAttribute("listStudent",repositorio.getLista());
		return "listStudent";
				
	}
	@GetMapping("login")
	public String login() {
		
		return "login";
				
	}
	
	@GetMapping("addStudent")
	public String addStudent(Model model) {
		Student u= new Student();
		model.addAttribute("student", u);
		return "addStudent";
	}
	@GetMapping("deleteStudent")
	public String deleteStudent(Model model, @RequestParam(name="name")String name,
			@RequestParam(name="surname")String surname) {
		Student student = repositorio.get(name, surname);
		model.addAttribute("student", student);
		return "deleteStudent";
	}
	@GetMapping("updateStudent")
	public String updateStudent(Model model, @RequestParam(name="name")String name,
			@RequestParam(name="surname")String surname) {
		Student student = repositorio.get(name, surname);
		model.addAttribute("student", student);
		return "updateStudent";
	}
	@PostMapping("updateStudent/submit")
	public String updateresult(@Validated @ModelAttribute("estudiante")Student u,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "updateStudent";
		}
		repositorio.updateStudent(u.getName(), u.getSurname(), u.getAge());
		
		
		return "redirect:/listStudent";
		
	}
	@PostMapping("deleteStudent/submit")
	public String deleteresult(@ModelAttribute("estudiante")Student u) {
		repositorio.remove(u);
		
		return "redirect:/listStudent";
		
	}
	
	@PostMapping("addStudent/submit")
	public String result(@Validated @ModelAttribute("student")Student u,BindingResult bindingresult) {
		if(bindingresult.hasErrors()) {
			return "addStudent";
		}else {
			repositorio.add(u);
			return "redirect:/listStudent";
			
		}
		
		
	}

}
