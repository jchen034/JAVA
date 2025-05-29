package app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class LoginWindow {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginWindow() {
        // 初始化登入視窗
        frame = new JFrame("登入視窗");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        // 初始化元件
        JLabel usernameLabel = new JLabel("帳號：");
        JLabel passwordLabel = new JLabel("密碼：");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("登入");

        // 設置登入按鈕的點擊事件處理
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // 在此處執行登入操作或其他相關處理

            // 例如，顯示登入成功的訊息框
            //JOptionPane.showMessageDialog(frame, "登入成功!");
        });

        // 創建面板並添加元件
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        // 將面板添加到登入視窗中
        frame.getContentPane().add(panel);

        // 設置登入視窗為不可見（僅在按下登入按鈕後才顯示）
        frame.setVisible(false);
    }

    public void show() {
        // 顯示登入視窗
        frame.setVisible(true);
    }
}
