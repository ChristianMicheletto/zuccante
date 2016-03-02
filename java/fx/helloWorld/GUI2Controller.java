import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class GUI2Controller {
    
    // set in Scene Builder document -> controller
    
    @FXML
    private Button boton;
    
    @FXML
    private Label label;
    
    @FXML
    private void onClick() {
        label.setText("fatto");
        System.out.println("Hello World");
    }
}
