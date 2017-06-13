package bankData;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter
 */
public class UserInfo {

    private final HashMap<String, User> users;
    private final String userFile = "users.xml";
    private final XStream xs;

    public UserInfo() {
        users = new HashMap<>();
        xs = new XStream(new DomDriver());
        xs.alias("users", User.class);
        deserializeUsersXML();
    }

    public boolean isUserRegistered(String username) {
        return users.containsKey(username);
    }

    public User getUser(String username) {
        if (!isUserRegistered(username)) {
            return null;
        }
        return users.get(username);
    }

    public boolean addUser(String username, String password, int privilegeLvl) {
        if (!isUserRegistered(username)) {
            User user = new User(username, password, privilegeLvl);
            users.put(username, user);
            return true;
        }
        return false;
    }

    public void serializeUsersXML() {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(userFile);
            ObjectOutputStream output = xs.createObjectOutputStream(fout, "users");
            users.entrySet().stream().forEach((entry) -> {
                try {
                    output.writeObject(entry.getValue());
                } catch (IOException ex) {
                    Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void deserializeUsersXML() {
        FileInputStream fin = null;
        ObjectInputStream in = null;
        try {
            fin = new FileInputStream(userFile);

            in = xs.createObjectInputStream(fin);

            while (true) {
                User user = (User) in.readObject();
                users.put(user.getUsername(), user);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {

        } catch (IOException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

                if (fin != null) {
                    fin.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
