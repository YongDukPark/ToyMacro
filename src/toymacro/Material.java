/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author dydej
 */
public class Material extends Thread{
    public static void main(String[] args) {
        
        try {
            Robot r = new Robot();
            
            //마우스 이동
            r.mouseMove(100, 44); 
            
            // 마우스 이벤트 (누르기 + 떼기) (1 == 왼 , 2 == 휠 , 3 == 오)
            r.mousePress(MouseEvent.BUTTON3_MASK); 
            r.mouseRelease(MouseEvent.BUTTON3_MASK);
            
            //마우스 휠 이동
            //휠에 걸리는 느낌 있지 그거로 조금씩 움직임 -5면 위로 5칸 움직임
            //아니 근데 그러면 터치패드는 ? 그건 휠할때 그런거 없잖아 ㅋㅋ
            r.mouseWheel(-5);
            
            //키 이벤트 (누르기)
            r.keyPress(KeyEvent.VK_ALT); //alt
            //이렇게도 가능하나 굳이??
            //r.keyPress(18);
            r.keyPress(KeyEvent.VK_TAB); //tap
            //키 이벤트 (떼기)
            r.keyRelease(144);
            
            //delay 기다리기
            r.delay(3000);
            
            
            
            
            
            r.keyPress(9); //tap
            r.keyRelease(18);
            r.keyRelease(9);
            //r.keyPress(0xA4);
            r.mouseMove(55, 772);
            
            r.delay(1000);
            
            //딜레이
            r.delay(3000);
            
            
            
            //r.mousePress(MouseEvent.BUTTON2_MASK); // 마우스 클릭 이벤트
            //r.mouseRelease(MouseEvent.BUTTON2_MASK);
            
            
            r.mouseWheel(-5);
            
            //파일 실행법 잘써먹으면 괜찮을듯
            //Desktop.getDesktop().open(new File("abcd.xls"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
