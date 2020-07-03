package br.com.brasilprev.lojarest.models;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
public class Product extends AbstractEntity {
	private static final long serialVersionUID = 7569921165149063388L;

	private Double price;
	private String name;
	private Integer quantity;

	public Product() {
	}

	public Product(Double price, String name, Integer quantity) {
		this.price = price;
		this.name = name;
		this.quantity = quantity;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			Product other = (Product) obj;
			return other.canEqual(this) && new EqualsBuilder().appendSuper(super.equals(other))
					.append(other.getPrice(), this.getPrice()).append(other.getName(), this.getName())
					.append(other.getQuantity(), this.getQuantity()).isEquals();
		}
		return false;
	}

	@Override
	public boolean canEqual(Object obj) {
		return obj instanceof Product;
	}

}
