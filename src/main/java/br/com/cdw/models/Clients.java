package br.com.cdw.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clients {
	
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;

	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

}
