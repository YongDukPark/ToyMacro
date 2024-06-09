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
    
    JPanel panel;
    KeyboardFocusManager manager;
    KeyEventDispatcher dispatcher;
    
    boolean selectIndexType = false;
    int addEventInex = 0;
    
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
        model.setColumnIdentifiers(new Object[]{"������ȣ" ,"��������", "���۰�", "�������"});
        jTable1.setModel(model);
        
        //deleteRow ��ü �����κ�
        deleteRow = new ArrayList<>();
        
        // ��ó�� init �� ������ �Ŀ� ���⼭ Į�� �������� ä���ش�.
        // ���� Row �����ϴ� ��� ä���Ѵ�. �޸� �Ű澲������ �ϴ� ����
        if(arrayList.size() > 0){
            for(int i = 0 ; i < arrayList.size() ; i++){
                if (arrayList.get(i).getActionType().equals("click")) {
                    model.addRow(new Object[]{arrayList.get(i).getIndexNumber(), arrayList.get(i).getActionType(), arrayList.get(i).getActionValue().get("clickX") + " ," + arrayList.get(i).getActionValue().get("clickY"), arrayList.get(i).isAction()});
                } else if (arrayList.get(i).getActionType().equals("pressKey")) {
                    model.addRow(new Object[]{arrayList.get(i).getIndexNumber(), arrayList.get(i).getActionType(), arrayList.get(i).getActionValue().get("pressKeyImpormation") + "-" + arrayList.get(i).getActionValue().get("pressKey"), arrayList.get(i).isAction()});
                } else if (arrayList.get(i).getActionType().equals("pressMultyKey")) {
                    model.addRow(new Object[]{arrayList.get(i).getIndexNumber(), arrayList.get(i).getActionType(), arrayList.get(i).getActionValue().get("pressMultyKeyImpormation1") + "-" + arrayList.get(i).getActionValue().get("pressMultyKey1") + " + " + arrayList.get(i).getActionValue().get("pressMultyKeyImpormation2") + "-" + arrayList.get(i).getActionValue().get("pressMultyKey2"), arrayList.get(i).isAction()});
                } else if (arrayList.get(i).getActionType().equals("delay")) {
                    model.addRow(new Object[]{arrayList.get(i).getIndexNumber(), arrayList.get(i).getActionType(), arrayList.get(i).getActionValue().get("delayTime"), arrayList.get(i).isAction()});
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
            
            if (!selectIndexType) {
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
                            model.addRow(new Object[]{1, taskList.getActionType(), taskList.getActionValue().get("clickX") + " ," + taskList.getActionValue().get("clickY"), taskList.isAction()});
                        } else if (arrayList.size() > 0) {
                            taskList = new MacroAction(arrayList.get(arrayList.size()-1).getIndexNumber()+1, "click", clickPoint, true);
                            model.addRow(new Object[]{arrayList.get(arrayList.size()-1).getIndexNumber()+1, taskList.getActionType(), taskList.getActionValue().get("clickX") + " ," + taskList.getActionValue().get("clickY"), taskList.isAction()});
                        }
                        arrayList.add(taskList);

                        //******�����ϴ� ģ����.******
                        frame.dispose();
                    }
                });
            } else if (selectIndexType) {
                
                System.out.println("test2323");
                
                
                
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clickPoint = new HashMap<>();
                        // x, y ���� HashMap�� ���
                        clickPoint.put("clickX", e.getX());
                        clickPoint.put("clickY", e.getY());
                        System.out.println(jTable1.getSelectedRow());
                        if(jTable1.getSelectedRow() != -1){
                            // ���⼭ ������ �ִ� ArrayList �� �𵨵� index +1 �������
                            for (int i = jTable1.getSelectedRow() ; i < model.getRowCount() ; i++) {
                                //model.setValueAt(e, i, NORMAL);
                                arrayList.get(i).setIndexNumber(arrayList.get(i).getIndexNumber()+1);
                                model.setValueAt(i+1, i, 0);
                            }
                        }
                        
                        // indexNumber �ִºκ� 
                        taskList = new MacroAction(arrayList.get(arrayList.size()-1).getIndexNumber()+1, "click", clickPoint, true);
                        model.addRow(new Object[]{arrayList.get(arrayList.size()-1).getIndexNumber()+1, taskList.getActionType(), taskList.getActionValue().get("clickX") + " ," + taskList.getActionValue().get("clickY"), taskList.isAction()});
                        
                        arrayList.add(taskList);
                        
                        //******�����ϴ� ģ����.******
                        frame.dispose();
                    }
                });
                this.selectIndexType  = false; 
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    private void getKeyBoardPoint(){
        try {
            jDialog1.setVisible(true);
            //dispatcher �����ϴ� �κ�
            if(this.manager != null){
                this.manager.removeKeyEventDispatcher(dispatcher);
            }
            
            //TabŰ �̺�Ʈ �����ϴºκ�
            this.manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            this.dispatcher = new KeyEventDispatcher() {
                @Override
                public boolean dispatchKeyEvent(KeyEvent e) {
                    //keyCode�� 0�ϰ�� set ���� �˼����� �Ⱥ��̰� �ϱ����� ���ǹ�
                    if(e.getKeyCode() != 0){
                        settingText1.setText(KeyEvent.getKeyText(e.getKeyCode()));
                        settingText2.setText(String.valueOf(e.getKeyCode()));
                        settingText3.setText(String.valueOf(e.getKeyChar()));
                    }
                    // �ٸ� Ű �̺�Ʈ�� ���⼭ ó������ ����
                    return false;
                }
            };
            this.manager.addKeyEventDispatcher(dispatcher);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private void getMixKeyBoardDialog(){
        jDialog2.setVisible(true);
    }
    
    private void getMixKeyBoardPoint(String mixKeyButton){
        try {
            if (this.manager != null) {
                this.manager.removeKeyEventDispatcher(dispatcher);
            }
            
            //TabŰ �̺�Ʈ �����ϴºκ�
            this.manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            this.dispatcher = new KeyEventDispatcher() {
                @Override
                public boolean dispatchKeyEvent(KeyEvent e) {
                    // �� Ű�� ���ȴ��� Ȯ��
                        if(mixKeyButton.equals("putKey1")){
                            //keyCode�� 0�ϰ�� set ���� �˼����� �Ⱥ��̰� �ϱ����� ���ǹ�
                            if(e.getKeyCode() != 0){
                                settingMixText1.setText(KeyEvent.getKeyText(e.getKeyCode()));
                                settingMixText2.setText(String.valueOf(e.getKeyCode()));
                                settingMixText3.setText(String.valueOf(e.getKeyChar()));
                            }
                        } else if (mixKeyButton.equals("putKey2")){
                            //keyCode�� 0�ϰ�� set ���� �˼����� �Ⱥ��̰� �ϱ����� ���ǹ�
                            if(e.getKeyCode() != 0){
                                settingMixText4.setText(KeyEvent.getKeyText(e.getKeyCode()));
                                settingMixText5.setText(String.valueOf(e.getKeyCode()));
                                settingMixText6.setText(String.valueOf(e.getKeyChar()));
                            }
                        }
                    // �ٸ� Ű �̺�Ʈ�� ���⼭ ó������ ����
                    return true;
                }
            };
            manager.addKeyEventDispatcher(dispatcher);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    // Ű���� ���� ��Ϲ�ư
    private void saveKeyBoardPoint(String actionType){
        if (actionType.equals("typeSingle")) {
            clickPoint = new HashMap<>();
            clickPoint.put("pressKey", Integer.parseInt(settingText2.getText()));
            clickPoint.put("pressKeyImpormation", settingText1.getText());

            if (arrayList.size() == 0) {
                taskList = new MacroAction(1, "pressKey", clickPoint, true);
                //���� �̺κп��� delete Row ������ ���� ���ɼ� ������
                model.addRow(new Object[]{1, taskList.getActionType(), settingText1.getText() + "-" + settingText2.getText(), taskList.isAction()});
            } else if (arrayList.size() > 0) {
                taskList = new MacroAction(arrayList.get(arrayList.size()-1).getIndexNumber()+1, "pressKey", clickPoint, true);
                model.addRow(new Object[]{arrayList.get(arrayList.size()-1).getIndexNumber()+1, taskList.getActionType(), settingText1.getText() + "-" + settingText2.getText(), taskList.isAction()});
            }
            arrayList.add(taskList);
            jDialog1.dispose();
        } else if (actionType.equals("typeMulty")){
            clickPoint = new HashMap<>();
            clickPoint.put("pressMultyKey1", Integer.parseInt(settingMixText2.getText()));
            clickPoint.put("pressMultyKey2", Integer.parseInt(settingMixText5.getText()));
            clickPoint.put("pressMultyKeyImpormation1", settingMixText1.getText());
            clickPoint.put("pressMultyKeyImpormation2", settingMixText4.getText());
            
            if (arrayList.size() == 0) {
                taskList = new MacroAction(1, "pressMultyKey", clickPoint, true);
                model.addRow(new Object[]{1, taskList.getActionType(), settingMixText1.getText() + "-" + settingMixText2.getText() + " + " + settingMixText4.getText() + "-" + settingMixText5.getText(), taskList.isAction()});
            } else if (arrayList.size() > 0) {
                taskList = new MacroAction(arrayList.get(arrayList.size()-1).getIndexNumber()+1, "pressMultyKey", clickPoint, true);
                model.addRow(new Object[]{arrayList.get(arrayList.size()-1).getIndexNumber()+1, taskList.getActionType(), settingMixText1.getText() + "-" + settingMixText2.getText() + " + " + settingMixText4.getText() + "-" + settingMixText5.getText(), taskList.isAction()});
            }
            arrayList.add(taskList);
            jDialog2.dispose();
        }
    }
    
    private void getDelayDialog(){
        jDialog3.setVisible(true);
    }
    
    private void saveDelayRow(){
        clickPoint = new HashMap<>();
        clickPoint.put("delayTime", Integer.parseInt(jTextField1.getText()));
        
        if (arrayList.size() == 0) {
            taskList = new MacroAction(1, "delay", clickPoint, true);
            model.addRow(new Object[]{1, taskList.getActionType(), jTextField1.getText(), taskList.isAction()});
        } else if (arrayList.size() > 0) {
            taskList = new MacroAction(arrayList.get(arrayList.size()-1).getIndexNumber()+1, "delay", clickPoint, true);
            model.addRow(new Object[]{arrayList.get(arrayList.size()-1).getIndexNumber()+1, taskList.getActionType(), jTextField1.getText(), taskList.isAction()});
        }
        arrayList.add(taskList);
        jDialog3.dispose();
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
            System.err.println(e);
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
        jDialog2 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        settingMixText1 = new javax.swing.JLabel();
        settingMixText2 = new javax.swing.JLabel();
        settingMixText3 = new javax.swing.JLabel();
        settingMixText4 = new javax.swing.JLabel();
        settingMixText5 = new javax.swing.JLabel();
        settingMixText6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDialog3 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jDialog4 = new javax.swing.JDialog();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        button1 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();
        button8 = new java.awt.Button();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setMinimumSize(new java.awt.Dimension(650, 400));

        jLabel1.setFont(new java.awt.Font("����", 0, 36)); // NOI18N
        jLabel1.setText("Ű���� �Է°�");

        settingText1.setFont(new java.awt.Font("����", 1, 24)); // NOI18N
        settingText1.setText("Ű���带");
        settingText1.setToolTipText("");
        settingText1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        settingText2.setFont(new java.awt.Font("����", 1, 24)); // NOI18N
        settingText2.setText("����");
        settingText2.setToolTipText("");
        settingText2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        settingText3.setFont(new java.awt.Font("����", 1, 24)); // NOI18N
        settingText3.setText("Ű�� �Է��ϼ���.");
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

        jDialog2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog2.setMinimumSize(new java.awt.Dimension(464, 329));

        jLabel2.setText("key1");

        jLabel3.setText("key2");

        jButton1.setText("key1 ���");
        jButton1.setActionCommand("putKey1");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        jButton2.setText("key2 ���");
        jButton2.setActionCommand("putKey2");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        jLabel6.setText("pressKey : ");

        jLabel7.setText("keyCode : ");

        jLabel8.setText("Information : ");

        jLabel9.setText("pressKey : ");

        jLabel10.setText("keyCode : ");
        jLabel10.setToolTipText("");

        jLabel11.setText("Information : ");

        jButton3.setText("����");
        jButton3.setActionCommand("saveMixKeyBoardPoint");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        jButton4.setText("����");
        jButton4.setActionCommand("saveMixKeyBoardPoint");
        jButton4.setFocusable(false);

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialog2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)))
                            .addGroup(jDialog2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jDialog2Layout.createSequentialGroup()
                                    .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(settingMixText1)
                                        .addComponent(settingMixText2))
                                    .addGap(157, 157, 157)
                                    .addComponent(jButton1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                                    .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(settingMixText4)
                                        .addComponent(settingMixText5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2)))
                            .addComponent(settingMixText3)
                            .addComponent(settingMixText6)))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton3)
                        .addGap(37, 37, 37)
                        .addComponent(jButton4)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(settingMixText1)
                            .addComponent(jButton1))
                        .addGap(2, 2, 2)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(settingMixText2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(settingMixText3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(settingMixText4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(settingMixText5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(settingMixText6))
                        .addGap(13, 13, 13)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(11, 11, 11))))
        );

        jDialog3.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog3.setMinimumSize(new java.awt.Dimension(400, 300));
        jDialog3.setPreferredSize(new java.awt.Dimension(400, 330));

        jLabel4.setText("������ ����");

        jLabel5.setText("���ǻ���");

        jLabel12.setText("���⼭ �����̸� �����Ұ�� ����ȭ�鿡�� ������");

        jLabel13.setText("Default Delay ��ŭ ������� �ʰ� �� ����������");

        jLabel14.setText("�ϴܿ��� �Է��� ����ŭ Delay�� �˴ϴ�.");

        jLabel15.setText("�������� 1000 �� 1���Դϴ�.");

        jTextField1.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        jTextField1.setText("1000");

        jButton5.setText("����");
        jButton5.setActionCommand("saveDelayRow");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(40, 40, 40)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog4.setMinimumSize(new java.awt.Dimension(400, 300));

        jButton6.setText("Ŭ������ �����");
        jButton6.setActionCommand("addMouseClickPointT2");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        jButton7.setText("Delay �����");
        jButton7.setActionCommand("addDelayT2");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        jButton8.setText("ȥ��Ű �����");
        jButton8.setActionCommand("addMixKeyBoaredPointT2");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        jButton9.setText("Ű���� �׼� �����");
        jButton9.setActionCommand("addKeyBoaredPointT2");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jButton9))
                .addGap(47, 47, 47))
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton9))
                .addGap(26, 26, 26)
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap(161, Short.MAX_VALUE))
        );

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

        button5.setActionCommand("addMixKeyBoaredPoint");
        button5.setLabel("ȥ�� Ű �����");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        button6.setActionCommand("addKeyBoaredPoint");
        button6.setLabel("Ű���� �׼� �����");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        button7.setActionCommand("addDelay");
        button7.setLabel("Delay �����");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickButton(evt);
            }
        });

        button8.setActionCommand("addEventPoint");
        button8.setLabel("button8");
        button8.addActionListener(new java.awt.event.ActionListener() {
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        button1.getAccessibleContext().setAccessibleName("addMouseClickPoint");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addEventPoint(){
        try {
            jDialog4.setVisible(true);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private void clickButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickButton
        Index deleteTest = new Index();
        if (evt.getActionCommand().equals("addEventPoint")){
            addEventPoint();
        } else if (evt.getActionCommand().equals("addMouseClickPoint")) {   //���콺 Ŭ�� ����Ʈ
            getMousePoint();
        } else if (evt.getActionCommand().equals("addMouseClickPointT2")) {   //�߰� ��� ���� ���콺 Ŭ�� ����Ʈ �ƴ� �ٵ� �̰� �³� ??? ���ʰ� �̻��ѵ�????
            this.selectIndexType = true;
            getMousePoint();
        } else if (evt.getActionCommand().equals("addKeyBoaredPoint")) {    //Ű���� Ŭ�� ����Ʈ
            getKeyBoardPoint();
        } else if (evt.getActionCommand().equals("addKeyBoaredPointT2")) {    //Ű���� Ŭ�� ����Ʈ
            this.selectIndexType = true;
            getKeyBoardPoint();
        } else if (evt.getActionCommand().equals("addMixKeyBoaredPoint")){  //Ű���� �ͽ� Ŭ�� ����Ʈ
            getMixKeyBoardDialog();
        } else if (evt.getActionCommand().equals("addMixKeyBoaredPointT2")){  //Ű���� �ͽ� Ŭ�� ����Ʈ
            this.selectIndexType = true;
            getMixKeyBoardDialog();
        } else if (evt.getActionCommand().equals("addDelay")) {
            getDelayDialog();
        } else if (evt.getActionCommand().equals("addDelayT2")) {
            this.selectIndexType = true;
            getDelayDialog();
        } else if (evt.getActionCommand().equals("putKey1")){   //ȥ��Ű1�� ������ư
            getMixKeyBoardPoint(evt.getActionCommand());
        } else if (evt.getActionCommand().equals("putKey2")){   //ȥ��Ű2�� ������ư
            getMixKeyBoardPoint(evt.getActionCommand());
        } else if (evt.getActionCommand().equals("saveKeyBoardPoint")){
            saveKeyBoardPoint("typeSingle");
        } else if (evt.getActionCommand().equals("saveMixKeyBoardPoint")){
            saveKeyBoardPoint("typeMulty");
        } else if (evt.getActionCommand().equals("saveDelayRow")) {
            saveDelayRow();
        } else if (evt.getActionCommand().equals("deleteRow")) {    //Row����
            deleteRow();
        } else if (evt.getActionCommand().equals("active")){    //����
            //setActionList();
        } else if (evt.getActionCommand().equals("actionSave")) {   //����
            if(deleteRow.size() > 0){
                //Index.class �� ArrayList row �����ϱ�
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
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private java.awt.Button button8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton keyCanselButton;
    private javax.swing.JButton keyPutButton;
    private javax.swing.JLabel settingMixText1;
    private javax.swing.JLabel settingMixText2;
    private javax.swing.JLabel settingMixText3;
    private javax.swing.JLabel settingMixText4;
    private javax.swing.JLabel settingMixText5;
    private javax.swing.JLabel settingMixText6;
    private javax.swing.JLabel settingText1;
    private javax.swing.JLabel settingText2;
    private javax.swing.JLabel settingText3;
    private javax.swing.JLabel settingText4;
    private javax.swing.JLabel settingText5;
    private javax.swing.JLabel settingText6;
    // End of variables declaration//GEN-END:variables
}
