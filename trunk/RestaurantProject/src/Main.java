
import Database.Database;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.security.Permission;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anders
 */
public class Main {
    static final Logger LOG = Logger.getLogger(Main.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager() {
            public void checkConnect(String host, int port) {}
            public void checkConnect(String host, int port, Object context) {}
            public void checkAccept(String host, int port) {}
            public void checkPermission(Permission perm) {}
        });

        try {
            Naming.lookup("rmi://158.38.14.25/" + Database.class.getName());
            LOG.info("Server connection ready. Databaseconnection active.");
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            LOG.log(Level.SEVERE, "Client exception: " + ex.toString(), ex);
        }
    }
}