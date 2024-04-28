/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MACROACTIONTHREAD;

import Main.Index;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 *
 * @author Administrator
 */
public class AutoMouseActionThread  implements Runnable{
    boolean isRunning = true;
    int actionCount = 0;
    int actionDelay = 0;
    boolean actionType = false; //true일경우 무한, false일경우 일정 횟수만
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
                if(actionType){ //무한 autoMouse
                    r.mousePress(InputEvent.BUTTON1_MASK);
                    r.mouseRelease(InputEvent.BUTTON1_MASK);
                    try {
                        Thread.sleep(actionDelay); // 1초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if(!actionType){ //횟수 정해진 autoMouse
                    r.mousePress(InputEvent.BUTTON1_MASK);
                    r.mouseRelease(InputEvent.BUTTON1_MASK);
                    try {
                        Thread.sleep(actionDelay); // 1초 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cnt++;
                    if(cnt >= actionCount){
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    public void stopThread() {
        isRunning = false; // 쓰레드 종료를 위해 플래그 변경
    }
    
    
}
