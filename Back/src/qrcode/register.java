package qrcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register extends JFrame {
    private JButton registerStudentButton;
    private JButton registerTeacherButton;
    private JButton backButton;
    private JTextField registerIdField;
    private JTextField registerNameField;

    public register() {
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("註冊");
        setSize(500, 1080);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void initializeComponents() {
        // registerStudentButton
        registerStudentButton = new JButton("");
        registerStudentButton.setVerticalAlignment(SwingConstants.CENTER);
        registerStudentButton.setHorizontalAlignment(SwingConstants.CENTER);
        registerStudentButton.setBounds(55, 560, 187, 43);
        registerStudentButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\學生button.png"));
        registerStudentButton.setVerticalTextPosition(SwingConstants.CENTER);
        registerStudentButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // registerTeacherButton
        registerTeacherButton = new JButton("");
        registerTeacherButton.setVerticalAlignment(SwingConstants.CENTER);
        registerTeacherButton.setHorizontalAlignment(SwingConstants.CENTER);
        registerTeacherButton.setBounds(252, 560, 190, 43);
        registerTeacherButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\老師button.png"));
        registerTeacherButton.setVerticalTextPosition(SwingConstants.CENTER);
        registerTeacherButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // 返回button
        backButton = new JButton("");
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setBounds(400, 15, 60, 60);
        backButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\返回button4.png"));
        backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);

        registerIdField = new JTextField(20);
        registerNameField = new JTextField(20);
        
        // 設定字體大小
        Font inputFont = new Font("微軟正黑體", Font.PLAIN, 15); // 可自行調整字體名稱和大小
        registerIdField.setFont(inputFont);
        registerNameField.setFont(inputFont);

        registerStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = registerIdField.getText();
                String name = registerNameField.getText();
                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "學號或姓名不能為空", "錯誤", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dispose();
                new Mainapp();
            }
        });

        registerTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = registerIdField.getText();
                String name = registerNameField.getText();
                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "學號或姓名不能為空", "錯誤", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dispose();
                new Mainapp();
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

        Image backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\註冊畫面.png").getImage();
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null); // 使用绝对布局

        registerIdField.setBounds(180, 376, 200, 35);
        registerNameField.setBounds(180,448, 200, 35);

        backgroundPanel.add(registerIdField);
        backgroundPanel.add(registerNameField);
        backgroundPanel.add(registerStudentButton);
        backgroundPanel.add(registerTeacherButton);
        backgroundPanel.add(backButton);

        add(backgroundPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new register();
            }
        });
    }
}

