package app;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class MainScreen {
    private JFrame frame;
    private JButton loginButton;
    private JButton registerButton;

    public MainScreen() {
        // 初始化主畫面視窗
        frame = new JFrame("主畫面");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(606,1080);

        // 設置背景圖片
        ImageIcon backgroundImage = new ImageIcon("D:/ide/app/src/app/image/mainscreen.png");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        frame.setContentPane(backgroundLabel);
        frame.setLayout(new BorderLayout());
        // 初始化按鈕
        loginButton = new JButton("登入");
        registerButton = new JButton("註冊");

        // 設置登入按鈕的點擊事件處理
        loginButton.addActionListener(e -> {
            // 創建登入視窗並顯示
        	 LoginWindow loginWindow = new LoginWindow();
             loginWindow.show();
        });

        // 將按鈕添加到主畫面視窗中
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(loginButton);
        frame.getContentPane().add(registerButton);

        // 顯示主畫面視窗
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 在主執行緒中創建主畫面物件
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainScreen();
            }
        });
    }
}