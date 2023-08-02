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

public class F_5_changeOption {
    public static void main(String[] args) {
        //나는야 Loader Test를 정복하기위해 끄적여진 놈이다.
        //나는야 Loader Test를 정복하기위해 끄적여진 놈이다.
        //나는야 Loader Test를 정복하기위해 끄적여진 놈이다.
        try {
            Robot r = new Robot();
            
            //반복횟수
            int loopCount = 38;
            
            //가로에서 떨어진 정도
            int widthPoint = 160;             
            //상단에서 떨어진 정도
            //int mouseKeyPoint = 410; 
            int mouseKeyPoint = 210; 
            
            //움직이는정도
            int plusPoint = 20; 
            
            //첫번? 펑션 위치
            int function1h = 630;
            int function1w = 520;
            
            //두번? 펑션 위치
            int function2h = 630;
            int function2w = 680;
            
            //우측 세번째 펑션
            int function3h = 1110;
            int function3w = 680;
            
            //우측 하단에 있는거
            r.mouseMove(1110, 850);
            
            //탭 다음으로 넘어가는 로직
            r.keyPress(18); //alt
            r.keyPress(9);  //tab
            r.keyRelease(9);//tab
            r.delay(500);
            r.keyPress(39); //우측화살표
            r.keyRelease(39); //우측화살표
            r.keyPress(39); //우측화살표
            r.keyRelease(39); //우측화살표
            r.delay(500);
            r.keyRelease(18); //alt
            
            //처음 위치
            //r.mouseMove(widthPoint, mouseKeyPoint);
            
            for (int i = 0 ; i < loopCount ; i++){ 
                // 첫 프로세스 클릭
                r.mouseMove(widthPoint, mouseKeyPoint);
                r.delay(500);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(500);
                
                //펑션으로 이동
                r.mouseMove(920, 680);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                
                r.mouseMove(1800, 830);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                
                r.delay(500);
                
                r.keyPress(97); //우측화살표
                r.keyRelease(97); //우측화살표
                r.keyPress(97); //우측화살표
                r.keyRelease(97); //우측화살표
                r.delay(100);
                r.keyPress(96); //우측화살표
                r.keyRelease(96); //우측화살표
                r.delay(100);
                r.keyPress(96); //우측화살표
                r.keyRelease(96); //우측화살표
                r.delay(100);
                r.keyPress(96); //우측화살표
                r.keyRelease(96); //우측화살표
                r.delay(100);
                r.keyPress(96); //우측화살표
                r.keyRelease(96); //우측화살표
                r.delay(100);
                r.keyPress(96); //우측화살표
                r.keyRelease(96); //우측화살표
                r.delay(300);
                
                
                r.keyPress(27); //우측화살표
                r.keyRelease(27); //우측화살표
                
                // 하단으로 20 이동
                mouseKeyPoint = mouseKeyPoint + plusPoint;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
