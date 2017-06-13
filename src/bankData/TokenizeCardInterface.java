package bankData;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Peter
 */
public interface TokenizeCardInterface extends Remote {

    public String createConnection(String username, String password) throws RemoteException;

    public String tokenize(String cardNumber) throws RemoteException;

    public String detokenize(String token) throws RemoteException;

    public String closeConnection() throws RemoteException;
}
