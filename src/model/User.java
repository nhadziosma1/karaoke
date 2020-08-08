package model;

import javafx.collections.ObservableList;
import model.Performance;
import model.Song;

public class User
{
    //ATTRIBUTE
    private String username;
    private String password;
    private Country country;
    private ObservableList<Song> favouriteSongs;
    private ObservableList<Performance> savedPerformances;

    //GETTERS AND SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ObservableList<Song> getFavouriteSongs() {
        return favouriteSongs;
    }

    public void setFavouriteSongs(ObservableList<Song> favouriteSongs) {
        this.favouriteSongs = favouriteSongs;
    }

    public ObservableList<Performance> getSavedPerformances() {
        return savedPerformances;
    }

    public void setSavedPerformances(ObservableList<Performance> savedPerformances) {
        this.savedPerformances = savedPerformances;
    }

    //CONSTRUCTORS
    public void User()
    {}

    public void User(String username, String password, Country country)
    {
        this.username = username;
        this.password = password;
        this.country = country;
    }
}
