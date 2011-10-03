package Database;

import java.sql.*;

/**
 * 
 * @author
 */
public class Cleaner {
    public static void closeResultSet(ResultSet res) {
        try {
            if(res != null) {
                res.close();
            }
        } catch(SQLException ex) {
            writeMsg(ex, "closeResSet()");
        }
    }
    
    public static void closeStatement(Statement stm) {
        try {
            if(stm != null) {
                stm.close();
            }
        } catch(SQLException ex) {
            writeMsg(ex, "closeStatement()");
        }
    }
    
    public static void closeConnection(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException ex) {
            writeMsg(ex, "closeConnection()");
        }
    }
    
    public static void rollback(Connection conn) {
        try {
            if(conn != null && !conn.getAutoCommit()) {
                conn.rollback();
            }
        } catch(SQLException ex) {
            writeMsg(ex, "rollback()");
        }
    }
    
    public static void setAutoCommit(Connection conn) {
        try {
            if(conn != null && !conn.getAutoCommit()) {
                conn.setAutoCommit(true);
            }
        } catch(SQLException ex) {
            writeMsg(ex, "setAutoCommit()");
        }
    }
    
    public static void writeMsg(Exception ex, String msg) {
        System.err.println("*** Error occurred: " + msg + ". ***");
        ex.printStackTrace(System.err);
    }
}