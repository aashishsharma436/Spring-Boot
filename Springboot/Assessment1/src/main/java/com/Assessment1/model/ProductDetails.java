package com.springbootTrendNext.Assessment1.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDetails {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("price")
	private String price;
	
	//getters
	public int getId() {return this.id; }
	public String getDescription() {return this.description;}
	public String getPrice() { return this.price;}
	
	//setters
	public void setId(int id) { this.id = id; }
	public void setDescription(String description) { this.description = description;}
	public void setPrice(String price) {this.price = price;}
	
	
	@Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    ProductDetails productDetails = (ProductDetails) o;
	    return Objects.equals(this.description, productDetails.description) &&
	        Objects.equals(this.price, productDetails.price) &&
	        Objects.equals(this.id, productDetails.id);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(id,description,price);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ProductDetails {\n");
	    sb.append("    ID: ").append(toIndentedString(id)).append("\n");
	    sb.append("    Description: ").append(toIndentedString(description)).append("\n");
	    sb.append("    memberName: ").append(toIndentedString(price)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  private String toIndentedString(Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
	
	
}
