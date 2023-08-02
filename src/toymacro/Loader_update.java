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

public class Loader_update {
    public static void main(String[] args) {
        //나는야 Loader Test를 정복하기위해 끄적여진 놈이다.
        //나는야 Loader Test를 정복하기위해 끄적여진 놈이다.
        //나는야 Loader Test를 정복하기위해 끄적여진 놈이다.
        //위에 프로젝트3개 스케줄그룹2개 스케줄 1개를 놓고 진행해라
        try {
            Robot r = new Robot();
            
            //반복횟수
            int loopCount = 25;
            
            //상단에서 떨어진 정도
            int mouseKeyPoint = 390; 
            //가로에서 떨어진 정도
            int widthPoint = 180; 
            //움직이는정도
            int plusPoint = 20; 
            
            //첫번? 펑션 위치
            int function1h = 630;
            int function1w = 520;
            
            //첫번? 펑션 위치
            int function2h = 630;
            int function2w = 680;
            
            //우측 세번째 펑션
            int function3h = 1110;
            int function3w = 680;
            
            //탭 다음으로 넘어가는 로직
            r.keyPress(18);
            r.keyPress(9);
            r.keyRelease(9);
            r.delay(500);
            r.keyPress(39);
            r.keyRelease(39);
            r.keyPress(39);
            r.keyRelease(39);
            r.delay(500);
            r.keyRelease(18);
            
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
                r.mouseMove(function3h, function3w);
                //더블클릭
                r.delay(500);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(300);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                
                //허공 클릭
                r.delay(1000);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(300);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(300);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(1000);
                
                // 지우는
                r.keyPress(8);
                r.delay(500);
                r.keyPress(8);
                
                //창 닫기 esc
                r.keyPress(27);
                r.keyRelease(27);
                
                r.delay(500);
                //네 위치
                r.mouseMove(970, 570);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                
                // 하단으로 20 이동
                mouseKeyPoint = mouseKeyPoint + plusPoint;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
