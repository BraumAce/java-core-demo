package com.yuan.chapter7.logging;

import javax.swing.*;
import java.awt.*;
import java.util.logging.*;

/**
 * 7.5.8 日志技巧
 * 7-2 创建一个日志记录器，在一个窗口中显示日志记录
 */
public class loggingImageViewer {

    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null &&
                System.getProperty("java.util.logging.config.file") == null) {
            try {
                Logger.getLogger("com.yuan.chapter7").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                FileHandler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("com.yuan.chapter7").addHandler(handler);
            } catch (Exception e) {
                Logger.getLogger("com.yuan.chapter7").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }

        EventQueue.invokeLater(() -> {
            WindowHandler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.yuan.chapter7").addHandler(windowHandler);

            ImageViewerFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 将图像查看器窗口居中显示
            frame.setLocationRelativeTo(null);
            
            Logger.getLogger("com.yuan.chapter7").fine("Showing frame");
            frame.setVisible(true);
            
            // 调整日志窗口的位置，使其显示在图像查看器窗口旁边
            windowHandler.positionWindow(frame);
        });
    }
}

