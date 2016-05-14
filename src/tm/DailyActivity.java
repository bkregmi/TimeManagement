/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author bregm
 */
public class DailyActivity extends JPanel implements EventListener {
    private JButton btnPrevious;
    private JButton btnNext;
    private JLabel lblStart;
    private JLabel lblDate;
    private JLabel lblWeek;
}
