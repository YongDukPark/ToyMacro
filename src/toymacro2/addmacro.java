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

/**
 *
 * @author dydej
 */
public class addmacro extends javax.swing.JFrame {
    private static addmacro addmacro;
    boolean clickCheck = false;
    
    private addmacro() {
        initComponents();
    }
    
    public static addmacro getInstance(){
        addmacro = new addmacro();
        if (! addmacro.isVisible()){
            addmacro.setVisible(true);
        }
        return addmacro;
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
                        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
                        System.out.println("화면 전체해상도 : " + res.width + " x " + res.height);  

                        //화면 정중앙부분 마우스 이동
                        r.mouseMove(res.width/2, res.height/2);

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
                                        String[] testdata = new String[3];
                                        testdata[0] = "1";
                                        testdata[1] = "2";
                                        testdata[2] = "3";
                                        jList1.setListData(testdata);
                                        jList1.
                                        //******종료하는 친구다.******
                                        frame.dispose();
                                }
                        });
                } catch (Exception e) {
                        System.err.println(e);
                }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        button1 = new java.awt.Button();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        button1.setLabel("클릭지점 만들기");
        button1.addActionListener(new java.awt.event.ActionListener() {
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(474, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(325, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(addmacro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addmacro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addmacro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addmacro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addmacro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
