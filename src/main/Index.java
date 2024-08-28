/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlmacro.Addmacro;
import bean.MacroAction;
import macroactionthread.AutoMouseActionThread;
import macroactionthread.MacroActionThread;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dydej
 */
public class Index extends javax.swing.JFrame {
    
    HashMap<Object, Object> mouseClickPoint = new HashMap<>();
    ArrayList<MacroAction> arrayList = new ArrayList<>();
    
    KeyboardFocusManager manager;
    KeyEventDispatcher dispatcher;
    
    boolean testCheck = true;
    
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
        autoMouseRadio = new javax.swing.JRadioButton();
        macroRadio = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("한컴 고딕", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PMacro");

        jButton1.setText("매크로만들기");
        jButton1.setActionCommand("Add");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClickEvent(evt);
            }
        });

        jButton2.setText("실행");
        jButton2.setActionCommand("macroAction");
        jButton2.setFocusable(false);
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

        autoMouseRadio.setText("오토마우스");
        autoMouseRadio.setActionCommand("autoMouseCheck");
        autoMouseRadio.setFocusable(false);
        autoMouseRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRadio(evt);
            }
        });

        macroRadio.setText("매크로");
        macroRadio.setActionCommand("macroCheck");
        macroRadio.setFocusable(false);
        macroRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRadio(evt);
            }
        });

        jTextField2.setText("반복횟수");
        jTextField2.setToolTipText("");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickTextField(evt);
            }
        });

        jCheckBox1.setText("무한");
        jCheckBox1.setActionCommand("infiniteLoop");
        jCheckBox1.setFocusable(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxAction(evt);
            }
        });

        jLabel8.setText("Macro를 사용시");

        jLabel9.setText("오토마우스는 클릭간격을 지정");

        jLabel10.setText("2초후 기능이");

        jLabel11.setText("시작됩니다.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)))
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(macroRadio)
                            .addComponent(autoMouseRadio))
                        .addGap(8, 8, 8)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(0, 89, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(autoMouseRadio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(macroRadio)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
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
            Addmacro.getInstance(arrayList);
        } else if (evt.getActionCommand().equals("macroAction")){   //매크로 액션
            //화면 시작지점 만들기
            startStandBy();
            setSize(0,0);
//            System.out.println(getSize());
            
            addWindowFocusListener(new WindowFocusListener() {
                @Override
                public void windowGainedFocus(WindowEvent e) {
                    // 포커스를 다시 요청
                    requestFocus();
                    setVisible(true);
                }

                @Override
                public void windowLostFocus(WindowEvent e) {
                    // 포커스를 다시 요청
                    requestFocus();
                    setVisible(true);
                }
            });
            try {
                if (autoMouseRadio.isSelected()) {
                    
                    //쓰레드 객체 생성 및 실행부분
                    AutoMouseActionThread bInstance = new AutoMouseActionThread(Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField1.getText()), jCheckBox1.isSelected());
                    Thread thread = new Thread(bInstance); // B 클래스의 인스턴스를 사용하여 쓰레드 생성
                    
                    thread.start(); // 쓰레드 시작
                    
                    this.manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
                    this.dispatcher = new KeyEventDispatcher() {
                        @Override
                        public boolean dispatchKeyEvent(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { // ESC 키가 눌렸을 때
                                System.out.println("ESC 키가 눌렸습니다. 쓰레드를 종료합니다.");
                                bInstance.stopThread(); // 쓰레드 종료
                                setSize(428, 353);
                                setVisible(true);
                                WindowFocusListener[] listeners = getWindowFocusListeners();
                                for (WindowFocusListener listener : listeners) {
                                    removeWindowFocusListener(listener);
                                }
                            }
                            return false;
                        }
                    };
                    manager.addKeyEventDispatcher(dispatcher);
                } else if (macroRadio.isSelected()) {
                    MacroActionThread bInstance = new MacroActionThread(arrayList, Integer.parseInt(jTextField1.getText()));
                    Thread thread = new Thread(bInstance); // B 클래스의 인스턴스를 사용하여 쓰레드 생성
                    
                    thread.start(); // 쓰레드 시작
                    this.manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
                    this.dispatcher = new KeyEventDispatcher() {
                        @Override
                        public boolean dispatchKeyEvent(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { // ESC 키가 눌렸을 때
                                System.out.println("ESC 키가 눌렸습니다. 쓰레드를 종료합니다.");
                                bInstance.stopThread(); // 쓰레드 종료
                                setSize(428, 353);
                                setVisible(true);
                                WindowFocusListener[] listeners = getWindowFocusListeners();
                                for (WindowFocusListener listener : listeners) {
                                    removeWindowFocusListener(listener);
                                }
                            }
                            return false;
                        }
                    };
                    manager.addKeyEventDispatcher(dispatcher);
                }
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                setVisible(true);
            }
        }
    }//GEN-LAST:event_buttonClickEvent
    
    private void startStandBy(){
        try {
            JPanel panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                }
            };
            JPanel dummyPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                }
            };
            //전체해상도 구하기
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            int screenResolution = toolkit.getScreenResolution();

            JFrame frame = new JFrame("Click Coordinates Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JFrame dummyFrame = new JFrame("Click Coordinates Example");
            dummyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(panel);
            dummyFrame.add(dummyPanel);

            //화면색상 바꿔줄 영역 지정
            frame.setSize(res.width, res.height);
            dummyFrame.setSize(res.width, res.height);

            //화면 반투명한 회색으로 바꿔주는 line
            frame.setUndecorated(true);
            frame.setBackground(new Color(0,0,0,122));
            dummyFrame.setUndecorated(true);
            dummyFrame.setBackground(new Color(0,0,0,0));
            panel.setBackground(new Color(0,0,0,122));
            dummyPanel.setBackground(new Color(0,0,0,0));

            JLabel label = new JLabel();
            if(autoMouseRadio.isSelected()){
                label.setText("..Auto Mouse 2 Seconds");
            } else if (macroRadio.isSelected()){
                label.setText("..Macro 2 Seconds");
            } else {
                label.setText("..Doing nothing");
            }

            label.setFont(new Font("Arial", Font.PLAIN, 150));
            label.setForeground(Color.WHITE);
            dummyPanel.setLayout(new BorderLayout());
            dummyPanel.add(label, BorderLayout.CENTER);

            frame.setVisible(true);
            dummyFrame.setVisible(true);

            Robot r = new Robot();
            //시작전 딜레이
            r.delay(1000);
            dummyFrame.setVisible(false);
            if(autoMouseRadio.isSelected()){
                label.setText(".Auto Mouse 1 Seconds");
            } else if (macroRadio.isSelected()){
                label.setText(".Macro 1 Seconds");
            } else {
                label.setText(".Doing nothing");
            }
            dummyFrame.setVisible(true);
            r.delay(1000);
            frame.setVisible(false);
            dummyFrame.setVisible(false);
        } catch (Exception e) {
        }
    }
    
    private void checkRadio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRadio
        if (evt.getActionCommand().equals("autoMouseCheck")) {
            if (macroRadio.isSelected()) {
                macroRadio.setSelected(false);
            }
        } else if (evt.getActionCommand().equals("macroCheck")) {
            if (autoMouseRadio.isSelected()) {
                autoMouseRadio.setSelected(false);
            }
        }
    }//GEN-LAST:event_checkRadio

    private void checkBoxAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAction
        if (evt.getActionCommand().equals("infiniteLoop")) {
            if (jCheckBox1.isSelected()) {
                jTextField2.setEditable(false);
                jTextField2.setBackground(Color.gray);
            } else if (!jCheckBox1.isSelected()) {
                jTextField2.setEditable(true);
                jTextField2.setBackground(Color.WHITE);
            }
        }
    }//GEN-LAST:event_checkBoxAction

    private void clickTextField(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickTextField
        //컴포넌트가 jTextField2이고 텍스트가 반복횟수만 적혀있으면 텍스트필드 clear
        if(evt.getComponent() == jTextField2){
            if(jTextField2.getText().equals("반복횟수")){
                jTextField2.setText("");
            }
        }
    }//GEN-LAST:event_clickTextField

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
    private javax.swing.JRadioButton autoMouseRadio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton macroRadio;
    // End of variables declaration//GEN-END:variables
}                                                                                             
