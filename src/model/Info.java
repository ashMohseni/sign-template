package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ashkan mohseni
 */
public class Info {

    protected String username, usernameTest;
    protected String email;
    protected String password, passwordTest;
    HashMap<String, String> userpass = new HashMap<>();

    public Info() {

    }

    public Info(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public void setUsername(String username) {
        if (username.matches("^[A-Za-z0-9_-]*$")) {
             this.username = username;
        } else{
         usernameTest = "notValid";   
        }
    }

    public String getUsernameTest() {
        return usernameTest;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        if (password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            this.password = password;
        } else{
            passwordTest = "notValid";
        }
        
    }

    public String getPasswordTest() {
        return passwordTest;
    }
    
    public void setUserpass(HashMap<String, String> userpass) {
        this.userpass = userpass;
    }

    // To write the new user's info to the UserPass.txt
    public void printUserPass() throws IOException {
        if (usernameTest != "notValid" && passwordTest != "notValid") {
        File file = new File("src/model/UserPass.txt");
        FileWriter fw = new FileWriter(file, true);
        try (fw) {
            fw.write(username + " ");
            fw.write(password);
            fw.write("\n");
        }
        }
    }

    // To read the user's info and store it in the hashMap so we can check it later on
    public void ReadUserPass() throws FileNotFoundException {
        File file = new File("src/model/UserPass.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String user = sc.next();
            String pss = sc.next();
            userpass.put(user, pss);
        }
    }

    public HashMap<String, String> getUserpass() throws IOException {
        if (usernameTest != "notValid" && passwordTest != "notValid") {
            userpass.put(username, password);
            ReadUserPass();
        }
        return userpass;
    }

}
