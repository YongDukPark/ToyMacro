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
        
        System.out.println("이름을 입력하세요:");
        try {
            // 한 줄을 읽어옴
            String name = reader.readLine();
            System.out.println("안녕하세요, " + name + "님!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
