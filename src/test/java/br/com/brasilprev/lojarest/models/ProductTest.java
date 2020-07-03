package br.com.brasilprev.lojarest.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.brasilprev.lojarest.utils.DataCreator;

public class ProductTest {
	@Test
	public void ConstructorEqualsTest() {
		Product randomProduct = DataCreator.createProduct("Random Product", 10.0, 10000.0, 100);
		Long id = randomProduct.getId();
		String name = randomProduct.getName();
		Double price = randomProduct.getPrice();
		Integer quantity = randomProduct.getQuantity();

		Product product = new Product(price, name, quantity);
		product.setId(id);

		assertEquals(product, randomProduct);
	}
}
