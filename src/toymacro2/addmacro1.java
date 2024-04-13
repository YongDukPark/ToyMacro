/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro2;

import Bean.MacroAction;
import Main.Index;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dydej
 */
public class addmacro1 extends javax.swing.JFrame {
    private static addmacro1 addmacro;
    
    boolean clickCheck = false;
    DefaultTableModel model = new DefaultTableModel();
    HashMap<Object, Object> clickPoint;
    
    MacroAction taskList;
    ArrayList<MacroAction> arrayList = new ArrayList<>();
    
    ArrayList<Object> deleteRow;
    
    private addmacro1(ArrayList<MacroAction> arrayList) {
        this.arrayList = arrayList;
        initComponents();
        defaultSetting();
    }
    
    public static addmacro1 getInstance(ArrayList<MacroAction> arrayList){
        addmacro = new addmacro1(arrayList);
        if (! addmacro.isVisible()){
            addmacro.setVisible(true);
        }
        return addmacro;
    }
    
    public void defaultSetting(){
        model.setColumnIdentifiers(new Object[]{"������ȣ" ,"����", "��ġ", "���"});
        jTable1.setModel(model);
        
        //deleteRow ��ü �����κ�
        deleteRow = new ArrayList<>();
        
        // ��ó�� init �� ������ �Ŀ� ���⼭ Į�� �������� ä���ش�.
        // ���� Row �����ϴ� ��� ä���Ѵ�. �޸� �Ű澲������ �ϴ� ����
        if(arrayList.size() > 0){
            for(int i = 0 ; i < arrayList.size() ; i++){
                if(arrayList.get(i).getActionType().equals("click")){
                    model.addRow(new Object[]{arrayList.get(i).getIndexNumber(), arrayList.get(i).getActionType(), arrayList.get(i).getClickPoint().get("clickX") + " ," + arrayList.get(i).getClickPoint().get("clickY"), arrayList.get(i).isAction()});
                } else if(arrayList.get(i).getActionType().equals("keyboardClick")){
                    model.addRow(new Object[]{arrayList.get(i).getIndexNumber(), arrayList.get(i).getActionType(), arrayList.get(i).getClickPoint().get("pressKey") + " - " + arrayList.get(i).getClickPoint().get("pressKeyImpormation"), arrayList.get(i).isAction()});
                }
            }
        }
    }
    private void getMousePoint(){
        try {
            JPanel panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                }
            };
            Robot r = new Robot();

            //��ü�ػ� ���ϱ�
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            int screenResolution = toolkit.getScreenResolution();

            int centerX = (int) (res.width * 0.5 * (96.0 / screenResolution));
            int centerY = (int) (res.height * 0.5 * (96.0 / screenResolution));

            //���콺 ��ġ ����ֱ�
            r.mouseMove(0, 0);
            //ȭ�� ���߾Ӻκ� ���콺 �̵�
            r.mouseMove(centerX, centerY);

            JFrame frame = new JFrame("Click Coordinates Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(panel);
            
            //ȭ����� �ٲ��� ���� ����
            frame.setSize(res.width, res.height);
            
            //ȭ�� �������� ȸ������ �ٲ��ִ� line
            frame.setUndecorated(true);
            frame.setBackground(new Color(0,0,0,122));
            panel.setBackground(new Color(0,0,0,122));

            frame.setVisible(true);

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clickPoint = new HashMap<>();

                    // x, y ���� HashMap�� ���
                    clickPoint.put("clickX", e.getX());
                    clickPoint.put("clickY", e.getY());

                    // indexNumber �ִºκ� 
                    if (arrayList.size() == 0) {
                        taskList = new MacroAction(1, "click", clickPoint, true);
                        //���� �̺κп��� delete Row ������ ���� ���ɼ� ������
                        model.addRow(new Object[]{1, taskList.getActionType(), taskList.getClickPoint().get("clickX") + " ," + taskList.getClickPoint().get("clickY"), taskList.isAction()});
                    } else if (arrayList.size() > 0) {
                        taskList = new MacroAction(arrayList.get(arrayList.size()-1).getIndexNumber()+1, "click", clickPoint, true);
                        model.addRow(new Object[]{arrayList.get(arrayList.size()-1).getIndexNumber()+1, taskList.getActionType(), taskList.getClickPoint().get("clickX") + " ," + taskList.getClickPoint().get("clickY"), taskList.isAction()});
                    }
                    arrayList.add(taskList);
                    //******�����ϴ� ģ����.******
                    frame.dispose();
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    private void getKeyBoardPoint(){
        try {
            jDialog1.setVisible(true);
            
            // JPanel ����
            JPanel panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                }
            };
            jDialog1.add(panel);
            
            // Ű �̺�Ʈ�� ���� �� �ֵ��� ��Ŀ�� ����
            panel.setFocusable(true); 
            
            panel.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    settingText1.setText(KeyEvent.getKeyText(e.getKeyCode()));
                    settingText2.setText(String.valueOf(e.getKeyCode()));
                    settingText3.setText(String.valueOf(e.getKeyChar()));
                }
            });
            
            //TabŰ �̺�Ʈ �����ϴºκ�
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.addKeyEventDispatcher(new KeyEventDispatcher() {
                @Override
                public boolean dispatchKeyEvent(KeyEvent e) {
                    // �� Ű�� ���ȴ��� Ȯ��
                    if (e.getKeyCode() == KeyEvent.VK_TAB) {
                        settingText1.setText(KeyEvent.getKeyText(e.getKeyCode()));
                        settingText2.setText(String.valueOf(e.getKeyCode()));
                        settingText3.setText(String.valueOf(e.getKeyChar()));
                    }
                    // �ٸ� Ű �̺�Ʈ�� ���⼭ ó������ ����
                    return false;
                }
            });
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private void saveKeyBoardPoint(){
        clickPoint = new HashMap<>();
        clickPoint.put("pressKey", Integer.parseInt(settingText2.getText()));
        clickPoint.put("pressKeyImpormation", Integer.parseInt(settingText2.getText()));
        
        if (arrayList.size() == 0) {
            taskList = new MacroAction(1, "keyboardClick", clickPoint, true);
            //���� �̺κп��� delete Row ������ ���� ���ɼ� ������
            model.addRow(new Object[]{1, taskList.getActionType(), settingText1.getText() + " - " + settingText2.getText(), taskList.isAction()});
        } else if (arrayList.size() > 0) {
            taskList = new MacroAction(arrayList.get(arrayList.size()-1).getIndexNumber()+1, "keyboardClick", clickPoint, true);
            model.addRow(new Object[]{arrayList.get(arrayList.size()-1), taskList.getActionType(), settingText1.getText() + " - " + settingText2.getText(), taskList.isAction()});
        }
        arrayList.add(taskList);
        jDialog1.dispose();
    }
    
    private void deleteRow(){
        try {
            //arrayList���� ����
            arrayList.remove(jTable1.getSelectedRow());
            
            //���� �۾����� �Ѱ��� �����͵� ����
            deleteRow.add(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
            
            //���� �𵨿��� ���� ���� �̰� ������ ����� index ������ �������� nullPoint �߻�
            model.removeRow(jTable1.getSelectedRow());
        } catch (Exception e) {
            //dialog ������
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        settingText1 = new javax.swing.JLabel();
        settingText2 = new javax.swing.JLabel();
        settingText3 = new javax.swing.JLabel();
        settingText4 = new javax.swing.JLabel();
        settingText5 = new javax.swing.JLabel();
        settingText6 = new javax.swing.JLabel();
        keyPutButton = new javax.swing.JButton();
        keyCanselButton = new javax.swing.JButton();
        button1 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setMinimumSize(new java.awt.Dimension(650, 400));
        jDialog1.setPreferredSize(new java.awt.Dimension(1000, 1000));

        jLabel1.setFont(new java.awt.Font("����", 0, 36)); // NOI18N
        jLabel1.setText("Ű���� �Է°�");

        settingText1.setFont(new java.awt.Font("����", 1, 24)); // NOI18N
        settingText1.setText("A");
        settingText1.setToolTipText("");
        settingText1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        settingText2.setFont(new java.awt.Font("����", 1, 24)); // NOI18N
        settingText2.setText("A");
        settingText2.setToolTipText("");
        settingText2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        settingText3.setFont(new java.awt.Font("����", 1, 24)); // NOI18N
        settingText3.setText("A");
        settingText3.setToolTipText("");
        settingText3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        settingText4.setFont(new java.awt.Font("����", 0, 14)); // NOI18N
        settingText4.setText("pressKey : ");
        settingText4.setToolTipText("");
        settingText4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        settingText5.setFont(new java.awt.Font("����", 0, 14)); // NOI18N
        settingText5.setText("keyCode : ");
        settingText5.setToolTipText("");
        settingText5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        settingText6.setFont(new java.awt.Font("����", 0, 14)); // NOI18N
        settingText6.setText("Information : ");
        settingText6.setToolTipText("");
        settingText6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        keyPutButton.setText("���");
        keyPutButton.setActionCommand("saveKeyBoardPoint");
        keyPutButton.setFocusable(false);
        keyPutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        keyCanselButton.setText("���");
        keyCanselButton.setFocusable(false);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addComponent(settingText4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingText1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addComponent(settingText5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingText2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(keyPutButton)
                                .addGap(36, 36, 36))
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(settingText6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keyCanselButton)
                            .addComponent(settingText3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(settingText1)
                    .addComponent(settingText4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(settingText2)
                    .addComponent(settingText5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(settingText3)
                    .addComponent(settingText6))
                .addGap(30, 30, 30)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyCanselButton)
                    .addComponent(keyPutButton))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        button1.setActionCommand("addMouseClickPoint");
        button1.setLabel("Ŭ������ �����");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        button2.setActionCommand("deleteRow");
        button2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button2.setLabel("���� ����");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        button3.setActionCommand("active");
        button3.setLabel("����");

        button4.setActionCommand("actionSave");
        button4.setLabel("����");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        button5.setActionCommand("addKeyBoaredPoint");
        button5.setLabel("Ű���� �׼� �����");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        button1.getAccessibleContext().setAccessibleName("addMouseClickPoint");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clickButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickButton
        Index deleteTest = new Index();
        if (evt.getActionCommand().equals("addMouseClickPoint")) {   //���콺 Ŭ�� ����Ʈ
            getMousePoint();
        } else if (evt.getActionCommand().equals("addKeyBoaredPoint")) {    //Ű���� Ŭ�� ����Ʈ
            getKeyBoardPoint();
        } else if (evt.getActionCommand().equals("deleteRow")) {    //Row����
            deleteRow();
        } else if (evt.getActionCommand().equals("active")){    //����
            //setActionList();
        } else if (evt.getActionCommand().equals("actionSave")) {   //����
            if(deleteRow.size() > 0){
                deleteTest.deleteRow(deleteRow);
            }
            //â�ݴºκ�
            dispose();
            //System.exit(0);
        } else if (evt.getActionCommand().equals("saveKeyBoardPoint")){
            saveKeyBoardPoint();
        }
    }//GEN-LAST:event_clickButton

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(addmacro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(addmacro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(addmacro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(addmacro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new addmacro1().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton keyCanselButton;
    private javax.swing.JButton keyPutButton;
    private javax.swing.JLabel settingText1;
    private javax.swing.JLabel settingText2;
    private javax.swing.JLabel settingText3;
    private javax.swing.JLabel settingText4;
    private javax.swing.JLabel settingText5;
    private javax.swing.JLabel settingText6;
    // End of variables declaration//GEN-END:variables
}
