package com.mobileco.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobileco.model.Accessories;
import com.mobileco.model.Mobile;
import com.mobileco.model.Brand;

public class Product {

	private int id;
	private Accessories accessories;
	private Mobile mobile;
	private Brand brand;
	private float price;
	private int quantity;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(int id, Accessories accessories) {
		super();
		this.id = id;
		this.accessories = accessories;
	}

	public Product(int id, Mobile mobile) {
		super();
		this.id = id;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Accessories getAccessories() {
		return accessories;
	}

	@Autowired
	public void setAccessories(Accessories accessories) {
		this.accessories = accessories;
	}

	public Mobile getMobile() {
		return mobile;
	}

	@Autowired
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Brand getBrand() {
		return brand;
	}

	@Autowired
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessories == null) ? 0 : accessories.hashCode());
		result = prime * result + id;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		Product other = (Product) obj;
		if (accessories == null) {
			if (other.accessories != null)
				return false;
		} else if (!accessories.equals(other.accessories))
			return false;
		if (id != other.id)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", accessories=" + accessories + ", mobile=" + mobile + ", brand=" + brand
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}

}
