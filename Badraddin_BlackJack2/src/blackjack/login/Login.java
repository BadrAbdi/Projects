package blackjack.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import blackjack.gui.BlackJacjGUI;
import blackjack.obj.Player;
import blackjack.obj.Account;
import blackjack.obj.Verify;
//import blackjack.utility.*;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Login extends JFrame {

 //all elements for jframe
 private JPanel contentPane;
 private JTextField user;
 private JTextField pass;
 private Account account;
 private Verify valid;
 public JButton btnLog;
 private static boolean verified;
 private JButton btnCreate;

 public boolean isDone() {
  //checks if the user and pass is valid
  return verified;
 }

 /**
  * Launch the application.
  */
 public  void main() {
  //main class
  verified = true;
  //runs gui for login
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Login frame = new Login();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
    
   }
   
  });
  System.out.println(verified);
  //keeps going until correct user and pass
  while(verified) {
  System.out.print("");
  }
 }

 /**
  * Create the frame.
  */
 public Login() {
  
  /// construtors include labels and jtextpanes to get user names and passwords
  setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/blackjack/utility/img.jpg")));
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 589, 338);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  
  //username
  JLabel lblUsername = new JLabel("UserName:");
  lblUsername.setBounds(132, 63, 64, 14);
  contentPane.add(lblUsername);
  
  //password
  JLabel lblPassword = new JLabel("PassWord:");
  lblPassword.setBounds(132, 106, 64, 14);
  contentPane.add(lblPassword);
  
  user = new JTextField();
  user.setBounds(259, 60, 124, 20);
  contentPane.add(user);
  user.setColumns(10);
  
  pass = new JTextField();
  pass.setColumns(10);
  pass.setBounds(259, 103, 124, 20);
  contentPane.add(pass);
  
  btnLog = new JButton("Log In");
  btnLog.setFont(new Font("Tahoma", Font.PLAIN, 18));
  btnLog.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    //gets text of user name and passsword when button is clicked
    String usern = user.getText();
    String passn = pass.getText();
    System.out.println((usern!=null && passn!=null) + " " + (!usern.equals("")) + " " +(!passn.equals("")));
    if(!usern.equals("") || !passn.equals("")) {
     try {
      //checks if username and password is in databas
      valid = new Verify(usern,passn);
     } catch (Exception e) {
     }
     if(valid.isCheck()) {
      //if its in the database  it will close the login prompt
      JOptionPane.showMessageDialog(null, "Successful");
      //contentPane.removeAll();
      verified = false;
      setVisible(false); 
      dispose();
      //verified = false;
      System.out.println(verified);
      System.out.println(isDone());
      //this.setEnabled(false);
      //BlackJacjGUI gui = new BlackJacjGUI(true);
      //gui.main();
      //gui.setEnabled(true);
      //gui.
      //gui.
      //contentPane.add(gui);
      //gui.main();
      //gui.setVisible(true);
      //contentPane.add(gui);
      //gui.setEnabled(true);
      
     //gui.contentPane.setVisible(true);
      //gui.staticMethod();
     // gui.set
      //gui.repaint();
      
      //verified = true;
      
      
     }
     else {
      JOptionPane.showMessageDialog(null, "No LogIn found");
     //System.out.println(usern + " "+ passn);
     }
     
     
    }
    else {
     JOptionPane.showMessageDialog(null, "No LogIn found");
    //System.out.println(usern + " "+ passn);
    }
   }
  });
  btnLog.setBounds(205, 162, 100, 31);
  contentPane.add(btnLog);
  
  btnCreate = new JButton("Create a new account...");
  btnCreate.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    //adds a new account to the database 
    String usern = user.getText();
    String passn = pass.getText();
    if(usern!=null && passn!=null) {
     try {
      account = new Account(usern,passn);
      user.setText("");
      pass.setText("");
     } catch (Exception c) {
      c.printStackTrace();
     }
     
      JOptionPane.showMessageDialog(null, "Successful, now you can log in");
      
     
     
     
    }
    else {
     JOptionPane.showMessageDialog(null, "Please re-enter your info ");
    }
   }
  });
  btnCreate.setFont(new Font("Tahoma", Font.ITALIC, 12));
  btnCreate.setBackground(SystemColor.menu);
  btnCreate.setHorizontalAlignment(SwingConstants.LEFT);
  btnCreate.setBounds(176, 227, 182, 23);
  contentPane.add(btnCreate);
  
 }
}
