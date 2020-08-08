package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Singer;

public class Song
{
    //ATTRIBUETS
    private ObservableList<Singer> obSingers = FXCollections.observableArrayList();
    private String songName;
    private String songLyrics;
    private Boolean balcanianSong;

    private String pathToMelodyOfTheSong;
    private String pathToVocalsOfTheSong;

    //GETTERS AND SETTERS
    public ObservableList<Singer> getObSingers() {
        return obSingers;
    }

    public void setObSingers(ObservableList<Singer> obSingers) {
        this.obSingers = obSingers;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongLyrics() {
        return songLyrics;
    }

    public void setSongLyrics(String songLyrics) {
        this.songLyrics = songLyrics;
    }

    public Boolean getBalcanianSong() {
        return balcanianSong;
    }

    public void setBalcanianSong(Boolean balcanianSong) {
        this.balcanianSong = balcanianSong;
    }

    //CONSTRUCTORS
    public void Song()
    {}

    public void Song(String songName, String songLyrics, ObservableList<Singer> obSingers)
    {

    }
}
