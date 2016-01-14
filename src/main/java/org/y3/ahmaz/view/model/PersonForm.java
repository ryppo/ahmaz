package org.y3.ahmaz.view.model;

import com.sebn.gsd.aptgrade.core.model.Person;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.y3.ahmaz.model.ModelController;

/** 
 * <p>Title: org.y3.ahmaz.view.model - PersonForm</p>
 * <p>Description: </p>
 * <p>Copyright: 2016</p>
 * <p>Organisation: IT-Happens.de</p>
 * @author Christian.Rybotycky
*/
public class PersonForm extends GridPane {
    
    private final ModelController MC;
    private TextField firstname_textField, lastname_textField;
    private Person personModel;

    public PersonForm(ModelController _modelController) {
        MC = _modelController;
        buildUi();
    }
    
    private void buildUi() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25,25,25,25));
        
        Text formTitle = new Text(MC.getAhmazConfiguration().PERSON);
        formTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(formTitle, 0, 0, 2, 1);
        
        Label firstname_label = new Label(MC.getAhmazConfiguration().FIRSTNAME);
        add(firstname_label, 0, 1);
        Label lastname_label = new Label(MC.getAhmazConfiguration().LASTNAME);
        add(lastname_label, 1, 1);
        
        firstname_textField = new TextField();
        add(firstname_textField, 0, 2);
        lastname_textField = new TextField();
        add(lastname_textField, 1, 2);
        
        Button save_button = new Button(MC.getAhmazConfiguration().SAVE);
        save_button.setOnAction((ActionEvent t) -> {
            actionSave();
        });
        HBox hb_saveButton = new HBox(10);
        hb_saveButton.setAlignment(Pos.BOTTOM_RIGHT);
        hb_saveButton.getChildren().add(save_button);
        add(hb_saveButton, 1, 4);
    }
    
    public void actionSave() {
        if (personModel == null) {
            personModel = MC.createPerson();
        }
        personModel.setFirstname(firstname_textField.getText());
        personModel.setLastname(lastname_textField.getText());
    }

}
