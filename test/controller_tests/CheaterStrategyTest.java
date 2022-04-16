package controller_tests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
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
	List<Country> n_list1;

	List<CardTypes> list1;
	List<CardTypes>	list2;
	List<CardTypes> list3;
	List<CardTypes> list4;

	private void setCountryGeneral(Country country, int continentId, int countryId, String name){
		country.setContinentId(continentId);
		country.setCountryId(countryId);
		country.setName(name);
	}

	private ArrayList<Country> iniListcountries(Country[] countries){
		List<Country> list = new ArrayList<Country>();
		for(int i = 0; i < countries.length; i++){
			list.add(countries[i]);
		}
		return (ArrayList<Country>) list;
	}

	private ArrayList<CardTypes> iniListCardTypes(CardTypes[] cardTypes){
		List<CardTypes> list = new ArrayList<>();
		for(int i = 0; i < cardTypes.length; i++){
			list.add(cardTypes[i]);
		}
		return (ArrayList<CardTypes>) list;
	}

	private void setPlayerGeneral(Player player, int id, String name, Color color, int armiesNotDeployed, List<Continent> continentsOccupied,
								  int playerArmies, List<Country> CountriesOccupied, List<CardTypes> playerCards){
		player.setPlayerId(id);
		player.setPlayerName(name);
		player.setPlayerColor(color);
		player.setPlayerTotalArmiesNotDeployed(armiesNotDeployed);
		player.setContinentsOccupied(continentsOccupied);
		player.setPlayerArmies(playerArmies);
		player.setTotalCountriesOccupied(CountriesOccupied);
		player.setPlayerCards(playerCards);
	}

	private void setCountryspecific(Country country, List<Country> neighbors, int noOfArmies, Player player){
		country.setNeighbors(neighbors);
		country.setNoOfArmies(noOfArmies);
		country.setPlayer(player);
	}

	private void setContinenspecific(Continent continent, int id, String name, List<Country> coutries, int controlValue){
		continent.setContinentId(id);
		continent.setName(name);
		continent.setCountries(coutries);
		continent.setControlValue(controlValue);
	}
	/**
	 * Method called before each test
	 */
	@Before
	public void onStart() {
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

		setCountryGeneral(countryIndia, 1, 11, "India");
		setCountryGeneral(countryChina, 2, 21, "China");
		setCountryGeneral(countryPakistan, 3, 31, "Pakistan");
		setCountryGeneral(countryBhutan, 4, 41, "Bhutan");
		setCountryGeneral(countryIran, 5, 51, "Iran");
		setCountryGeneral(countryCanada, 6, 61, "Canada");
		setCountryGeneral(countryEgypt, 7, 71, "Egypt");

		Country[] listCountries1 = {countryChina,countryIran,countryCanada};
		n_list = iniListcountries(listCountries1);
		Country[] listCountries2 = {countryChina,countryIran,countryPakistan,countryIndia};
		List<Country> n_list4 = iniListcountries(listCountries2);
		Country[] listCountries3 = {countryPakistan};
		List<Country> n_list3 = iniListcountries(listCountries3);
		Country[] listCountries4 = {countryIndia, countryIran, countryCanada};
		List<Country> n_list1 = iniListcountries(listCountries4);
		Country[] listCountries5 = {countryIndia, countryPakistan, countryIran};
		List<Country> n_list2 = iniListcountries(listCountries5);

		CardTypes[] cardTypes = {CardTypes.Infantry, CardTypes.Cavalry, CardTypes.Cavalry};
		List<CardTypes> listp1 = iniListCardTypes(cardTypes);
		CardTypes[] cardTypes1 = {CardTypes.Artillery, CardTypes.Cavalry, CardTypes.Artillery, CardTypes.Infantry, CardTypes.Infantry, CardTypes.Cavalry};
		List<CardTypes> listp2 = iniListCardTypes(cardTypes1);
		CardTypes[] cardTypes2 = {CardTypes.Artillery, CardTypes.Cavalry, CardTypes.Infantry};
		list1 = iniListCardTypes(cardTypes2);
		CardTypes[] cardTypes3 = {CardTypes.Artillery, CardTypes.Artillery, CardTypes.Artillery};
		list2 = iniListCardTypes(cardTypes3);
		CardTypes[] cardTypes4 = {CardTypes.Artillery, CardTypes.Cavalry, CardTypes.Artillery};
		list3 = iniListCardTypes(cardTypes4);
		CardTypes[] cardTypes5 = {CardTypes.Artillery, CardTypes.Cavalry};
		list4 = iniListCardTypes(cardTypes5);

		player1 = new Player(9);
		setPlayerGeneral(player1, 9, "Navjot", new Color(255, 255, 0), 4, null, 7, n_list, listp1);
		player2 = new Player(10);
		setPlayerGeneral(player1, 10, "Neeraj", new Color(0 - 191 - 255), 0, null, 8, n_list3, listp2);

		setCountryspecific(countryIndia, n_list, 1, player2);
		setCountryspecific(countryChina, n_list3, 4, player1);
		setCountryspecific(countryPakistan, n_list, 6, player1);
		setCountryspecific(countryCanada, n_list, 1, player2);
		setCountryspecific(countryIran, n_list3, 5, player2);
		setCountryspecific(countryBhutan, n_list1, 2, player1);

		setContinenspecific(continentAsia, 81, "Asia", n_list, 4);
		setContinenspecific(continentAfrica, 82, "Africa", n_list2, 5);

		ReadingFiles.CountryNameObject = new HashMap<>();
		ReadingFiles.ContinentNameObject = new HashMap<>();
		ReadingFiles.playerId = new HashMap<>();
		temp = ReadingFiles.CountryNameObject;
		temp1 = ReadingFiles.playerId;
		temp3 = ReadingFiles.ContinentNameObject;
		ReadingFiles.ContinentNameObject.clear();
		ReadingFiles.playerId.clear();
		ReadingFiles.CountryNameObject.clear();
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
		assertEquals(true, size_before < size_after);
	}

	/**
	 * Method tests the fortification phase based on cheater strategy rules
	 */
	@Test
	public void testFortify() {
		int armies_before = countryPakistan.getNoOfArmies();
		cs.fortify(player1);
		assertEquals(armies_before * 2, countryPakistan.getNoOfArmies());
	}

}
