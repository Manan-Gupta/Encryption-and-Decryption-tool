import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Dialogbox1 {

	private JFrame frame;
	private JTextField depath;
	private JTextField demess;
	JFileChooser fc = new JFileChooser();
	File f1;
	login_s.get g1 = new login_s.get();	
	JFileChooser fc1 = new JFileChooser();
	File f3;
	private JTextField enpath;
	private JTextField enmess;
	FileNameExtensionFilter filter0 = new FileNameExtensionFilter("Choose File Format",".");
	FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Text File(.txt .dat)","txt","dat");
	FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Encrypted Only(.encrypted)","encrypted");
	FileNameExtensionFilter filter3 = new FileNameExtensionFilter("Microsoft Office File(.doc .docx .pptx .ppt .xlsx .xls)","docx","doc",".xlsx","xls","pptx","ppt");
	FileNameExtensionFilter filter4 = new FileNameExtensionFilter("PDF File(.pdf)","pdf");
	FileNameExtensionFilter filter5 = new FileNameExtensionFilter("Audio File(.mp3)","mp3");
	FileNameExtensionFilter filter6 = new FileNameExtensionFilter("Video File(.mp4 .mkv .flv .avi)","mp4","mkv","flv","avi");
	FileNameExtensionFilter filter7 = new FileNameExtensionFilter("Image File(.jpg .jpeg .png .bmp .gif)","jpg","jpeg","png","bmp","gif");
	
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialogbox1 window = new Dialogbox1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dialogbox1() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame("Encryption and decryption tool");
		frame.setBackground(new Color(255, 0, 0));
		frame.getContentPane().setBackground(new Color(255, 153, 102));
    	frame.setBounds(700, 700, 700, 700);
    	frame.setLocation(280,110);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			frame.setIconImage(ImageIO.read(new File("icon.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		
		JLabel lblintro = new JLabel("Welcome to the Encryption and Decryption tool");
		lblintro.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblintro.setBounds(109, 24, 505, 45);
		frame.getContentPane().add(lblintro);
		
		depath = new JTextField("No file choosen");
		depath.setEditable(false);
		depath.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		depath.setBackground(new Color(153, 204, 255));
		depath.setBounds(109, 397, 350, 20);
		frame.getContentPane().add(depath);
		depath.setColumns(10);
		
		demess = new JTextField();
		demess.setEditable(false);
		demess.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		demess.setBackground(new Color(153, 204, 255));
		demess.setBounds(163, 508, 248, 20);
		frame.getContentPane().add(demess);
		demess.setColumns(10);
		
		enpath = new JTextField("No file choosen");
		enpath.setEditable(false);
		enpath.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		enpath.setBackground(new Color(153, 204, 255));
		enpath.setColumns(10);
		enpath.setBounds(109, 145, 350, 20);
		frame.getContentPane().add(enpath);
		
		enmess = new JTextField();
		enmess.setEditable(false);
		enmess.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		enmess.setBackground(new Color(153, 204, 255));
		enmess.setColumns(10);
		enmess.setBounds(163, 253, 248, 20);
		frame.getContentPane().add(enmess);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBackground(new Color(102, 204, 255));
		btnBrowse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBrowse.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				try {
			    
			    fc.setAcceptAllFileFilterUsed(false);			    
			    fc.setFileFilter(filter1);
			    fc.setFileFilter(filter3);
			    fc.setFileFilter(filter4);
			    fc.setFileFilter(filter5);
			    fc.setFileFilter(filter6);
			    fc.setFileFilter(filter7);
			    fc.setFileFilter(filter0);
			    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    int r = fc.showOpenDialog(null);
			    if(r==fc.APPROVE_OPTION) {
				f1 = fc.getSelectedFile();
				enpath.setText(f1.getAbsolutePath());
			    }
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		btnBrowse.setBounds(475, 143, 89, 23);
		frame.getContentPane().add(btnBrowse);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBackground(new Color(102, 204, 255));
		btnEncrypt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			if(f1.exists()==false) {
				enmess.setText("Please choose the correct file!");
			}
			else if(!enpath.getText().equals(f1.getAbsolutePath())) {
				enmess.setText("Please choose the correct file!");
			}
			else if(enpath.getText().equals("No file choosen")) {
				enmess.setText("Please choose the correct file!");
			}
			else {	
			
			File e = new File(f1.getAbsolutePath()+".encrypted");
			InputStream fileIs = null;
		    ObjectInputStream objIs = null;
		   try {
		            fileIs = new FileInputStream(g1.getdata());
		            objIs = new ObjectInputStream(fileIs);
		            userss emp = (userss) objIs.readObject();
		            try {
				         Crypto1.encrypt(emp.getkeyy(), f1, e);
				         f1.delete();
				         if(f1.exists()) {
				        	 f1.delete();
				         }
				         enmess.setText("File encrypted successfully!");
			            } catch (Exceptionforcrypto ex) {
			              enmess.setText("Error in encrypting file!"); 
				          ex.printStackTrace();				          
			            }
			            
		       } catch (FileNotFoundException e2) {
		            e2.printStackTrace();
		       } catch (IOException e2) {
		            e2.printStackTrace();
		       } catch (ClassNotFoundException e2) {
		            e2.printStackTrace();
		       } finally {
		            try {
		                objIs.close();
		                fileIs.close();
		                } catch (Exception ex){
		                 
		        }
		        }
			}
		        
			}
		});
		btnEncrypt.setBounds(248, 197, 89, 23);
		frame.getContentPane().add(btnEncrypt);
		
		JButton btnBrowse_1 = new JButton("Browse");
		btnBrowse_1.setBackground(new Color(102, 204, 255));
		btnBrowse_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBrowse_1.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				try {
				    fc1.setAcceptAllFileFilterUsed(false);
				    fc1.setFileFilter(filter2);
				    fc1.setFileSelectionMode(JFileChooser.FILES_ONLY);
				    int r = fc1.showOpenDialog(null);
				    if(r==fc1.APPROVE_OPTION) {
					f3 = fc1.getSelectedFile();
					depath.setText(f3.getAbsolutePath());
					}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
			}
		});
		btnBrowse_1.setBounds(475, 396, 89, 23);
		frame.getContentPane().add(btnBrowse_1);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDecrypt.setBackground(new Color(102, 204, 255));
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			if(f3.exists()==false) {
				demess.setText("Please choose the correct file!");
			}
			else if(!depath.getText().equals(f3.getAbsolutePath())) {
				demess.setText("Please choose the correct file!");
			}
			else if(depath.getText().equals("No file choosen")) {
				demess.setText("Please choose the correct file!");
			}
			else {	
			File e = new File(f3.getAbsolutePath());
			File d = new File(f3.getAbsolutePath().replace(".encrypted",""));
			InputStream fileIs = null;
		    ObjectInputStream objIs = null;
		   try {
		            fileIs = new FileInputStream(g1.getdata());
		            objIs = new ObjectInputStream(fileIs);
		            userss emp = (userss) objIs.readObject();
		            try {
				         Crypto1.decrypt(emp.getkeyy(), e, d);
				         demess.setText("File decrypted successfully!");
				         f3.delete();
			            } catch (Exceptionforcrypto ex) {
			               demess.setText("Error in decrypting file!"); 
			               ex.printStackTrace();
			            }
			            
		       } catch (FileNotFoundException e2) {
		            e2.printStackTrace();
		       } catch (IOException e2) {
		            e2.printStackTrace();
		       } catch (ClassNotFoundException e2) {
		            e2.printStackTrace();
		       } finally {
		            
		                try {
		                	objIs.close();
		                	fileIs.close();							
						} catch (Exception ex) {
							
						}
		                
		                
		        }
		        }
			}  
				
			}
		);
		btnDecrypt.setBounds(248, 457, 89, 23);
		frame.getContentPane().add(btnDecrypt);
				
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBackground(new Color(204, 204, 255));
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_s.main(null);
				frame.dispose();
			}
		});
		btnLogOut.setBounds(248, 598, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		
		
		
	}
}
