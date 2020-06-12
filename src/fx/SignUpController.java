
package fx;

import java.io.FileNotFoundException;
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
public class SignUpController implements Initializable {

    @FXML private TextField username;
    @FXML private TextField email;
    @FXML private PasswordField password;
    
    
    Info info = new Info();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void create_account(ActionEvent event) throws FileNotFoundException, IOException {
        
        String user = username.getText().trim();
        String user_email = email.getText().trim();
        String user_pass = password.getText().trim();
        info.setUsername(user);
        info.setEmail(user_email);
        info.setPassword(user_pass);


        System.out.println(info.getUserpass());
        info.printUserPass(); 
    }
    

    @FXML
    private void sign_in(MouseEvent event) throws IOException {
        Parent login = FXMLLoader.load(this.getClass().getResource("Login.fxml"));
        Scene scene = new Scene(login, 1500, 870);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setMaximized(true);
        window.show();
    }
    
}
