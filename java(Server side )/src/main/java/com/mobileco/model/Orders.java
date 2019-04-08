package com.mobileco.model;

import java.time.LocalDate;

public class Orders {

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private LocalDate dateOrdered;
	private LocalDate dateExpected;
	private LocalDate dateDelivered;
	private int quantity;
	private Customer customer;
	private Product product;
	private String productName;

	public Orders(int id, LocalDate dateOrdered, LocalDate dateExpected, LocalDate dateDelivered, int quantity,
			Customer customer, Product product) {
		super();
		this.id = id;
		this.dateOrdered = dateOrdered;
		this.dateExpected = dateExpected;
		this.dateDelivered = dateDelivered;
		this.quantity = quantity;
		this.customer = customer;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(LocalDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public LocalDate getDateExpected() {
		return dateExpected;
	}

	public void setDateExpected(LocalDate dateExpected) {
		this.dateExpected = dateExpected;
	}

	public LocalDate getDateDelivered() {
		return dateDelivered;
	}

	public void setDateDelivered(LocalDate dateDelivered) {
		this.dateDelivered = dateDelivered;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateDelivered == null) ? 0 : dateDelivered.hashCode());
		result = prime * result + ((dateExpected == null) ? 0 : dateExpected.hashCode());
		result = prime * result + ((dateOrdered == null) ? 0 : dateOrdered.hashCode());
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
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
		Orders other = (Orders) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (dateDelivered == null) {
			if (other.dateDelivered != null)
				return false;
		} else if (!dateDelivered.equals(other.dateDelivered))
			return false;
		if (dateExpected == null) {
			if (other.dateExpected != null)
				return false;
		} else if (!dateExpected.equals(other.dateExpected))
			return false;
		if (dateOrdered == null) {
			if (other.dateOrdered != null)
				return false;
		} else if (!dateOrdered.equals(other.dateOrdered))
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", dateOrdered=" + dateOrdered + ", dateExpected=" + dateExpected
				+ ", dateDelivered=" + dateDelivered + ", quantity=" + quantity + ", customer=" + customer
				+ ", product=" + product + ", productName=" + productName + "]";
	}

}
