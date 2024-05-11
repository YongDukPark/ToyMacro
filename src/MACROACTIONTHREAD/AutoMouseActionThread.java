/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MACROACTIONTHREAD;

import Main.Index;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.WindowFocusListener;

/**
 *
 * @author Administrator
 */
public class AutoMouseActionThread  implements Runnable{
    boolean isRunning = true;
    int actionCount = 0;
    int actionDelay = 0;
    boolean actionType = false; //true�ϰ�� ����, false�ϰ�� ���� Ƚ����
    int cnt = 0;
    
    public AutoMouseActionThread(int actionCount, int actionDelay, boolean actionType){
        this.actionCount = actionCount;
        this.actionDelay = actionDelay;
        this.actionType = actionType;
    }
    
    @Override
    public void run() {
        try {
            Robot r = new Robot();
            
            while (isRunning) {
                if(actionType){ //���� autoMouse
                    r.mousePress(InputEvent.BUTTON1_MASK);
                    r.mouseRelease(InputEvent.BUTTON1_MASK);
                    try {
                        Thread.sleep(actionDelay); // 1�� ���
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if(!actionType){ //Ƚ�� ������ autoMouse
                    r.mousePress(InputEvent.BUTTON1_MASK);
                    r.mouseRelease(InputEvent.BUTTON1_MASK);
                    try {
                        Thread.sleep(actionDelay); // 1�� ���
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cnt++;
                    if(cnt >= actionCount){
                        break;
                        
                    }
                }
            }
            //esc�� ���� ȭ���� �������� ������ ����
            Thread.sleep(300);
            r.keyPress(27);
            r.keyRelease(27);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
        }
    }
    public void stopThread() {
        isRunning = false; // ������ ���Ḧ ���� �÷��� ����
    }
    
    
}
