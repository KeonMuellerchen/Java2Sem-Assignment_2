package secsemassignment2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Keon Muellerchen
 */
public class CarLaunch extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }//end
     
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("CarView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Java Assignment 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }//end
}//end
