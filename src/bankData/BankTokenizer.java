package bankData;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Peter
 */
//class representing the algorithm of tokenization and detokenization

public class BankTokenizer {

    private final static int DIGITS = 16;
    private final Random random;
    private final ArrayList<Integer> digits;
    private final BankInfo type;

    public BankTokenizer(BankInfo type) {
        random = new Random();
        digits = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            digits.add(i);
        }
        this.type = type;

    }

    private boolean isLuhn(String cardNumber) {
        if (cardNumber.length() != DIGITS) {
            return false;
        }
        int[] checkDigits = new int[DIGITS];
        for (int i = 0; i < DIGITS; i++) {
            checkDigits[i] = fromCharToNumber(cardNumber.charAt(i));
        }

        for (int i = DIGITS - 2; i >= 0; i -= 2) {
            checkDigits[i] = checkDigits[i] * 2;
            if (checkDigits[i] > 9) {
                checkDigits[i] = checkDigits[i] / 10 + checkDigits[i] % 10;
            }
        }
        int sum = 0;
        for (int i = 0; i < DIGITS; i++) {
            sum += checkDigits[i];
        }
        return sum % 10 == 0;

    }

    private int fromCharToNumber(char number) {
        return number - '0';
    }

    private char fromIntToChar(int number) {
        return (char) (number + '0');
    }

    private boolean isValid(String cardNumber) {
        return cardNumber.matches("3\\d{15}|4\\d{15}|5\\d{15}"
                + "6\\d{15}") && isLuhn(cardNumber);
    }

    public String tokenize(String cardNumber) {
        char[] charToken = new char[cardNumber.length()];
        String token = "";
        if (!isValid(cardNumber)) {
            return null;
        }
        int[] firstDigits = {1, 2, 7, 8, 9};
        int sum;
        do {
            sum = 0;
            int randomNum = random.nextInt(firstDigits.length);
            sum += firstDigits[randomNum];
            charToken[0] = fromIntToChar(firstDigits[randomNum]);
            for (int i = 1; i < DIGITS - 4; i++) {
                Integer removed = fromCharToNumber(cardNumber.charAt(i));
                digits.remove(removed);
                randomNum = random.nextInt(digits.size());
                sum += digits.get(randomNum);
                charToken[i] = fromIntToChar(digits.get(randomNum));
                digits.add(removed);
            }
            for (int i = DIGITS - 4; i < DIGITS; i++) {
                charToken[i] = cardNumber.charAt(i);
            }
            token = new String(charToken);
        } while (sum % 10 != 0 && type.isRegistered(token));

        return token;
    }

    public String detokenize(String token) {
        if (!type.isRegistered(token)) {
            return null;
        }
        return type.getCardFromToken(token);
    }

}
