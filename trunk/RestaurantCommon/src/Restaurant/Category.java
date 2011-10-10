package Restaurant;

/**
 *
 * @author Martinsen
 */
public class Category {
    
    private int categoryID;
    private String category;
    
    public Category(int categoryID, String category) {
        this.categoryID = categoryID;
        this.category = category;
    }
    
    public void setCategory(String name) {
        category = name;
    }
    
    public String getCategory() {
        return category;
    }
    
    private void setCategoryID (int catID) {
        categoryID = catID;
    }
    
    public int getCategoryID() {
        return categoryID;
    }
}