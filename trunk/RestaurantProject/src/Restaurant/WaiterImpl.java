package Restaurant;

/**
 *
 * @author Ahmet Cinar
 */
public class WaiterImpl {
    private int waiterID;
    private String name;
    private String userName;
    private String password;

    public WaiterImpl(int waiterID, String name, String userName, String password) {
        this.waiterID = waiterID;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWaiterID() {
        return waiterID;
    }

    public void setWaiterID(int waiterID) {
        this.waiterID = waiterID;
    }
}