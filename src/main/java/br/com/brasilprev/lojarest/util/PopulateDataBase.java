package br.com.brasilprev.lojarest.util;

import static br.com.brasilprev.lojarest.enums.Genre.FEMALE;
import static br.com.brasilprev.lojarest.enums.Genre.MALE;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;

import br.com.brasilprev.lojarest.dao.JPAUtil;
import br.com.brasilprev.lojarest.enums.Genre;
import br.com.brasilprev.lojarest.models.Address;
import br.com.brasilprev.lojarest.models.Cart;
import br.com.brasilprev.lojarest.models.Client;
import br.com.brasilprev.lojarest.models.Product;
import br.com.brasilprev.lojarest.models.User;

public class PopulateDataBase {
	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Product oil = createProduct("oil", 7, 15, 500);
		em.persist(oil);

		Product bacon = createProduct("bacon", 20, 35, 2500);
		em.persist(bacon);

		Product rice = createProduct("rice", 10, 15, 1500);
		em.persist(rice);

		Product beans = createProduct("Beans", 5, 10, 200);
		em.persist(beans);

		Product water = createProduct("Water", 10, 20, 100);
		em.persist(water);

		Product computer = createProduct("Computer", 2000, 4000, 1000);
		em.persist(computer);

		Product headPhones = createProduct("HeadPhones", 2000, 4000, 1000);
		em.persist(headPhones);

		Product printer = createProduct("Printer", 100, 230, 100);
		em.persist(printer);

		Product keyboard = createProduct("Keyboard", 20, 40, 2000);
		em.persist(keyboard);

		User user = createUser("root", "123");
		em.persist(user);

		Cart cartInfo = new Cart();
		cartInfo.add(keyboard);
		cartInfo.add(printer);
		cartInfo.add(computer);
		cartInfo.add(headPhones);
		cartInfo.setClient(createClient("Mary", FEMALE));
		cartInfo.setAddress(cartInfo.getClient().getAddress());
		em.persist(cartInfo);

		Cart cartFood = new Cart();
		cartFood.add(rice);
		cartFood.add(beans);
		cartFood.add(bacon);
		cartFood.add(water);
		cartFood.add(bacon);
		cartFood.setClient(createClient("Peter", MALE));
		cartFood.setAddress(getRandomAddress());

		em.persist(cartFood);

		em.getTransaction().commit();
		em.close();

	}

	private static Client createClient(String name, Genre genre) {
		Client client = new Client();
		client.setName(name);
		client.setGenre(genre);
		client.setAge(createRandomInt(18, 60));
		client.setDocument("123456");
		client.setAddress(getRandomAddress());
		return client;
	}

	private static Address getRandomAddress() {
		Address address1 = new Address("Joanne Lane", 1267, "Andover", "MA", "01810");
		Address address2 = new Address("Trainer Avenue", 2426, "Port Byron", "IL", "61275");
		Address address3 = new Address("Traction Street", 4037, "Greenville", "SC", "29601");
		Address address4 = new Address("Creekside Lane", 3641, "Carpinteria", "CA", "93013");

		List<Address> listAddress = Arrays.asList(address1, address2, address3, address4);

		return listAddress.get(createRandomInt(listAddress.size()));
	}

	private static User createUser(String userName, String password) {
		return new User(userName, password);
	}

	private static Product createProduct(String productName, int minValue, double maxValue, int maxQuantity) {
		Product product = new Product();
		product.setName(productName);
		product.setPrice(createRandomDouble(minValue, maxValue));
		product.setQuantity(createRandomInt(maxQuantity));
		return product;
	}

	private static Integer createRandomInt(int minQuantity, int maxQuantity) {
		return ThreadLocalRandom.current().nextInt(minQuantity, maxQuantity);
	}

	private static Integer createRandomInt(int maxQuantity) {
		return createRandomInt(1, maxQuantity);
	}

	private static Double createRandomDouble(double minValue, double maxValue) {
		return ThreadLocalRandom.current().nextDouble(minValue, maxValue);
	}

}
