package qrcode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttendanceWindow extends JFrame {
    public AttendanceWindow() {
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
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("D:\\ide\\Back\\src\\image\\點名畫面.png");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
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
        int y = 390; // y 座標
        int width = 250; // 元件寬度
        int height = 250; // 元件高度
        imageLabel.setBounds(x, y, width, height);
        //返回button
        JButton backButton = new JButton("");
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\返回button.png"));
        backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backButton.setBounds(10,10,76,80);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 dispose();  // 關閉主選單視窗
                 new MainMenuWindow();  // 創建並顯示點名畫面視窗
            }
        });
        
        setLayout(null); // 取消佈局管理器
        add(imageLabel);
    }
}