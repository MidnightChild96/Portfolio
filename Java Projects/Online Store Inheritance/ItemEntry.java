public class ItemEntry {// ItemEntry class
    private Item item;// variables
    private int quantity;

    public ItemEntry(Item inputItem, int inputQuantity) {// constructor
        item = inputItem;
        quantity = inputQuantity;
    }

    public Item getItem() {// getter and setter methods
        return item;
    }

    public void setItem(Item inputItem) {
        item = inputItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int inputQuantity) {
        quantity = inputQuantity;
    }
}
