package br.com.brasilprev.lojarest.models;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {
	private static final long serialVersionUID = -558367053330496720L;

	private String userName;
	private String password;
	private Boolean logged = Boolean.FALSE;

	public User() {
		super();
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLogged() {
		return logged;
	}

	public void setLogged(Boolean logged) {
		this.logged = logged;
	}

}
