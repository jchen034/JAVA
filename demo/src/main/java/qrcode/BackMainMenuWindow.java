package qrcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackMainMenuWindow extends JFrame {
    private JButton signInButton;
    private JButton logoutButton;
    private JButton backButton;

    public BackMainMenuWindow() {
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("後台主選單");
        setSize(500, 1080);
        setLocationRelativeTo(null); // 顯示視窗在螢幕正中間
        setResizable(false);
        setVisible(true);
    }

    private void initializeComponents() {
    	//點名button
        signInButton = new JButton("");
        signInButton.setVerticalAlignment(SwingConstants.CENTER);
        signInButton.setHorizontalAlignment(SwingConstants.CENTER);
        signInButton.setBounds(48,220,395,160);
        signInButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\點名button.png"));
        signInButton.setVerticalTextPosition(SwingConstants.CENTER);
        signInButton.setHorizontalTextPosition(SwingConstants.CENTER);
        //後台button
        backButton = new JButton("");
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setBounds(48,400,395,160);
        backButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\後台button.png"));
        backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        //登出button
        logoutButton = new JButton("");
        logoutButton.setVerticalAlignment(SwingConstants.CENTER);
        logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
        logoutButton.setBounds(48,578,395,160);
        logoutButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\登出button2.png"));
        logoutButton.setVerticalTextPosition(SwingConstants.CENTER);
        logoutButton.setHorizontalTextPosition(SwingConstants.CENTER);
    
        add(signInButton);
    	add(logoutButton);
    	add(backButton);
    	
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignInDialog();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 dispose();
            	 new Mainapp();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 dispose();
                 new BackBack();
            }
        });
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("D:/ide/Back/src/image/後台主選單.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BackMainMenuWindow();
            }
        });
    }
}