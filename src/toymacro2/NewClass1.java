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

            // ȭ�� �߾� ��ǥ ��� (���� ���)
            int centerX = (int) (res.width * 0.5 * (96.0 / screenResolution));
            int centerY = (int) (res.height * 0.5 * (96.0 / screenResolution));
            
            
            
                        System.out.println("ȭ�� ��ü�ػ� : " + res.width + " x " + res.height);  

                        //ȭ�� ���߾Ӻκ� ���콺 �̵�
                        r.mouseMove(res.width / 2, res.height / 2);
                        
            System.out.println(centerX);
            System.out.println(centerY);
                        
        } catch (Exception e) {
        }
        
    }
}
