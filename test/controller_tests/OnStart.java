package controller_tests;

import controller.ReadingFiles;
import model.Continent;
import model.Country;
import model.Player;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OnStart {
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
    HashMap<Integer, Player> temp1;
    List<Country> n_list;
    List<Country> n_list1;

    @Before
    public void onStart() {
        player1 = new Player(2);
        country1 = new Country("India");
        country2 = new Country("China");
        country3 = new Country("Pakistan");
        country4 = new Country("Bhutan");
        country5 = new Country("Iran");
        country6 = new Country("Canada");
        country7 = new Country("Egypt");

        country1.setContinentId(1);
        country1.setCountryId(11);
        country1.setName("India");

        country2.setContinentId(2);
        country2.setCountryId(21);
        country2.setName("China");

        country3.setContinentId(3);
        country3.setCountryId(31);
        country3.setName("Pakistan");

        country4.setContinentId(4);
        country4.setCountryId(41);
        country4.setName("Bhutan");

        country5.setContinentId(5);
        country5.setCountryId(51);
        country5.setName("Iran");

        country6.setContinentId(6);
        country6.setCountryId(61);
        country6.setName("Canada");

        country7.setContinentId(7);
        country7.setCountryId(71);
        country7.setName("Egypt");

        n_list = new ArrayList<Country>();
        n_list.add(country2);
        n_list.add(country5);
        n_list.add(country6);

        List<Country> n_list4 = new ArrayList<Country>();
        n_list4.add(country2);
        n_list4.add(country5);
        n_list4.add(country3);
        n_list4.add(country1);

        List<Country> n_list3 = new ArrayList<Country>();
        n_list3.add(country3);

        n_list1 = new ArrayList<Country>();
        n_list1.add(country1);
        n_list1.add(country5);
        n_list1.add(country6);

        List<Country> n_list2 = new ArrayList<Country>();
        n_list2.add(country1);
        n_list2.add(country3);
        n_list2.add(country5);

        player1 = new Player(9);
        player1.setPlayerId(9);
        player1.setPlayerName("Navjot");
        player1.setPlayerArmies(7);
        player1.setTotalCountriesOccupied(n_list4);

        player2 = new Player(10);
        player2.setPlayerId(10);
        player2.setPlayerName("Neeraj");
        player2.setPlayerArmies(8);
        player2.setTotalCountriesOccupied(n_list1);

        country1.setNeighbors(n_list);
        country1.setNoOfArmies(1);
        country1.setPlayer(player2);

        country2.setNeighbors(n_list3);
        country2.setNoOfArmies(4);
        country2.setPlayer(player1);

        country3.setNeighbors(n_list);
        country3.setNoOfArmies(4);
        country3.setPlayer(player1);

        country6.setNeighbors(n_list);
        country6.setNoOfArmies(0);
        country6.setPlayer(player2);

        country5.setNeighbors(n_list3);
        country5.setNoOfArmies(4);
        country5.setPlayer(player2);

        country4.setNeighbors(n_list1);
        country4.setNoOfArmies(2);
        country4.setPlayer(player1);

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
}
