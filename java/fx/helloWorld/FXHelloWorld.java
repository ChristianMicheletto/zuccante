import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

 

public class JavaFXHelloWorld extends Application {

    public static void main(String[] args) {
        // Application.launch(args);
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello World");
        Group group = new Group();
        Scene scene = new Scene(group, 200, 300);
        Button btn = new Button();
        btn.setLayoutX(50);
        btn.setLayoutY(100);
        btn.setText("Hello World");
        /*
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        */
        /* OR 
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World");
        });
        */
        btn.setOnAction((event) -> {
            System.out.println("Hello World");
        });
        group.getChildren().add(btn);
        stage.setScene(scene);
        stage.show();
    }
}
