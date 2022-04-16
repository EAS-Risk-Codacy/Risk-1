package controller_tests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.AttackController;
import controller.ReadingFiles;
import model.Country;
import model.Player;

/**
 * Tests the attack controller
 * @author Navjot kaur
 *
 */

public class AttackTest {
	AttackController attack;
	Player player1;
	Player player2;
	Country countryIndia;
	Country countryChina;
	Country countryPakistan;
	Country countryBhutan;
	Country countryIran;
	Country countryCanada;
	Country countryEgypt;
	HashMap<String, Country> temp;
	HashMap<Integer,Player> temp1;

	/**
	 * Method called before each test
	 *
	 */
	@Before
	public void onStart()
	{
		OnStart start = new OnStart();

		attack = new AttackController();
		player1 = new Player(2);

		countryIndia = new Country("India");
		countryChina = new Country("China");
		countryPakistan = new Country("Pakistan");
		countryBhutan = new Country("Bhutan");
		countryIran = new Country("Iran");
		countryCanada = new Country("Canada");
		countryEgypt = new Country("Egypt");

		start.setCountryData(countryIndia, 1, 11);
		start.setCountryData(countryChina, 2, 21);
		start.setCountryData(countryPakistan, 3, 31);
		start.setCountryData(countryBhutan, 4, 41);
		start.setCountryData(countryIran, 5, 51);
		start.setCountryData(countryCanada, 6, 61);
		start.setCountryData(countryEgypt, 7, 71);

		Country[] listCountries = {countryChina, countryIran, countryCanada};
		List<Country> n_list = new ArrayList<>(Arrays.asList(listCountries));
		Country[] listCountries1 = {countryIndia, countryIran, countryCanada};
		List<Country> n_list1 = new ArrayList<>(Arrays.asList(listCountries1));
		Country[] listCountries3 = {countryPakistan};
		List<Country> n_list3 = new ArrayList<>(Arrays.asList(listCountries3));
		Country[] listCountries4 = {countryChina, countryIran, countryPakistan, countryIndia};
		List<Country> n_list4 = new ArrayList<>(Arrays.asList(listCountries4));

		player1 = new Player(9);
		start.setPlayerData(player1, 9, "abc", 7, n_list4);
		player2 = new Player(10);
		start.setPlayerData(player2, 10, "xyz", 8, n_list1);

		start.setCountrySpecificData(countryIndia, n_list, 1, player2);
		start.setCountrySpecificData(countryChina, n_list3, 4, player1);
		start.setCountrySpecificData(countryPakistan, n_list, 4, player1);
		start.setCountrySpecificData(countryCanada, n_list, 1, player2);
		start.setCountrySpecificData(countryIran, n_list3, 4, player2);
		start.setCountrySpecificData(countryBhutan, n_list1, 2, player1);


		ReadingFiles.CountryNameObject = new HashMap<>();
		ReadingFiles.playerId = new HashMap<>();
		temp = ReadingFiles.CountryNameObject;
		temp1 = ReadingFiles.playerId;
		ReadingFiles.CountryNameObject.put(countryIndia.getName(), countryIndia);
		ReadingFiles.CountryNameObject.put(countryChina.getName(), countryChina);
		ReadingFiles.CountryNameObject.put(countryPakistan.getName(), countryPakistan);
		ReadingFiles.CountryNameObject.put(countryBhutan.getName(), countryBhutan);
		ReadingFiles.CountryNameObject.put(countryIran.getName(), countryIran);
		ReadingFiles.CountryNameObject.put(countryCanada.getName(), countryCanada);

		ReadingFiles.playerId.put(player1.getPlayerId(),player1);
		ReadingFiles.playerId.put(player2.getPlayerId(),player2);

	}
	/**
	 *Method called after each test
	 *
	 */
	@After
	public void atEnd() {
		ReadingFiles.CountryNameObject.clear();
		ReadingFiles.playerId.clear();
		ReadingFiles.CountryNameObject = temp;
		ReadingFiles.playerId = temp1;

	}
	/**
	 *Tests Countries of the player
	 *
	 */
	@Test
	public void testGetMyCountries() {
		assertEquals(3, attack.getMyCountries(player2).size());
	}

	/**
	 *Tests list neighbor countries of the player
	 *
	 */
	@Test
	public void testGetMyNeighborsForAttack()
	{
		assertEquals(countryIndia.getNeighbors(), attack.getMyNeighborsForAttack(countryIndia));
	}
	/**
	 *Tests attack simulator
	 *
	 */
	@Test
	public void testAttackButton()
	{
		assertEquals("",attack.attackButton(countryPakistan, countryCanada, 3,1,false));
	}
	/**
	 *Tests attack simulator
	 *
	 */
	@Test
	public void testAttackButton1()
	{
		assertEquals("Your country must have more than one army",attack.attackButton(countryIndia, countryChina,3,1,false));
	}

	/**
	 *Tests attack simulator
	 *
	 */
	@Test
	public void testAttackButton2()
	{
		assertEquals("",attack.attackButton(countryChina, countryIndia,3,1,true));
	}

	/**
	 *Tests update owner of the country
	 *
	 */
	@Test
	public void testUpdateOwner()
	{
		attack.updateOwner(countryIndia, player1);
		assertEquals(player1, countryIndia.getOwner());
	}

}