package org.y3.ahmaz.view;

import com.sebn.gsd.aptgrade.core.database.DatabaseException;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.y3.ahmaz.model.AhmazConfiguration;
import org.y3.ahmaz.model.ModelController;

/** 
 * <p>Title: org.y3.ahmaz.view - ApplicationFrame</p>
 * <p>Description: </p>
 * <p>Copyright: 2015 - 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
@Log4j2
public class ApplicationFrame {
    
    private final Stage primaryStage;
    private MenuBar menuBar;
    private CheckMenuItem mi_fullScreen;
    private AhmazConfiguration CONF = new AhmazConfiguration();
    private Scene root_scene;
    private ModelController modelController;

    public ApplicationFrame(Stage _primaryStage) throws DatabaseException {
        primaryStage = _primaryStage;
        buildUi();
        bindUi();
    }

    private void buildUi() {
        primaryStage.setTitle(CONF.APPLICATION_IDENTITY);
        primaryStage.getIcons().add(CONF.APPLICATION_ICON);
        buildMenu();
        BorderPane rootPane = new BorderPane();
        rootPane.setTop(menuBar);
        Group rootGroup = new Group();
        rootGroup.getChildren().add(rootPane);
        root_scene = new Scene(rootGroup);
        root_scene.getStylesheets().add(CONF.getStylesheet());
        primaryStage.setScene(root_scene);
    }
    
    private void buildMenu() {
        ImageView menuAppIcon = new ImageView(CONF.APPLICATION_SYMBOL);
        Menu menuApp = new Menu(CONF.APPLICATION_IDENTITY, menuAppIcon);

        mi_fullScreen = new CheckMenuItem(CONF.FULLSCREEN);
        menuApp.setOnShowing((Event event) -> {
            mi_fullScreen.setSelected(primaryStage.isFullScreen());
        });
        mi_fullScreen.setOnAction((ActionEvent t) -> {
            actionSwitchFullScreen();
        });
        MenuItem mi_y3 = new MenuItem(CONF.APPLICATION_ORIGIN, new ImageView(CONF.Y3_SYMBOL));
        mi_y3.setOnAction((ActionEvent t) -> {
            try {
                actionShowOriginUrl();
            } catch (URISyntaxException | IOException ex) {
                handleException(ex);
            }
        });
        
        menuApp.getItems().addAll(mi_fullScreen, mi_y3);
        
        menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        menuBar.getMenus().addAll(menuApp);
    }
    
    public void setVisible(boolean visible) {
        if (visible) {
            primaryStage.show();
        } else {
            primaryStage.hide();
        }
    }
    
    public void actionSwitchFullScreen() {
        primaryStage.setFullScreen(!primaryStage.isFullScreen());
    }

    private void actionShowOriginUrl() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI(CONF.APPLICATION_ORIGIN_URL));
    }
    
    private void handleException(Exception e) {
        log.error(e);
        e.printStackTrace();
    }
    
    public void bindUi() throws DatabaseException {
        log.debug("bindUi");
        modelController = new ModelController(CONF);
        modelController.initAhmazDatabase();
        modelController.debugDatabaseToConsole();
    }
    
}
