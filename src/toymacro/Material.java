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
            
            //���콺 �̵�
            r.mouseMove(100, 44); 
            
            // ���콺 �̺�Ʈ (������ + ����) (1 == �� , 2 == �� , 3 == ��)
            r.mousePress(MouseEvent.BUTTON3_MASK); 
            r.mouseRelease(MouseEvent.BUTTON3_MASK);
            
            //���콺 �� �̵�
            //�ٿ� �ɸ��� ���� ���� �װŷ� ���ݾ� ������ -5�� ���� 5ĭ ������
            //�ƴ� �ٵ� �׷��� ��ġ�е�� ? �װ� ���Ҷ� �׷��� ���ݾ� ����
            r.mouseWheel(-5);
            
            //Ű �̺�Ʈ (������)
            r.keyPress(KeyEvent.VK_ALT); //alt
            //�̷��Ե� �����ϳ� ����??
            //r.keyPress(18);
            r.keyPress(KeyEvent.VK_TAB); //tap
            //Ű �̺�Ʈ (����)
            r.keyRelease(144);
            
            //delay ��ٸ���
            r.delay(3000);
            
            
            
            
            
            r.keyPress(9); //tap
            r.keyRelease(18);
            r.keyRelease(9);
            //r.keyPress(0xA4);
            r.mouseMove(55, 772);
            
            r.delay(1000);
            
            //������
            r.delay(3000);
            
            
            
            //r.mousePress(MouseEvent.BUTTON2_MASK); // ���콺 Ŭ�� �̺�Ʈ
            //r.mouseRelease(MouseEvent.BUTTON2_MASK);
            
            
            r.mouseWheel(-5);
            
            //���� ����� �߽������ ��������
            //Desktop.getDesktop().open(new File("abcd.xls"));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
