import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {


    private static String FILE_PATH = "./data/";
    private static String FILE_NAME = "data.txt";
    private Duke duke;


    @Override
    public void start(Stage stage) {
        try {
            String filePATH = Storage.makeDirectory(FILE_PATH);
            File fileNAME = new File(FILE_NAME);
            duke = new Duke(filePATH, FILE_NAME);
        }
        catch (FileNotFoundException e){
            System.out.println("Error!");
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
