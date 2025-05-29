package qrcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BackBack extends JFrame {
   
	private static final long serialVersionUID = 1L;

	public BackBack() {
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("後台");
        setSize(500, 1080);
        setLocationRelativeTo(null); // 顯示視窗在螢幕正中間
        setResizable(false);
        setVisible(true);
    }

    private void initializeComponents() {
      
       //學生資料button
       JButton studentButton = new JButton("");
       studentButton.setVerticalAlignment(SwingConstants.CENTER);
       studentButton.setHorizontalAlignment(SwingConstants.CENTER);
       studentButton.setBounds(110,210,270,220);
       studentButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\學生資料button.png"));
       studentButton.setVerticalTextPosition(SwingConstants.CENTER);
       studentButton.setHorizontalTextPosition(SwingConstants.CENTER);
        
      // 出席狀況button
       JButton attendanceButton = new JButton("");
       attendanceButton.setVerticalAlignment(SwingConstants.CENTER);
       attendanceButton.setHorizontalAlignment(SwingConstants.CENTER);
       attendanceButton.setBounds(110,470,270,220);
       attendanceButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\出席狀況button.png"));
       attendanceButton.setVerticalTextPosition(SwingConstants.CENTER);
       attendanceButton.setHorizontalTextPosition(SwingConstants.CENTER);
       
      //返回button
       JButton backButton = new JButton("");
       backButton.setVerticalAlignment(SwingConstants.CENTER);
       backButton.setHorizontalAlignment(SwingConstants.CENTER);
       backButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\返回button2.png"));
       backButton.setVerticalTextPosition(SwingConstants.CENTER);
       backButton.setHorizontalTextPosition(SwingConstants.CENTER);
       backButton.setBounds(11,8,80,80);
    	
    	add(studentButton);
    	add(attendanceButton);
    	add(backButton);

    	studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();  // 關閉視窗
                new StudentData();  
            }
        });

    	attendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();  // 關閉視窗
                new Attendance();  
            }
            
        });
    	 backButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
             	 dispose();  // 關閉視窗
                  new BackMainMenuWindow();  
             }
         });
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\後台.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        add(mainPanel, BorderLayout.CENTER);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BackBack();
            }
        });
    }
}