package br.com.cdw.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Users {
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 private String 	name;
	 private String 	email;
	 private String 	password;
	 private Date 		created_at;
	 private Date 		updated_at;
	 private Boolean 	is_enabled;
	 
	 @OneToOne @PrimaryKeyJoinColumn
	 private Clients client;

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private Date getCreated_at() {
		return created_at;
	}

	private void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	private Date getUpdated_at() {
		return updated_at;
	}

	private void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	private Boolean getIs_enabled() {
		return is_enabled;
	}

	private void setIs_enabled(Boolean is_enabled) {
		this.is_enabled = is_enabled;
	}

	private Clients getClient() {
		return client;
	}

	private void setClient(Clients client) {
		this.client = client;
	}
}
