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
    private MousePoint mouseClickPoint;

    public MainFrame() {
        mouseClickPoint = new MousePoint();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 그리기 작업
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickPoint = new Point(e.getX(), e.getY());
                mouseClickPoint.setClickPoint(clickPoint);
            }
        });

        add(panel);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            Point clickPoint = mouseClickPoint.getClickPoint();
            System.out.println(clickPoint.getX());
            System.out.println(clickPoint.getY());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
