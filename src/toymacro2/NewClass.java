/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toymacro2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class NewClass {
    public interface ClickListener {
        void onClick(int x, int y);
    }

    public static void waitForClick(ClickListener listener) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mouse Click Listener");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.add(panel);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // 클릭된 좌표를 콜백 메서드에 전달
                    listener.onClick(e.getX(), e.getY());
                }
            });
        });
    }
}