import controller.StartScreenController;
import databse.BazaDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ResourceBundle bundle = ResourceBundle.getBundle("Translation");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/startScreen.fxml"), bundle);

        BazaDao bazaDao = BazaDao.getInstance();

        loader.setController(new StartScreenController(bazaDao));
        Parent root = loader.load();
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
