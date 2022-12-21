package com.nttdatacenters.springt3.arr.persistence;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * 
 * @author Alexandra Rodríguez
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	
	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** User de creación */
	private String createUser;

	/** Fecha de creación */
	private String createDate;
	
	/**
	 * @return the createUser
	 */
	@Column(name = "C_CREATE_USER")
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * @return the createDate
	 */
	@Column(name = "C_CREATE_DATE")
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;}

}
