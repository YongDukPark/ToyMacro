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
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
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
    
    MacroAction mouseClickPoint;
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
        
        // ��ó�� init �� ������ �Ŀ� ���⼭ Į�� �� �Žñ� ������ �ٲ۴�.
        // ���� Row �����ϴ� ��� ä���Ѵ�. �޸� �Ű澲������ �ϴ� ����
        if(arrayList.size() > 0){
            for(int i = 0 ; i < arrayList.size() ; i++){
                model.addRow(new Object[]{arrayList.get(i).getIndexNumber(), arrayList.get(i).getActionType(), arrayList.get(i).getClickPoint().get("clickX") + " ," + arrayList.get(i).getClickPoint().get("clickY"), arrayList.get(i).isAction()});
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
                        
                        //System.out.println("ȭ�� ��ü�ػ� : " + res.width + " x " + res.height);  

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
                                            mouseClickPoint = new MacroAction(1, "click", clickPoint, true);
                                            //���� �̺κп��� delete Row ������ ���� ���ɼ� ������
                                            model.addRow(new Object[]{1, mouseClickPoint.getActionType(), mouseClickPoint.getClickPoint().get("clickX") + " ," + mouseClickPoint.getClickPoint().get("clickY"), mouseClickPoint.isAction()});
                                        } else if (arrayList.size() > 0) {
                                            mouseClickPoint = new MacroAction(arrayList.get(arrayList.size()-1).getIndexNumber()+1, "click", clickPoint, true);
                                            model.addRow(new Object[]{arrayList.get(arrayList.size()-1).getIndexNumber()+1, mouseClickPoint.getActionType(), mouseClickPoint.getClickPoint().get("clickX") + " ," + mouseClickPoint.getClickPoint().get("clickY"), mouseClickPoint.isAction()});
                                        }
                                        arrayList.add(mouseClickPoint);
                                        //******�����ϴ� ģ����.******
                                        frame.dispose();
                                }
                        });
                } catch (Exception e) {
                        System.err.println(e);
                }
        }
    private void deleteRow(){
        try {
//            System.out.println(jTable1.getSelectedRow());
            
            
            arrayList.remove(jTable1.getSelectedRow());
            
            
            //int�� �� ��������
            deleteRow.add(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
//            for(int i = 0 ; i < deleteRow.size() ; i++){
//                System.out.println("����Ʈ ���" + i+1);
//                System.out.println(deleteRow.get(i));
//            }
            
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
        button1 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(285, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
