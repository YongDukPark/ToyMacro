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
            // �����尡 ����� �۾�
            System.out.println("�����尡 ���� ���Դϴ�.");

            try {
                Thread.sleep(1000); // 1�� ���
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("�����尡 ����Ǿ����ϴ�.");
    }
    public void stopThread() {
        isRunning = false; // ������ ���Ḧ ���� �÷��� ����
    }
    
    
}
