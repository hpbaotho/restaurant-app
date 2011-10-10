package Restaurant;

/**
 *
 * @author Martinsen
 */
public class MenuItemImpl {
    
    private int menuItemID;
    private String itemName;
    private int categoryID;
    private int price;
    
    public MenuItemImpl(int menuItemID, String itemName, int categoryID, int price) {
        this.menuItemID = menuItemID;
        this.itemName = itemName;
        this.categoryID = categoryID;
        this.price = price;
    }
    
    public void setItemName(String name) {
        itemName = name;
    }
    
    public void setMenuItemID(int itemID) {
        menuItemID = itemID;
    }
    
    public void setCatID(int catID) {
        categoryID = catID;
    }
    
    public void setPrice(int itemPrice) {
        price = itemPrice;
    }
    
    public String getMenuItemName() {
        return itemName;
    }
    
    public int getMenuItemID() {
        return menuItemID;
    }
    
    public int getCatID() {
        return categoryID;
    }
    
    public int getPrice() {
        return price;
    }
}