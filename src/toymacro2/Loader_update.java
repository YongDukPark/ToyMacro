/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro2;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Loader_update {
    public static void main(String[] args) {
        //???¾? Loader Test?? ??????????? ???????? ?????.
        //???¾? Loader Test?? ??????????? ???????? ?????.
        //???¾? Loader Test?? ??????????? ???????? ?????.
        //???? ???????3?? ????????2?? ?????? 1???? ???? ???????
        try {
            Robot r = new Robot();
            
            //??????
            int loopCount = 25;
            
            //?????? ?????? ????
            int mouseKeyPoint = 390; 
            //???ο??? ?????? ????
            int widthPoint = 180; 
            //???????????
            int plusPoint = 20; 
            
            //???? ??? ???
            int function1h = 630;
            int function1w = 520;
            
            //???? ??? ???
            int function2h = 630;
            int function2w = 680;
            
            //???? ????° ???
            int function3h = 1110;
            int function3w = 680;
            
            //?? ???????? ????? ????
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
            
            //??? ???
            //r.mouseMove(widthPoint, mouseKeyPoint);
            
            for (int i = 0 ; i < loopCount ; i++){ 
                // ? ???μ??? ???
                r.mouseMove(widthPoint, mouseKeyPoint);
                r.delay(500);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(500);
                
                //??????? ???
                r.mouseMove(function3h, function3w);
                //???????
                r.delay(500);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(300);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                
                //??? ???
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
                
                // ?????
                r.keyPress(8);
                r.delay(500);
                r.keyPress(8);
                
                //? ??? esc
                r.keyPress(27);
                r.keyRelease(27);
                
                r.delay(500);
                //?? ???
                r.mouseMove(970, 570);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                
                // ??????? 20 ???아니 왜이래
                mouseKeyPoint = mouseKeyPoint + plusPoint;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
