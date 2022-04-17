package controller_tests;

import model.CardTypes;
import model.Continent;
import model.Country;
import model.Player;

import java.awt.*;
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

    public void setContinentData(Continent continent, int id, String name, List<Country> countries, int bonus) {
        continent.setContinentId(id);
        continent.setName(name);
        continent.setCountries(countries);
        continent.setControlValue(bonus);
    }

    public void setPlayerSpecificData(Player player, Color color, int armyNotDeployed, List<CardTypes> cards, List<Continent> continentsOccupied) {
        player.setPlayerColor(color);
        player.setPlayerTotalArmiesNotDeployed(armyNotDeployed);
        player.setPlayerCards(cards);
        player.setContinentsOccupied(continentsOccupied);
    }
}
