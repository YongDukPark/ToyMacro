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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class checkClass {
    public static void main(String[] args) {
        Loader_update2 pointTest = new Loader_update2();
        
        try {
            Robot r = new Robot();
            
            //로봇 마우스 움직이기
            //r.mouseMove(1110, 680);
            //로봇 마우스 움직이기
            //r.mouseMove(1090, 800);
            
            r.mouseMove(1900, 680);
            //r.mouseMove(1800, 830);
            
            
            //전체해상도 구하기 
            Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            System.out.println("??이거뭐누 : " + res.width + " x " + res.height);  
            
            
            
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
                    //frame.setVisible(false);
                    //frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                    
                    //******종료하는 친구다.******
                    frame.dispose();
                    
                    
                    System.out.println("testtest");
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
