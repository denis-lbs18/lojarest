package br.com.brasilprev.lojarest.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.brasilprev.lojarest.dao.ClientDAO;
import br.com.brasilprev.lojarest.models.Address;
import br.com.brasilprev.lojarest.models.Client;

@Path("/clients")
public class ClientResource {
	private ClientDAO clientDAO;

	@PostConstruct
	private void init() {
		this.clientDAO = new ClientDAO();
	}

	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> listAll(@PathParam("id") long id) {
		List<Client> allCarts = clientDAO.listAll();
		return allCarts;
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Client findCart(@PathParam("id") long id) {
		Client client = clientDAO.findClientById(id);
		return client;
	}

	@GET
	@Path("{id}/address")
	@Produces(MediaType.APPLICATION_JSON)
	public Address getAddressFromClient(@PathParam("id") long id) {
		Client client = clientDAO.findClientById(id);
		return client.getAddress();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addClient(Client client) {
		clientDAO.saveItem(client);
		return Response.ok().build();
	}

	@Path("{id}")
	@DELETE
	public Response removeClient(@PathParam("id") long id) {
		Client client = clientDAO.findClientById(id);
		clientDAO.removeItem(client);
		return Response.ok().build();
	}
}
