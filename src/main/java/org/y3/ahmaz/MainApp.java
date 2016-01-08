package org.y3.ahmaz;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import org.y3.ahmaz.view.ApplicationFrame;


public class MainApp extends Application {
    
    private static String[] args;

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start");
        ApplicationFrame applicationFrame = new ApplicationFrame(stage);
        applicationFrame.setVisible(true);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param _args the command line arguments
     */
    public static void main(String[] _args) {
        System.out.println("main");
        args = _args;
        launch(args);
    }

}
