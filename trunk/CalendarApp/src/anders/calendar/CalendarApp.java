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
    private int[][] visualMonth;
    private Map<Month, int[][]> visualYear;

    public CalendarApp() {
        dateNow = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        monthNow = Calendar.getInstance().get(Calendar.MONTH);
        yearNow = Calendar.getInstance().get(Calendar.YEAR);
        calendar = new GregorianCalendar(START_YEAR, START_MONTH, START_DATE);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        dateFormat = new SimpleDateFormat("dd MMM yyyy");
        visualMonth = new int[6][7];
        visualYear = new HashMap<>();
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
    
    private void printCurrentMonth() {
        setNow();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Month month = null;
        switch(monthNow) {
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
        String format = "|%3s ||%3d |%3d |%3d |%3d |%3d |%3d |%3d |\n";
        System.out.print("|----------------------------------------|\n"
                + "|" + month.toPaddedString() + "|\n"
                + "|----------------------------------------|\n"
                + "|Week|| Mo | Tu | We | Th | Fr | Sa | Su |\n"
                + "|----||----|----|----|----|----|----|----|\n");
        for (int i = 0; i < 6; i++) {
            int week = calendar.get(Calendar.WEEK_OF_YEAR);
            for (int j = 0; j < 7; j++) {
                if ((calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7 == j && calendar.get(Calendar.MONTH) == month.ordinal()) {
                    visualMonth[i][j] = calendar.get(Calendar.DAY_OF_MONTH);
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }
            }
            System.out.printf(format, week, visualMonth[i][0], visualMonth[i][1], visualMonth[i][2], visualMonth[i][3], visualMonth[i][4], visualMonth[i][5], visualMonth[i][6]);
        }
    }

    private void printLongDate() {
        System.out.println(dateFormat.format(calendar.getTime()));
    }
    
    private void printShortDate() {
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        
        System.out.printf("%02d.%02d.%4d\n", date, month, year);
    }

    private void printCalendar() {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalendarApp c = new CalendarApp();
        c.printCurrentMonth();
    }
}
