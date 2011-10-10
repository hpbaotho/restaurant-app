package CounterGUI;

import CounterGUI.CalendarPanel.Month;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.UIManager.*;

/**
 *
 * @author Anders
 */
public class CalendarPanel extends JPanel {
    //<editor-fold defaultstate="collapsed" desc="public enum Month {}">
    public enum Month {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;
        
        public String toString() {
            String text = super.toString();
            return text.charAt(0) + text.substring(1).toLowerCase();
        }
        
        public Month[] getMonths() {
            return values();
        }
    }
    //</editor-fold>
    private final Dimension BUTTON_DIM = new Dimension(30, 20);
    private final int START_DAY = 1;
    private final int START_MONTH = 0;
    private final int START_YEAR = 2011;
    private final Calendar START_DATE = new GregorianCalendar(START_YEAR, START_MONTH, START_DAY);
    private final JLabel[] DAYS = {
        new JLabel("Mon"),
        new JLabel("Tue"),
        new JLabel("Wed"),
        new JLabel("Thu"),
        new JLabel("Fri"),
        new JLabel("Sat"),
        new JLabel("Sun")
    };
    private Calendar now;
    private int mon;
    private Month month;
    private int year;
    private JComboBox<Month> monthBox;
    private JSpinner monthSpin;
    private JSpinner yearSpin;
    private JButton showToday;
    private JButton[][] dayButton;
    private Calendar[][] dayArray;
    private Map<Month, Calendar[][]> monthMap;
    private Map<String, Map/*<Month, Calendar[][]>*/> yearMap;
    private JLabel[] week;
    private JPanel chooser;
    private JPanel buttonGrid;
    
    public CalendarPanel() {
        initCalendar();
    }
    
    private void initCalendar() {
        now = Calendar.getInstance();
        mon = now.get(Calendar.MONTH);
        month = monthSwitch(mon);
        year = now.get(Calendar.YEAR);
        makeChooser();
        makeButtonGrid();
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup())
        );
    }
    
    private void makeChooser() {
        monthBox = new JComboBox<>(Month.values());
        monthSpin = new JSpinner(new SpinnerNumberModel(mon, 0, 11, 1));
        yearSpin = new JSpinner(new SpinnerNumberModel(year, 2010, 2015, 1));
        showToday = new JButton("Show today");
//        chooser.setLayout(new FlowLayout(FlowLayout.RIGHT));
//        chooser.add(monthBox);
//        chooser.add(monthSpin);
//        chooser.add(yearSpin);
//        chooser.add(showToday);
    }
    
    private void makeButtonGrid() {
        Calendar temp = now;
        dayButton = new JButton[6][7];
        dayArray = new Calendar[6][7];
        monthMap = new HashMap<>();
        yearMap = new HashMap<>();
        week = new JLabel[6];
        temp.set(Calendar.DAY_OF_MONTH, 1);
        temp.add(Calendar.MONTH, 1);
        while (temp.get(Calendar.DAY_OF_WEEK) != 2)
            temp.add(Calendar.DAY_OF_MONTH, -1);
        buttonGrid.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        for (int i = 0; i < 7; i++) {
            gbc.gridx = i + 1;
            DAYS[i].setVerticalAlignment(JLabel.CENTER);
            buttonGrid.add(DAYS[i], gbc);
        }
        for (int i = 0; i < 6; i++) {
            week[i] = new JLabel(temp.get(Calendar.WEEK_OF_YEAR) + "      ");
            week[i].setVerticalAlignment(JLabel.CENTER);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            buttonGrid.add(week[i], gbc);
            for (int j = 0; j < 7; j++) {
                dayArray[i][j] = temp;
                dayButton[i][j] = new JButton();
                dayButton[i][j].setText(temp.get(Calendar.DAY_OF_MONTH) + "");
                dayButton[i][j].setSize(BUTTON_DIM);
                dayButton[i][j].setEnabled(temp.get(Calendar.MONTH) == mon);
                gbc.gridx = j + 1;
                buttonGrid.add(dayButton[i][j], gbc);
                temp.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        monthMap.put(month, dayArray);
        yearMap.put(year + "", monthMap);
    }
    
    private Month monthSwitch(int m) {
        if (m == -1)
            m = mon;
        Month mth = null;
        switch(m) {
            case 0: mth = Month.JANUARY; break;
            case 1: mth = Month.FEBRUARY; break;
            case 2: mth = Month.MARCH; break;
            case 3: mth = Month.APRIL; break;
            case 4: mth = Month.MAY; break;
            case 5: mth = Month.JUNE; break;
            case 6: mth = Month.JULY; break;
            case 7: mth = Month.AUGUST; break;
            case 8: mth = Month.SEPTEMBER; break;
            case 9: mth = Month.OCTOBER; break;
            case 10: mth = Month.NOVEMBER; break;
            case 11: mth = Month.DECEMBER; break;
            default: System.out.println("The program should not get here."); break;
        }
        return mth;
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainMenuCounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}