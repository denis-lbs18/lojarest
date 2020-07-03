package br.com.brasilprev.lojarest.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cart extends AbstractEntity {
	private static final long serialVersionUID = 8471550000153580309L;

	@ManyToMany
	private List<Product> productList = new ArrayList<>();;
	@OneToOne(cascade = { CascadeType.ALL })
	private Client client;
	@ManyToOne(cascade = { CascadeType.ALL })
	private Address address;

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
}
