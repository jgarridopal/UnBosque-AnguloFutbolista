package com.unBosque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="schedule")
public class Schedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8273029849416103336L;

	@Id
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localTeam")
	private Team localTeam;
	
	@Column(name="localGoals")
	private int localGoals;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visitTeam")
	private Team visitTeam;
	
	@Column(name="visitGoals")
	private int visitGoals;
	
	@Column(name = "gameDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date gameDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStadium")
	private Stadium idStadium;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReferee")
	private Referee idReferee;
	
	@Column(name="state")
	private char state;
	
	public Schedule() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getLocalTeam() {
		return localTeam;
	}

	public void setLocalTeam(Team localTeam) {
		this.localTeam = localTeam;
	}

	public int getLocalGoals() {
		return localGoals;
	}

	public void setLocalGoals(int localGoals) {
		this.localGoals = localGoals;
	}

	public Team getVisitTeam() {
		return visitTeam;
	}

	public void setVisitTeam(Team visitTeam) {
		this.visitTeam = visitTeam;
	}

	public int getVisitGoals() {
		return visitGoals;
	}

	public void setVisitGoals(int visitGoals) {
		this.visitGoals = visitGoals;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Stadium getIdStadium() {
		return idStadium;
	}

	public void setIdStadium(Stadium idStadium) {
		this.idStadium = idStadium;
	}

	public Referee getIdReferee() {
		return idReferee;
	}

	public void setIdReferee(Referee idReferee) {
		this.idReferee = idReferee;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}
	
	
	
}
