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

/**
 * Represents all endpoint resources under /clients.
 * 
 * @author denis
 *
 */
@Path("/clients")
public class ClientResource {
	private ClientDAO clientDAO;

	/**
	 * Post construct method.
	 */
	@PostConstruct
	private void init() {
		this.clientDAO = new ClientDAO();
	}

	/**
	 * Lists all clients in application.
	 * 
	 * @return {@link List} of all clients.
	 */
	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> listAll() {
		List<Client> allCarts = clientDAO.listAll();
		return allCarts;
	}

	/**
	 * List a single client.
	 * 
	 * @param id id from a client.
	 * @return {@link Client} object type.
	 */
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Client findCart(@PathParam("id") long id) {
		Client client = clientDAO.findClientById(id);
		return client;
	}

	/**
	 * Show a client's address
	 * 
	 * @param id id from a client.
	 * @return {@link Address} client's address.
	 */
	@GET
	@Path("{id}/address")
	@Produces(MediaType.APPLICATION_JSON)
	public Address getAddressFromClient(@PathParam("id") long id) {
		Client client = clientDAO.findClientById(id);
		return client.getAddress();
	}

	/**
	 * Add a client into the system.
	 * 
	 * @param client client to be added.
	 * @return {@link Response} with status.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addClient(Client client) {
		clientDAO.saveItem(client);
		return Response.ok().build();
	}

	/**
	 * Remove a client from the system.
	 * 
	 * @param id id from the client.
	 * @return {@link Response} with status.
	 */
	@Path("{id}")
	@DELETE
	public Response removeClient(@PathParam("id") long id) {
		Client client = clientDAO.findClientById(id);
		clientDAO.removeItem(client);
		return Response.ok().build();
	}
}
