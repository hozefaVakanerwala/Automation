package Data;

public class PaymentDetails {

    private String cardtype;
    private String cardNumber;

    public PaymentDetails() {
        cardtype = "Visa";
        cardNumber = "0876543217856";
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
