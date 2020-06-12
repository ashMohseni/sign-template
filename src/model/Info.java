
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
    
    public Info(){
        
    }
    
    public Info(String username, String email, String password){
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
    
    public HashMap<String, String> getUserpass() {
        userpass.put(username, password);
        return userpass;
    }
    
    public void printUserPass() throws FileNotFoundException{
        File file = new File("src/model/UserPass.txt");
        PrintWriter pw = new PrintWriter(file);
       try(pw){
        pw.write(username);
        pw.write("=");
        pw.write(password);
        pw.write("\n");
        pw.close();
       }
    }
}
