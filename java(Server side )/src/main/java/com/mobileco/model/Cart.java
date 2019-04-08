package com.mobileco.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Cart {

	private Customer customer;
	private Product product;
	private int orderQuantity;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Customer customer, Product product) {
		super();
		this.customer = customer;
		this.product = product;
	}

	public Cart(Customer customer, Product product, int orderQuantity) {
		super();
		this.customer = customer;
		this.product = product;
		this.orderQuantity = orderQuantity;
	}

	public Cart(Product product, int orderQuantity) {
		super();
		this.product = product;
		this.orderQuantity = orderQuantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Autowired
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	@Autowired
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + orderQuantity;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Cart other = (Cart) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderQuantity != other.orderQuantity)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [customer=" + customer + ", product=" + product + ", orderQuantity=" + orderQuantity + "]";
	}

}
