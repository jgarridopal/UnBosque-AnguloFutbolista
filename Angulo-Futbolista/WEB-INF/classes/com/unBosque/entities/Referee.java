package com.unBosque.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "referee")
public class Referee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2940153855086505011L;

	@Id
	private int id;

	@Column(name = "fullName")
	private String fullName;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "state")
	private char state;

	public Referee() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

}
