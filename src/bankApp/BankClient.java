package bankApp;

import bankData.TokenizeCardInterface;
import bankData.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Peter
 */
public class BankClient {

    private TokenizeCardInterface server;
    private JFrame currentWindow;
    private boolean loggedIn = false;
    private User user;

    public BankClient() {
        initializeRMI();
        changeSession(null);
    }

    public void initializeRMI() {
        try {
            Registry registry = LocateRegistry.getRegistry("", 1089);
            server = (TokenizeCardInterface) registry.lookup("banktokenizer");
        } catch (RemoteException ex) {
            Logger.getLogger(BankClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(BankClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TokenizeCardInterface getServer() {
        return server;
    }

    public User getUser() {
        return user;
    }

    public void changeSession(User user) {

        if (user == null) {
            this.loggedIn = false;
            if (currentWindow != null) {
                currentWindow.setVisible(false);
            }
            currentWindow = new JFrame();
            currentWindow.add(new LoginPanel(this));
        } else {
            this.loggedIn = true;
            if (currentWindow != null) {
                currentWindow.setVisible(false);
            }

            currentWindow = new ServicePanel(this);
        }
        attachHandlers(currentWindow, loggedIn);
        currentWindow.setSize(600, 500);
        currentWindow.setVisible(true);
    }

    private void attachHandlers(JFrame currentWindow, boolean loggedOn) {
        currentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (loggedOn) {
            currentWindow.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try {
                        server.closeConnection();
                        changeSession(user);
                    } catch (RemoteException ex) {
                        Logger.getLogger(BankClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } else {
            currentWindow.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        }
    }

    public static void main(String[] args) {
        BankClient client = new BankClient();
        LoginPanel panel = new LoginPanel(client);
    }

}
