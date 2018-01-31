package testingPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class TestWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow window = new TestWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 937, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(537, 21, 381, 305);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtrApplicationLog = new JTextArea();
		scrollPane.setViewportView(txtrApplicationLog);
		txtrApplicationLog.setText(getDate() + " | Application Log:\n");
		
		String[] yesNo = {"yes", "no"};
		String[] OcrFiletype = {".pdf", ".tiff"};
		String[] OcrQuality = {"high", "medium", "fast"};
		
		JComboBox comboBox = new JComboBox(yesNo);
		comboBox.setBounds(128, 80, 71, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(yesNo);
		comboBox_1.setBounds(128, 164, 71, 27);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(yesNo);
		comboBox_2.setBounds(128, 108, 71, 27);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(yesNo);
		comboBox_3.setBounds(128, 136, 71, 27);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox(OcrFiletype);
		comboBox_4.setBounds(128, 234, 81, 27);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox(OcrQuality);
		comboBox_5.setBounds(128, 262, 101, 27);
		frame.getContentPane().add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox(yesNo);
		comboBox_6.setBounds(128, 290, 71, 27);
		frame.getContentPane().add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox(yesNo);
		comboBox_7.setBounds(362, 80, 71, 27);
		frame.getContentPane().add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox(yesNo);
		comboBox_8.setBounds(362, 108, 71, 27);
		frame.getContentPane().add(comboBox_8);
		
		JLabel lblEmailtag = new JLabel("email_tag:");
		lblEmailtag.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmailtag.setBounds(15, 112, 101, 16);
		frame.getContentPane().add(lblEmailtag);
		
		JLabel lblSearchtag = new JLabel("search_tag:");
		lblSearchtag.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSearchtag.setBounds(15, 84, 101, 16);
		frame.getContentPane().add(lblSearchtag);
		
		JLabel lblOcr = new JLabel("ocr:");
		lblOcr.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOcr.setBounds(15, 140, 101, 16);
		frame.getContentPane().add(lblOcr);
		
		JLabel lblExport = new JLabel("export:");
		lblExport.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExport.setBounds(15, 168, 105, 16);
		frame.getContentPane().add(lblExport);
		
		JLabel lblTasksTBe = new JLabel("Tasks to be Completed");
		lblTasksTBe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTasksTBe.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTasksTBe.setBounds(34, 56, 184, 16);
		frame.getContentPane().add(lblTasksTBe);
		
		JLabel lblOcrOptions = new JLabel("OCR Options");
		lblOcrOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcrOptions.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblOcrOptions.setBounds(34, 210, 184, 16);
		frame.getContentPane().add(lblOcrOptions);
		
		JLabel lblFiletype = new JLabel("filetype:");
		lblFiletype.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFiletype.setBounds(15, 238, 105, 16);
		frame.getContentPane().add(lblFiletype);
		
		JLabel lblQuality = new JLabel("quality:");
		lblQuality.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQuality.setBounds(15, 266, 105, 16);
		frame.getContentPane().add(lblQuality);
		
		JLabel lblOnlysearchable = new JLabel("only_searchable:");
		lblOnlysearchable.setBounds(15, 294, 105, 16);
		frame.getContentPane().add(lblOnlysearchable);
		
		JLabel lblEcportOptions = new JLabel("Export Options");
		lblEcportOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblEcportOptions.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEcportOptions.setBounds(265, 57, 168, 16);
		frame.getContentPane().add(lblEcportOptions);
		
		JLabel lblSummary = new JLabel("summary:");
		lblSummary.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSummary.setBounds(265, 84, 85, 16);
		frame.getContentPane().add(lblSummary);
		
		JLabel lblKwsexport = new JLabel("kws_export:");
		lblKwsexport.setHorizontalAlignment(SwingConstants.TRAILING);
		lblKwsexport.setBounds(265, 112, 85, 16);
		frame.getContentPane().add(lblKwsexport);
		
		textField = new JTextField();
		textField.setBounds(121, 18, 272, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JFileChooser fc = new JFileChooser();
		
		Button button = new Button("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(frame);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            textField.setText(file.getPath());
		            //This is where a real application would open the file.
		            txtrApplicationLog.append("Opening: " + file.getPath() + "\n");
		        } else {
		        		txtrApplicationLog.append("Open command cancelled by user.\n");
		        }
			}
		});
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		button.setBounds(399, 18, 126, 26);
		frame.getContentPane().add(button);
		
		JLabel lblSelectCase = new JLabel("Select Case:");
		lblSelectCase.setBounds(34, 23, 82, 16);
		frame.getContentPane().add(lblSelectCase);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 43, 491, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(241, 56, 12, 270);
		frame.getContentPane().add(separator_1);

	}
	
	private String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date); //2016/11/16 12:08:43
	}
}
