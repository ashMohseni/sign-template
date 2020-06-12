
package fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.ERROR;
import javafx.scene.control.Button; 
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Info;

/**
 * FXML Controller class
 *
 * @author ashkan mohseni
 */
public class LoginController implements Initializable {

    @FXML private Button sign_in; 
    @FXML  private Label sign_up; 
    @FXML private TextField username;
    @FXML private PasswordField password;
     Info info = new Info();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Sign_in(ActionEvent event) throws IOException {
        String user = username.getText().trim();
        String pass = password.getText().trim();
        
        //Check if the username exists and if so check if the pass matches
        if (info.getUserpass().containsKey(user)) {
            String storedPass = info.getUserpass().get(user);
            // If password is right
            if (storedPass.equals(pass)) {
               Parent signUp = FXMLLoader.load(getClass().getResource("signUp.fxml"));
                Scene scene = new Scene(signUp,1500, 870);
                scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());
                 
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
                window.setScene(scene);
                window.setTitle("Sign up");
                window.setMaximized(true);
                window.show();
            }
            // If password is not right
            else{
                Alert alert = new Alert(ERROR, "Your Password is wrong!", OK);
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add( getClass().getResource("login.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                alert.show();
            }
        }
        // If username doesn't exist
        if (!(info.getUserpass().containsKey(user))) {
             Alert alert = new Alert(ERROR, "The username is not valid!", OK);
             DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add( getClass().getResource("login.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                alert.show();
        }
        
        
    }

    @FXML
    private void sign_up(MouseEvent event) throws IOException {

                Parent signUp = FXMLLoader.load(getClass().getResource("signUp.fxml"));
                Scene scene = new Scene(signUp,1500, 870);
                scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());
                
                //This line gets the stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
                window.setScene(scene);
                window.setTitle("Sign up");
                window.setMaximized(true);
                window.show();
                
    }
    
}
