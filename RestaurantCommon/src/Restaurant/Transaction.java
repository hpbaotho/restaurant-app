package Restaurant;

/**
 *
 * @author Ahmet Cinar
 */
public class Transaction {
    private int paymentID;
    private int orderID;
    private String creditCardType;
    private int creditCardNumber;
    private int expirationDate;
    private String nameOnCard;
    private String address;
    private String country;
    private String city;
    private String state;
    private int postalCode;

    public Transaction(int paymentID, int orderID, String creditCardType, int creditCardNumber, int expirationDate, String nameOnCard, String address, String country, String city, String state, int postalCode){
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.creditCardType = creditCardType;
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
    
    public void setPaymentID(int paymentID){
       this.paymentID = paymentID;
    }
    
    public void setOrderID(int orderID){
        this.orderID = orderID;
    }
    
    public void setCreditCardType(String creditCardType){
        this.creditCardType = creditCardType;
    }
    
    public void setCreditCardNumber(int creditCardNumber){
        this.creditCardNumber = creditCardNumber;
    }   
    
    public void setExpirationDate(int expirationDate){
        this.expirationDate = expirationDate;
    }
    
    public void setNameOnCard(String nameOnCard){
        this.nameOnCard = nameOnCard;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setCountry(String country){
        this.country = country;
    }  
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public void setPostalCode(int postalCode){
        this.postalCode = postalCode;
    }
    
    public int getPaymentID(){
        return paymentID;
    }
    
    public int getOrderID(){
        return orderID;
    }
    
    public String getCreditCardType(){
        return creditCardType;
    }
    
    public int getCreditCardNumber(){
        return creditCardNumber;
    }  
    
    public int getExpirationDate(){
        return expirationDate;
    }
    
    public String getNameOnCard(){
        return nameOnCard;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getCountry(){
        return country;
    } 
    
    public String getCity(){
        return city;
    }
    
    public String getState(){
        return state;
    }
    
    public int getPostalCode(){
        return postalCode;
    }
}