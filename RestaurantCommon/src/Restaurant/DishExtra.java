package Restaurant;

/**
 *
 * @author Ahmet Cinar
 */
public class DishExtra {
    private int orderNumber;
    private int menuItemID;
    private String extraName;

    public DishExtra(int orderNumber, int menuItemID, String extraName) {
        this.orderNumber = orderNumber;
        this.menuItemID = menuItemID;
        this.extraName = extraName;
    }
    
    public void setOrderNumber(int orderNumber) {
       this.orderNumber = orderNumber;
    }
    
    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }
    
    public void setExtraName(String extraName) {
        this.extraName = extraName;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public int getMenuItem() {
        return menuItemID;
    }
    
    public String getExtraName() {
        return extraName;
    }
}