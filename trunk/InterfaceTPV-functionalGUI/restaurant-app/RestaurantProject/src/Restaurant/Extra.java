package Restaurant;

/**
 *
 * @author Ahmet Cinar
 */
public class Extra {
    private String extraName;
    private int price;
    
    public Extra(String extraName, int price){
        this.extraName = extraName;
        this.price = price;
    }
    
    public void setExtraName(String extraName){
        this.extraName = extraName;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public String getExtraName(){
        return extraName;
    }
    
    public int getPrice(){
        return price;
    }
}
