package com.yuan.chapter7.logging;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * 窗口日志，在一个窗口中显示日志记录
 */
class WindowHandler extends StreamHandler {

    private JFrame frame;

    public WindowHandler() {
        frame = new JFrame();
        JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(400, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) {}

            @Override
            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        });
    }

    @Override
    public void publish(LogRecord record) {
        if (!frame.isVisible()) {
            return;
        }
        super.publish(record);
        flush();
    }

    public void positionWindow(ImageViewerFrame mainFrame) {
        // 获取主窗口的位置和尺寸
        Rectangle mainBounds = mainFrame.getBounds();

        // 设置日志窗口的位置在主窗口右侧，间隔10像素
        int logX = mainBounds.x + mainBounds.width + 10;
        int logY = mainBounds.y;
        frame.setLocation(logX, logY);

        frame.setVisible(true);
    }
}