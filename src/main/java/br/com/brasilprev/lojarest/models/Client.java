package br.com.brasilprev.lojarest.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;

import br.com.brasilprev.lojarest.enums.Genre;

@Entity
public class Client extends AbstractEntity {
	private static final long serialVersionUID = -133417625352009800L;

	private String name;
	private Integer age;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	private String document;
	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;

	public Client() {
	}

	public Client(String name, Integer age, Genre genre, String document, Address address) {
		this.name = name;
		this.age = age;
		this.genre = genre;
		this.document = document;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((document == null) ? 0 : document.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Client) {
			Client other = (Client) obj;
			return other.canEqual(this) && new EqualsBuilder().appendSuper(super.equals(other))
					.append(other.getName(), this.getName()).append(other.getAge(), this.getAge())
					.append(other.getGenre(), this.getGenre()).append(other.getDocument(), this.getDocument())
					.append(other.getAddress(), this.getAddress()).isEquals();
		}
		return false;
	}

	@Override
	public boolean canEqual(Object obj) {
		return obj instanceof Client;
	}

}
