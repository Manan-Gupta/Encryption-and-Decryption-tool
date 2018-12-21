import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class login_s {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pwd;
	private String u;
	private String p;
	public static class get{
		private static String u2;
		void putdata(String u3) {
			u2="C:\\Users\\Public\\"+u3;
		}
		public String getdata() {
			return u2;
		}
		
	}
    	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_s window = new login_s();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public login_s() {
		initialize();
	}
   	private void initialize()  {
		
		frame = new JFrame("Encryption and Decryption tool login");
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.setBackground(new Color(0, 0, 0));
		frame.setLocation(252,500);
		frame.getContentPane().setBackground(new Color(0, 255, 204));
		frame.setBounds(385, 330, 450, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			frame.setIconImage(ImageIO.read(new File("icon.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		
			
		JLabel lblintro = new JLabel("Please login");
		lblintro.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblintro.setBounds(132, 11, 210, 36);
		frame.getContentPane().add(lblintro);
		
		JLabel lbluser = new JLabel("Username");
		lbluser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbluser.setBounds(29, 61, 76, 14);
		frame.getContentPane().add(lbluser);
		
		JLabel lblpwd = new JLabel("Password");
		lblpwd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblpwd.setBounds(29, 103, 60, 14);
		frame.getContentPane().add(lblpwd);
		
		user = new JTextField();
		user.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		user.setBackground(new Color(204, 255, 255));
		user.setBounds(132, 58, 184, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		pwd.setBackground(new Color(204, 255, 255));
		pwd.setBounds(132, 100, 184, 20);
		frame.getContentPane().add(pwd);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBackground(new Color(0, 204, 255));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				u = user.getText();
				p = pwd.getText();
				
				File f = new File("C:\\Users\\Public\\"+u);
				if(f.exists()==false) {
					JOptionPane.showMessageDialog(null,"Invalid login details","Login error",JOptionPane.ERROR_MESSAGE);
					user.setText(null);
					pwd.setText(null);
				}
				else if(u.equals("") || p.equals("")){
					JOptionPane.showMessageDialog(null,"Invalid login details","Login error",JOptionPane.ERROR_MESSAGE);
					user.setText(null);
					pwd.setText(null);
				}
				else {
					FileInputStream fis = null;
			        ObjectInputStream objis = null;
			        try {
			            fis = new FileInputStream(f);
			            objis = new ObjectInputStream(fis);
			            userss uss = (userss) objis.readObject();
			            if(p.equals(uss.getpassword())) {
			            	login_s.get g = new login_s.get();
			            	g.putdata(u);
			                Dialogbox1.main(null);		
			                user.setText(null);
							pwd.setText(null);
							frame.dispose();
						}
			            else {
			            	JOptionPane.showMessageDialog(null,"Invalid login details","Login error",JOptionPane.ERROR_MESSAGE);
			            	user.setText(null);
							pwd.setText(null);
			            }
			        } catch (FileNotFoundException e1) {
			            e1.printStackTrace();
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        } catch (ClassNotFoundException e1) {
			            e1.printStackTrace();
			        } finally {
			           try {
						objis.close();
						fis.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			            
			        }
					
				}
				
			}
			});
		btnLogin.setBounds(132, 152, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewUser = new JButton("New user");
		btnNewUser.setForeground(new Color(0, 0, 0));
		btnNewUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewUser.setBackground(new Color(0, 204, 255));
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Newuser.main(null);
				frame.dispose();
			}
		});
		btnNewUser.setBounds(231, 152, 95, 23);
		frame.getContentPane().add(btnNewUser);
		
		
	}
}
