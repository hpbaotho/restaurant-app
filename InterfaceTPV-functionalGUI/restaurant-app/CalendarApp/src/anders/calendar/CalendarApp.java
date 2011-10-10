package anders.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Anders
 */
public class CalendarApp {
    private final int START_DATE = 1;
    private final int START_MONTH = 10;
    private final int START_YEAR = 2011;
    private int dateNow;
    private int monthNow;
    private int yearNow;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private int[][] dayArray;
    private Map<Month, int[][]> monthMap;
    private Map<String, Map> yearMap;

    public CalendarApp() {
        dateNow = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        monthNow = Calendar.getInstance().get(Calendar.MONTH);
        yearNow = Calendar.getInstance().get(Calendar.YEAR);
        calendar = new GregorianCalendar(START_YEAR, START_MONTH, START_DATE);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        dateFormat = new SimpleDateFormat("dd MMM yyyy");
        dayArray = new int[6][7];
        monthMap = new HashMap<>();
        yearMap = new HashMap<>();
    }

    private void setUpCalendar(int day, int month, int year) {
        calendar.set(year, month - 1, day);
    }
    
    private void resetCalendar() {
        calendar.set(START_YEAR, START_MONTH, START_DATE);
    }
    
    private void setNow() {
        calendar = Calendar.getInstance();
        getNow();
    }
    
    private void getNow() {
        dateNow = calendar.get(Calendar.DAY_OF_MONTH);
        monthNow = calendar.get(Calendar.MONTH);
        yearNow = calendar.get(Calendar.YEAR);
    }
    
    private Month monthSwitch(int m) {
        if(m == -1)
            m = monthNow;
        Month month = null;
        switch(m) {
            case 0: month = Month.JANUARY; break;
            case 1: month = Month.FEBRUARY; break;
            case 2: month = Month.MARCH; break;
            case 3: month = Month.APRIL; break;
            case 4: month = Month.MAY; break;
            case 5: month = Month.JUNE; break;
            case 6: month = Month.JULY; break;
            case 7: month = Month.AUGUST; break;
            case 8: month = Month.SEPTEMBER; break;
            case 9: month = Month.OCTOBER; break;
            case 10: month = Month.NOVEMBER; break;
            case 11: month = Month.DECEMBER; break;
            default: System.out.println("The program should not get here."); break;
        }
        return month;
    }
    
    public void printCurrentMonth() {
        printMonth(monthSwitch(-1), yearNow);
    }
    
    public void printMonth(Month m, int year) {
        setNow();
        if(year == 0)
            year = calendar.get(Calendar.YEAR);
        else
            calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, m.ordinal());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        while(calendar.get(Calendar.DAY_OF_WEEK) != 2)
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        String format = "|%3s ||%3d |%3d |%3d |%3d |%3d |%3d |%3d |\n";
        System.out.println("|----------------------------------------|\n"
                + "|" + m.toPaddedString(year) + "|\n"
                + "|----------------------------------------|\n"
                + "|Week|| Mo | Tu | We | Th | Fr | Sa | Su |\n"
                + "|----||----|----|----|----|----|----|----|");
        for (int i = 0; i < 6; i++) {
            int week = calendar.get(Calendar.WEEK_OF_YEAR);
            for (int j = 0; j < 7; j++) {
                if ((calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7 == j) {
                    dayArray[i][j] = calendar.get(Calendar.DAY_OF_MONTH);
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                } else
                    dayArray[i][j] = 0;
            }
            System.out.printf(format, week, dayArray[i][0], dayArray[i][1], dayArray[i][2], dayArray[i][3], dayArray[i][4], dayArray[i][5], dayArray[i][6]);
        }
        monthMap.put(m, dayArray);
    }
    
    public void printMonth(int mon, int year) {
        printMonth(monthSwitch(mon), year);
    }
    
    public void printCurrentYear() {
        printYear(0);
    }
    
    public void printYear(int year) {
        for (int i = 0; i < 12; i++)
            printMonth(i, year);
        yearMap.put(year + "", monthMap);
    }

    public void printLongDate() {
        System.out.println(dateFormat.format(calendar.getTime()));
    }
    
    public void printShortDate() {
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        
        System.out.printf("%02d.%02d.%4d\n", date, month, year);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalendarApp c = new CalendarApp();
        c.printCurrentYear();
        c.printYear(2012);
    }
}
