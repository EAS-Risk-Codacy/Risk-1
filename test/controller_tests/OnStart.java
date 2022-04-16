package controller_tests;

import controller.ReadingFiles;
import model.Country;
import model.Player;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OnStart {

    protected void setCountryData(Country country, int idCountinent, int idCountry){
        country.setContinentId(idCountinent);
        country.setCountryId(idCountry);
    }

    protected void setPlayerData(Player player, int id, String name, int army, List<Country> list) {
        player.setPlayerId(id);
        player.setPlayerName(name);
        player.setPlayerArmies(army);
        player.setTotalCountriesOccupied(list);
    }

    public void setCountrySpecificData(Country country, List<Country> list, int army, Player player) {
        country.setNeighbors(list);
        country.setNoOfArmies(army);
        country.setPlayer(player);
    }
}
