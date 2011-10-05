package anders.calendar;

/**
 *
 * @author Anders
 */
public enum Month {
    JANUARY(31),
    FEBRUARY(28, 29),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);
    
    
    private int standard;
    private int leap;
    private int leadingSpaces;
    private int trailingSpaces;
    
    private Month(int standard, int leap) {
        this.standard = standard;
        this.leap = leap;
        trailingSpaces = (40 - super.toString().length()) / 2;
        leadingSpaces = 40 - super.toString().length() - trailingSpaces;
    }
    
    private Month(int days) {
        this(days, days);
    }
    
    public int getMaxDays(int year){
        if (year % 4 == 0)
            return leap;
        else
            return standard;
    }
    
    public String toPaddedString() {
        String retVal = "";
        for(int i = 0; i < leadingSpaces; i++)
            retVal += " ";
        retVal += toString();
        for(int i = 0; i < trailingSpaces; i++)
            retVal += " ";
        return retVal;
    }
    
    public String toString() {
        String month = super.toString();
        return month.charAt(0) + month.substring(1).toLowerCase();
    }
    
    public String toPaddedStringUpper() {
        String retVal = "";
        for(int i = 0; i < leadingSpaces; i++)
            retVal += " ";
        retVal += super.toString();
        for(int i = 0; i < trailingSpaces; i++)
            retVal += " ";
        return retVal;
    }
    
    public String toStringUpper() {
        return super.toString();
    }
}