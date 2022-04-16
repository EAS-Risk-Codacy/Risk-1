package controller_tests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.BenevolentStrategy;
import controller.ReadingFiles;
import model.CardTypes;
import model.Continent;
import model.Country;
import model.Player;
import controller.HelperClass;

/**
 * This class tests Benevolent Strategy
 * 
 * @author navjot
 * @version 1.0
 *
 */
public class BenevolentStrategyTest {
	HelperClass helper = new HelperClass();
	BenevolentStrategy bs;
	Player player1;
	Player player2;
	Player player3;
	Country country1;
	Country country2;
	Country country3;
	Country country4;
	Country country5;
	Country country6;
	Country country7;
	Continent continent1;
	Continent continent2;
	HashMap<String, Country> temp;
	HashMap<Integer, Player> temp1;
	HashMap<String, Continent> temp3;
	List<Country> n_list;
	List<Country> n_list1;
	List<CardTypes> list1;
	List<CardTypes> list2;
	List<CardTypes> list3;
	List<CardTypes> list4;

	/**
	 * Method called before each test
	 */
	@Before
	public void onStart() {

		OnStart start = new OnStart();

		bs = new BenevolentStrategy();

		continent1 = new Continent(4, "Asia");
		continent2 = new Continent(5, "Africa");

		List<CardTypes> listp1 = new ArrayList<>();
		listp1.add(CardTypes.Infantry);
		listp1.add(CardTypes.Cavalry);
		listp1.add(CardTypes.Cavalry);

		List<CardTypes> listp2 = new ArrayList<>();
		listp2.add(CardTypes.Artillery);
		listp2.add(CardTypes.Cavalry);
		listp2.add(CardTypes.Artillery);
		listp2.add(CardTypes.Infantry);
		listp2.add(CardTypes.Infantry);
		listp2.add(CardTypes.Cavalry);

		list1 = new ArrayList<>();
		list1.add(CardTypes.Artillery);
		list1.add(CardTypes.Cavalry);
		list1.add(CardTypes.Infantry);

		list2 = new ArrayList<>();
		list2.add(CardTypes.Artillery);
		list2.add(CardTypes.Artillery);
		list2.add(CardTypes.Artillery);

		list3 = new ArrayList<>();
		list3.add(CardTypes.Artillery);
		list3.add(CardTypes.Cavalry);
		list3.add(CardTypes.Artillery);

		list4 = new ArrayList<>();
		list4.add(CardTypes.Artillery);
		list4.add(CardTypes.Cavalry);


		player1.setPlayerColor(new Color(255, 255, 0));
		player1.setPlayerTotalArmiesNotDeployed(4);
		player1.setContinentsOccupied(null);
		player1.setPlayerCards(listp1);

		player2.setPlayerColor(new Color(0 - 191 - 255));
		player2.setPlayerTotalArmiesNotDeployed(0);
		player2.setContinentsOccupied(null);
		player2.setPlayerCards(listp2);


		continent1.setContinentId(81);
		continent1.setName("Asia");
		continent1.setCountries(n_list);
		continent1.setControlValue(4);

		continent2.setContinentId(82);
		continent2.setName("Africa");
		continent2.setCountries(n_list1);
		continent2.setControlValue(5);

		ReadingFiles.ContinentNameObject = new HashMap<>();
		temp3 = ReadingFiles.ContinentNameObject;
		ReadingFiles.ContinentNameObject.clear();
		ReadingFiles.ContinentNameObject.put(continent1.getName(), continent1);
		ReadingFiles.ContinentNameObject.put(continent2.getName(), continent2);
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
	 * Method tests the reinforcement phase based on benevolent strategy rules
	 */
	@Test
	public void testReinforce() {
		List<Country> countries = player1.getMyCountries(player1);
		Country c = countries.get(helper.getWeakestCountryIndex(countries));
		int armies = c.getNoOfArmies() + player1.getPlayerArmiesNotDeployed();
		bs.reinforce(player1);
		assertEquals(armies, c.getNoOfArmies());
	}

	/**
	 * Method tests the fortification phase based on aggressive strategy rules
	 */
	@Test
	public void fortify() {
		List<Country> countries = player1.getMyCountries(player1);
		Country c = countries.get(helper.getWeakestCountryIndex(countries));
		int armies_before = c.getNoOfArmies();
		bs.fortify(player1);
		assertEquals(true, c.getNoOfArmies() > armies_before);
	}

}
