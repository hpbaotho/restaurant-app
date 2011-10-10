package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Roar
 */
public interface Restaurant extends Remote {
   void setRestaurantID(int restaurantID)
           throws RemoteException; 
   void setAddress(String address)
           throws RemoteException;
   void setCity(String city)
           throws RemoteException;
   void setName(String name)
           throws RemoteException;
   void setPhone(String phone)
           throws RemoteException;
   void setPostalCode(String postalCode)
           throws RemoteException;
   int getRestaurantID()
           throws RemoteException;
   String getAddress()
           throws RemoteException;
   String getName()
           throws RemoteException;
   String getPhone()
           throws RemoteException;
   String getPostalCode()
           throws RemoteException;
   String getCity()
           throws RemoteException;
}
