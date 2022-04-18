package controller_tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.FortificationController;
import controller.ReadingFiles;
import model.Continent;
import model.Country;
import model.Player;

/**
 * Class to test Fortification Controller
 * 
 * @author Navjot kaur
 *
 */
public class FortificationTest {
	FortificationController fortification;
	Player player1;
	Player player2;
	Country countryIndia;
	Country countryChina;
	Country countryPakistan;
	Country countryBhutan;
	Country countryIran;
	Country countryCanada;
	Country countryEgypt;
	Continent continentAsia;
	Continent continentAfrica;
	/**
	 * Method to create all objects
	 */
	@Before
	public void onStart() {
		OnStart start = new OnStart();

		fortification = new FortificationController();
		player1 = new Player(2);
		countryIndia = new Country("India");
		countryChina = new Country("China");
		countryPakistan = new Country("Pakistan");
		countryBhutan = new Country("Bhutan");
		countryIran = new Country("Iran");
		countryCanada = new Country("Canada");
		countryEgypt = new Country("Egypt");
		continentAsia = new Continent(4, "Asia");
		continentAfrica = new Continent(5, "Africa");

		start.setCountryData(countryIndia, 1, 11);
		start.setCountryData(countryChina, 2, 21);
		start.setCountryData(countryPakistan, 3, 31);
		start.setCountryData(countryBhutan, 4, 41);
		start.setCountryData(countryIran, 5, 51);
		start.setCountryData(countryCanada, 6, 61);
		start.setCountryData(countryEgypt, 7, 71);

		Country[] listCountries1 = {countryChina, countryIran, countryCanada, countryPakistan};
		List<Country> n_list = new ArrayList<>(Arrays.asList(listCountries1));
		Country[] listCountries2 = {countryChina, countryIran, countryPakistan, countryIndia};
		List<Country> n_list4 = new ArrayList<>(Arrays.asList(listCountries2));
		Country[] listCountries3 = {countryPakistan};
		List<Country> n_list3 = new ArrayList<>(Arrays.asList(listCountries3));
		Country[] listCountries4 = {countryIndia, countryIran, countryCanada};
		List<Country> n_list1 = new ArrayList<>(Arrays.asList(listCountries4));
		Country[] listCountries5 = {countryIndia, countryPakistan, countryIran, countryBhutan};
		List<Country> n_list2 = new ArrayList<>(Arrays.asList(listCountries5));

		player1 = new Player(9);
		start.setPlayerData(player1,9, "abc", 7, n_list4);
		player2 = new Player(10);
		start.setPlayerData(player2,10, "xyz", 8, n_list1);

		start.setCountrySpecificData(countryIndia, n_list, 1, player1);
		countryIndia.setContinent(continentAsia);
		start.setCountrySpecificData(countryChina, n_list3, 4, player1);
		countryChina.setContinent(continentAsia);
		start.setCountrySpecificData(countryPakistan, n_list, 4, player1);
		countryPakistan.setContinent(continentAsia);
		start.setCountrySpecificData(countryCanada, n_list, 4, player1);
		countryCanada.setContinent(continentAfrica);
		start.setCountrySpecificData(countryIran, n_list3, 4, player2);
		countryIran.setContinent(continentAfrica);
		start.setCountrySpecificData(countryBhutan, n_list1, 2, player1);
		countryBhutan.setContinent(continentAfrica);

		start.setContinentData(continentAsia, 81, "Asia", n_list, 4);
		start.setContinentData(continentAfrica, 82, "Africa", n_list2, 5);

		ReadingFiles.ContinentNameObject = new HashMap<>();
		ReadingFiles.ContinentNameObject.put(continentAsia.getName(), continentAsia);
		ReadingFiles.ContinentNameObject.put(continentAfrica.getName(), continentAfrica);
	}

	/**
	 * Tests path between countries
	 */
	@Test
	public void testHasPathBFS() {
		assertEquals(true, fortification.hasPathBFS2(countryIndia, countryPakistan));
	}

	/**
	 * Tests path between countries
	 */
	@Test
	public void test1HasPathBFS() {
		assertNotEquals(true, fortification.hasPathBFS2(countryChina, countryBhutan));
	}

	/**
	 * Tests can armies be moved or not
	 */
	@Test
	public void testMoveArmies() {
		assertEquals("less army", fortification.moveArmies(countryIndia, countryPakistan, 2));
	}

	/**
	 * Tests can armies be moved or not
	 */
	@Test
	public void test1MoveArmies() {
		assertEquals("You can only move3", fortification.moveArmies(countryChina, countryPakistan, 5));
	}

	/**
	 * Tests can armies be moved or not
	 */
	@Test
	public void test2MoveArmies() {
		assertEquals("NO path", fortification.moveArmies(countryChina, countryIran, 3));
	}

	/**
	 * Tests can armies be moved or not
	 */
	@Test
	public void test3MoveArmies() {
		assertEquals("", fortification.moveArmies(countryChina, countryPakistan, 3));
	}
}
