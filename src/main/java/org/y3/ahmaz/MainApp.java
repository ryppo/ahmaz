package org.y3.ahmaz;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.y3.ahmaz.view.ApplicationFrame;

@Log4j2
public class MainApp extends Application {
    
    private static String[] args;

    @Override
    public void start(Stage stage) throws Exception {
        log.debug("start");
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
        log.debug("main");
        args = _args;
        launch(args);
    }

}
