import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Newuser {

	private JFrame frame;
	private JTextField nuser;
	private JPasswordField npwd;
	private JPasswordField npwd1;
	private String nu;
	private String np;
	private String np1;
	private String nk;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newuser window = new Newuser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Newuser() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Create your account");
		frame.getContentPane().setBackground(new Color(153, 255, 153));
		frame.setBackground(new Color(153, 255, 153));
		frame.setBounds(100, 100, 450, 300);
		frame.setLocation(380,320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterYourUsername = new JLabel("Enter your username");
		lblEnterYourUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterYourUsername.setBackground(new Color(255, 255, 255));
		lblEnterYourUsername.setForeground(new Color(0, 0, 0));
		lblEnterYourUsername.setBounds(22, 41, 151, 14);
		frame.getContentPane().add(lblEnterYourUsername);
		
		nuser = new JTextField();
		nuser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		nuser.setBackground(new Color(255, 255, 204));
		nuser.setBounds(195, 39, 193, 20);
		frame.getContentPane().add(nuser);
		nuser.setColumns(10);
		
		JLabel lblEnterYourPassword = new JLabel("Enter your password");
		lblEnterYourPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterYourPassword.setBounds(22, 99, 139, 14);
		frame.getContentPane().add(lblEnterYourPassword);
		
		JLabel lblReenterYourPassword = new JLabel("Re-enter your password");
		lblReenterYourPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblReenterYourPassword.setBounds(22, 157, 163, 14);
		frame.getContentPane().add(lblReenterYourPassword);
		
		npwd = new JPasswordField();
		npwd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		npwd.setBackground(new Color(255, 255, 204));
		npwd.setBounds(195, 96, 193, 20);
		frame.getContentPane().add(npwd);
		
		npwd1 = new JPasswordField();
		npwd1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		npwd1.setBackground(new Color(255, 255, 204));
		npwd1.setBounds(195, 154, 193, 20);
		frame.getContentPane().add(npwd1);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBackground(new Color(153, 255, 204));
		btnSave.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				nu=nuser.getText();
				np=npwd.getText();
				np1=npwd1.getText();
				File file = new File(nu);
				if(nu.equals("") || np.equals("") || np1.equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill all the fields","Field error",JOptionPane.ERROR_MESSAGE);
					nuser.setText(null);
					npwd.setText(null);
					npwd1.setText(null);					
				}
				else if(!np.equals(np1)) {
			    JOptionPane.showMessageDialog(null,"Password and re-entered password doesn't match","Field error",JOptionPane.ERROR_MESSAGE);
			    nuser.setText(null);
			    npwd.setText(null);		
			    npwd1.setText(null);	
					
				}
				else if(file.exists()){
					JOptionPane.showMessageDialog(null,"Username already exist","Field error",JOptionPane.ERROR_MESSAGE);
				    nuser.setText(null);
				    npwd.setText(null);		
				    npwd1.setText(null);
					
				}
				else {
				userss nuser1 = new userss();
				users nuser = new users();
				Keygen keygen = new Keygen();
				nuser1.setname(nu);
				nuser1.setpassword(np);
				nk=keygen.geek_Password(32);
				nuser1.setkeyy(nk);
				try {
					nuser.storeObject(nuser1,nu);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame,"Account created successfully","Account Created",JOptionPane.PLAIN_MESSAGE);
				frame.dispose();
				login_s.main(null);
				}
				
			}
		});
		btnSave.setBounds(197, 206, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancel.setBackground(new Color(153, 255, 204));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuser.setText(null);
			    npwd.setText(null);		
			    npwd1.setText(null);
			    frame.dispose();
			    login_s.main(null);
			}
		});
		btnCancel.setBounds(299, 206, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		
	}
}
