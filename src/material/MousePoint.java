/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

import toymacro2.Loader_update2;
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

public class MousePoint {
        boolean clickCheck = false;
        public HashMap getMousePoint(){
                HashMap widthHeight = new HashMap();
                
                try {
                        JPanel panel = new JPanel() {
                                @Override
                                public void paintComponent(Graphics g) {
                                        super.paintComponent(g);
                                }
                        };

                        Robot r = new Robot();

                        //��ü�ػ� ���ϱ�
                        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
                        System.out.println("ȭ�� ��ü�ػ� : " + res.width + " x " + res.height);  

                        //ȭ�� ���߾Ӻκ� ���콺 �̵�
                        r.mouseMove(res.width/2, res.height/2);

                        JFrame frame = new JFrame("Click Coordinates Example");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        frame.add(panel);
                        //ȭ����� �ٲ��� ���� ����
                        frame.setSize(res.width, res.height);
                        //ȭ�� �������� ȸ������ �ٲ��ִ� line
                        frame.setUndecorated(true);
                        frame.setBackground(new Color(0,0,0,122));
                        panel.setBackground(new Color(0,0,0,122));
                        
                        if (! frame.isVisible()){
                                frame.setVisible(true);
                        }

                        panel.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                        // x, y ���� HashMap�� ���
                                        widthHeight.put("clickPointX", e.getX());
                                        widthHeight.put("clickPointY", e.getY());

                                        //******�����ϴ� ģ����.******
                                        frame.dispose();
                                        clickCheck = true;
                                }
                        });
                } catch (Exception e) {
                        System.err.println(e);
                }
                while (clickCheck){
                    
                }
                
                
                return widthHeight;
        }
}
