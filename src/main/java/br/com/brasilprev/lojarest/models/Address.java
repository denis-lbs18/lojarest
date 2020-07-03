package br.com.brasilprev.lojarest.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Address extends AbstractEntity {
	private static final long serialVersionUID = 2483258580348038490L;

	@Column(length = 40)
	private String street;
	@Column(length = 40)
	private Integer number;
	private String city;
	private String state;
	@Column(length = 10)
	private String zipCode;

	public Address() {
	}

	public Address(String street, Integer number, String city, String state, String zipCode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
