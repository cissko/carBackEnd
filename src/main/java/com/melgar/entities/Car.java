package com.melgar.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String brand, model, color, registerNumber;
	private int year, price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
	private Owner owner;
	
	public Car() {}
	
	public Car(String brand, String model, String color, String registerNumber, int year, int price, Owner owner ) {
		this.brand=brand;
		this.model=model;
		this.color=color;
		this.registerNumber=registerNumber;
		this.year=year;
		this.price=price;
		this.owner=owner;
	}
	public Car(String brand, String model, String color, String registerNumber, int year, int price ) {
		this.brand=brand;
		this.model=model;
		this.color=color;
		this.registerNumber=registerNumber;
		this.year=year;
		this.price=price;
		
	}
	public Car(long id,String brand, String model, String color, String registerNumber, int year, int price, Owner owner ) {
		this.id=id;
		this.brand=brand;
		this.model=model;
		this.color=color;
		this.registerNumber=registerNumber;
		this.year=year;
		this.price=price;
		this.owner=owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + price;
		result = prime * result + ((registerNumber == null) ? 0 : registerNumber.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (price != other.price)
			return false;
		if (registerNumber == null) {
			if (other.registerNumber != null)
				return false;
		} else if (!registerNumber.equals(other.registerNumber))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
	
}
