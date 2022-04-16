package controller_tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
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

	private void setCoutryGeneral(Country country, int idContinent, int idCountry, String name){
		country.setContinentId(idContinent);
		country.setCountryId(idCountry);
		country.setName(name);
	}

	private ArrayList<Country> iniListcountries(Country[] countries){
		List<Country> list = new ArrayList<Country>();
		for(int i = 0; i < countries.length; i++){
			list.add(countries[i]);
		}
		return (ArrayList<Country>) list;
	}

	private void iniPlayer(Player player, int id, String name, int armies, List<Country> totalCountriesOccupied){
		player.setPlayerId(id);
		player.setPlayerName(name);
		player.setPlayerArmies(armies);
		player.setTotalCountriesOccupied(totalCountriesOccupied);
	}

	private void setCountryspecific(Country country, List<Country> neighbors, int noOfArmies, Player player, Continent continent){
		country.setNeighbors(neighbors);
		country.setNoOfArmies(noOfArmies);
		country.setPlayer(player);
		country.setContinent(continent);
	}

	private void setContinenspecific(Continent continent, int id, String name, List<Country> coutries, int controlValue){
		continent.setContinentId(id);
		continent.setName(name);
		continent.setCountries(coutries);
		continent.setControlValue(controlValue);
	}
	/**
	 * Method to create all objects
	 */
	@Before
	public void onStart() {
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

		setCoutryGeneral(countryIndia, 1, 11, "India");
		setCoutryGeneral(countryChina, 2, 21, "China");
		setCoutryGeneral(countryPakistan, 3, 31, "Pakistan");
		setCoutryGeneral(countryBhutan, 4, 41, "Bhutan");
		setCoutryGeneral(countryIran, 5, 51, "Iran");
		setCoutryGeneral(countryCanada, 6, 61, "Canada");
		setCoutryGeneral(countryEgypt, 7, 71, "Egypt");

		Country[] listCountries1 = {countryChina, countryIran, countryCanada, countryPakistan};
		List<Country> n_list = iniListcountries(listCountries1);
		Country[] listCountries2 = {countryChina, countryIran, countryPakistan, countryIndia};
		List<Country> n_list4 = iniListcountries(listCountries2);
		Country[] listCountries3 = {countryPakistan};
		List<Country> n_list3 = iniListcountries(listCountries3);
		Country[] listCountries4 = {countryIndia, countryIran, countryCanada};
		List<Country> n_list1 = iniListcountries(listCountries4);
		Country[] listCountries5 = {countryIndia, countryPakistan, countryIran, countryBhutan};
		List<Country> n_list2 = iniListcountries(listCountries5);

		player1 = new Player(9);
		iniPlayer(player1,9, "abc", 7, n_list4);
		player2 = new Player(10);
		iniPlayer(player2,10, "xyz", 8, n_list1);

		setCountryspecific(countryIndia, n_list, 1, player1, continentAsia);
		setCountryspecific(countryChina, n_list3, 4, player1, continentAsia);
		setCountryspecific(countryPakistan, n_list, 4, player1, continentAsia);
		setCountryspecific(countryCanada, n_list, 4, player1, continentAfrica);
		setCountryspecific(countryIran, n_list3, 4, player2, continentAfrica);
		setCountryspecific(countryBhutan, n_list1, 2, player1, continentAfrica);

		setContinenspecific(continentAsia, 81, "Asia", n_list, 4);
		setContinenspecific(continentAfrica, 82, "Africa", n_list2, 5);

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
