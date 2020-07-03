package br.com.brasilprev.lojarest.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import br.com.brasilprev.lojarest.utils.DataCreator;

public class CartTest {
	private Cart randomCart = DataCreator.createCart(5);
	private int randomItem = DataCreator.createRandomInt(randomCart.getProductList().size());
	private Product productMock = randomCart.getProductList().get(randomItem);

	@Test
	public void ConstructorEqualsTest() {
		List<Product> productList = randomCart.getProductList();
		Client client = randomCart.getClient();
		Address address = randomCart.getAddress();
		Long id = randomCart.getId();

		Cart cart = new Cart(productList, client, address);
		cart.setId(id);
		assertEquals(cart, randomCart);
	}

	@Test
	public void findTest() {
		Product productFound = randomCart.find(productMock.getId());
		assertEquals(productMock, productFound);
	}

	@Test
	public void changeProductQuantityTest() {
		productMock.setQuantity(DataCreator.createRandomInt());
		randomCart.changeProductQuantity(productMock);

		Product productFound = randomCart.find(productMock.getId());

		assertEquals(productFound.getQuantity(), productMock.getQuantity());
	}

	@Test
	public void removeTest() {
		randomCart.remove(productMock.getId());

		assertFalse(randomCart.getProductList().contains(productMock));
	}
}
