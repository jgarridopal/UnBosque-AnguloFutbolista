package com.unBosque.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "goalscorer")
public class GoalScorer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name="fullName")
	private String fullName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team")
	private Team team;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="goals")
	private int goals;
	
	public GoalScorer () {
		
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
