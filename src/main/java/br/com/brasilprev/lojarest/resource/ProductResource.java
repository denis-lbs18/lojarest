package br.com.brasilprev.lojarest.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import br.com.brasilprev.lojarest.dao.ProductDAO;
import br.com.brasilprev.lojarest.models.Product;

@Path("/produto")
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
		List<Product> allProducts = productDAO.listAllProducts();
		return allProducts;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list/{id}")
	public Product listProduct(@PathParam("id") int id) {
		Product product = productDAO.findProductById(Integer.valueOf(id).longValue());
		return product;
	}
}
