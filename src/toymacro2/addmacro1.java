/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    
    
    private addmacro1() {
        initComponents();
        defaultSetting();
    }
    
    public static addmacro1 getInstance(){
        addmacro = new addmacro1();
        if (! addmacro.isVisible()){
            addmacro.setVisible(true);
        }
        return addmacro;
    }
    
    public void defaultSetting(){
        model.setColumnIdentifiers(new Object[]{"동작", "위치", "사용"});
        jTable1.setModel(model);
        // 맨처음 init 을 진행한 후에 여기서 칼럼 및 거시기 정보들 바꾼다.
        // 그후 Row 생성하는 방식 채용한다. 메모리 신경쓰지말고 일단 하자
    }
    
    private void getMousePoint(){
                HashMap widthHeight = new HashMap();
                
                try {
                        JPanel panel = new JPanel() {
                                @Override
                                public void paintComponent(Graphics g) {
                                        super.paintComponent(g);
                                }
                        };

                        Robot r = new Robot();

                        //전체해상도 구하기
                        Toolkit toolkit = Toolkit.getDefaultToolkit();
                        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
                        System.out.println("화면 전체해상도 : " + res.width + " x " + res.height);  

                        //화면 정중앙부분 마우스 이동
                        r.mouseMove(res.width / 2, res.height / 2);
                        
                        System.out.println(res.width/2);
                        System.out.println(res.height/2);
                        
                        
                        JFrame frame = new JFrame("Click Coordinates Example");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        frame.add(panel);
                        //화면색상 바꿔줄 영역 지정
                        frame.setSize(res.width, res.height);
                        //화면 반투명한 회색으로 바꿔주는 line
                        frame.setUndecorated(true);
                        frame.setBackground(new Color(0,0,0,122));
                        panel.setBackground(new Color(0,0,0,122));
                        
                        frame.setVisible(true);

                        panel.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                        // x, y 지점 HashMap에 담기
                                        widthHeight.put("clickPointX", e.getX());
                                        widthHeight.put("clickPointY", e.getY());
                                        
                                        System.out.println(e.getX());
                                        System.out.println(e.getY());
                                        
                                        model.addRow(new Object[]{"New Data 1", "New Data 2", "New Data 3"});
                                        
                                        //DefaultTableModel tableModel = new DefaultTableModel();
                                        
                                        
                                        
//                                        System.out.println(jList1.getModel().getSize());
//                                        //jList1.
//                                        String[] strings = new String[jList1.getModel().getSize()+1];
//                                        
//                                        for (int i = 0; i < jList1.getModel().getSize() ; i++) {
//                                                strings[i] = jList1.getModel().getElementAt(i);
//                                        }
//                                        
//                                        
//                                        jList1.setModel(new javax.swing.AbstractListModel<String>() {
//                                            TESTTT();
//                                            
//                                            
//                                            strings = null;
//                                            public int getSize() { return strings.length; }
//                                            public String getElementAt(int i) { return strings[i]; }
//                                        });
//                                        
//                                        String[] testdata = new String[3];
//                                        
//                                        jList1.setListData(testdata);
//                                      //jList1.
                                        //******종료하는 친구다.******
                                        frame.dispose();
                                }
                        });
                } catch (Exception e) {
                        System.err.println(e);
                }
        }
    public int TESTTT(){
        return 5;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        button1 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        button1.setLabel("클릭지점 만들기");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        button1.getAccessibleContext().setAccessibleName("addMouseClickPoint");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clickButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickButton
        System.out.println(evt.getActionCommand());
        
        getMousePoint();
        
        
    }//GEN-LAST:event_clickButton

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addmacro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addmacro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addmacro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addmacro1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addmacro1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
