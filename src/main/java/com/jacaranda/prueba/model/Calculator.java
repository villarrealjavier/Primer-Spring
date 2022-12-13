package com.jacaranda.prueba.model;

import java.util.Objects;

public class Calculator {
	private Double number1;
	private Double number2;
	private Integer simbolo;
	
	
	public Calculator(Double number1, Double number2) {
		super();
		this.number1 = number1;
		this.number2 = number2;
	}

	public Calculator() {
		
	}


	public Double getNumber1() {
		return number1;
	}


	public void setNumber1(Double number1) {
		this.number1 = number1;
	}


	public Double getNumber2() {
		return number2;
	}


	public void setNumber2(Double number2) {
		this.number2 = number2;
	}


	public Integer getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(Integer simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number1, number2);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return Objects.equals(number1, other.number1) && Objects.equals(number2, other.number2);
	}
	
	public Double calculo() {
		Double resultado=0.0;
		if(simbolo==1) {
			resultado=this.number1+this.number2;
		}else if(simbolo==2) {
			resultado=this.number1-this.number2;
		}else if(simbolo==3) {
			resultado=this.number1*this.number2;
		}else if(simbolo==4) {
			
			resultado=this.number1/this.number2;
			
		}
		return resultado;
	}
	
	
}
