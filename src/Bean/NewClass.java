/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class NewClass {
    public static void main(String[] arg)  throws Exception  {
        BufferedReader reader = new asdasdBufferedReader(new InputStreamReader(System.in));
        
        System.out.println("�̸��� �Է��ϼ���:");
        try {
            // �� ���� �о��
            String name = reader.readLine();
            System.out.println("�ȳ��ϼ���, " + name + "��!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
