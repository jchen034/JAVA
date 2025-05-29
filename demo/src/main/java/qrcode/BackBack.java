package qrcode;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.*;

public class BackBack extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/client.json";
    private static final String APPLICATION_NAME = "jc";
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

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
        // 學生資料button
        JButton studentButton = new JButton("");
        studentButton.setVerticalAlignment(SwingConstants.CENTER);
        studentButton.setHorizontalAlignment(SwingConstants.CENTER);
        studentButton.setBounds(110, 210, 270, 220);
        studentButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\學生資料button.png"));
        studentButton.setVerticalTextPosition(SwingConstants.CENTER);
        studentButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // 出席狀況button
        JButton attendanceButton = new JButton("");
        attendanceButton.setVerticalAlignment(SwingConstants.CENTER);
        attendanceButton.setHorizontalAlignment(SwingConstants.CENTER);
        attendanceButton.setBounds(110, 470, 270, 220);
        attendanceButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\出席狀況button.png"));
        attendanceButton.setVerticalTextPosition(SwingConstants.CENTER);
        attendanceButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // 返回button
        JButton backButton = new JButton("");
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setIcon(new ImageIcon("D:\\ide\\Back\\src\\image\\返回button2.png"));
        backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backButton.setBounds(11, 8, 80, 80);

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
                SwingUtilities.invokeLater(() -> {
                    try {
       
                    	// 創建 JFrame 實例
                        JFrame frame = new JFrame("Google Sheets Reader");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        // 創建 JTable 用於顯示結果
                        DefaultTableModel tableModel = new DefaultTableModel();
                        JTable table = new JTable(tableModel);
                        table.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
                        table.setRowHeight(30);

                        // 創建自定義 JPanel 並設置布局為 BorderLayout
                        JPanel panel = new JPanel(new BorderLayout()) {
                            @Override
                            protected void paintComponent(Graphics g) {
                                super.paintComponent(g);
                                ImageIcon backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\出席狀況.png");
                                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
                            }
                        };

                        // 創建 JScrollPane 並將 JTable 添加到其中
                        JScrollPane scrollPane = new JScrollPane(table);

                        // 設置 JScrollPane 的大小
                        scrollPane.setPreferredSize(new Dimension(400, 500));

                        // 設置自定義 JPanel 的大小為背景圖片的大小
                        ImageIcon backgroundImage = new ImageIcon("D:\\ide\\Back\\src\\image\\出席狀況.png");
                        panel.setPreferredSize(new Dimension(500,1080));

                        // 設置自定義 JPanel 的位置
                        panel.setBorder(BorderFactory.createEmptyBorder(220, 100, 100, 90));

                        // 將 JScrollPane 添加到自定義 JPanel 的中間位置
                        panel.add(scrollPane, BorderLayout.CENTER);

                        // 將自定義 JPanel 添加到 JFrame
                        frame.getContentPane().add(panel);

                        // 調整 JFrame 的大小和布局
                        frame.pack();
                        frame.setLocationRelativeTo(null); // 居中顯示視窗
                        frame.setResizable(false);
                        frame.setVisible(true);
                        
                        // 在 JTable 中显示结果
                        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
                        final String spreadsheetId = "12-8FzfyIVigsRbI6axxpYO7X6W5-TdAXYWMeWOotd1k";
                        final String range = "list!A:C";
                        int rowCount = 0;
                        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getcredentials(HTTP_TRANSPORT))
                                .setApplicationName(APPLICATION_NAME)
                                .build();
                        ValueRange response = service.spreadsheets().values()
                                .get(spreadsheetId, range)
                                .execute();
                        List<List<Object>> values = response.getValues();
                        if (values == null || values.isEmpty()) {
                       	    System.out.println("No data found.");
                       	} else {
                       	    // 获取A、B、C列的数据
                       	    List<Object> columnA = new ArrayList<>();
                       	    List<Object> columnB = new ArrayList<>();
                       	    List<Object> columnC = new ArrayList<>();
                       	    for (List<Object> row : values) {
                       	    	if (row.size() >= 1) {
                       	            columnA.add(row.get(0));
                       	        } else {
                       	            columnA.add(""); // 如果列为空，则显示空字符串
                       	        }
                       	        if (row.size() >= 2) {
                       	            columnB.add(row.get(1));
                       	        } else {
                       	            columnB.add(""); // 如果列为空，则显示空字符串
                       	        }
                       	        if (row.size() >= 3) {
                       	            columnC.add(row.get(2));
                       	        } else {
                       	            columnC.add(""); // 如果列为空，则显示空字符串
                       	        }
                       	        rowCount++;
                       	        if (rowCount == 58) {
                       	            break;
                       	        }
                       	    }
                       	    // 将数据添加到表格模型中
                       	    tableModel.addColumn("A", columnA.toArray());
                       	    tableModel.addColumn("B", columnB.toArray());
                       	    tableModel.addColumn("C", columnC.toArray());
                    
                       	}
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
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
    private static Credential getcredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = BackBack.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found:" + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader (in));
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder (
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets,SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8886).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
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
