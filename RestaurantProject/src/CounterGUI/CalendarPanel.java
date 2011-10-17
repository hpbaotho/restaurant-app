package CounterGUI;

import java.util.logging.Logger;
import CounterGUI.CalendarPanel.Month;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import static javax.swing.UIManager.*;

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
    private final Dimension M_COMBO_BOX_DIM = new Dimension(100, 30);
    private final Dimension M_SPINNER_DIM = new Dimension(20, 30);
    private final Dimension Y_SPINNER_DIM = new Dimension(65, 30);
    private final Dimension LABEL_DIM = new Dimension(37, 30);
    private final Dimension BUTTON_DIM = new Dimension(45, 30);
    private final Insets BUTTON_INSETS = new Insets(2, 10, 2, 10);
    private final int START_DAY = 1;
    private final int START_MONTH = 0;
    private final int START_YEAR = 2010;
    private final Calendar START_DATE = new GregorianCalendar(START_YEAR, START_MONTH, START_DAY);
    private  JLabel[] days = {
        new JLabel("Mon"),
        new JLabel("Tue"),
        new JLabel("Wed"),
        new JLabel("Thu"),
        new JLabel("Fri"),
        new JLabel("Sat"),
        new JLabel("Sun")
    };
    private Calendar now;
    private Calendar chosen;
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
    private Map<Month, Calendar[][]> dayArrayMap;
    private Map<Month, JToggleButton[][]> dayButtonMap;
    private Map<String, Map/*<Month, Calendar[][]>*/> yearMap;
    private Map<String, Map/*<Month, JToggleButton[][]>*/> yearButtonMap;
    private int ii;
    private int ij;

    public CalendarPanel() {
        initCalendar();
    }

    private void initCalendar() {
        //<editor-fold defaultstate="collapsed" desc="Setup components">
        now = new GregorianCalendar();
        Calendar temp = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        chosen = now;
        mon = now.get(Calendar.MONTH);
        month = monthSwitch(mon);
        year = now.get(Calendar.YEAR);
        mComboBox = new JComboBox<>(Month.values());
//        mComboBox.setSelectedIndex(mon);
        mComboBox.setSelectedItem(month);
        mComboBox.setMinimumSize(M_COMBO_BOX_DIM);
        mComboBox.setMaximumSize(M_COMBO_BOX_DIM);
        mComboBox.setPreferredSize(M_COMBO_BOX_DIM);
        mComboBox.addActionListener(new PanelListener());
        mSpinner = new JSpinner(new SpinnerNumberModel(mon, 0, 11, 1));
        mSpinner.setMinimumSize(M_SPINNER_DIM);
        mSpinner.setMaximumSize(M_SPINNER_DIM);
        mSpinner.setPreferredSize(M_SPINNER_DIM);
        mSpinner.enableInputMethods(false);
        ySpinner = new JSpinner(new SpinnerNumberModel(year, 2010, 2015, 1));
        ySpinner.setMinimumSize(Y_SPINNER_DIM);
        ySpinner.setMaximumSize(Y_SPINNER_DIM);
        ySpinner.setPreferredSize(Y_SPINNER_DIM);
        ySpinner.enableInputMethods(false);
        showToday = new JButton("Show today");
        showToday.addActionListener(new PanelListener());
        showToday.setMinimumSize(BUTTON_DIM);
        showToday.setMaximumSize(new Dimension(150, 30));
        dayButton = new JToggleButton[6][7];
        dayArray = new Calendar[6][7];
        dayArrayMap = new HashMap<>();
        dayButtonMap = new HashMap<>();
        yearMap = new HashMap<>();
        yearButtonMap = new HashMap<>();
        week = new JLabel[6];
        ii = -1;
        ij = -1;
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Setup calendar grid">
        temp.set(Calendar.DAY_OF_MONTH, 1);
        while (temp.get(Calendar.DAY_OF_WEEK) != 2) {
            temp.add(Calendar.DAY_OF_MONTH, -1);
        }
        for (int i = 0; i < 7; i++) {
            days[i].setHorizontalAlignment(JLabel.CENTER);
            days[i].setMaximumSize(LABEL_DIM);
            days[i].setMinimumSize(LABEL_DIM);
            days[i].setPreferredSize(LABEL_DIM);
        }
        for (int i = 0; i < 6; i++) {
            week[i] = new JLabel("    " + temp.get(Calendar.WEEK_OF_YEAR) + "    ");
            week[i].setVerticalAlignment(JLabel.CENTER);
            for (int j = 0; j < 7; j++) {
                dayArray[i][j] = temp;
                dayButton[i][j] = new JToggleButton();
                dayButton[i][j].setText(temp.get(Calendar.DAY_OF_MONTH) + "");
//                dayButton[i][j].setMargin(BUTTON_INSETS);
//                dayButton[i][j].setMaximumSize(BUTTON_DIM);
                dayButton[i][j].setMinimumSize(BUTTON_DIM);
                dayButton[i][j].setPreferredSize(BUTTON_DIM);
                dayButton[i][j].setEnabled(temp.get(Calendar.MONTH) == mon);
                dayButton[i][j].setActionCommand(i + " " + j);
                if (temp.get(Calendar.MONTH) == now.get(Calendar.MONTH) && temp.get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH)) {
                    dayButton[i][j].doClick();
                    ii = i;
                    ij = j;
                }
                
                dayButton[i][j].addActionListener(new PanelListener());
                temp.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        dayArrayMap.put(month, dayArray);
        dayButtonMap.put(month, dayButton);
        yearMap.put(year + "", dayArrayMap);
        yearButtonMap.put(year + "", dayButtonMap);
        //</editor-fold>

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        //<editor-fold defaultstate="collapsed" desc="setHorizontalGroup">
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mComboBox)
                .addComponent(mSpinner)
                .addComponent(ySpinner)
                .addGap(0, 12, 1000)
                .addComponent(showToday))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(week[0])
                    .addComponent(week[1])
                    .addComponent(week[2])
                    .addComponent(week[3])
                    .addComponent(week[4])
                    .addComponent(week[5]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(days[0])
                    .addComponent(dayButton[0][0])
                    .addComponent(dayButton[1][0])
                    .addComponent(dayButton[2][0])
                    .addComponent(dayButton[3][0])
                    .addComponent(dayButton[4][0])
                    .addComponent(dayButton[5][0]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(days[1])
                    .addComponent(dayButton[0][1])
                    .addComponent(dayButton[1][1])
                    .addComponent(dayButton[2][1])
                    .addComponent(dayButton[3][1])
                    .addComponent(dayButton[4][1])
                    .addComponent(dayButton[5][1]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(days[2])
                    .addComponent(dayButton[0][2])
                    .addComponent(dayButton[1][2])
                    .addComponent(dayButton[2][2])
                    .addComponent(dayButton[3][2])
                    .addComponent(dayButton[4][2])
                    .addComponent(dayButton[5][2]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(days[3])
                    .addComponent(dayButton[0][3])
                    .addComponent(dayButton[1][3])
                    .addComponent(dayButton[2][3])
                    .addComponent(dayButton[3][3])
                    .addComponent(dayButton[4][3])
                    .addComponent(dayButton[5][3]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(days[4])
                    .addComponent(dayButton[0][4])
                    .addComponent(dayButton[1][4])
                    .addComponent(dayButton[2][4])
                    .addComponent(dayButton[3][4])
                    .addComponent(dayButton[4][4])
                    .addComponent(dayButton[5][4]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(days[5])
                    .addComponent(dayButton[0][5])
                    .addComponent(dayButton[1][5])
                    .addComponent(dayButton[2][5])
                    .addComponent(dayButton[3][5])
                    .addComponent(dayButton[4][5])
                    .addComponent(dayButton[5][5]))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(days[6])
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
                .addComponent(days[0])
                .addComponent(days[1])
                .addComponent(days[2])
                .addComponent(days[3])
                .addComponent(days[4])
                .addComponent(days[5])
                .addComponent(days[6]))
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
    
    private void setUpMonth(Calendar temp) {
        if (yearMap.containsKey(temp.get(Calendar.YEAR) + "")) {
            dayArrayMap = yearMap.get(temp.get(Calendar.YEAR) + "");
            dayButtonMap = yearButtonMap.get(temp.get(Calendar.YEAR) + "");
            if (dayArrayMap.containsKey(monthSwitch(temp.get(Calendar.MONTH)))) {
                dayArray = dayArrayMap.get(monthSwitch(temp.get(Calendar.MONTH)));
                dayButton = dayButtonMap.get(monthSwitch(temp.get(Calendar.MONTH)));
            } else {
                dayArray = new Calendar[6][7];
                dayButton = new JToggleButton[6][7];
                setUpDays(temp);
            }
        }
        else {
            dayArrayMap = new HashMap<>();
            dayButtonMap = new HashMap<>();
            dayArray = new Calendar[6][7];
            dayButton = new JToggleButton[6][7];
            setUpDays(temp);
        }
        dayArrayMap.put(monthSwitch(temp.get(Calendar.MONTH)), dayArray);
        dayButtonMap.put(monthSwitch(temp.get(Calendar.MONTH)), dayButton);
        yearMap.put(temp.get(Calendar.YEAR) + "", dayArrayMap);
        yearButtonMap.put(temp.get(Calendar.YEAR) + "", dayButtonMap);
    }
    
    private void setUpMonth(int m, int y) {
        setUpMonth(new GregorianCalendar(y, m, 1));
    }
    
    private void setUpDays(Calendar temp) {
        if (ii != -1 && ij != -1)
            dayButton[ii][ij].setSelected(false);
        int tMon = temp.get(Calendar.MONTH);
        temp.set(Calendar.DAY_OF_MONTH, 1);
        while (temp.get(Calendar.DAY_OF_WEEK) != 2)
            temp.add(Calendar.DAY_OF_MONTH, -1);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                dayArray[i][j] = temp;
                dayButton[i][j].setText(temp.get(Calendar.DAY_OF_MONTH) + "");
                dayButton[i][j].setEnabled(temp.get(Calendar.MONTH) == tMon);
                dayButton[i][j].setActionCommand(i + " " + j);
                if (temp.get(Calendar.MONTH) == now.get(Calendar.MONTH) && temp.get(Calendar.DAY_OF_MONTH) == now.get(Calendar.DAY_OF_MONTH)) {
                    dayButton[i][j].doClick();
                    ii = i;
                    ij = j;
                }
                temp.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        for (int i = 0; i < 6; i++) {
            week[i].setText("    " + temp.get(Calendar.WEEK_OF_YEAR) + "    ");
            week[i].setVerticalAlignment(JLabel.CENTER);
            for (int j = 0; j < 7; j++) {
                
            }
        }
    }

    private Month monthSwitch(int m) {
        if (m == -1) {
            m = mon;
        }
        Month mth = null;
        switch (m) {
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
    
    private class PanelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals(showToday.getActionCommand())) {
                setUpMonth(now);
            } else if (command.equals(mComboBox.getActionCommand())) {
                int index = mComboBox.getSelectedIndex();
                mSpinner.setValue(index);
                setUpMonth(index, (int) ySpinner.getValue());
            } else {
                dayButton[ii][ij].setSelected(false);
                String[] index = e.getActionCommand().split(" ");
                ii = Integer.parseInt(index[0]);
                ij = Integer.parseInt(index[1]);
                chosen = dayArray[ii][ij];
                System.out.println("[" + ii + "][" + ij + "]");
            }
        }
    }
    
//    private class 

    public static void main(String args[]) {
        try {
            for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}