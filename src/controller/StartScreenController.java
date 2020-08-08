package controller;

import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import databse.BazaDao;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class StartScreenController implements Initializable
{
    private BazaDao bazaDao;

    public TextField tfUsernamLeogIn;
    public TextField tfPasswordLogIn;
    public TextField tfUsernameSignIn;
    public TextField tfPasswordSignIn;
    public ChoiceBox cbCountrySignIn;

    public StartScreenController(BazaDao bazaDao)
    {
        this.bazaDao = bazaDao;
    }
    /*
    pokrece se odmah pri kreiranju
    ovi parametri metode moraju postojati, jer je obavezno preklopiti ovu metodu kada implementiramo "Initializable"
    */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //cbCountrySignIn.setItems(bazaDao.getAllCountries());
    }
}
