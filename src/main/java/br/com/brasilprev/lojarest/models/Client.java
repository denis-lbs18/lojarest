package br.com.brasilprev.lojarest.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

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

}
