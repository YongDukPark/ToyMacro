/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro2;

/**
 *
 * @author Administrator
 */
public class MainClass {
    public static void main(String[] args) {
        
        
        NewClass.waitForClick(new NewClass.ClickListener() {
            @Override
            public void onClick(int x, int y) {
                // Ŭ���� ��ǥ�� �޾ƿͼ� ���ϴ� �۾��� ����
                System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
            }
        });
    }
}
