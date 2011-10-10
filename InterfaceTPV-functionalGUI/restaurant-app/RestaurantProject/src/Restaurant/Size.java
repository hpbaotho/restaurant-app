package Restaurant;

/**
 *
 * @author Rush
 */
public class Size {
    private int sizeID;
    private String sizeName;
    
    public Size (int sizeID, String sizeName) {
        this.sizeID = sizeID;
        this.sizeName = sizeName;
    }
    
    public void setSizeID (int size) {
        sizeID = size;
    }
    
    public void setSizeName (String sizeName) {
        this.sizeName = sizeName;
    }
    
    public int getSizeID() {
        return sizeID;
    }
    
    public String getSizeName() {
        return sizeName;
    }
}