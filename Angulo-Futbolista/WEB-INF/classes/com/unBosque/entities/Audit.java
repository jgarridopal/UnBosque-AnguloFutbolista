package com.unBosque.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "audit")
public class Audit implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="userId")
	private int userId;

	@Column(name="operation")
	private String operation;

	@Column(name="tableId")
	private int tableId;

	@Column(name="tableName")
	private String tableName;

	@Column(name="createDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public Audit() {
	
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
