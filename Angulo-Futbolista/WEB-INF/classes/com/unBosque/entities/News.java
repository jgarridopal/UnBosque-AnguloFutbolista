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
@Table(name = "news")
public class News implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "dateNews")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateNews;

	@Column(name = "shortDescription")
	private String shortDescription;

	@Column(name = "largeDescription")
	private String largeDescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser")
	private User user;

	@Column(name = "state")
	private char state;

	
	
	public News() {

	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateNews() {
		return dateNews;
	}

	public void setDateNews(Date dateNews) {
		this.dateNews = dateNews;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLargeDescription() {
		return largeDescription;
	}

	public void setLargeDescription(String largeDescription) {
		this.largeDescription = largeDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

}
