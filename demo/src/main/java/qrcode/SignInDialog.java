package qrcode;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInDialog extends JFrame {
    public SignInDialog() {
        initializeComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("點名畫面");
        setSize(500, 1080);
        setLocationRelativeTo(null); // 顯示視窗在螢幕正中間
        setResizable(false);
        setVisible(true);
    }

    private void initializeComponents() {
        setContentPane(new JPanel() {
            private ImageIcon backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\後臺點名畫面.png");

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        });
    	JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("D:\\ide\\Back\\src\\image\\點名.png");
        Image scaledImage = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel);
        int x = 117; // x 座標
        int y = 240; // y 座標
        int width = 250; // 元件寬度
        int height = 250; // 元件高度
        imageLabel.setBounds(x, y, width, height);

        setLayout(null); // 取消佈局管理器
        add(imageLabel);
      
        //開放點名button
        JButton startButton = new JButton("");
        startButton.setVerticalAlignment(SwingConstants.CENTER);
        startButton.setHorizontalAlignment(SwingConstants.CENTER);
        startButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\開放點名button.png"));
        startButton.setVerticalTextPosition(SwingConstants.CENTER);
        startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        startButton.setBounds(82, 550, 320, 80);
        //結束點名button
        JButton endButton = new JButton("");
        endButton.setVerticalAlignment(SwingConstants.CENTER);
        endButton.setHorizontalAlignment(SwingConstants.CENTER);
        endButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\結束點名button.png"));
        endButton.setVerticalTextPosition(SwingConstants.CENTER);
        endButton.setHorizontalTextPosition(SwingConstants.CENTER);
        endButton.setBounds(82,660,320,80);

        //返回button
        JButton backButton = new JButton("");
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\返回button2.png"));
        backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backButton.setBounds(10,10,80,80);
        add(backButton);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 dispose();  // 關閉主選單視窗
                 new BackMainMenuWindow();  // 創建並顯示點名畫面視窗
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  //開放點名後的事件
            	
            }
        });
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 //結束點名後的事件
            }
        });
       
        add(startButton);
        add(endButton);

        setLayout(null);
    }
}
