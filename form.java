import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Toolkit;
public class form extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtAge;
	private JTextField txtMobileno;
	private JTextField txtEmail;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public form() {
		setBackground(new Color(0, 0, 0));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ELCOT\\Downloads\\icon-g0280a2966_1280.png"));
		setTitle("Registration form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setToolTipText("Registration");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 33, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 86, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel txtGen = new JLabel("Gendar");
		txtGen.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtGen.setBounds(33, 160, 46, 14);
		contentPane.add(txtGen);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(33, 217, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Mobile no");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(33, 266, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(33, 318, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("User name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(33, 375, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(33, 413, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JTextField txtName = new JTextField();
		txtName.setBackground(new Color(255, 255, 255));
		txtName.setBounds(174, 32, 231, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JTextArea txtAddr = new JTextArea();
		txtAddr.setBounds(174, 63, 231, 86);
		contentPane.add(txtAddr);
		
		JRadioButton rbMale = new JRadioButton("Male");
		rbMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonGroup.add(rbMale);
		rbMale.setBounds(172, 168, 109, 23);
		contentPane.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonGroup.add(rbFemale);
		rbFemale.setBounds(317, 168, 109, 23);
		contentPane.add(rbFemale);
		
		txtAge = new JTextField();
		txtAge.setBounds(174, 216, 178, 23);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtMobileno = new JTextField();
		txtMobileno.setBounds(174, 264, 178, 23);
		contentPane.add(txtMobileno);
		txtMobileno.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(174, 317, 183, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(174, 374, 183, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(174, 412, 183, 19);
		contentPane.add(txtPassword);
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","T*9758@pqr");
					String query="insert into registration values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
				    ps.setString(1, txtName.getText());
					ps.setString(2, txtAddr.getText());
					if(rbMale.isSelected())
						ps.setString(3, rbMale.getText());
					else
						ps.setString(3,rbFemale.getText());
					ps.setInt(4, Integer.parseInt(txtAge.getText()));
					ps.setInt(5, Integer.parseInt(txtMobileno.getText()));
					ps.setString(6, txtEmail.getText());
					ps.setString(7,txtUser.getText());
					ps.setString(8, txtPassword.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnRegister,i+"Record add successfully");
					ps.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegister.setBounds(144, 445, 89, 23);
		contentPane.add(btnRegister);
		
		JButton Restart = new JButton("Restart");
		Restart.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAddr.setText("");
		        txtGen.setText("");
				txtAge.setText("");
				txtMobileno.setText("");
				txtEmail.setText("");
				txtUser.setText("");
				txtPassword.setText("");
				buttonGroup.clearSelection();
				
			}
		});
		Restart.setFont(new Font("Tahoma", Font.BOLD, 14));
		Restart.setBounds(299, 445, 89, 23);
		contentPane.add(Restart);
	}
}
