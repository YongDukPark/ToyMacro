/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Bean.MacroAction;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import material.MousePoint;
import toymacro2.*;

/**
 *
 * @author dydej
 */
public class Index extends javax.swing.JFrame {
    
    HashMap<Object, Object> mouseClickPoint = new HashMap<>();
    ArrayList<MacroAction> arrayList = new ArrayList<>();
    
    public Index() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("한컴 고딕", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PMacro");

        jButton1.setText("기능만들기");
        jButton1.setActionCommand("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClickEvent(evt);
            }
        });

        jButton2.setText("실행");
        jButton2.setActionCommand("macroAction");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClickEvent(evt);
            }
        });

        jLabel2.setText("강제 종료는 ctrl + F9 입니다.");

        jLabel3.setText("마우스를 사용할경우 화면배율을 100%로 설정해주세요.");

        jTextField1.setText("500");

        jLabel4.setText("Default Delay");

        jLabel5.setText("Delay row가 없을경우 여기 입력된 ");

        jLabel6.setText("값만큼 기능마다 delay됩니다.");

        jLabel7.setText("ex 1000 > 1초");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void deleteRow(ArrayList<Object> deleteRow){
        for(int i = 0 ; i < deleteRow.size() ; i++){
            for(int j = 0 ; j < arrayList.size() ; j++){
                if (arrayList.get(j).getIndexNumber() == Integer.parseInt(String.valueOf(deleteRow.get(i)))) {
                    arrayList.remove(j);
                }
            }
        }
    }
    
    private void buttonClickEvent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClickEvent
        if(evt.getActionCommand().equals("Add")){   //실행창 띄우기
            addmacro1.getInstance(arrayList);
            System.out.println(arrayList.size());
            
        } else if (evt.getActionCommand().equals("macroAction")){   //매크로 액션
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            int screenResolution = toolkit.getScreenResolution();
            int mousePointX = 0;
            int mousePointY = 0;
            
            try {
                Robot r = new Robot();
                
                //매크로 실행되는 구간
                for (int i = 0; i < arrayList.size(); i++) {
                    if(arrayList.get(i).getActionType().equals("click")){
                        //화면 고려
                        mousePointX = (int) ((int)arrayList.get(i).getActionValue().get("clickX") * 0.5 * (96.0 / screenResolution));
                        mousePointY = (int) ((int)arrayList.get(i).getActionValue().get("clickY") * 0.5 * (96.0 / screenResolution));
                        
                        //마우스 이동하는 부분
                        r.mouseMove(0, 0);
                        r.mouseMove((int)arrayList.get(i).getActionValue().get("clickX"), (int)arrayList.get(i).getActionValue().get("clickY"));
                        
                        // 마우스 클릭하는부분
                        r.mousePress(InputEvent.BUTTON1_MASK);
                        r.mouseRelease(InputEvent.BUTTON1_MASK);
                    } else if (arrayList.get(i).getActionType().equals("pressKey")){
                        r.keyPress(Integer.parseInt(String.valueOf(arrayList.get(i).getActionValue().get("pressKey"))));
                        r.keyRelease(Integer.parseInt(String.valueOf(arrayList.get(i).getActionValue().get("pressKey"))));
                    } else if (arrayList.get(i).getActionType().equals("pressMultyKey")) {
                        r.keyPress(Integer.parseInt(String.valueOf(arrayList.get(i).getActionValue().get("pressMultyKey1"))));
                        r.keyPress(Integer.parseInt(String.valueOf(arrayList.get(i).getActionValue().get("pressMultyKey2"))));
                        r.keyRelease(Integer.parseInt(String.valueOf(arrayList.get(i).getActionValue().get("pressMultyKey2"))));
                        r.keyRelease(Integer.parseInt(String.valueOf(arrayList.get(i).getActionValue().get("pressMultyKey1"))));
                    }
                    //delay Row가 있을경우 대기하는 시간
                    if(arrayList.get(i).getActionType().equals("delay")){
                        r.delay(Integer.parseInt(String.valueOf(arrayList.get(i).getActionValue().get("delayTime"))));
                    } else {
                        r.delay(Integer.parseInt(String.valueOf(jTextField1.getText())));
                    }
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_buttonClickEvent

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
