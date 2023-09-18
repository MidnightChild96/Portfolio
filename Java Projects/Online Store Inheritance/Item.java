public class Item {// item parent class
    private String title = " ";// variables
    private double price;

    public Item(String inputTitle, double inputPrice) {// constructor with title and price
        title = inputTitle;
        price = inputPrice;
    }

    public String getTitle() {// setters and getter methods
        return title;
    }

    public void setTitle(String inputTitle) {
        title = inputTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double inputPrice) {
        price = inputPrice;
    }

    public String getType() {// return item type if ever used
        return "Item";
    }
}
