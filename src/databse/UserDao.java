package databse;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao
{
    private static UserDao instance = null;
    private DatabaseConnection datConn;

    private PreparedStatement nadjiKorisnikaPoUsername;
    private PreparedStatement nadjiHesPasswordaKorinsika;

    private static void initialize()
    {
        instance = new UserDao();
    }

    private UserDao()
    {
        String url = "jdbc:sqlite:database_init.sql";

        File db = new File("database_init.sql");
        boolean doesDbExist = db.exists();

        try
        {
            nadjiKorisnikaPoUsername = datConn.getConnection().prepareStatement("SELECT * FROM korisnik WHERE username LIKE '?' ");
            nadjiHesPasswordaKorinsika = datConn.getConnection().prepareStatement("SELECT hes_lozinke FROM korisnik WHERE username LIKE '?'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public static UserDao getInstance()
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
