/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class checkClass {
    public static void main(String[] args) {
        Loader_update2 pointTest = new Loader_update2();
        
        try {
            Robot r = new Robot();
            
            //���� ��ܿ� �ִ°�
            //r.mouseMove(1110, 680);
            //���� �ϴܿ� �ִ°�
            //r.mouseMove(1090, 800);
            
            r.mouseMove(1900, 680);
            //r.mouseMove(1800, 830);
            
            
            //��ü�ػ� ���ϱ�
            Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("�ػ� : " + res.width + " x " + res.height);  
            
            //����Ʈ ���� ���ϱ�
//            PointerInfo pt = MouseInfo.getPointerInfo();
//            while(true) {
//                    pt = MouseInfo.getPointerInfo();
//                    System.out.println(pt.getLocation()); // x,y 
//                    System.out.println(pt.getLocation().x);// x ��ǥ
//                    System.out.println(pt.getLocation().y); // y ��ǥ
//            }
            
            JFrame frame = new JFrame("Click Coordinates Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                }
            };

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    System.out.println("Clicked at coordinates: (" + x + ", " + y + ")");
                    frame.setVisible(false);
                    
                    //frame.setDefaultCloseOperation();
                }
            });
            
            
            
            frame.add(panel);
            //��üȭ��
            frame.setSize(res.width, res.height);
            //��üȭ���� �ƴѵ� �׷�����
            frame.setUndecorated(true);
            frame.setBackground(new Color(0,0,0,122));
            panel.setBackground(new Color(0,0,0,122));
            frame.setVisible(true);

            } catch (Exception e) {
                System.err.println(e);
            }
    }
}
