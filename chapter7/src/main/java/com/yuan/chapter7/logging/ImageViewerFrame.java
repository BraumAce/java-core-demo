package com.yuan.chapter7.logging;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 显示图片
 */
class ImageViewerFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 600;

    private final JLabel label;

    private static final Logger logger = Logger.getLogger("com.yuan.chapter7");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });

        // 使用 label 展示图片
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");
    }

    private class FileOpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", event);

            // 创建文件选择器
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            // 接收所有以 .glf 结尾的文件
            chooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });

            // 显示文件选择器
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            // 如果用户点击了确定按钮, 则获取选择的文件作为图标
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            } else {
                logger.fine("File open dialog canceled.");
            }
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
    }

    public Rectangle getBounds() {
        return super.getBounds();
    }
}
