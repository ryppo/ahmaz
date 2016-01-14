package org.y3.ahmaz.model;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.y3.commons.fx.FxContext;
import org.y3.commons.fx.environment.FxPersistantEnvironment;

/** 
 * <p>Title: org.y3.ahmaz.model - AhmazFxEnvironment</p>
 * <p>Description: </p>
 * <p>Copyright: 2016</p>
* <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
@Log4j2
public class AhmazFxEnvironment extends FxPersistantEnvironment {
    
    private final String KEY__PATH_TO_DATABASE = "path-to-database";

    @Override
    public PERSISTANCE_CONTEXT getPersistanceContext() {
        return PERSISTANCE_CONTEXT.USER;
    }

    @Override
    public Logger getLogger() {
        return log;
    }
    
    public void setPathToDatabase(String pathToDatabase) {
        setString(KEY__PATH_TO_DATABASE, pathToDatabase);
    }
    
    public String getPathToDatabase() throws InstantiationException, IllegalAccessException {
        return getString(KEY__PATH_TO_DATABASE, FxContext.getInstance().getFxOperatingSystemEnvironment().getOsUserHome() + "/ahmaz.db");
    }

}
