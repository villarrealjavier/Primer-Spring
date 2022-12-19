package com.jacaranda.prueba.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.prueba.model.Calculator;


@Controller
public class ControladorPrincipal {
	
	@GetMapping("/")
	public String principal() {
		return "redirect:/listStudent";
	}
	//PRIMERA FORMA DE PONER UN PARAMETRO QUE SEA DE TIPO NO REQUERIDO
//	@GetMapping("/Welcome")
//	public String welcome(Model model, @RequestParam(required=false,defaultValue = "Debes pasarme un nombre",name="nombre")String name) {
//		model.addAttribute("mensaje", "Bienvenido: "+name);
//		return "index";
//	}
//	
	@GetMapping("/Welcome")
	public String welcome(Model model, @RequestParam(name="nombre")Optional<String> name) {
		model.addAttribute("mensaje", "Bienvenido: "+name.orElse("Debes escribir un nombre"));
		return "index";
	}
	@GetMapping("/suma")
	public String suma(Model model) {
		Calculator calc = new Calculator();
		model.addAttribute("calc", calc);
		return "calculator";
	}
	
	@PostMapping("/suma/submit")
	public String sumaSubmit(Model model, @ModelAttribute("calc")Calculator c) {
		model.addAttribute("resultado",c.calculo());
		return "resultado";
	}

}
