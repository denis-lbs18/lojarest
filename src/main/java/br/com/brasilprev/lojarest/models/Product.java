package br.com.brasilprev.lojarest.models;

import javax.persistence.Entity;

@Entity
public class Product extends AbstractEntity {
	private static final long serialVersionUID = 7569921165149063388L;

	private Double price;
	private String name;
	private Integer quantity;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
