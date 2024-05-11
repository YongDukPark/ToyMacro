/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MACROACTIONTHREAD;

import Bean.MacroAction;
import Main.Index;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class MacroActionThread  implements Runnable{
    boolean isRunning = true;
    ArrayList<MacroAction> arrayList = new ArrayList<>();
    int actionDelay = 0;
    
    int mousePointX = 0;
    int mousePointY = 0;
    int cnt = 0;
    
    public MacroActionThread(ArrayList<MacroAction> arrayList, int actionDelay){
        this.arrayList = arrayList;
        this.actionDelay = actionDelay;
    }
    
    @Override
    public void run() {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
            int screenResolution = toolkit.getScreenResolution();
            
            Robot r = new Robot();
            
            //매크로 실행되는 구간
            while (isRunning) {
                if(arrayList.get(cnt).getActionType().equals("click")){
                    //화면 고려
                    mousePointX = (int) ((int)arrayList.get(cnt).getActionValue().get("clickX") * 0.5 * (96.0 / screenResolution));
                    mousePointY = (int) ((int)arrayList.get(cnt).getActionValue().get("clickY") * 0.5 * (96.0 / screenResolution));

                    //마우스 이동하는 부분
                    r.mouseMove(0, 0);
                    r.mouseMove((int)arrayList.get(cnt).getActionValue().get("clickX"), (int)arrayList.get(cnt).getActionValue().get("clickY"));

                    // 마우스 클릭하는부분
                    r.mousePress(InputEvent.BUTTON1_MASK);
                    r.mouseRelease(InputEvent.BUTTON1_MASK);
                } else if (arrayList.get(cnt).getActionType().equals("pressKey")){
                    r.keyPress(Integer.parseInt(String.valueOf(arrayList.get(cnt).getActionValue().get("pressKey"))));
                    r.keyRelease(Integer.parseInt(String.valueOf(arrayList.get(cnt).getActionValue().get("pressKey"))));
                } else if (arrayList.get(cnt).getActionType().equals("pressMultyKey")) {
                    r.keyPress(Integer.parseInt(String.valueOf(arrayList.get(cnt).getActionValue().get("pressMultyKey1"))));
                    r.keyPress(Integer.parseInt(String.valueOf(arrayList.get(cnt).getActionValue().get("pressMultyKey2"))));
                    r.keyRelease(Integer.parseInt(String.valueOf(arrayList.get(cnt).getActionValue().get("pressMultyKey2"))));
                    r.keyRelease(Integer.parseInt(String.valueOf(arrayList.get(cnt).getActionValue().get("pressMultyKey1"))));
                }
                //delay Row가 있을경우 대기하는 시간
                if(arrayList.get(cnt).getActionType().equals("delay")){
                    r.delay(Integer.parseInt(String.valueOf(arrayList.get(cnt).getActionValue().get("delayTime"))));
                } else {
                    r.delay(actionDelay);
                }
                try {
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cnt++;
                if(cnt >= arrayList.size()){
                    break;
                }
            }
            //esc를 눌러 화면을 정상으로 돌리는 로직
            Thread.sleep(300);
            r.keyPress(27);
            r.keyRelease(27);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
        }
    }
    public void stopThread() {
        isRunning = false; // 쓰레드 종료를 위해 플래그 변경
    }
    
    
}
