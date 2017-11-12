package br.com.cdw.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Drinks {
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	 
	 private String name;

	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
