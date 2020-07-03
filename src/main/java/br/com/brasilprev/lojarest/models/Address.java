package br.com.brasilprev.lojarest.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Address) {
			Address other = (Address) obj;
			return other.canEqual(this) && new EqualsBuilder().appendSuper(super.equals(other))
					.append(other.getStreet(), this.getStreet()).append(other.getState(), this.getState())
					.append(other.getNumber(), this.getNumber()).append(other.getCity(), this.getCity())
					.append(other.getState(), this.getState()).append(other.getZipCode(), this.getZipCode()).isEquals();
		}
		return false;
	}

	@Override
	public boolean canEqual(Object obj) {
		return obj instanceof Address;
	}
}