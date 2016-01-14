package org.y3.ahmaz.model;

import com.sebn.gsd.aptgrade.core.database.ModelFactory;
import com.sebn.gsd.aptgrade.core.model.Person;
import java.util.ArrayList;
import javafx.scene.image.Image;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.y3.commons.fx.FxConfiguration;

/** 
 * <p>Title: org.y3.ahmaz.model - AhmazConfiguration</p>
 * <p>Description: </p>
 * <p>Copyright: 2015 - 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
@Log4j2
public class AhmazConfiguration extends FxConfiguration {
    
    public Image APPLICATION_ICON = getFxImage("ahmaz_no_subtitle.png");
    public Image APPLICATION_SYMBOL = getFxImage("ahmaz_no_subtitle_symbol.png");
    public Image PERSON_ICON = getFxImage("person_24.png");
    public Image Y3_ICON = getFxImage("y3.png");
    public Image Y3_SYMBOL = getFxImage("y3_symbol.png");
    
    public String ADD_PERSON = getRbString("ADD_PERSON");
    public String APPLICATION_IDENTITY = getRbString("APPLICATION_IDENTITY");
    public String APPLICATION_ORIGIN = getRbString("APPLICATION_ORIGIN");
    public String FIRSTNAME = getRbString("FIRSTNAME");
    public String FULLSCREEN = getRbString("FULLSCREEN");
    public String LASTNAME = getRbString("LASTNAME");
    public String PERSON = getRbString("PERSON");
    public String SAVE = getRbString("SAVE");
    public String APPLICATION_ORIGIN_URL = "http://www.IT-Happens.de";

    @Override
    public String getResourceBundlePath() {
        return "org/y3/ahmaz";
    }

    @Override
    public String getImagesPath() {
        return getResourceBundlePath() + "/img";
    }

    @Override
    public String getStylesheetPath() {
        return getResourceBundlePath();
    }

    @Override
    public String getResourceBundleName() {
        return "ahmaz";
    }

    @Override
    public String getStylesheetName() {
        return "ahmaz.css";
    }

    @Override
    public Logger getLogger() {
        return log;
    }
    
    public ArrayList<ModelFactory> getModelFactoriesToRegister() {
        ArrayList<ModelFactory> modelFactories = new ArrayList<>();
        modelFactories.add(new ModelFactory(Person.class));
        return modelFactories;
    } 

}
