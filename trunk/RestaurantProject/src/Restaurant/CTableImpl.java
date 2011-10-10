package Restaurant;

/**
 *
 * @author Ahmet Cinar
 */
public class CTableImpl implements CTable {
    private int cTableId;
    private int seats;

    public CTableImpl(int cTableId, int seats) {
        this.cTableId = cTableId;
        this.seats = seats;
    }

    public int getcTableId() {
        return cTableId;
    }

    public void setcTableId(int cTableId) {
        this.cTableId = cTableId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}