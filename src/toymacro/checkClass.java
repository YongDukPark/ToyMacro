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

public class checkClass {
    public static void main(String[] args) {
        Loader_update2 pointTest = new Loader_update2();
        
        try {
            Robot r = new Robot();
            
            //우측 상단에 있는거
            //r.mouseMove(1110, 680);
            //우측 하단에 있는거
            r.mouseMove(180, 410);
            
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
