/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro2;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;

/**
 *
 * @author Administrator
 */
public class NewClass1 {
    public static void main(String[] args) {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Robot r = new Robot();
            Dimension res = toolkit.getDefaultToolkit().getScreenSize();
            int screenResolution = toolkit.getScreenResolution();

            // 화면 중앙 좌표 계산 (배율 고려)
            int centerX = (int) (res.width * 0.5 * (96.0 / screenResolution));
            int centerY = (int) (res.height * 0.5 * (96.0 / screenResolution));
            
            
            
                        System.out.println("화면 전체해상도 : " + res.width + " x " + res.height);  

                        //화면 정중앙부분 마우스 이동
                        r.mouseMove(res.width / 2, res.height / 2);
                        
            System.out.println(centerX);
            System.out.println(centerY);
                        
        } catch (Exception e) {
        }
        
    }
}
