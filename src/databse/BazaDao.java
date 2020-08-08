package databse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.io.File;
import java.sql.*;

public class BazaDao
{
    //ATTRIBUTES
    private PreparedStatement nadjiDrzavuPoIdu;
    private PreparedStatement nadjiDrzavuPoSkracenici2;
    private PreparedStatement nadjiDrzavuPoSkracenici3;
    private PreparedStatement nadjiDrzavuPoNazivu;
    private Statement nadjiSveDrzave;

    private PreparedStatement nadjiKorisnikaPoUsername;


    private static BazaDao instance = null;
    private Connection conn;
    //SINGLETONE
    private static void initialize()
    {
        instance = new BazaDao();
    }

    private BazaDao()
    {
        String url = "jdbc:sqlite:database.db";

        File db = new File("database.db");
        boolean doesDbExist = db.exists();

        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);

            nadjiDrzavuPoIdu = conn.prepareStatement("SELECT * FROM drzava WHERE id = ?");
            nadjiDrzavuPoSkracenici2 = conn.prepareStatement("SELECT * FROM drzava WHERE skracenica2 LIKE '?' ");
            nadjiDrzavuPoSkracenici3 = conn.prepareStatement("SELECT * FROM drzava WHERE skracenica3 LIKE '?' ");
            nadjiDrzavuPoNazivu = conn.prepareCall("SELECT * FROM drzava WHERE naziv_malim LIKE '?' OR naziv_velikim LIKE '?'");

            nadjiKorisnikaPoUsername = conn.prepareStatement("SELECT * FROM korisnik WHERE username LIKE '?' ");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public static BazaDao getInstance()
    {
        if(instance == null)
            initialize();

        return instance;
    }

    public static void removeInstance()
    {
        instance = null;
    }

    //METHODS
    public ObservableList<Country> getAllCountries()
    {
        ObservableList<Country> obCountry = FXCollections.observableArrayList();

        try
        {
            nadjiSveDrzave = conn.createStatement();
            String nadjiSveDrzaveS = new String("SELECT * FROM drzava");
            ResultSet rsDrzave = nadjiSveDrzave.executeQuery(nadjiSveDrzaveS);

            while(rsDrzave.next())
            {
                Country country = new Country(rsDrzave.getString("naziv_malim"), rsDrzave.getString("skracenica2"),
                        rsDrzave.getString("skracenica3"), rsDrzave.getInt("numcode"),
                        rsDrzave.getInt("phonecode"));

                obCountry.add(country);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return obCountry;
    }

    public Country getAcountryWith2LetterAbbervation(String skracenica2)
    {
        Country country = null;
        try
        {
            nadjiDrzavuPoSkracenici2.setString(1, skracenica2);
            ResultSet rsSkracenica2 = nadjiDrzavuPoSkracenici2.executeQuery();

            if(rsSkracenica2.next() == true)
                country = new Country(rsSkracenica2.getString("naziv_malim"), rsSkracenica2.getString("skracenica2"),
                        rsSkracenica2.getString("skracenica3"), rsSkracenica2.getInt("numcode"),
                        rsSkracenica2.getInt("phonecode"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return country;
    }

    public Country getAcountryWith3LetterAbbervation(String skracenica3)
    {
        Country country = null;
        try
        {
            nadjiDrzavuPoSkracenici3.setString(1, skracenica3);
            ResultSet rsSkracenica3 = nadjiDrzavuPoSkracenici3.executeQuery();

            if(rsSkracenica3.next() == true)
                country = new Country(rsSkracenica3.getString("naziv_malim"), rsSkracenica3.getString("skracenica2"),
                        rsSkracenica3.getString("skracenica3"), rsSkracenica3.getInt("numcode"),
                        rsSkracenica3.getInt("phonecode"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return country;
    }

    public Country dajDrzavuPoNazivu(String countryName)
    {
        Country country = null;

        String upperCaseCountryName = countryName.toUpperCase();
        String lowerCaseCountryName = countryName.toLowerCase();

        try
        {
            nadjiDrzavuPoNazivu.setString(1, upperCaseCountryName);
            nadjiDrzavuPoNazivu.setString(2, lowerCaseCountryName);
            ResultSet rsDrzava = nadjiDrzavuPoNazivu.executeQuery();

            country = new Country(rsDrzava.getString("naziv_malim"), rsDrzava.getString("skracenica2"),
                    rsDrzava.getString("skracenica3"), rsDrzava.getInt("numcode"),
                    rsDrzava.getInt("phonecode"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  country;
    }

    public boolean doesAUserWithUSernameExist(String username)
    {
        try
        {
            nadjiKorisnikaPoUsername.setString(1, username);
            ResultSet rsKorisnik = nadjiKorisnikaPoUsername.executeQuery();

            if(rsKorisnik.next()==true)
                return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
