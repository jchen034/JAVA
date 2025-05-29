package qrcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {
    private JButton loginStudentButton;
    private JButton loginTeacherButton;
    private JButton backButton;
    private JTextField idField;
    private JTextField nameField;

    public login() {
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("登入");
        setSize(500, 1080);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void initializeComponents() {
        // 學生登入Button
        loginStudentButton = new JButton("");
        loginStudentButton.setVerticalAlignment(SwingConstants.CENTER);
        loginStudentButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginStudentButton.setBounds(55, 560, 178, 40);
        loginStudentButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\學生登入button.png"));
        loginStudentButton.setVerticalTextPosition(SwingConstants.CENTER);
        loginStudentButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // 老師登入Button
        loginTeacherButton = new JButton("");
        loginTeacherButton.setVerticalAlignment(SwingConstants.CENTER);
        loginTeacherButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginTeacherButton.setBounds(252, 560, 190, 43);
        loginTeacherButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\老師登入button.png"));
        loginTeacherButton.setVerticalTextPosition(SwingConstants.CENTER);
        loginTeacherButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // 返回button
        backButton = new JButton("");
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setBounds(400, 15, 60, 60);
        backButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\返回button4.png"));
        backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);

        idField = new JTextField(20);
        nameField = new JTextField(20);
        
        // 設定字體大小
        Font inputFont = new Font("微軟正黑體", Font.PLAIN, 15); // 可自行調整字體名稱和大小
        idField.setFont(inputFont);
        nameField.setFont(inputFont);

        loginStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "學號或姓名不能為空", "錯誤", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dispose();
                new MainMenuWindow();
            }
        });

        loginTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "學號或姓名不能為空", "錯誤", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dispose();
                new BackMainMenuWindow();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Mainapp();
            }
        });
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        Image backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\登入畫面.png").getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null); // 使用绝对布局

        idField.setBounds(180, 376, 200, 35);
        nameField.setBounds(180,448, 200, 35);

        backgroundPanel.add(idField);
        backgroundPanel.add(nameField);
        backgroundPanel.add(loginStudentButton);
        backgroundPanel.add(loginTeacherButton);
        backgroundPanel.add(backButton);

        add(backgroundPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new login();
            }
        });
    }
}


