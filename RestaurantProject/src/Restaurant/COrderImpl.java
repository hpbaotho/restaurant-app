package Restaurant;

/**
 *
 * @author Rush
 */
public class COrderImpl implements COrder {
    private int orderID;
    private int restaurantID;
    private String customer;
    private int cTableID;
    private int orderStart;
    private int waiterID;
    private boolean paymentRecieved;

    
    public COrderImpl (int orderID, int restaurantID, String customer, int cTableID,
            int orderStart, int waiterID, boolean paymentRecieved){
        this.orderID = orderID;
        this.restaurantID = restaurantID;
        this.customer = customer;
        this.cTableID = cTableID;
        this.orderStart = orderStart;
        this.waiterID = waiterID;
        this.paymentRecieved = paymentRecieved;
    }

    public void setCTableID(int cTableID) {
        this.cTableID = cTableID;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderStart(int orderStart) {
        this.orderStart = orderStart;
    }

    public void setPaymentRecieved(boolean paymentRecieved) {
        this.paymentRecieved = paymentRecieved;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setWaiterID(int waiterID) {
        this.waiterID = waiterID;
    }

    public int getCTableID() {
        return cTableID;
    }

    public String getCustomer() {
        return customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getOrderStart() {
        return orderStart;
    }

    public boolean isPaymentRecieved() {
        return paymentRecieved;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public int getWaiterID() {
        return waiterID;
    }
}