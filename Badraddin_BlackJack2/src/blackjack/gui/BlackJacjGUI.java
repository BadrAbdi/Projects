package blackjack.gui;

//imports everything like swing needed for the program
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import blackjack.login.Login;
import blackjack.obj.Player;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.ComponentOrientation;
import java.awt.Toolkit;

public class BlackJacjGUI extends JFrame {

 //all the elements needed for GUI
 public JPanel contentPane;
 private JTextPane txtpnAddNewBet;
 static DefaultListModel pl = new DefaultListModel();
 static DefaultListModel dl = new DefaultListModel();
 JButton button_500;
 JButton button_1000;
 JButton button_100;
 JButton btnEnterBet;
 JTextPane displayBet;
 static JTextPane scorePane_p;
 static JTextPane scorePane_d;
 static JTextPane winner;
 static JTextPane bankPane;
 static JButton btnStand;
 static JButton btnHit;
 static int bet;
 public static boolean stay = false;
 public static boolean hit = false;
 public static boolean le = true;
 static Player player;
 /**
  * Supresses warning so not every warning shows for the list
  */
 @SuppressWarnings("unchecked")
 //public void run() {
	// main(null);
 //}
 
 
 public BlackJacjGUI(boolean check) {
	 
 }
 public static void main(String[]args) {  
	
	 //logg.main();
	//adds nothing into the list of cards
    pl.addElement(" ");
    dl.addElement(" ");
    //creates a login interface
    Login log = new Login();
    log.main();
   while(log.isDone()) {
    	//System.out.print(log.isDone());
	   //while the log in is not valid it keeps running
    }

   runNow();//runs GUI after succesfull login

   player = new Player(); // creates a player
      Player dealer = new Player(player.card);//creates a dealer
      
      //bankPane.setText("ne");
   System.out.println("WHU");
      while(true){
    	//resets the players hand every time
        player.reset();
        dealer.reset(player.card);
        //btnHit.setEnabled(false);
        //btnStand.setEnabled(false);
        //removes elements in  the list for the hand
        pl.removeAllElements();
        dl.removeAllElements();
    
     //  System.out.println("CHCk");
    
      
        boolean first = false;
        bet = 0;

     // bankPane.setText(player.money+ "");
        le = true;
        while(le) {
        	//until bet is entered
         System.out.print("");
        }
        System.out.println(bet);
        //hits and adds to list;
        dl.addElement("X");
        player.hit();
        pl.addElement((player.card.showCard().startsWith("0"))?player.card.showCard().replace("0","10") : player.card.showCard());
        player.hit();
        pl.addElement((player.card.showCard().startsWith("0"))?player.card.showCard().replace("0","10") : player.card.showCard());
        dealer.hit();
        dl.addElement((dealer.card.showCard().startsWith("0"))?dealer.card.showCard().replace("0","10"): dealer.card.showCard());
       // dealer.first = dealer.score;
        //dealer.hit();
        //dl.addElement((dealer.card.showCard().startsWith("0"))?dealer.card.showCard().replace("0","10"): dealer.card.showCard());
     
        System.out.println("WHI");
        if(dealer.score >= 21 || player.score >=21) first =true;
        else 
          player.show(dealer);
       // btnEnterBet.setEnabled(false);
        btnHit.setEnabled(true);
        btnStand.setEnabled(true);
        bankPane.setText(player.money+"");
        scorePane_p.setText(player.score+"");
        scorePane_d.setText(dealer.score+"");
        while(player.score <21 && dealer.score<21 && !first){
         
         System.out.print("");
          if(hit){
//if player choses to hit it will hit and add it to the hand
   
              player.hit();
              scorePane_p.setText(player.score+"");
              player.show(dealer);
              pl.addElement((player.card.showCard().startsWith("0"))?player.card.showCard().replace("0","10") : player.card.showCard());
              hit = false;
          }
          else if(stay){
        	  try {
        		  dl.removeElement("X");
        	  }
        	  catch(Exception E) {
        		  
        	  }
           System.out.println(stay);
            if(dealer.score >= 16) {
             stay =false;
             break;
            }
            dealer.hit();
            dl.addElement((dealer.card.showCard().startsWith("0"))?dealer.card.showCard().replace("0","10"): dealer.card.showCard());
            player.show(dealer);
            scorePane_d.setText(dealer.score+"");
          }
          if(player.score == 21)break;
          //System.out.println(stay+  " stay");
        }
        scorePane_p.setText(player.score+"");
        scorePane_d.setText(dealer.score+"");
        btnHit.setEnabled(false);
        btnStand.setEnabled(false);
        //player.winner(dealer,bet);
        
       // try {
        	 winner.setText(player.winner(dealer,bet));
             bankPane.setText(player.money+"");
             JOptionPane.showMessageDialog(null, "Winner: "+player.winner(dealer));
			//Thread.sleep(5000);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
        int delay = 1000; //milliseconds
        //ActionListener taskPerformer = new ActionListener() {
          //  public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
            //}
       // };
        //Timer myTime = new Timer(delay, taskPerformer);
        //myTime.setRepeats(false);
        //myTime.start();
        System.out.println(delay);


        scorePane_d.setText("0");
        scorePane_p.setText("0");
        player.score = 0;
        dealer.score =0;
        if(player.money == 0) {
        	JOptionPane.showMessageDialog(null, "ALTHOUGH YOU WENT BROKE, I SHALL LEND YOU $100 YOU WILL FOREVER BE IN MY DEBT");
        	player.money +=100;
        	bankPane.setText("100");
        }
      }
 
 }


 /**
  * Create the frame for blackjack
  */
 public static void runNow() {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     BlackJacjGUI frame = new BlackJacjGUI();
 
     frame.setVisible(true);
     
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
  
 }
 
//class constructor with all elements for the graphics
 public  BlackJacjGUI() {
	 //sets the blackjack icon to an image of cards in blackjack.utility
 	setIconImage(Toolkit.getDefaultToolkit().getImage(BlackJacjGUI.class.getResource("/blackjack/utility/img.jpg")));
 	//sets exit button to work
 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	//sets a boundary for the frame 
  setBounds(100, 100, 768, 485);
  this.setVisible(true);
  //makes it visible
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  //creats label
  JLabel lblPlayer = new JLabel("Player");
  lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 32));
  lblPlayer.setBounds(57, 11, 106, 52);
  contentPane.add(lblPlayer);
  
  scorePane_p = new JTextPane();
  scorePane_p.setText("0");
  scorePane_p.setEditable(false);
  scorePane_p.setBounds(257, 110, 97, 34);
  contentPane.add(scorePane_p);
  
  scorePane_d = new JTextPane();
  scorePane_d.setText("0");
  scorePane_d.setBounds(397, 110, 97, 34);
  contentPane.add(scorePane_d);
  
  JLabel lblBankRoll = new JLabel("Bank Roll:");
  lblBankRoll.setFont(new Font("Tahoma", Font.PLAIN, 24));
  lblBankRoll.setBounds(380, 230, 116, 34);
  contentPane.add(lblBankRoll);
  
  bankPane = new JTextPane();
  bankPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
  bankPane.setText("100");
  bankPane.setBounds(397, 268, 314, 75);
  contentPane.add(bankPane);
 
  
  JLabel lblDealer = new JLabel("Dealer");
  lblDealer.setFont(new Font("Tahoma", Font.BOLD, 32));
  lblDealer.setBounds(565, 11, 106, 52);
  contentPane.add(lblDealer);
  
  displayBet = new JTextPane();
  displayBet.setText("0");
  displayBet.setEditable(false);
  displayBet.setBounds(141, 331, 158, 34);
  contentPane.add(displayBet);
  
  button_1000 = new JButton("$1000");
  button_1000.addActionListener(new ActionListener() {
   
   public void actionPerformed(ActionEvent e) {
     displayBet.setText((Integer.parseInt(displayBet.getText()) + 1000) +"");
   }
  });
  button_1000.setBounds(10, 294, 89, 23);
  contentPane.add(button_1000);
  
  button_500 = new JButton("$500");
  //adds button listener to increase bet
  button_500.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    displayBet.setText((Integer.parseInt(displayBet.getText()) + 500) +"");
   }
  });
  button_500.setBounds(10, 342, 89, 23);
  contentPane.add(button_500);
  
  button_100 = new JButton("$100");
  //sets button listener for the bet to increase
  button_100.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    displayBet.setText((Integer.parseInt(displayBet.getText()) + 100) +"");
   }
  });
  button_100.setBounds(10, 390, 89, 23);
  contentPane.add(button_100);
  
  JLabel lblAddBet = new JLabel("Add Bet:");
  lblAddBet.setFont(new Font("Tahoma", Font.PLAIN, 15));
  lblAddBet.setBounds(23, 269, 63, 14);
  contentPane.add(lblAddBet);
  
  
  
  JLabel lblCurrentBet = new JLabel("Current Bet:");
  lblCurrentBet.setBounds(183, 298, 69, 19);
  contentPane.add(lblCurrentBet);
  
  
  
  txtpnAddNewBet = new JTextPane();
  txtpnAddNewBet.setEditable(false);
  txtpnAddNewBet.setBackground(UIManager.getColor("Button.background"));
  txtpnAddNewBet.setFont(new Font("Tahoma", Font.PLAIN, 18));
  txtpnAddNewBet.setText("ADD NEW BET!");
  txtpnAddNewBet.setBounds(88, 230, 148, 23);
  contentPane.add(txtpnAddNewBet);
  
  JScrollPane scrollPane = new JScrollPane();
  scrollPane.setBounds(23, 59, 224, 146);
  contentPane.add(scrollPane);
  
  JList playerlst = new JList(pl);
  scrollPane.setViewportView(playerlst);
  
  JList dealerlst = new JList(dl);
  dealerlst.setBounds(507, 60, 222, 144);
  contentPane.add(dealerlst);
  
  JLabel lblScore = new JLabel("Score:");
  lblScore.setFont(new Font("Tahoma", Font.PLAIN, 13));
  lblScore.setBounds(280, 61, 53, 23);
  contentPane.add(lblScore);
  
  JLabel label = new JLabel("Score:");
  label.setFont(new Font("Tahoma", Font.PLAIN, 13));
  label.setBounds(432, 61, 53, 23);
  contentPane.add(label);
  
  
  
  JLabel lblWinner = new JLabel("WINNER:");
  lblWinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
  lblWinner.setBounds(337, 394, 123, 19);
  contentPane.add(lblWinner);
  
  winner = new JTextPane();
  winner.setBounds(507, 378, 196, 34);
  contentPane.add(winner);
  
  btnHit = new JButton("HIT");
  btnHit.setEnabled(false);
  btnHit.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    hit = true;
   }
  });
  btnHit.setBounds(257, 189, 106, 48);
  contentPane.add(btnHit);
  
  btnStand = new JButton("STAND");
  btnStand.setEnabled(false);
  btnStand.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    stay = true;
    System.out.println("faulty");
   }
  });
  btnStand.setBounds(373, 189, 130, 44);
  contentPane.add(btnStand);
  
  JButton btnNewButton = new JButton("Reset Bet");
  btnNewButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    displayBet.setText("0");
   }
  });
  btnNewButton.setBounds(226, 376, 89, 23);
  contentPane.add(btnNewButton);
  btnEnterBet = new JButton("Enter Bet");
  btnEnterBet.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
	   int x = Integer.parseInt(displayBet.getText());
	   if(x > player.money) {
		   JOptionPane.showMessageDialog(null, "You don't have enough balance to continue with this bet, choose a smaller number");
		   displayBet.setText("0");
		   
	   }
	   else if(x != 0) {
    bet += Integer.parseInt(displayBet.getText());
    le = false;
	   }
	   else {
		   JOptionPane.showMessageDialog(null, "Please enter a number greater than 0");
	   }
   }
  });
  btnEnterBet.setBounds(115, 376, 89, 23);
  contentPane.add(btnEnterBet);
 }
}
