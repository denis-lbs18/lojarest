package br.com.brasilprev.lojarest.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
public class Cart extends AbstractEntity {
	private static final long serialVersionUID = 8471550000153580309L;

	@ManyToMany
	private List<Product> productList = new ArrayList<>();;
	@OneToOne(cascade = { CascadeType.ALL })
	private Client client;
	@ManyToOne(cascade = { CascadeType.ALL })
	private Address address;

	public Cart() {
	}

	public Cart(List<Product> productList, Client client, Address address) {
		this.productList = productList;
		this.client = client;
		this.address = address;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void add(Product product) {
		this.productList.add(product);
	}

	public Product find(Long id) {
		Product product = null;
		for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
			product = iterator.next();
			if (product.getId() == id) {
				return product;
			}
		}
		return product;
	}

	public void remove(Long id) {
		for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void changeProductQuantity(Product product) {
		for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
			Product p = iterator.next();
			if (p.getId() == product.getId()) {
				p.setQuantity(product.getQuantity());
				return;
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cart) {
			Cart other = (Cart) obj;
			return other.canEqual(this) && new EqualsBuilder().appendSuper(super.equals(other))
					.append(other.getProductList(), this.getProductList()).append(other.getClient(), this.getClient())
					.append(other.getAddress(), this.getAddress()).isEquals();
		}
		return false;
	}

	@Override
	public boolean canEqual(Object obj) {
		return obj instanceof Cart;
	}
}
