package Data;

public class Product {

    private String toyName;
    private int qty;
    private String teddyPrice;

    public Product(String toyName) {
        this.toyName = toyName;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getTeddyPrice() {
        return teddyPrice;
    }

    public void setTeddyPrice(String teddyPrice) {
        this.teddyPrice = teddyPrice;
    }

}
