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

public class Loader_update2 {
    public static void main(String[] args) {
        //���¾� Loader Test�� �����ϱ����� �������� ���̴�.
        //���¾� Loader Test�� �����ϱ����� �������� ���̴�.
        //���¾� Loader Test�� �����ϱ����� �������� ���̴�.
        try {
            Robot r = new Robot();
            
            //�ݺ�Ƚ��
            int loopCount = 38;
            
            //���ο��� ������ ����
            int widthPoint = 160;             
            //��ܿ��� ������ ����
            //int mouseKeyPoint = 410; 
            int mouseKeyPoint = 210; 
            
            //�����̴�����
            int plusPoint = 20; 
            
            //ù��? ��� ��ġ
            int function1h = 630;
            int function1w = 520;
            
            //�ι�? ��� ��ġ
            int function2h = 630;
            int function2w = 680;
            
            //���� ����° ���
            int function3h = 1110;
            int function3w = 680;
            
            //���� �ϴܿ� �ִ°�
            r.mouseMove(1110, 850);
            
            //�� �������� �Ѿ�� ����
            r.keyPress(18); //alt
            r.keyPress(9);  //tab
            r.keyRelease(9);//tab
            r.delay(500);
            r.keyPress(39); //����ȭ��ǥ
            r.keyRelease(39); //����ȭ��ǥ
            r.keyPress(39); //����ȭ��ǥ
            r.keyRelease(39); //����ȭ��ǥ
            r.delay(500);
            r.keyRelease(18); //alt
            
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
                
                /*-------------------------------------------------------*/
                /*��� ����*/
                
                //��� Ŭ�� �� ��ũ�� 
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
                
                /*��� ����*/
                /*-------------------------------------------------------*/
                
                //â �ݱ� esc 
                r.keyPress(27);
                r.keyRelease(27);
                
                r.delay(500);
                //�� ��ġ ������ ����
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
