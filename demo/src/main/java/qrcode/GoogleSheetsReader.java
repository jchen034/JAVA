package qrcode;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions. java6. auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions. jetty.auth. oauth2. LocalServerReceiver; 
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow; 
import com.google.api.client.googleapis. auth. oauth2.GoogleClientSecrets; 
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport; 
import com.google.api.client.http. javanet. NetHttpTransport;
import com.google.api.client. json. JsonFactory;
import com.google.api.client. json. jackson2. JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services. sheets. v4. Sheets;
import com.google.api.services. sheets. v4. SheetsScopes;
import com. google.api.services. sheets. v4. model. ValueRange;

import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GoogleSheetsReader {
	private static final String APPLICATION_NAME ="jc";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String TOKENS_DIRECTORY_PATH = "tokens";
/**
* Global instance of the scopes required by this quickstart.
* If modifying these scopes, delete your previously saved tokens/ folder.
*/
private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
private static final String CREDENTIALS_FILE_PATH = "/client.json";

/**
* Creates an authorized credential object.
* @param HTTP_TRANSPORT The network HTTP Transport.
* @return An authorized credential object.
* @throws IOException If the credentials. json file cannot be found.
*/
private static Credential getcredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
	// Load client secrets.
	InputStream in = GoogleSheetsReader.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
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
	LocalServerReceiver receiver = new LocalServerReceiver. Builder () . setPort (8886) . build();
	return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
}
/**
* Prints the names and majors of students in a sample spreadsheet:
* https://docs.google.com/spreadsheets/d/12-8FzfyIVigsRbI6axxpYO7X6W5-TdAXYWMeWOotd1k/edit#gid=1432811408
*/

public static void main(String... args) throws IOException, GeneralSecurityException {
	EventQueue.invokeLater(() -> {
		 try {
             // 创建 JFrame 实例
             JFrame frame = new JFrame("Google Sheets Reader");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             // 创建 JTable 用于显示结果
             DefaultTableModel tableModel = new DefaultTableModel();
             JTable table = new JTable(tableModel);
             table.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
             table.setRowHeight(30);

             // 创建 JScrollPane，并将 JTable 添加到其中
             JScrollPane scrollPane = new JScrollPane(table);
             scrollPane.setPreferredSize(new Dimension(500, 1080));

             // 添加 JScrollPane 到 JFrame
             frame.getContentPane().add(scrollPane);

             // 调整 JFrame 的大小和布局
             frame.pack();
             frame.setLocationRelativeTo(null); // 居中显示窗口
             frame.setVisible(true);
             frame.setTitle("出席狀況");
             frame.setSize(500, 1080);
             frame.setResizable(false);

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
         } catch (Exception e) {
             e.printStackTrace();
         }
     });
 }
}