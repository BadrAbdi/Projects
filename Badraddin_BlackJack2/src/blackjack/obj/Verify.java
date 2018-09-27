package blackjack.obj;
import java.io.*;
import java.net.URL;

//import blackjack.utility.*;
public class Verify {
 //file reader to check if the account is in the text file
 private boolean check;
 private String user;
 private String pass;
 public Verify(String user,String pass) throws Exception {
  this.user = user;
  this.pass = pass;
  try {
   //gets location of the textfile
   URL url = Verify.class.getClassLoader().getResource("blackjack/utility/info.txt");
   url.openStream();
  // url.openConnection(null);
   //bufferereader to check if the user and pass is in the file
   BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("blackjack/utility/info.txt")));
   //checkss if user and pass is in the textfile
   String line;
   while((line = br.readLine())!=null) {
    if(line.contains(user +" "+pass)){
     check = true;
    }
   }
   br.close();
  }
  catch (Exception e) {
   e.printStackTrace();
   check = false;
  }
  
  
 }
 public boolean isCheck() {
  return check;
 }
 
 //public static void main(String[]args) throws Exception {
  //Verify very = new Verify("user","pass");
  //System.out.println(very.isCheck());
 //}
}
