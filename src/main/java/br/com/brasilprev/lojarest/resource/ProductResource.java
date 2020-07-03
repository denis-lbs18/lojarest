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

@Path("/product")
public class ProductResource extends Application {

	private ProductDAO productDAO;

	@PostConstruct
	private void init() {
		this.productDAO = new ProductDAO();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listAll")
	public List<Product> listAllProducts() {
		List<Product> allProducts = productDAO.listAll();
		return allProducts;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list/{id}")
	public Product listProduct(@PathParam("id") int id) {
		Product product = productDAO.findProductById(Integer.valueOf(id).longValue());
		return product;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addProduct(Product product) {
		productDAO.saveItem(product);
		return Response.ok().build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response removeProduct(@PathParam("id") long productId) {
		Product product = productDAO.findProductById(productId);
		productDAO.removeItem(product);
		return Response.ok().build();
	}
}
