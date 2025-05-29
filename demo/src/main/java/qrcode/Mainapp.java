package qrcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainapp extends JFrame {
	private JButton loginButton;
    private JButton registerButton;
    
    public Mainapp() {
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("首頁");
        setSize(500, 1080);
        setLocationRelativeTo(null); // 顯示視窗在螢幕正中間
        setResizable(false);
        setVisible(true);
    }

    private void initializeComponents() {
    	//loginButton
    	loginButton = new JButton("");
    	loginButton.setVerticalAlignment(SwingConstants.CENTER);
    	loginButton.setHorizontalAlignment(SwingConstants.CENTER);
    	loginButton.setBounds(110,380,252,60);
    	loginButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\登入button.png"));
    	loginButton.setVerticalTextPosition(SwingConstants.CENTER);
    	loginButton.setHorizontalTextPosition(SwingConstants.CENTER);
        //registerButton
    	registerButton = new JButton("");
    	registerButton.setVerticalAlignment(SwingConstants.CENTER);
    	registerButton.setHorizontalAlignment(SwingConstants.CENTER);
    	registerButton.setBounds(110,480,252,60);
    	registerButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\註冊button.png"));
    	registerButton.setVerticalTextPosition(SwingConstants.CENTER);
    	registerButton.setHorizontalTextPosition(SwingConstants.CENTER);
           
        add(loginButton);
    	add(registerButton);
    	
    	loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new login();
            }
        });

    	registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new register();
            }
        });

    	
	}
    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\主畫面.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mainapp();
            }
        });
    }
}