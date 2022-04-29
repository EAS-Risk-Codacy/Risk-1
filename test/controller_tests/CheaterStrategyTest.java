package controller_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.CheaterStrategy;
import controller.ReadingFiles;
import model.CardTypes;
import model.Continent;
import model.Country;
import model.Player;

/**
 * This class tests Cheater Strategy
 * 
 * @author navjot
 * @version 1.0
 *
 */
public class CheaterStrategyTest {
	CheaterStrategy cs;
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

	HashMap<String, Country> temp;
	HashMap<Integer, Player> temp1;
	HashMap<String, Continent> temp3;

	List<Country> n_list;

	List<CardTypes> list1;
	List<CardTypes>	list2;
	List<CardTypes> list3;
	List<CardTypes> list4;

	/**
	 * Method called before each test
	 */
	@Before
	public void onStart() {
		OnStart start = new OnStart();

		cs = new CheaterStrategy();
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

		Country[] listCountries1 = {countryChina,countryIran,countryCanada};
		n_list = new ArrayList<>(Arrays.asList(listCountries1));
		Country[] listCountries3 = {countryPakistan};
		List<Country> n_list3 = new ArrayList<>(Arrays.asList(listCountries3));
		Country[] listCountries4 = {countryIndia, countryIran, countryCanada};
		List<Country> n_list1 = new ArrayList<>(Arrays.asList(listCountries4));
		Country[] listCountries5 = {countryIndia, countryPakistan, countryIran};
		List<Country> n_list2 = new ArrayList<>(Arrays.asList(listCountries5));

		CardTypes[] cardTypes = {CardTypes.Infantry, CardTypes.Cavalry, CardTypes.Cavalry};
		List<CardTypes> listp1 = new ArrayList<>(Arrays.asList(cardTypes));
		CardTypes[] cardTypes1 = {CardTypes.Artillery, CardTypes.Cavalry, CardTypes.Artillery, CardTypes.Infantry, CardTypes.Infantry, CardTypes.Cavalry};
		List<CardTypes> listp2 = new ArrayList<>(Arrays.asList(cardTypes1));
		CardTypes[] cardTypes2 = {CardTypes.Artillery, CardTypes.Cavalry, CardTypes.Infantry};
		list1 = new ArrayList<>(Arrays.asList(cardTypes2));
		CardTypes[] cardTypes3 = {CardTypes.Artillery, CardTypes.Artillery, CardTypes.Artillery};
		list2 =  new ArrayList<>(Arrays.asList(cardTypes3));
		CardTypes[] cardTypes4 = {CardTypes.Artillery, CardTypes.Cavalry, CardTypes.Artillery};
		list3 = new ArrayList<>(Arrays.asList(cardTypes4));
		CardTypes[] cardTypes5 = {CardTypes.Artillery, CardTypes.Cavalry};
		list4 = new ArrayList<>(Arrays.asList(cardTypes5));

		player1 = new Player(9);
		start.setPlayerData(player1, 9, "Navjot", 7, n_list);
		start.setPlayerSpecificData(player1, new Color(255, 255, 0), 4, listp1, null);
		player2 = new Player(10);
		start.setPlayerData(player1, 10, "Neeraj", 8, n_list3);
		start.setPlayerSpecificData(player1, new Color(255, 254, 66), 0, listp2, null);

		start.setCountrySpecificData(countryIndia, n_list, 1, player2);
		start.setCountrySpecificData(countryChina, n_list3, 4, player1);
		start.setCountrySpecificData(countryPakistan, n_list, 6, player1);
		start.setCountrySpecificData(countryCanada, n_list, 1, player2);
		start.setCountrySpecificData(countryIran, n_list3, 5, player2);
		start.setCountrySpecificData(countryBhutan, n_list1, 2, player1);

		start.setContinentData(continentAsia, 81, "Asia", n_list, 4);
		start.setContinentData(continentAfrica, 82, "Africa", n_list2, 5);

		ReadingFiles.CountryNameObject = new HashMap<>();
		ReadingFiles.ContinentNameObject = new HashMap<>();
		ReadingFiles.playerId = new HashMap<>();
		temp = ReadingFiles.CountryNameObject;
		temp1 = ReadingFiles.playerId;
		temp3 = ReadingFiles.ContinentNameObject;
		ReadingFiles.ContinentNameObject.put(continentAsia.getName(), continentAsia);
		ReadingFiles.ContinentNameObject.put(continentAfrica.getName(), continentAfrica);
		ReadingFiles.CountryNameObject.put(countryIndia.getName(), countryIndia);
		ReadingFiles.CountryNameObject.put(countryChina.getName(), countryChina);
		ReadingFiles.CountryNameObject.put(countryPakistan.getName(), countryPakistan);
		ReadingFiles.CountryNameObject.put(countryBhutan.getName(), countryBhutan);
		ReadingFiles.CountryNameObject.put(countryIran.getName(), countryIran);
		ReadingFiles.CountryNameObject.put(countryCanada.getName(), countryCanada);
		ReadingFiles.playerId.put(player1.getPlayerId(), player1);
		ReadingFiles.playerId.put(player2.getPlayerId(), player2);
	}

	/**
	 * Method called after each test
	 */
	@After
	public void atEnd() {
		ReadingFiles.CountryNameObject.clear();
		ReadingFiles.playerId.clear();
		ReadingFiles.CountryNameObject = temp;
		ReadingFiles.playerId = temp1;

	}

	/**
	 * Method tests the reinforcement phase based on cheater strategy rules
	 */
	@Test
	public void testReinforce() {
		int player_armies_before = 0;
		int player_armies_after = 0;
		for (int i = 0; i < player1.getMyCountries(player1).size(); i++) {
			player_armies_before += player1.getMyCountries(player1).get(i).getNoOfArmies();
		}
		cs.reinforce(player1);
		for (int i = 0; i < player1.getMyCountries(player1).size(); i++) {
			player_armies_after += player1.getMyCountries(player1).get(i).getNoOfArmies();
		}
		assertEquals(player_armies_before * 2, player_armies_after);
	}

	/**
	 * Method tests the attack phase based on cheater strategy rules
	 */
	@Test
	public void testAttack() {
		int size_before = player1.getMyCountries(player1).size();
		cs.attack(player1);
		int size_after = player1.getMyCountries(player1).size();
		// if(size_before>size_after)
		assertTrue(size_before <= size_after);
	}

	/**
	 * Method tests the fortification phase based on cheater strategy rules
	 */
	@Test
	public void testFortify() {
		int armies_before = countryPakistan.getNoOfArmies();
		cs.fortify(player1);
		assertEquals(armies_before, countryPakistan.getNoOfArmies());
	}

}
