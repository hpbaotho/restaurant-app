package Restaurant;

/**
 * 
 * @author Rush
 */
public class Dish {
    private int orderID;
    private int menuItemID;
    private int sizeID;
    private int number;
    private String details;

    public Dish(int orderID, int menuItemID, int sizeID, int Number, String Details) {
        this.orderID = orderID;
        this.menuItemID = menuItemID;
        this.sizeID = sizeID;
        this.number = Number;
        this.details = Details;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public int getSizeID() {
        return sizeID;
    }

    public int getNumber() {
        return number;
    }

    public String getDetails() {
        return details;
    }
}