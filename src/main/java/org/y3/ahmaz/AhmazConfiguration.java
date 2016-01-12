package org.y3.ahmaz;

import javafx.scene.image.Image;
import org.y3.commons.fx.FxConfiguration;

/** 
 * <p>Title: org.y3.ahmaz - AhmazConfiguration</p>
 * <p>Description: </p>
 * <p>Copyright: 2015 - 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class AhmazConfiguration extends FxConfiguration {
    
    public Image APPLICATION_ICON = getFxImage("ahmaz_no_subtitle.png");
    public Image APPLICATION_SYMBOL = getFxImage("ahmaz_no_subtitle_symbol.png");
    public Image Y3_ICON = getFxImage("y3.png");
    public Image Y3_SYMBOL = getFxImage("y3_symbol.png");
    
    public String APPLICATION_IDENTITY = getRbString("APPLICATION_IDENTITY");
    public String APPLICATION_ORIGIN = getRbString("APPLICATION_ORIGIN");
    public String FULLSCREEN = getRbString("FULLSCREEN");
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

}
