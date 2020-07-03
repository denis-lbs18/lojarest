package br.com.brasilprev.lojarest.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.brasilprev.lojarest.utils.DataCreator;

public class AddressTest {
	@Test
	public void ConstructorEqualsTest() {
		Address randomAddress = DataCreator.getRandomAddress();
		Long id = randomAddress.getId();
		String city = randomAddress.getCity();
		Integer number = randomAddress.getNumber();
		String state = randomAddress.getState();
		String street = randomAddress.getStreet();
		String zipCode = randomAddress.getZipCode();

		Address address = new Address(street, number, city, state, zipCode);
		address.setId(id);

		assertEquals(address, randomAddress);
	}
}
