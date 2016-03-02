import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class Es001 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Text msg = new Text("Hello JavaFX");
        VBox root = new VBox();
        root.getChildren().add(msg);
        
        // Create a button with "Exit" text
        Button exitBtn = new Button("Exit");
        root.getChildren().add(exitBtn);
        // Using a lambda expression
        exitBtn.setOnAction(e -> Platform.exit());
        
        /* Using an anonymous class
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Platform.exit();
            }
        });
        */
        
        Scene scene = new Scene(root, 300, 50);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX Application with a Scene");
        stage.show();
    }
}
