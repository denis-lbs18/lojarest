package br.com.brasilprev.lojarest.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.brasilprev.lojarest.enums.Genre;
import br.com.brasilprev.lojarest.utils.DataCreator;

public class ClientTest {
	@Test
	public void ConstructorEqualsTest() {
		Client randomClient = DataCreator.createClient("Random Client", DataCreator.randomGenre());
		Long id = randomClient.getId();
		String name = randomClient.getName();
		Address address = randomClient.getAddress();
		Integer age = randomClient.getAge();
		String document = randomClient.getDocument();
		Genre genre = randomClient.getGenre();

		Client client = new Client(name, age, genre, document, address);
		client.setId(id);

		assertEquals(client, randomClient);
	}
}
