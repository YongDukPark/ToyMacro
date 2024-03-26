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
        notifyAll(); // 대기 중인 모든 스레드에게 알림
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

                        //전체해상도 구하기
                        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
                        System.out.println("화면 전체해상도 : " + res.width + " x " + res.height);  

                        //화면 정중앙부분 마우스 이동
                        r.mouseMove(res.width/2, res.height/2);

                        JFrame frame = new JFrame("Click Coordinates Example");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        frame.add(panel);
                        //화면색상 바꿔줄 영역 지정
                        frame.setSize(res.width, res.height);
                        //화면 반투명한 회색으로 바꿔주는 line
                        frame.setUndecorated(true);
                        frame.setBackground(new Color(0,0,0,122));
                        panel.setBackground(new Color(0,0,0,122));
                        
                        if (! frame.isVisible()){
                                frame.setVisible(true);
                        }
                        
                        //이지점에서 멈춰야함
                        
                        panel.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                        // x, y 지점 HashMap에 담기
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

                                        //******종료하는 친구다.******
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
