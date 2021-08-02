package com.unBosque.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parameter")
public class Parameter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name="parameterType")
	private char parameterType;
	
	@Column(name="parameterCode")
	private int parameterCode;
	
	@Column(name="descriptionParameter")
	private String descriptionParameter;
	
	@Column(name="textValue")
	private String textValue;
	
	@Column(name="numberValue")
	private int numberValue;
	
	public Parameter() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getParameterType() {
		return parameterType;
	}

	public void setParameterType(char parameterType) {
		this.parameterType = parameterType;
	}

	public int getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(int parameterCode) {
		this.parameterCode = parameterCode;
	}

	public String getDescriptionParameter() {
		return descriptionParameter;
	}

	public void setDescriptionParameter(String descriptionParameter) {
		this.descriptionParameter = descriptionParameter;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public int getNumberValue() {
		return numberValue;
	}

	public void setNumberValue(int numberValue) {
		this.numberValue = numberValue;
	}
	
	
	
	
}
