package br.com.cdw.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Clients {
	
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 private Users user;
	 
	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private Users getUser() {
		return user;
	}

	private void setUser(Users user) {
		this.user = user;
	}

}
