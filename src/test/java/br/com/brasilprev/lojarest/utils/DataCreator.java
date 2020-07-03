package br.com.brasilprev.lojarest.utils;

import static br.com.brasilprev.lojarest.enums.Genre.FEMALE;
import static br.com.brasilprev.lojarest.enums.Genre.MALE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import br.com.brasilprev.lojarest.enums.Genre;
import br.com.brasilprev.lojarest.models.Address;
import br.com.brasilprev.lojarest.models.Cart;
import br.com.brasilprev.lojarest.models.Client;
import br.com.brasilprev.lojarest.models.Product;

public final class DataCreator {
	private DataCreator() {
	}

	public static Integer createRandomInt(int minQuantity, int maxQuantity) {
		return ThreadLocalRandom.current().nextInt(minQuantity, maxQuantity);
	}

	public static Integer createRandomInt(int maxQuantity) {
		return createRandomInt(1, maxQuantity);
	}

	public static Long createRandomId() {
		return ThreadLocalRandom.current().nextLong();
	}

	public static Double createRandomDouble(double minValue, double maxValue) {
		return ThreadLocalRandom.current().nextDouble(minValue, maxValue);
	}

	public static Address getRandomAddress() {
		Address address1 = new Address("Joanne Lane", 1267, "Andover", "MA", "01810");
		address1.setId(createRandomId());
		Address address2 = new Address("Trainer Avenue", 2426, "Port Byron", "IL", "61275");
		address2.setId(createRandomId());
		Address address3 = new Address("Traction Street", 4037, "Greenville", "SC", "29601");
		address3.setId(createRandomId());
		Address address4 = new Address("Creekside Lane", 3641, "Carpinteria", "CA", "93013");
		address4.setId(createRandomId());

		List<Address> listAddress = Arrays.asList(address1, address2, address3, address4);

		return listAddress.get(createRandomInt(listAddress.size()));
	}

	public static Client createClient(String name, Genre genre) {
		Client client = new Client();
		client.setName(name);
		client.setGenre(genre);
		client.setAge(createRandomInt(18, 60));
		client.setDocument("123456");
		client.setAddress(getRandomAddress());
		return client;
	}

	public static Cart createCart(int productListSize) {
		Client client = createClient("Random Client", DataCreator.randomGenre());
		Address address = getRandomAddress();
		List<Product> productList = new ArrayList<>();
		for (int i = 0; i <= productListSize; i++) {
			Product product = createProduct("Mock Product " + i, 10.0, 100.0, 1000);
			productList.add(product);
		}

		Cart cart = new Cart(productList, client, address);
		cart.setId(createRandomId());
		return cart;
	}

	public static Product createProduct(String productName, double minValue, double maxValue, int maxQuantity) {
		Product product = new Product();
		product.setName(productName);
		product.setPrice(createRandomDouble(minValue, maxValue));
		product.setQuantity(createRandomInt(maxQuantity));
		product.setId(createRandomId());
		return product;
	}

	public static Genre randomGenre() {
		return (createRandomInt() % 2 == 0) ? MALE : FEMALE;
	}

	public static Integer createRandomInt() {
		return ThreadLocalRandom.current().nextInt();
	}
}
