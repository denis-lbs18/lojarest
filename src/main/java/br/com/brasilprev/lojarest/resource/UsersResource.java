package br.com.brasilprev.lojarest.resource;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.brasilprev.lojarest.dao.UserDAO;
import br.com.brasilprev.lojarest.models.User;

@Path("/login")
public class UsersResource {
	private UserDAO userDAO;

	@PostConstruct
	private void init() {
		this.userDAO = new UserDAO();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User loginUser(User userRequest) {
		User user = userDAO.findUser(userRequest.getUserName(), userRequest.getPassword());

		return user;
	}
}
