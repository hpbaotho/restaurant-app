package Database;

import java.sql.*;

/**
 *
 * @author Anders
 */
public class DbConnection {
    private int number;
    private Connection dbConn;
    private boolean available;
    
    DbConnection(int nr, String dbName) throws SQLException  {
        this.number = nr;
        dbConn = DriverManager.getConnection(dbName);
        available = true;
    }
    
    void closeConnection() throws SQLException {
        if(dbConn != null)
            dbConn.close();
    }
    
    void setAvailable(boolean available) {
        this.available = available;
    }
    
    public int getNumber() {
        return number;
    }
    public Connection getConnection() {
        return dbConn;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    @Override
    public String toString() {
        String result = "Connection number " + number;
        if(available)
            result += " is available";
        else
            result += " is not available";
        
        return result;
    }
}