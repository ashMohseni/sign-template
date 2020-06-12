package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ashkan mohseni
 */
public class Info {

    protected String username;
    protected String email;
    protected String password;
    HashMap<String, String> userpass = new HashMap<>();

    public Info() {

    }

    public Info(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserpass(HashMap<String, String> userpass) {
        this.userpass = userpass;
    }

    public HashMap<String, String> getUserpass() throws IOException {
        userpass.put(username, password);
        return userpass;
    }

    // To write the new user's info to the UserPass.txt
    public void printUserPass() throws IOException {
        File file = new File("src/model/UserPass.txt");
        FileWriter fw = new FileWriter(file, true);
        try (fw) {
            fw.write(username);
            fw.write("=");
            fw.write(password);
            fw.write("\n");
        }
    }
}
