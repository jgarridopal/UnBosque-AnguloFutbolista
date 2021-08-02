package com.unBosque.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "country")
	private String country;

	@Column(name = "flag")
	private String flag;

	@Column(name = "group")
	private char group;

	@Column(name = "playedGames")
	private int playedGames;

	@Column(name = "wonMatches")
	private int wonMatches;

	@Column(name = "tiedMatches")
	private int tiedMatches;

	@Column(name = "lostMatches")
	private int lostMatches;

	@Column(name = "goalsFavor")
	private int goalsFavor;

	@Column(name = "goalsAgainst")
	private int goalsAgainst;

	@Column(name = "state")
	private char state;

	public Team() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public char getGroup() {
		return group;
	}

	public void setGroup(char group) {
		this.group = group;
	}

	public int getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}

	public int getWonMatches() {
		return wonMatches;
	}

	public void setWonMatches(int wonMatches) {
		this.wonMatches = wonMatches;
	}

	public int getTiedMatches() {
		return tiedMatches;
	}

	public void setTiedMatches(int tiedMatches) {
		this.tiedMatches = tiedMatches;
	}

	public int getLostMatches() {
		return lostMatches;
	}

	public void setLostMatches(int lostMatches) {
		this.lostMatches = lostMatches;
	}

	public int getGoalsFavor() {
		return goalsFavor;
	}

	public void setGoalsFavor(int goalsFavor) {
		this.goalsFavor = goalsFavor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

}
