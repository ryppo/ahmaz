package org.y3.ahmaz.model;

import com.sebn.gsd.aptgrade.core.database.DatabaseException;
import com.sebn.gsd.aptgrade.core.database.GraphDatabase;
import com.sebn.gsd.aptgrade.core.database.ModelFactory;
import com.sebn.gsd.aptgrade.core.model.Person;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.extern.log4j.Log4j2;
import org.y3.commons.fx.FxContext;

/** 
 * <p>Title: org.y3.ahmaz.model - ModelController</p>
 * <p>Description: </p>
 * <p>Copyright: 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
@Log4j2
public class ModelController {
    
    private GraphDatabase ahmazDatabase = null;
    private AhmazConfiguration ahmazConfiguration;

    public AhmazConfiguration getAhmazConfiguration() {
        return ahmazConfiguration;
    }
    private FxContext ahmazFxContext;
    private ArrayList<ModelFactory> registeredModelFactories;

    public ModelController(AhmazConfiguration _ahmazConfiguration) {
        ahmazConfiguration = _ahmazConfiguration;
        ahmazFxContext = FxContext.getInstance();
        ahmazFxContext.addFxEnvironment(new AhmazFxEnvironment());
    }
    
    public boolean initAhmazDatabase() {
        boolean successful = false;
        ahmazDatabase = new GraphDatabase();
        try {
            successful = ahmazDatabase.init(getPathToDatabase());
            registeredModelFactories = ahmazConfiguration.getModelFactoriesToRegister();
            for (Iterator<ModelFactory> it = registeredModelFactories.iterator(); it.hasNext();) {
                ModelFactory modelFactory = it.next();
                ahmazDatabase.registerModelFactory(modelFactory);
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            log.error(ex);
        }
        return successful;
    }
    
    public Person createPerson() {
        return new Person(ahmazDatabase.createNode("Person"));
    }

    public String getPathToDatabase() throws InstantiationException, IllegalAccessException {
        return ((AhmazFxEnvironment) ahmazFxContext.getFxEnvironment(AhmazFxEnvironment.class)).getPathToDatabase();
    }
    
    public void debugDatabaseToConsole() throws DatabaseException {
        ahmazDatabase.listAllNodesToConsole();
        ahmazDatabase.listAllModelsToConsole();
    }

}
