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
            
            //우측 상단에 있는거
            //r.mouseMove(1110, 680);
            //우측 하단에 있는거
            //r.mouseMove(1090, 800);
            
            r.mouseMove(1900, 680);
            //r.mouseMove(1800, 830);
            
            
            //전체해상도 구하기
            Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("해상도 : " + res.width + " x " + res.height);  
            
            //포인트 지점 구하기
//            PointerInfo pt = MouseInfo.getPointerInfo();
//            while(true) {
//                    pt = MouseInfo.getPointerInfo();
//                    System.out.println(pt.getLocation()); // x,y 
//                    System.out.println(pt.getLocation().x);// x 좌표
//                    System.out.println(pt.getLocation().y); // y 좌표
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
            //전체화면
            frame.setSize(res.width, res.height);
            //전체화면은 아닌데 그런느낌
            frame.setUndecorated(true);
            frame.setBackground(new Color(0,0,0,122));
            panel.setBackground(new Color(0,0,0,122));
            frame.setVisible(true);

            } catch (Exception e) {
                System.err.println(e);
            }
    }
}
