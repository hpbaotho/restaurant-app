package Restaurant;

/**
 *
 * @author Roar
 */

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface Transaction extends Remote
{
    void setPaymentID(int paymentID) throws RemoteException;
       
    void setOrderID(int orderID) throws RemoteException;
        
    void setCreditCardType(String creditCardType) throws RemoteException;
       
    void setCreditCardNumber(int creditCardNumber) throws RemoteException;
        
    void setExpirationDate(int expirationDate) throws RemoteException;
        
    void setNameOnCard(String nameOnCard) throws RemoteException;
        
    void setAddress(String address) throws RemoteException;
        
    void setCountry(String country) throws RemoteException;
        
    void setCity(String city) throws RemoteException;
        
    void setState(String state) throws RemoteException;
        
    void setPostalCode(int postalCode) throws RemoteException;
        
    int getPaymentID() throws RemoteException;
        
    int getOrderID() throws RemoteException;
        
    int getPostalCode() throws RemoteException;
       
    int getCreditCardNumber() throws RemoteException;
        
    int getExpirationDate() throws RemoteException;
        
    String getNameOnCard() throws RemoteException;
       
    String getAddress() throws RemoteException;
      
    String getCountry() throws RemoteException;
        
    String getCity() throws RemoteException;
      
    String getState() throws RemoteException;
        
    String getCreditCardType() throws RemoteException;
    
}
