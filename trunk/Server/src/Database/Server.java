package Database;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Server {
    static final Logger LOG = Logger.getLogger(Server.class.getName());

    /**
     * This starts up a database server, enabling connection to the database.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try {
            LocateRegistry.createRegistry(1099);
            LOG.info("RMI registry ready.");

            String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbName = "jdbc:sqlserver://localhost\\CHINO\\SQLSERVER:49156;databaseName=RestaurantChinoDB;integratedSecurity=true;";

            Database db = new DatabaseImpl(dbDriver, dbName);

            Naming.rebind("Database", db);
            System.out.println("Server ready");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Server exception: " + ex.toString(), ex);
        }
    }
}