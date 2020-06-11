
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
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ashkan mohseni
 */
public class LoginController implements Initializable {

    @FXML private Button sign_in; 
    @FXML  private Label sign_up;
    //Stage window;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Sign_in(ActionEvent event) {
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
