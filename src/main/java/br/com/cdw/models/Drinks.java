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
	 private String img_drink;

	 public int getId() {
		 return id;
	 }
	 
	 public void setId(int id) {
		 this.id = id;
	 }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg_drink() {
		return img_drink;
	}

	public void setImg_drink(String img_drink) {
		this.img_drink = img_drink;
	}

}
