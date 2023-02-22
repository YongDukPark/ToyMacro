/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TEST_CLASS {
    public static void main(String[] args) {
        try {
            Robot r = new Robot();
            //r.mouseMove(1800, 800);
            //r.mousePress(MouseEvent.BUTTON3_MASK); // 마우스 클릭 이벤트
            //r.mouseRelease(MouseEvent.BUTTON3_MASK);
            r.keyPress(KeyEvent.VK_ALT); //alt
            r.keyPress(9); //tap
            r.keyRelease(18);
            r.keyRelease(9);
            
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.delay(300);
            
            r.keyPress(67);
            r.keyRelease(67);
            r.delay(300);
            
            r.keyPress(72);
            r.keyRelease(72);
            r.delay(300);
            
            r.keyPress(76);
            r.keyRelease(76);
            r.delay(300);
            
            r.keyPress(84);
            r.keyRelease(84);
            r.delay(300);
            
            r.keyPress(78);
            r.keyRelease(78);
            r.delay(300);
            
            r.keyPress(65);
            r.keyRelease(65);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_L);
            r.keyRelease(KeyEvent.VK_L);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_S);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_SPACE);
            r.keyRelease(KeyEvent.VK_SPACE);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_Q);
            r.keyRelease(KeyEvent.VK_Q);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_U);
            r.keyRelease(KeyEvent.VK_U);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_D);
            r.keyRelease(KeyEvent.VK_D);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_T);
            r.keyRelease(KeyEvent.VK_T);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_L);
            r.keyRelease(KeyEvent.VK_L);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_S);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_Z);
            r.keyRelease(KeyEvent.VK_Z);
            r.delay(300);
            
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.delay(300);
            
            //딜레이
//            r.delay(3000);
            
//            
//            r.keyRelease(144);
//            r.delay(3000);
//            r.keyPress(9); //tap
            
            //r.keyPress(0xA4);
//            r.mouseMove(55, 772);
//            
//            r.delay(1000);
            
            //r.mousePress(MouseEvent.BUTTON2_MASK); // 마우스 클릭 이벤트
            //r.mouseRelease(MouseEvent.BUTTON2_MASK);
            
            //휠에 걸리는 느낌 있지 그거로 조금씩 움직임 -5면 위로 5칸 움직임
//            r.mouseWheel(-5);
            
            //파일 실행법 잘써먹으면 괜찮을듯
            //Desktop.getDesktop().open(new File("abcd.xls"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
