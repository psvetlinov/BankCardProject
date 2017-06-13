package bankData;

/**
 *
 * @author Peter
 */
//class representing the relation Card <-> Token

public class CardToken implements Comparable<CardToken> {

    private String cardNumber;
    private String token;

    public CardToken(String cardNumber, String token) {
        this.cardNumber = cardNumber;
        this.token = token;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getToken() {
        return token;
    }

    @Override
    public int compareTo(CardToken o) {
        return token.compareTo(o.getToken());
    }

}
