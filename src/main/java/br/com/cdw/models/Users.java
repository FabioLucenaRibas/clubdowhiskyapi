package br.com.cdw.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Users {
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 private String 	name;
	 private String 	email;
	 private String 	password;
	 private String		created_at;
	 private String		updated_at;
	 private Boolean 	is_enabled;
	 
	 @OneToOne @PrimaryKeyJoinColumn @JsonBackReference
	 private Clients client;

	 public String getName() {
		return name;
	}

	 public void setName(String name) {
		this.name = name;
	}

	 public String getEmail() {
		return email;
	}

	 public void setEmail(String email) {
		this.email = email;
	}

	 public String getPassword() {
		return password;
	}

	 public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIs_enabled() {
		return is_enabled;
	}

	public void setIs_enabled(Boolean is_enabled) {
		this.is_enabled = is_enabled;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
}
