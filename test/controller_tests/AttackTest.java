package controller_tests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.AttackController;
import controller.ReadingFiles;
import model.Continent;
import model.Country;
import model.Player;

/**
 * Tests the attack controller
 * @author Navjot kaur
 *
 */

public class AttackTest 
{
	AttackController attack;
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
	HashMap<String, Country> temp;
	HashMap<Integer,Player> temp1;
	List<Country> n_list;
	List<Country> n_list1;
	
	/**
	* Method called before each test
	*/
	@Before
	public void onStart()
	{

		OnStart start = new OnStart();
		start.onStart();

		attack = new AttackController();

		ReadingFiles.CountryNameObject = new HashMap<>();
		ReadingFiles.playerId = new HashMap<>();
		temp = ReadingFiles.CountryNameObject;
		temp1 = ReadingFiles.playerId;
		ReadingFiles.playerId.clear();
		ReadingFiles.CountryNameObject.clear();
		ReadingFiles.CountryNameObject.put(country1.getName(), country1);
		ReadingFiles.CountryNameObject.put(country2.getName(), country2);
		ReadingFiles.CountryNameObject.put(country3.getName(), country3);
		ReadingFiles.CountryNameObject.put(country4.getName(), country4);
		ReadingFiles.CountryNameObject.put(country5.getName(), country5);
		ReadingFiles.CountryNameObject.put(country6.getName(), country6);
		
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
	*/
	@Test
	public void testGetMyNeighborsForAttack()
	{
		assertEquals(n_list,attack.getMyNeighborsForAttack(country1));
	}
	/**
	*Tests attack simulator
	*/
	@Test
	public void testAttackButton()
	{
		assertEquals("Wrong input",attack.attackButton(country3, country6, 3,1,false));
	}
	/**
	*Tests attack simulator
	*/
	@Test
	public void testAttackButton1()
	{
		assertEquals("Your country must have more than one army",attack.attackButton(country1,country2,3,1,false));
	}
	
	/**
	*Tests attack simulator
	*/
	@Test
	public void testAttackButton2()
	{
		assertEquals("",attack.attackButton(country2,country1,3,1,true));		
	}
	
	/**
	*Tests update owner of the country
	*/
	@Test
	public void testUpdateOwner()
	{
		attack.updateOwner(country1, player1);
		assertEquals(player1,country1.getOwner());
	}
	
}
