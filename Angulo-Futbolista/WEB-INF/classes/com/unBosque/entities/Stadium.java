package com.unBosque.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity
@Table(name="stadium")
public class Stadium implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5568851946836279500L;

	@Id
	private int id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="capacity")
	private int capacity;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="temperature")
	private String temperature;
	
	@Column(name="population")
	private int population;
	
	public Stadium () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	
}
