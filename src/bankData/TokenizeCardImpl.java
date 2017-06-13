package bankData;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter
 */
//class which implements methods of the TokenizeCardInterface 
//and registering with RMI

enum Choice {
    TOKENIZE, DETOKENIZE
};

public class TokenizeCardImpl extends UnicastRemoteObject implements TokenizeCardInterface {

    private BankInfo cardInfo;
    private UserInfo userInfo;
    private BankTokenizer tokenizer;
    private User crrUser;

    public TokenizeCardImpl() throws RemoteException {
        cardInfo = new BankInfo();
        userInfo = new UserInfo();
        tokenizer = new BankTokenizer(cardInfo);
        registerWithRMI();
    }

    @Override
    public String createConnection(String username, String password) throws RemoteException {
        if (userInfo.isUserRegistered(username)) {
            User user = userInfo.getUser(username);
            if (isValidUser(user, password)) {
                this.crrUser=user;
                return "Connection established."+ String.valueOf(userInfo.getUser(username).getPrivilege());
            } else {
                return "Error! Incorrect password!";
            }
        }
        return "Error! User does not exist!";
    }

    @Override
    public String tokenize(String cardNumber) throws RemoteException {
         if (isValidChoice(Choice.TOKENIZE, crrUser)) {
            String token = tokenizer.tokenize(cardNumber);
            if (token == null) {
                return "Error! Card number is not valid!";
            }
            cardInfo.addCardToken(cardNumber, token);
            return token;
        } else {
            return "Error! You do not have permission to tokenize cards!";
        }
    }

    @Override
    public String detokenize(String token) throws RemoteException {
        if (isValidChoice(Choice.DETOKENIZE, crrUser)) {
            String cardNumber = tokenizer.detokenize(token);
            if (cardNumber == null) {
                return "Error! Not registered token!";
            }
            return cardNumber;
        } else {
            return "Error! You do not have permission to receive card number from token";
        }
    }

    @Override
    public String closeConnection() throws RemoteException {
        return "Connection closed";
    }

    public boolean addUser(String username, String password, int privilege) {
        if (userInfo.isUserRegistered(username)) {
            return false;
        }
        userInfo.addUser(username, password, privilege);
        return true;
    }

    private boolean isValidUser(User user, String password) {
        return user.getPassword().equals(password);
    }

    private boolean isValidChoice(Choice choice, User user) {
        if (choice == Choice.TOKENIZE) {
            return user.getPrivilege() >= cardInfo.getTokenizeLvl();
        } else {
            return user.getPrivilege() >= cardInfo.getDetokenizeLvl();
        }
    }

    public BankInfo getCardInfo() {
        return cardInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    private void registerWithRMI() {
        try {
            Registry registry = LocateRegistry.createRegistry(1089);
            registry.rebind("banktokenizer", this);
        } catch (RemoteException ex) {
            Logger.getLogger(TokenizeCardImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
