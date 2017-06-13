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
import java.util.ArrayList;
import java.util.Formatter;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter
 */
public class BankInfo {

    private final TreeMap<String, String> tokenToCard;
    private final TreeMap<String, ArrayList<String>> cardToToken;
    private final String bankFile = "bank";
    private final XStream xs;
    private static final int TOKENIZE_LVL = 1;
    private static final int DETOKENIZE_LVL = 2;

    public BankInfo() {
        tokenToCard = new TreeMap<>();
        cardToToken = new TreeMap<>();
        xs = new XStream(new DomDriver());
        xs.alias("bankInf", CardToken.class);
        deserializeBankXML();
    }

    public boolean isRegistered(String token) {
        return tokenToCard.containsKey(token);
    }

    public String getCardFromToken(String token) {
        if (!tokenToCard.containsKey(token)) {
            return null;
        }
        return tokenToCard.get(token);
    }

    public boolean addCardToken(String card, String token) {
        if (!isRegistered(token)) {
            tokenToCard.put(token, card);
            if (cardToToken.containsKey(token)) {
                ArrayList<String> cardTokens = new ArrayList<>();
                cardTokens.add(token);
                cardToToken.replace(token, cardTokens);
            } else {
                ArrayList<String> cardTokens = new ArrayList<>();
                cardTokens.add(token);
                cardToToken.put(token, cardTokens);
            }
            return true;
        }
        return false;
    }

    public void serializeBankXML() {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(bankFile);
            ObjectOutputStream output = xs.createObjectOutputStream(fout, "users");
            tokenToCard.entrySet().stream().forEach((entry) -> {
                CardToken cardToken = new CardToken(entry.getValue(), entry.getKey());
                try {
                    output.writeObject(cardToken);
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

    public void deserializeBankXML() {
        FileInputStream fin = null;
        ObjectInputStream input = null;
        try {
            fin = new FileInputStream(bankFile);
            input = xs.createObjectInputStream(fin);
            while (true) {
                CardToken cardToken = (CardToken) input.readObject();
                addCardToken(cardToken.getCardNumber(), cardToken.getToken());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BankInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {

        } catch (IOException ex) {
            Logger.getLogger(BankInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BankInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getTokenizeLvl() {
        return TOKENIZE_LVL;
    }

    public int getDetokenizeLvl() {
        return DETOKENIZE_LVL;
    }

    public void printSortedCards(Formatter output) {
        output.format("Token:        \tCard:\n");
        cardToToken.entrySet().stream().forEach((cardToken) -> {
            cardToken.getValue().stream().forEach((token) -> {
                output.format("%s\t%s\n", token, cardToken.getKey());
            });
        });
    }

    public void printSortedTokens(Formatter output) {
        output.format("Token:        \tCard:\n");
        tokenToCard.entrySet().stream().forEach((elem) -> {
            output.format("%s\t%s\n", elem.getKey(), elem.getValue());
        });
    }
}
