package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sævar
 */
public interface COrder extends Remote {
    void setCTableID(int CTableID)
            throws RemoteException;
    void setCustomer(String customer)
            throws RemoteException;
    void setOrderStart(int OrderStart)
            throws RemoteException;
    void setPaymentRecieved(boolean paymentReceived)
            throws RemoteException;
    void setRestaurantID(int RestaurantID)
            throws RemoteException;
    void setWaiterID(int WaiterID)
            throws RemoteException;
    int getCTableID()
            throws RemoteException;
    String getCustomer()
            throws RemoteException;
    int getOrderID()
            throws RemoteException;
    int getOrderStart()
            throws RemoteException;
    boolean isPaymentRecieved()
            throws RemoteException;
    int getRestaurantID()
            throws RemoteException;
    int getWaiterID()
            throws RemoteException;
}