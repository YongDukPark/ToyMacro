/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MousePoint1 {
    private Point clickPoint;

    public synchronized void setClickPoint(Point point) {
        this.clickPoint = point;
        notifyAll(); // ��� ���� ��� �����忡�� �˸�
    }
    
    
    
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
                        
                        //���������� �������
                        
                        panel.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                        // x, y ���� HashMap�� ���
                                        widthHeight.put("clickPointX", e.getX());
                                        widthHeight.put("clickPointY", e.getY());
//                                        System.out.println("????11111111");
//                                        System.out.println(e.getX());
//                                        System.out.println("????22222222");
//                                        System.out.println(e.getY());
                                        //frame.dispose();
//                                        synchronized(panel){
//                                            panel.notify();
//                                        }

                                        //******�����ϴ� ģ����.******
                                        frame.dispose();
                                }
                        });
                        
                        synchronized(panel){
                                            panel.notify();
                                        }
                        
                        
                } catch (Exception e) {
                        System.err.println(e);
                }
                System.out.println("dkflsjakfljaskdfjlasdjfkl");
                return widthHeight;
        }
}
