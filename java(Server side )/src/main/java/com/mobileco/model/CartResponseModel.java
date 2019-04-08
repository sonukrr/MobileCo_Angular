package com.mobileco.model;

import java.util.List;

public class CartResponseModel {

	private String error;
	private List<Cart> results;

	public CartResponseModel() {
		// TODO Auto-generated constructor stub
	}

	public CartResponseModel(String error, List<Cart> results) {
		super();
		this.error = error;
		this.results = results;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Cart> getResults() {
		return results;
	}

	public void setResults(List<Cart> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
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
		CartResponseModel other = (CartResponseModel) obj;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartResponseModel [error=" + error + ", results=" + results + "]";
	}

}
