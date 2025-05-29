package qrcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuWindow extends JFrame {
  
	private static final long serialVersionUID = 1L;

	public MainMenuWindow() {
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("主選單");
        setSize(500, 1080);
        setLocationRelativeTo(null); // 顯示視窗在螢幕正中間
        setResizable(false);
        setVisible(true);
    }

    private void initializeComponents() {
    	//簽到button
    	JButton signInButton = new JButton("");
    	signInButton.setVerticalAlignment(SwingConstants.CENTER);
    	signInButton.setHorizontalAlignment(SwingConstants.CENTER);
        signInButton.setBounds(50,310,395,160);
    	signInButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\簽到button.png"));
    	signInButton.setVerticalTextPosition(SwingConstants.CENTER);
    	signInButton.setHorizontalTextPosition(SwingConstants.CENTER);
        // 登出button
        JButton logoutButton = new JButton("");
        logoutButton.setVerticalAlignment(SwingConstants.CENTER);
        logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
        logoutButton.setBounds(50,493,395,160);
        logoutButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\登出button.png"));
        logoutButton.setVerticalTextPosition(SwingConstants.CENTER);
        logoutButton.setHorizontalTextPosition(SwingConstants.CENTER);
        	
    	add(logoutButton);
    	add(signInButton);
    
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 dispose();  
                 new AttendanceWindow();  
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();  
            	new Mainapp();
            }
            
        });
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\主選單6061080.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        add(mainPanel, BorderLayout.CENTER);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenuWindow();
            }
        });
    }
}