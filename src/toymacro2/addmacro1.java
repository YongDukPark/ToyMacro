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
    HashMap<Object, Object> clickPoint = new HashMap<>();
    
    MacroAction mouseClickPoint;
    ArrayList<MacroAction> arrayList = new ArrayList<>();
    
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
        model.setColumnIdentifiers(new Object[]{"동작", "위치", "사용"});
        jTable1.setModel(model);
        // 맨처음 init 을 진행한 후에 여기서 칼럼 및 거시기 정보들 바꾼다.
        // 그후 Row 생성하는 방식 채용한다. 메모리 신경쓰지말고 일단 하자
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

                        //전체해상도 구하기
                        Toolkit toolkit = Toolkit.getDefaultToolkit();
                        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
                        int screenResolution = toolkit.getScreenResolution();
                        
                        int centerX = (int) (res.width * 0.5 * (96.0 / screenResolution));
                        int centerY = (int) (res.height * 0.5 * (96.0 / screenResolution));
                        
                        System.out.println("화면 전체해상도 : " + res.width + " x " + res.height);  

                        //마우스 위치 잡아주기
                        r.mouseMove(0, 0);
                        //화면 정중앙부분 마우스 이동
                        r.mouseMove(centerX, centerY);
                        
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
                                        clickPoint.put("clickX", e.getX());
                                        clickPoint.put("clickY", e.getY());
                                        mouseClickPoint = new MacroAction("click", clickPoint, true);
                                        
                                        model.addRow(new Object[]{mouseClickPoint.getActionType(), mouseClickPoint.getClickPoint().get("clickX") + " ," + mouseClickPoint.getClickPoint().get("clickY"), mouseClickPoint.isAction()});
                                        
                                        arrayList.add(mouseClickPoint);
                                        
                                        //******종료하는 친구다.******
                                        frame.dispose();
                                }
                        });
                } catch (Exception e) {
                        System.err.println(e);
                }
        }
    private void deleteRow(){
        try {
            model.removeRow(jTable1.getSelectedRow());
            arrayList.remove(jTable1.getSelectedRow());
        } catch (Exception e) {
            //dialog 날리기
        }
        
    }
    
    //왜안되는건데
    public void setActionList(){
        
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

        button2.setActionCommand("deleteRow");
        button2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button2.setLabel("동작 삭제");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        button3.setActionCommand("active");
        button3.setLabel("적용");

        button4.setActionCommand("actionSave");
        button4.setLabel("저장");

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
        
        if (evt.getActionCommand().equals("addMouseClickPoint")) {   //마우스 클릭 포인트
            getMousePoint();
        } else if (evt.getActionCommand().equals("addKeyBoaredPoint")) {    //키보드 클릭 포인트
            
        } else if (evt.getActionCommand().equals("deleteRow")) {    //Row삭제
            deleteRow();
        } else if (evt.getActionCommand().equals("active")){    //적용
            setActionList();
        } else if (evt.getActionCommand().equals("actionSave")) {   //저장
            Index test = new Index();
            test.processArrayList(arrayList);
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
