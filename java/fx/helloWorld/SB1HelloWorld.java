import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

 

public class SB1HelloWorld extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("SBHelloWorld v1");
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI1.fxml"));
            // FXMLLoader loader = new FXMLLoader(SceneBuilderHelloWorld.class.getResource("GUI1.fxml"));
            
            AnchorPane layout = (AnchorPane) loader.load();
            // show the scene containing the root layout.
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }

}
