package fx;

import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
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
    @FXML private ImageView gitHub;

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
        
        //Fields being empty
        if (user.isEmpty() || user_email.isEmpty() || user_pass.isEmpty()) {
            alert("You should fill every fields");
        }
        else if(info.getUsernameTest() == "notValid" || info.getPasswordTest() == "notValid" || 
                info.getEmailTest() == "notValid"){
            //Username not valid
            if (info.getUsernameTest() == "notValid") {
                alert("The entered username is not valid!\nYour username should only contain letters and numbers");
            }
            // Password not valid
            if (info.getPasswordTest() == "notValid") {
                alert("The entered Password is not valid!\nYour password should contain at least eight characters, at least one letter and one number");
            }
            // Email not valid
            if (info.getEmailTest() == "notValid") {
                alert("The entered email is not valid!");
            }
        } else if(info.getUserpass().containsKey(user)){
                alert("The entered username already exists");
        }
    }
    
    // A method to show the alerts easier
    private Alert alert(String AlertText){
        Alert alert = new Alert(ERROR, AlertText, OK);
         DialogPane dialogPane = alert.getDialogPane();
         dialogPane.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
         dialogPane.getStyleClass().add("myDialog");
         alert.show(); 
        return alert;
    }

    @FXML
    private void sign_in(MouseEvent event) throws IOException {
        Parent login = FXMLLoader.load(this.getClass().getResource("Login.fxml"));
        Scene scene = new Scene(login, 1500, 870);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setMaximized(true);
        window.show();
    }

    @FXML
    private void gitEffect(MouseEvent event) {
        // entering imageView 
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.18);
        gitHub.setEffect(colorAdjust); 
         // exiting imageView
        gitHub.addEventFilter(MouseEvent.MOUSE_EXITED, eh ->{
        gitHub.setEffect(null);
        });
    }

    @FXML
    private void git(MouseEvent event) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://github.com/ashMohseni"));
    }

}
