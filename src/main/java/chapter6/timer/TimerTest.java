package chapter6.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

/**
 * 6.1.7 接口与回调
 * 6-3 创建一个定时器，每隔1秒执行一次
 */
public class TimerTest {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();

        Timer timer = new Timer(1000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
