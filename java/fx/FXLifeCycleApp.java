import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

//GNOME install grk2-engines
 
public class FXLifeCycleApp extends Application {
    
    public FXLifeCycleApp() {
        String name = Thread.currentThread().getName();
        System.out.println("*** new FXLifeCycleApp() ***\n Thread:" + name);
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void init() {
        String name = Thread.currentThread().getName();
        System.out.println("*** init() ***\n Thread" + name);
    }
    
    @Override
    public void start(Stage stage) {
        String name = Thread.currentThread().getName();
        System.out.println("*** start() ***\n Thread" + name);
        Scene scene = new Scene(new Group(), 200, 200);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application Life Cycle");
        stage.show();
    }
    
    @Override
    public void stop() {
        String name = Thread.currentThread().getName();
        System.out.println("*** stop() ***\n Thread" + name);
    }
}
