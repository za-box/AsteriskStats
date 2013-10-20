package GUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;


public class RunningSettingsPanel extends JPanel {
    private static Double MINIMUM_SIZE_RATIO = 0.15;
    private static Double SIZE_RATIO = 0.2;
    private static Double MAXIMUM_SIZE_RATIO = 0.25;
    private static int PREFERRED_WIDTH;

    RunningSettingsPanel(){
        super();
        this.setLayout(new FlowLayout());
        this.setPreferredSize(Gui.getPreferredWidth(SIZE_RATIO));
        this.PREFERRED_WIDTH = new Double(Gui.getPreferredWidth(SIZE_RATIO).getWidth()).intValue();
        this.setMinimumSize(Gui.getPreferredWidth(MINIMUM_SIZE_RATIO));
        this.setMaximumSize(Gui.getPreferredWidth(MAXIMUM_SIZE_RATIO));

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        PanelLabel opisanie = new PanelLabel("Параметры выборки данных.");
        PanelCheckbox filterStartDate = new PanelCheckbox("Фильтровать от:");
        PanelCheckbox filterEndDate = new PanelCheckbox("Фильтровать до:");
        Calendar startDate = Calendar.getInstance();
        startDate.set(Calendar.DAY_OF_MONTH, 1);
        JDateChooser fromDate = new PanelCalendar(startDate.getTime());
        JDateChooser toDate = new PanelCalendar(Calendar.getInstance().getTime());
        PanelTable users = new PanelTable();
        users.setBackground(this.getBackground());

        this.add(opisanie);
        this.add(filterStartDate);
        this.add(fromDate);
        filterStartDate.setSelected(true);
        this.add(filterEndDate);
        this.add(toDate);
        this.add(users);

    }

    class PanelCalendar extends JDateChooser{
        PanelCalendar(){
            super();
            this.setPreferredSize(new Dimension(110, this.getFont().getSize() + 7));
            this.setAlignmentX(SwingConstants.CENTER);
            this.setAlignmentY(SwingConstants.CENTER);
        }

        PanelCalendar(java.util.Date time){
        super(time);
        this.setPreferredSize(new Dimension(110, this.getFont().getSize() + 7));
        this.setAlignmentX(JDateChooser.CENTER_ALIGNMENT);
        this.setAlignmentY(JDateChooser.CENTER_ALIGNMENT);
        }
    }

    class PanelLabel extends JLabel{
        private PanelLabel(){}

        PanelLabel(String text){
            super(text);
            this.setPreferredSize(new Dimension(PREFERRED_WIDTH, this.getFont().getSize()));
            this.setHorizontalAlignment(SwingConstants.CENTER);

        }


    }

    class PanelCheckbox extends JCheckBox{
        PanelCheckbox(){
            super();
           // this.setPreferredSize(new Dimension(PREFERRED_WIDTH - 5, this.getFont().getSize() + 5));
        }

        PanelCheckbox(String text){
            super(text);
            this.setPreferredSize(new Dimension(150, this.getFont().getSize() + 5));
            this.setHorizontalAlignment(SwingConstants.LEFT);

        }
    }

    class PanelTable extends JTable{
        PanelTable(){
            super();
            this.setPreferredSize(new Dimension(PREFERRED_WIDTH - 2, 500));
            this.setModel(new UsersTableDataModel(this));
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.getColumnModel().getColumn(0).setPreferredWidth(10);


        }
    }
}

