/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Administrator
 */
public class TESTS implements Runnable{
    boolean isRunning = true;
    
    @Override
    public void run() {
        while (isRunning) {
            // 쓰레드가 실행될 작업
            System.out.println("쓰레드가 실행 중입니다.");

            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("쓰레드가 종료되었습니다.");
    }
    public void stopThread() {
        isRunning = false; // 쓰레드 종료를 위해 플래그 변경
    }
    
    
}
