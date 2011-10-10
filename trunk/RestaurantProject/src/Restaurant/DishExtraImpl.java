package Restaurant;

import java.rmi.RemoteException;

/**
 *
 * @author Ahmet Cinar
 */
public class DishExtraImpl implements DishExtra {
    private int orderNumber;
    private int menuItemID;
    private String extraName;

    public DishExtraImpl(int orderNumber, int menuItemID, String extraName) {
        this.orderNumber = orderNumber;
        this.menuItemID = menuItemID;
        this.extraName = extraName;
    }
    
    public void setOrderNumber(int orderNumber) throws RemoteException {
       this.orderNumber = orderNumber;
    }
    
    public void setMenuItemID(int menuItemID) throws RemoteException {
        this.menuItemID = menuItemID;
    }
    
    public void setExtraName(String extraName) throws RemoteException {
        this.extraName = extraName;
    }
    
    public int getOrderNumber() throws RemoteException {
        return orderNumber;
    }
    
    public int getMenuItemID() throws RemoteException {
        return menuItemID;
    }
    
    public String getExtraName() throws RemoteException {
        return extraName;
    }
}