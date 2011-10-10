package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;

/**
 *
 * @author Roar
 */
public interface Transaction extends Remote {
    int getPaymentID()
            throws RemoteException;
    int getOrderID()
            throws RemoteException;
    String getPostalCode()
            throws RemoteException;
    String getCreditCardNumber()
            throws RemoteException;
    Calendar getExpirationDate()
            throws RemoteException;
    String getNameOnCard()
            throws RemoteException;
    String getAddress()
            throws RemoteException;
    String getCountry()
            throws RemoteException;
    String getCity()
            throws RemoteException;
    String getState()
            throws RemoteException;
    String getCreditCardType()
            throws RemoteException;
    
    boolean makePayment(int orderID, String postalCode, String creditCardNumber, Calendar expirationDate, String nameOnCard, String address, String country, String city, String state, String creditCardType)
            throws RemoteException;
}
