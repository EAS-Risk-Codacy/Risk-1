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

import controller.AggressiveStratery;
import controller.ReadingFiles;
import model.CardTypes;
import model.Continent;
import model.Country;
import model.Player;

/**
 * This class tests the Aggressive Strategy
 *
 * @author navjot
 * @version 1.0
 *
 */
public class AggressiveStrategyTest {
	AggressiveStratery ast;
	Player player1;
	Player player2;
	Country countryIndia;
	Country countryChina;
	Country countryPakistan;
	Country countryBhutan;
	Country countryIran;
	Country countryCanada;
	Country countryEgypt;
	Continent continent1;
	Continent continent2;
	HashMap<String, Country> temp;
	HashMap<Integer, Player> temp1;
	HashMap<String, Continent> temp3;

	List<Country> n_list = new ArrayList<>();
	List<Country> n_list1 = new ArrayList<>();
	List<Country> n_list2 = new ArrayList<>();
	List<Country> n_list3 = new ArrayList<>();

	/**
	 * Method called before each test
	 */


	@Before
	public void onStart() {

		OnStart start = new OnStart();

		ast = new AggressiveStratery();
		player1 = new Player(2);
		countryIndia = new Country("India");
		countryChina = new Country("China");
		countryPakistan = new Country("Pakistan");
		countryBhutan = new Country("Bhutan");
		countryIran = new Country("Iran");
		countryCanada = new Country("Canada");
		countryEgypt = new Country("Egypt");

		continent1 = new Continent(4, "Asia");
		continent2 = new Continent(5, "Africa");

		start.setCountryData(countryIndia, 1, 11);
		start.setCountryData(countryChina, 2, 21);
		start.setCountryData(countryPakistan, 3, 31);
		start.setCountryData(countryBhutan, 4, 41);
		start.setCountryData(countryIran, 5, 51);
		start.setCountryData(countryCanada, 6, 61);
		start.setCountryData(countryEgypt, 7, 71);

		n_list.add(countryChina);
		n_list.add(countryIran);
		n_list.add(countryCanada);

		n_list1.add(countryIndia);
		n_list1.add(countryIran);
		n_list1.add(countryCanada);

		n_list2.add(countryIndia);
		n_list2.add(countryPakistan);
		n_list2.add(countryIran);

		n_list3.add(countryPakistan);

		CardTypes[] listCard = {CardTypes.Infantry, CardTypes.Cavalry, CardTypes.Cavalry};
		List<CardTypes> n_listCard = new ArrayList<>(Arrays.asList(listCard));
		CardTypes[] listCard1 = {CardTypes.Artillery, CardTypes.Cavalry, CardTypes.Artillery, CardTypes.Infantry, CardTypes.Infantry, CardTypes.Cavalry};
		List<CardTypes> n_listCard1 = new ArrayList<>(Arrays.asList(listCard1));

		player1 = new Player(9);
		start.setPlayerData(player1, 9, "Navjot", 7, n_list);
		start.setPlayerSpecificData(player1, new Color(255,255,0), 4, n_listCard, null);
		player2 = new Player(10);
		start.setPlayerData(player2, 10, "Neeraj", 8, n_list3);
		start.setPlayerSpecificData(player2, new Color(0,191,255), 0, n_listCard1, null);

		start.setCountrySpecificData(countryIndia, n_list, 1, player2);
		start.setCountrySpecificData(countryChina, n_list3, 4, player1);
		start.setCountrySpecificData(countryPakistan, n_list, 6, player1);
		start.setCountrySpecificData(countryCanada, n_list, 1, player2);
		start.setCountrySpecificData(countryIran, n_list3, 5, player2);
		start.setCountrySpecificData(countryBhutan, n_list1, 2, player1);

		start.setContinentData(continent1, 81, "Asia", n_list, 4);
		start.setContinentData(continent2, 82, "Africa", n_list2, 5);


		ReadingFiles.CountryNameObject = new HashMap<>();
		ReadingFiles.ContinentNameObject = new HashMap<>();
		ReadingFiles.playerId = new HashMap<>();
		temp = ReadingFiles.CountryNameObject;
		temp1 = ReadingFiles.playerId;
		temp3 = ReadingFiles.ContinentNameObject;
		ReadingFiles.ContinentNameObject.put(continent1.getName(), continent1);
		ReadingFiles.ContinentNameObject.put(continent2.getName(), continent2);
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
	 * Method test the player with maximum number of armies
	 */
	@Test
	public void testStrongestPlayer() {
		Country temp = n_list.get(ast.getStrongestCountry(n_list));
		assertEquals(countryIran, temp);

	}

	/**
	 * Method tests the reinforcement phase based on aggressive strategy rules
	 */
	@Test
	public void testReinforce() {
		List<Country> countries = player1.getMyCountries(player1);
		int n = countries.get(ast.getStrongestCountry(countries)).getNoOfArmies()
				+ player1.getPlayerArmiesNotDeployed();
		ast.reinforce(player1);
		assertEquals(n, countries.get(ast.getStrongestCountry(countries)).getNoOfArmies());
	}

	/**
	 * Method tests the attack phase based on aggressive strategy rules
	 */
	@Test
	public void testAttack() {
		List<Country> countries = player1.getMyCountries(player1);
		Country c = countries.get(ast.getStrongestCountry(countries));
		ast.attack(player1);
		int a = c.getNoOfArmies();
		List<Country> an = player1.getMyNeighborsForAttack(c);
		if (a > 1) {
			assertEquals(an.size(), 0);
		} else {
			assertEquals(a, 1);
		}
	}

	/**
	 * Method tests the fortification phase based on aggressive strategy rules
	 */
	@Test
	public void testFortify() {
		List<Country> countries = player1.getMyCountries(player1);
		Country c = countries.get(ast.getStrongestCountry(countries));
		int armies_before_fortify = c.getNoOfArmies();
		ast.fortify(player1);
		int armies_after_fortify = c.getNoOfArmies();
		assertEquals(true, armies_after_fortify > armies_before_fortify);
	}
}