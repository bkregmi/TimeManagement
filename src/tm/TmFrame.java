/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author bregm
 */
public class TmFrame extends javax.swing.JFrame implements ActionListener, WindowListener {

    private Map<String, MyTask> taskMap;

    public TmFrame() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelDay = new Activity();
        btnPrevDay = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnNextDay = new javax.swing.JButton();
        btnStartWeek = new javax.swing.JButton();
        btnPrevWeek = new javax.swing.JButton();
        lblWeek = new javax.swing.JLabel();
        txtWeek = new javax.swing.JTextField();
        btnNextWeek = new javax.swing.JButton();
        btnLastWeek = new javax.swing.JButton();
        lblStarted = new javax.swing.JLabel();
        txtStartTime = new javax.swing.JTextField();
        lblExpectedEnd = new javax.swing.JLabel();
        txtTaskEnd = new javax.swing.JTextField();
        txtProgress = new javax.swing.JTextField();
        lblTask = new javax.swing.JLabel();
        lblProgress = new javax.swing.JLabel();
        txtRunningTask = new javax.swing.JTextField();
        btnWork = new javax.swing.JButton();
        btnRelax = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTasks = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanelHistory = new javax.swing.JPanel();
        jPanelAnalytics = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        mnuSystem = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jMenuItemSetting = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        mnuTask = new javax.swing.JMenu();
        mnuTools = new javax.swing.JMenu();
        mnuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelDay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDay.setToolTipText("Today's Activity");

        btnPrevDay.setText("<Prev");
        btnPrevDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevDayActionPerformed(evt);
            }
        });

        lblDate.setText("Date:");

        txtDate.setText("Today's Date");
        txtDate.setHorizontalAlignment(JTextField.CENTER);
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        btnNextDay.setText("Next");
        btnNextDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextDayActionPerformed(evt);
            }
        });

        btnStartWeek.setText("<<");
        btnStartWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartWeekActionPerformed(evt);
            }
        });

        btnPrevWeek.setText("<");
        btnPrevWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevWeekActionPerformed(evt);
            }
        });

        lblWeek.setText("Week:");

        txtWeek.setText("Week Number");
        txtWeek.setHorizontalAlignment(JTextField.CENTER);

        btnNextWeek.setText(">");
        btnNextWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextWeekActionPerformed(evt);
            }
        });

        btnLastWeek.setText(">>");
        btnLastWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastWeekActionPerformed(evt);
            }
        });

        lblStarted.setText("Started at:");

        txtStartTime.setText("8:30");

        lblExpectedEnd.setText("Expected Ens at:");

        txtTaskEnd.setText("16:30");

        txtProgress.setText("progress bar");

        lblTask.setText("Task:");

        lblProgress.setText("Progress:");

        txtRunningTask.setText("Running Task");

        btnWork.setText("Work");
        btnWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkActionPerformed(evt);
            }
        });

        btnRelax.setText("Relax");

        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        tblTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Priority", "Description", "Duration", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTasks.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTasks);

        btnAdd.setText("Add");

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");

        jCheckBox1.setText("Show Finished Tasks");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDayLayout = new javax.swing.GroupLayout(jPanelDay);
        jPanelDay.setLayout(jPanelDayLayout);
        jPanelDayLayout.setHorizontalGroup(
            jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDayLayout.createSequentialGroup()
                        .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDayLayout.createSequentialGroup()
                                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelDayLayout.createSequentialGroup()
                                        .addComponent(btnPrevDay)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNextDay))
                                    .addGroup(jPanelDayLayout.createSequentialGroup()
                                        .addComponent(btnStartWeek)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPrevWeek)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblWeek)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNextWeek)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLastWeek))
                                    .addGroup(jPanelDayLayout.createSequentialGroup()
                                        .addComponent(lblStarted)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblExpectedEnd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTaskEnd)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelDayLayout.createSequentialGroup()
                                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTask)
                                    .addComponent(lblProgress))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDayLayout.createSequentialGroup()
                                        .addComponent(btnWork)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRelax)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDone))
                                    .addComponent(txtProgress)
                                    .addComponent(txtRunningTask))))
                        .addGap(56, 56, 56))
                    .addGroup(jPanelDayLayout.createSequentialGroup()
                        .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDayLayout.createSequentialGroup()
                                    .addGap(111, 111, 111)
                                    .addComponent(btnAdd)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnRemove)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEdit))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelDayLayout.setVerticalGroup(
            jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDayLayout.createSequentialGroup()
                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevDay)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNextDay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartWeek)
                    .addComponent(btnPrevWeek)
                    .addComponent(lblWeek)
                    .addComponent(txtWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNextWeek)
                    .addComponent(btnLastWeek))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStarted)
                    .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpectedEnd)
                    .addComponent(txtTaskEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProgress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTask)
                    .addComponent(txtRunningTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWork)
                    .addComponent(btnRelax)
                    .addComponent(btnDone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove)
                    .addComponent(btnEdit))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Day", jPanelDay);

        javax.swing.GroupLayout jPanelHistoryLayout = new javax.swing.GroupLayout(jPanelHistory);
        jPanelHistory.setLayout(jPanelHistoryLayout);
        jPanelHistoryLayout.setHorizontalGroup(
            jPanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        jPanelHistoryLayout.setVerticalGroup(
            jPanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("History", jPanelHistory);

        javax.swing.GroupLayout jPanelAnalyticsLayout = new javax.swing.GroupLayout(jPanelAnalytics);
        jPanelAnalytics.setLayout(jPanelAnalyticsLayout);
        jPanelAnalyticsLayout.setHorizontalGroup(
            jPanelAnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        jPanelAnalyticsLayout.setVerticalGroup(
            jPanelAnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Analytics", jPanelAnalytics);

        mnuSystem.setText("System");

        jMenuItemAbout.setText("About");
        mnuSystem.add(jMenuItemAbout);

        jMenuItemSetting.setText("Setting");
        jMenuItemSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSettingActionPerformed(evt);
            }
        });
        mnuSystem.add(jMenuItemSetting);

        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        mnuSystem.add(jMenuItemExit);

        jMenuBar.add(mnuSystem);

        mnuTask.setText("Task");
        jMenuBar.add(mnuTask);

        mnuTools.setText("Tools");
        jMenuBar.add(mnuTools);

        mnuHelp.setText("Help");
        jMenuBar.add(mnuHelp);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void btnLastWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastWeekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastWeekActionPerformed

    private void btnNextWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextWeekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextWeekActionPerformed

    private void btnStartWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartWeekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartWeekActionPerformed

    private void btnWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWorkActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        //if(evt.getSource()==tblTasks.getSelectionModel() && tblTasks.getRowSelectionAllowed()){
        DefaultTableModel model = (DefaultTableModel) tblTasks.getModel();
        model.removeRow(tblTasks.getSelectedRow());

        //}
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnNextDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextDayActionPerformed
        String dateString = txtDate.getText();
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        try {
            date = df.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 1); // add 10 days
            date = cal.getTime();
            txtDate.setText(df.format(date));
            txtWeek.setText(Integer.toString(cal.get(Calendar.WEEK_OF_YEAR)));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnNextDayActionPerformed

    private void btnPrevDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevDayActionPerformed
        String dateString = txtDate.getText();
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        try {
            date = df.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, -1); // add 10 days
            date = cal.getTime();
            txtDate.setText(df.format(date));
            txtWeek.setText(Integer.toString(cal.get(Calendar.WEEK_OF_YEAR)));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnPrevDayActionPerformed

    private void btnPrevWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevWeekActionPerformed
        JTextField tx = this.getTxtWeek();
        int Itx = Integer.parseInt(tx.getText());
        Itx--;
        this.setTxtWeek(Itx);
    }//GEN-LAST:event_btnPrevWeekActionPerformed

    private void jMenuItemSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSettingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemSettingActionPerformed

    private void initTasks(List<Task> tasks) {
        DefaultTableModel model = (DefaultTableModel) tblTasks.getModel();
 //       for (Map.Entry<String, Task> entry : taskMap.entrySet()) {
        //           System.out.print(entry.getValue().getTaskName());
        //           model.addRow(new Object[]{
        //               entry.getKey(),
        //               entry.getValue().getTaskName(),
        //               entry.getValue().getPlannedDuration(),
        //               entry.getValue().getTaskStatus()
        //           });
//        }
        for (Task task1 : tasks) {
            model.addRow(new Object[]{
                task1.getTaskID(),
                task1.getTaskName(),
                task1.getPlannedDuration(),
                task1.getTaskStatus()
            });
        }
    }

    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException, JAXBException {
        //MyTask task = new MyTask();
        //Task task = new Task();
        //List<MyTask> tasks = new ArrayList();
        Tasks xmlTasks = Tasks.unMarshalTasks();
        //Map<String, MyTask> taskMap = new HashMap<String, MyTask>();
        //Map<String, Task> taskMap = xmlTasks.getTaskMap();
        /*
         try {
         task.parseTasksXML();
         tasks = task.getTasks();
         taskMap = task.getTaskMap();
         System.out.println(tasks);
         task.parseXML();
         //System.out.println("Hello Parser");
         } catch (XPathExpressionException ex) {
         Logger.getLogger(TmFrame.class.getName()).log(Level.SEVERE, null, ex);
         ex.printStackTrace();
         }
         */
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        String reportDate = df.format(today);
        int weekNo = cal.get(Calendar.WEEK_OF_YEAR);
        TmFrame tm = new TmFrame();
        tm.initComponents();
        tm.setTxtDate(reportDate);
        tm.setTxtWeek(weekNo);
        tm.initTasks(xmlTasks.getTasks());
        tm.setVisible(true);
        //Tasks xmlTasks = Tasks.unMarshalTasks();
        //Tasks.marshalTasks(xmlTasks);

        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
        System.out.println("Opened database successfully");

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String what = evt.paramString();
        if (what.equals("Exit")) {
            System.exit(0);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    public void setTxtDate(String txtDate) {
        this.txtDate.setText(txtDate);
    }

    public void setTxtWeek(int txtWeek) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(txtWeek);
        String sbI = sb.toString();
        this.txtWeek.setText(sbI);
    }

    public JTextField getTxtDate() {
        return txtDate;
    }

    public JTextField getTxtWeek() {
        return txtWeek;
    }
    static Tasks tasks;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLastWeek;
    private javax.swing.JButton btnNextDay;
    private javax.swing.JButton btnNextWeek;
    private javax.swing.JButton btnPrevDay;
    private javax.swing.JButton btnPrevWeek;
    private javax.swing.JButton btnRelax;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnStartWeek;
    private javax.swing.JButton btnWork;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemSetting;
    private javax.swing.JPanel jPanelAnalytics;
    private javax.swing.JPanel jPanelDay;
    private javax.swing.JPanel jPanelHistory;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblExpectedEnd;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblStarted;
    private javax.swing.JLabel lblTask;
    private javax.swing.JLabel lblWeek;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuSystem;
    private javax.swing.JMenu mnuTask;
    private javax.swing.JMenu mnuTools;
    private javax.swing.JTable tblTasks;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtProgress;
    private javax.swing.JTextField txtRunningTask;
    private javax.swing.JTextField txtStartTime;
    private javax.swing.JTextField txtTaskEnd;
    private javax.swing.JTextField txtWeek;
    // End of variables declaration//GEN-END:variables

}
