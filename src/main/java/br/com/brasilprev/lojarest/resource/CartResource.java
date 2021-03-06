package br.com.brasilprev.lojarest.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.brasilprev.lojarest.dao.CartDAO;
import br.com.brasilprev.lojarest.dao.ProductDAO;
import br.com.brasilprev.lojarest.models.Cart;
import br.com.brasilprev.lojarest.models.Product;

/**
 * Represents all endpoint resources under /carts.
 * 
 * @author denis
 *
 */
@Path("/carts")
public class CartResource {
	private CartDAO cartDAO;
	private ProductDAO productDAO;

	/**
	 * Post construct method.
	 */
	@PostConstruct
	private void init() {
		this.cartDAO = new CartDAO();
		this.productDAO = new ProductDAO();
	}

	/**
	 * Lists all created carts in application.
	 * 
	 * @return {@link List} of all carts.
	 */
	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cart> listAll() {
		List<Cart> allCarts = cartDAO.listAll();
		return allCarts;
	}

	/**
	 * List a single cart.
	 * 
	 * @param id id from a cart.
	 * @return {@link Cart} object type.
	 */
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cart findCart(@PathParam("id") long id) {
		Cart cart = cartDAO.findCartById(id);
		return cart;
	}

	/**
	 * Insert a product in a cart
	 * 
	 * @param id        id from the cart.
	 * @param productId id from the product to be added.
	 * @return {@link Response} with status.
	 */
	@POST
	@Path("{id}/products/{productId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProductToCart(@PathParam("id") long id, @PathParam("productId") long productId) {
		Cart cart = cartDAO.findCartById(id);
		Product product = productDAO.findProductById(productId);
		cart.add(product);
		cartDAO.saveItem(cart);
		return Response.ok().build();
	}

	/**
	 * Remove a product from a cart.
	 * 
	 * @param id        id from the cart.
	 * @param productId id from the product to be removed.
	 * @return {@link Response} with status.
	 */
	@Path("{id}/products/{productId}")
	@DELETE
	public Response removeProduct(@PathParam("id") long id, @PathParam("productId") long productId) {
		Cart cart = cartDAO.findCartById(id);
		cart.remove(productId);
		cartDAO.saveItem(cart);
		return Response.ok().build();
	}

	/**
	 * Get a single product from a cart
	 * 
	 * @param id        id from the cart.
	 * @param productId id from the product to be removed.
	 * @return {@link Product} found.
	 */
	@GET
	@Path("{id}/products/{productId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Product getProductFromCart(@PathParam("id") long id, @PathParam("productId") long productId) {
		Cart cart = cartDAO.findCartById(id);
		Product product = cart.find(productId);

		return product;
	}

	/**
	 * Change a product quantity
	 * 
	 * @param id        id from the cart.
	 * @param productId id from the product to be removed.
	 * @return {@link Response} with status.
	 */
	@Path("{id}/products/{productId}/quantity")
	@PUT
	public Response changeProductQuantity(@PathParam("id") long id, @PathParam("productId") long productId) {
		Cart cart = cartDAO.findCartById(id);
		Product produto = productDAO.findProductById(productId);
		cart.changeProductQuantity(produto);
		return Response.ok().build();
	}
}