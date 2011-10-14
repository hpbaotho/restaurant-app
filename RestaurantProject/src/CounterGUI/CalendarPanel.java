package CounterGUI;

import CounterGUI.CalendarPanel.Month;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
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
    private final Dimension BUTTON_DIM = new Dimension(37, 23);
    private final Dimension LABEL_DIM = new Dimension(37, 14);
    private final Insets BUTTON_INSETS = new Insets(2, 10, 2, 10);
    private final int START_DAY = 1;
    private final int START_MONTH = 0;
    private final int START_YEAR = 2011;
    private final Calendar START_DATE = new GregorianCalendar(START_YEAR, START_MONTH, START_DAY);
    private  JLabel[] Days = {
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
    private JComboBox<Month> mComboBox;
    private JSpinner mSpinner;
    private JSpinner ySpinner;
    private JButton showToday;
    private JLabel[] week;
    private JToggleButton[][] dayButton;
    private Calendar[][] dayArray;
    private Map<Month, Calendar[][]> monthMap;
    private Map<String, Map/*<Month, Calendar[][]>*/> yearMap;

    public CalendarPanel() {
        initCalendar();
    }

    private void initCalendar() {
        //<editor-fold defaultstate="collapsed" desc="Setup components">
        now = Calendar.getInstance();
        Calendar temp = now;
        mon = now.get(Calendar.MONTH);
        month = monthSwitch(mon);
        year = now.get(Calendar.YEAR);
        mComboBox = new JComboBox<>(Month.values());
//        mComboBox.setSelectedIndex(mon);
        mComboBox.setSelectedItem(month);
        mSpinner = new JSpinner(new SpinnerNumberModel(mon, 0, 11, 1));
        mSpinner.enableInputMethods(false);
        ySpinner = new JSpinner(new SpinnerNumberModel(year, 2010, 2015, 1));
        ySpinner.enableInputMethods(false);
        showToday = new JButton("Show today");
        dayButton = new JToggleButton[6][7];
        dayArray = new Calendar[6][7];
        monthMap = new HashMap<>();
        yearMap = new HashMap<>();
        week = new JLabel[6];
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Setup calendar grid">
        temp.set(Calendar.DAY_OF_MONTH, 1);
        while (temp.get(Calendar.DAY_OF_WEEK) != 2) {
            temp.add(Calendar.DAY_OF_MONTH, -1);
        }
        for (int i = 0; i < 7; i++) {
            Days[i].setHorizontalAlignment(JLabel.CENTER);
            Days[i].setMaximumSize(LABEL_DIM);
            Days[i].setMinimumSize(LABEL_DIM);
            Days[i].setPreferredSize(LABEL_DIM);
        }
        for (int i = 0; i < 6; i++) {
            week[i] = new JLabel(temp.get(Calendar.WEEK_OF_YEAR) + "      ");
            week[i].setVerticalAlignment(JLabel.CENTER);
            for (int j = 0; j < 7; j++) {
                dayArray[i][j] = temp;
                dayButton[i][j] = new JToggleButton();
                dayButton[i][j].setText(temp.get(Calendar.DAY_OF_MONTH) + "");
                dayButton[i][j].setMargin(BUTTON_INSETS);
                dayButton[i][j].setMaximumSize(BUTTON_DIM);
                dayButton[i][j].setMinimumSize(BUTTON_DIM);
                dayButton[i][j].setPreferredSize(BUTTON_DIM);
                dayButton[i][j].setEnabled(temp.get(Calendar.MONTH) == mon);
                temp.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        monthMap.put(month, dayArray);
        yearMap.put(year + "", monthMap);
        //</editor-fold>

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        //<editor-fold defaultstate="collapsed" desc="setHorizontalGroup">
        JLabel t = new JLabel();
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mComboBox)
                .addComponent(mSpinner)
                .addComponent(ySpinner)
                .addComponent(showToday))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
//                    .addComponent(t)
                    .addComponent(week[0])
                    .addComponent(week[1])
                    .addComponent(week[2])
                    .addComponent(week[3])
                    .addComponent(week[4])
                    .addComponent(week[5]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(Days[0])
                    .addComponent(dayButton[0][0])
                    .addComponent(dayButton[1][0])
                    .addComponent(dayButton[2][0])
                    .addComponent(dayButton[3][0])
                    .addComponent(dayButton[4][0])
                    .addComponent(dayButton[5][0]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(Days[1])
                    .addComponent(dayButton[0][1])
                    .addComponent(dayButton[1][1])
                    .addComponent(dayButton[2][1])
                    .addComponent(dayButton[3][1])
                    .addComponent(dayButton[4][1])
                    .addComponent(dayButton[5][1]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(Days[2])
                    .addComponent(dayButton[0][2])
                    .addComponent(dayButton[1][2])
                    .addComponent(dayButton[2][2])
                    .addComponent(dayButton[3][2])
                    .addComponent(dayButton[4][2])
                    .addComponent(dayButton[5][2]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(Days[3])
                    .addComponent(dayButton[0][3])
                    .addComponent(dayButton[1][3])
                    .addComponent(dayButton[2][3])
                    .addComponent(dayButton[3][3])
                    .addComponent(dayButton[4][3])
                    .addComponent(dayButton[5][3]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(Days[4])
                    .addComponent(dayButton[0][4])
                    .addComponent(dayButton[1][4])
                    .addComponent(dayButton[2][4])
                    .addComponent(dayButton[3][4])
                    .addComponent(dayButton[4][4])
                    .addComponent(dayButton[5][4]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(Days[5])
                    .addComponent(dayButton[0][5])
                    .addComponent(dayButton[1][5])
                    .addComponent(dayButton[2][5])
                    .addComponent(dayButton[3][5])
                    .addComponent(dayButton[4][5])
                    .addComponent(dayButton[5][5]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(Days[6])
                    .addComponent(dayButton[0][6])
                    .addComponent(dayButton[1][6])
                    .addComponent(dayButton[2][6])
                    .addComponent(dayButton[3][6])
                    .addComponent(dayButton[4][6])
                    .addComponent(dayButton[5][6])))
        );
        //</editor-fold>
//        TODO Check if Horizontal group is OK.
        //<editor-fold defaultstate="collapsed" desc="setVerticalGroup">
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(mComboBox)
                .addComponent(mSpinner)
                .addComponent(ySpinner)
                .addComponent(showToday))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
//                .addComponent(t)
                .addComponent(Days[0])
                .addComponent(Days[1])
                .addComponent(Days[2])
                .addComponent(Days[3])
                .addComponent(Days[4])
                .addComponent(Days[5])
                .addComponent(Days[6]))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(week[0])
                .addComponent(dayButton[0][0])
                .addComponent(dayButton[0][1])
                .addComponent(dayButton[0][2])
                .addComponent(dayButton[0][3])
                .addComponent(dayButton[0][4])
                .addComponent(dayButton[0][5])
                .addComponent(dayButton[0][6]))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(week[1])
                .addComponent(dayButton[1][0])
                .addComponent(dayButton[1][1])
                .addComponent(dayButton[1][2])
                .addComponent(dayButton[1][3])
                .addComponent(dayButton[1][4])
                .addComponent(dayButton[1][5])
                .addComponent(dayButton[1][6]))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(week[2])
                .addComponent(dayButton[2][0])
                .addComponent(dayButton[2][1])
                .addComponent(dayButton[2][2])
                .addComponent(dayButton[2][3])
                .addComponent(dayButton[2][4])
                .addComponent(dayButton[2][5])
                .addComponent(dayButton[2][6]))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(week[3])
                .addComponent(dayButton[3][0])
                .addComponent(dayButton[3][1])
                .addComponent(dayButton[3][2])
                .addComponent(dayButton[3][3])
                .addComponent(dayButton[3][4])
                .addComponent(dayButton[3][5])
                .addComponent(dayButton[3][6]))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(week[4])
                .addComponent(dayButton[4][0])
                .addComponent(dayButton[4][1])
                .addComponent(dayButton[4][2])
                .addComponent(dayButton[4][3])
                .addComponent(dayButton[4][4])
                .addComponent(dayButton[4][5])
                .addComponent(dayButton[4][6]))
            .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(week[5])
                .addComponent(dayButton[5][0])
                .addComponent(dayButton[5][1])
                .addComponent(dayButton[5][2])
                .addComponent(dayButton[5][3])
                .addComponent(dayButton[5][4])
                .addComponent(dayButton[5][5])
                .addComponent(dayButton[5][6]))
        );
        //</editor-fold>
//        TODO Make vertical group.
    }

    private Month monthSwitch(int m) {
        if (m == -1) {
            m = mon;
        }
        Month mth = null;
        switch (m) {
            case 0:
                mth = Month.JANUARY;
                break;
            case 1:
                mth = Month.FEBRUARY;
                break;
            case 2:
                mth = Month.MARCH;
                break;
            case 3:
                mth = Month.APRIL;
                break;
            case 4:
                mth = Month.MAY;
                break;
            case 5:
                mth = Month.JUNE;
                break;
            case 6:
                mth = Month.JULY;
                break;
            case 7:
                mth = Month.AUGUST;
                break;
            case 8:
                mth = Month.SEPTEMBER;
                break;
            case 9:
                mth = Month.OCTOBER;
                break;
            case 10:
                mth = Month.NOVEMBER;
                break;
            case 11:
                mth = Month.DECEMBER;
                break;
            default:
                System.out.println("The program should not get here.");
                break;
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