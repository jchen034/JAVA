package qrcode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Attendance extends JFrame {
  
	private static final long serialVersionUID = 1L;

	public Attendance() {
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("出席狀況");
        setSize(500, 1080);
        setLocationRelativeTo(null); // 顯示視窗在螢幕正中間
        setResizable(false);
        setVisible(true);
    }

    private void initializeComponents() {
    	//返回button
        JButton backButton = new JButton("");
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\返回button3.png"));
        backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backButton.setBounds(10,10,95,80);
        add(backButton);
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
                ImageIcon backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\出席狀況.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };

        add(mainPanel, BorderLayout.CENTER);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Attendance();
            }
        });
    }
}