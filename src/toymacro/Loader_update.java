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
        //���¾� Loader Test�� �����ϱ����� �������� ���̴�.
        //���¾� Loader Test�� �����ϱ����� �������� ���̴�.
        //���¾� Loader Test�� �����ϱ����� �������� ���̴�.
        //���� ������Ʈ3�� �����ٱ׷�2�� ������ 1���� ���� �����ض�
        try {
            Robot r = new Robot();
            
            //�ݺ�Ƚ��
            int loopCount = 25;
            
            //��ܿ��� ������ ����
            int mouseKeyPoint = 390; 
            //���ο��� ������ ����
            int widthPoint = 180; 
            //�����̴�����
            int plusPoint = 20; 
            
            //ù��? ��� ��ġ
            int function1h = 630;
            int function1w = 520;
            
            //ù��? ��� ��ġ
            int function2h = 630;
            int function2w = 680;
            
            //���� ����° ���
            int function3h = 1110;
            int function3w = 680;
            
            //�� �������� �Ѿ�� ����
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
            
            //ó�� ��ġ
            //r.mouseMove(widthPoint, mouseKeyPoint);
            
            for (int i = 0 ; i < loopCount ; i++){ 
                // ù ���μ��� Ŭ��
                r.mouseMove(widthPoint, mouseKeyPoint);
                r.delay(500);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(500);
                
                //������� �̵�
                r.mouseMove(function3h, function3w);
                //����Ŭ��
                r.delay(500);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                r.delay(300);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                
                //��� Ŭ��
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
                
                // �����
                r.keyPress(8);
                r.delay(500);
                r.keyPress(8);
                
                //â �ݱ� esc
                r.keyPress(27);
                r.keyRelease(27);
                
                r.delay(500);
                //�� ��ġ
                r.mouseMove(970, 570);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
                
                // �ϴ����� 20 �̵�
                mouseKeyPoint = mouseKeyPoint + plusPoint;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
