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
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.brasilprev.lojarest.dao.ProductDAO;
import br.com.brasilprev.lojarest.models.Product;

/**
 * Represents all endpoint resources under /products.
 * 
 * @author denis
 *
 */
@Path("/products")
public class ProductResource extends Application {

	private ProductDAO productDAO;

	/**
	 * Post construct method.
	 */
	@PostConstruct
	private void init() {
		this.productDAO = new ProductDAO();
	}

	/**
	 * Lists all products in application.
	 * 
	 * @return {@link List} of all products.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listAll")
	public List<Product> listAllProducts() {
		List<Product> allProducts = productDAO.listAll();
		return allProducts;
	}

	/**
	 * List a single product.
	 * 
	 * @param id id from a product.
	 * @return {@link Product} object type.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Product listProduct(@PathParam("id") int id) {
		Product product = productDAO.findProductById(Integer.valueOf(id).longValue());
		return product;
	}

	/**
	 * Add a product into the system.
	 * 
	 * @param product product to be added.
	 * @return {@link Response} with status.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addProduct(Product product) {
		productDAO.saveItem(product);
		return Response.ok().build();
	}

	/**
	 * Remove a product from the system.
	 * 
	 * @param id id from the product.
	 * @return {@link Response} with status.
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response removeProduct(@PathParam("id") long productId) {
		Product product = productDAO.findProductById(productId);
		productDAO.removeItem(product);
		return Response.ok().build();
	}
}