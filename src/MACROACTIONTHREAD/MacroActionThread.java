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
            
            //��ũ�� ����Ǵ� ����
            while (isRunning) {
                if(arrayList.get(cnt).getActionType().equals("click")){
                    //ȭ�� ���
                    mousePointX = (int) ((int)arrayList.get(cnt).getActionValue().get("clickX") * 0.5 * (96.0 / screenResolution));
                    mousePointY = (int) ((int)arrayList.get(cnt).getActionValue().get("clickY") * 0.5 * (96.0 / screenResolution));

                    //���콺 �̵��ϴ� �κ�
                    r.mouseMove(0, 0);
                    r.mouseMove((int)arrayList.get(cnt).getActionValue().get("clickX"), (int)arrayList.get(cnt).getActionValue().get("clickY"));

                    // ���콺 Ŭ���ϴºκ�
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
                //delay Row�� ������� ����ϴ� �ð�
                if(arrayList.get(cnt).getActionType().equals("delay")){
                    r.delay(Integer.parseInt(String.valueOf(arrayList.get(cnt).getActionValue().get("delayTime"))));
                } else {
                    r.delay(actionDelay);
                }
                try {
                    Thread.sleep(1000); // 1�� ���
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cnt++;
                if(cnt >= arrayList.size()){
                    break;
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
