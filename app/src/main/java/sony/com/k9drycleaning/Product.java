package sony.com.k9drycleaning;

public class Product  {

    private int id, quantity,tPrice ;
    private String title;
    private int image;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void settPrice(int tPrice) {
        this.tPrice = tPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int gettPrice() {
        return tPrice;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
