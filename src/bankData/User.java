package bankData;

/**
 *
 * @author Peter
 */
public class User {

    private final String username;
    private String password;
    private int privilege;

    public User(String username, String password, int privilege) {
        this.username = username;
        setPassword(password);
        setPrivilege(privilege);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivilege(int privilege) {
        if (privilege >= 0 && privilege <= 3) {
            this.privilege = privilege;
        } else {
            this.privilege = 0;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPrivilege() {
        return privilege;
    }

}
