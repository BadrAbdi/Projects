/*
 * PrintWriter pr = new PrintWriter(new File())
 * pr.close;
 */




import java.util.*;
import java.io.*;
//class for adress Book
public class AdressBook{
	//arraylist to contain object of people
  static ArrayList<Person> book;
 // static addFile add;
  //static readFile read;
  //runner method
  public static void main(String[]args) throws Exception{
	  //book arraylist made
    book = new ArrayList<Person>();
    //scanner
    Scanner sc = new Scanner(System.in);
    //class created to add new people to adress book
    addFile add = new addFile();
    //class to readfile
    readFile read = new readFile();
    //current file that is selected
    String file = null;
    //runner for the while loop
    while(true){
      run();
      int a = sc.nextInt();
      sc.nextLine();
      //if theoption is 1 it will let them choose file
      if(a == 1){
        boolean quit = false;
        
        do{
          try{
            options();
            //sets file to the chosen one
            int num = sc.nextInt();
            if(num == 1) file = "ad1";
            else if(num == 2) file = "ad2";
            else if(num == 3) file = "ad3";
            else if(num == 4) file = "ad4";
            read.read(file);
            book = read.listPeople();
          }catch(Exception e){
            quit = true;
          }
        }while(quit);
        
        
      }
      
      else if(a == 2){
        save(file,add);
        file = null;
      }
      //validates peoples name number email
      else if(a == 3){
        if(file !=null){
          System.out.println();
          String[] name;
          boolean validate = false;
          do{
          System.out.println("Please Enter the First and Last Name");
          name = sc.nextLine().split(" ");
          try{
            if(!name[0].matches(".*\\d+.*") && !
                 name[1].matches(".*\\d+.*") && name.length ==2 && name[0].length()>=1 && name[1].length() >=1)
              validate = true;
          }catch(Exception e){};
          }while(!validate);
          validate = false;
          String adress[];
          boolean pass;
          do{
          System.out.println("Please Enter the Adress");
          adress = sc.nextLine().split(" ");
          try{
            Integer.parseInt(adress[0]);
            pass = true;
          }catch( Exception e){
            pass = false;
          }
          try{
            if(!adress[1].matches(".*\\d+.*") && !adress[2].matches(".*\\d+.*") && adress.length ==3)
              validate = true;
          }catch(Exception e){
            
          }
         // System.out.println(pass + " "+validate + " " +!adress[1].matches(".*\\d+.*") + " " +!adress[1].matches(".*\\d+.*") + " " + adress.length);
          }while(!validate || !pass);
          pass = false;
          String number;
          validate = false;
          do{
          System.out.println("Please Enter the Phone Number");
          number = sc.nextLine();
          try{
            Integer.parseInt(number);
            pass = true;
          }catch(Exception e){
            pass = false;
          }
          }while(!pass);
          pass = false;
          String email;
          do{
          System.out.println("Please Enter the email");
          email = sc.nextLine();
          if(!email.startsWith("@") && !email.endsWith("@.com") && email.endsWith(".com") || email.endsWith(".ca") && email.contains("@"))
            pass = true;
          else pass = false;
          }while(!pass);
          book.add(new Person(name[0],name[1],adress[0] +" "+ adress[1] + " "+adress[2],number,email));
          System.out.println();
        }
        else System.out.println("\nPlease Select an Adress Book");
      }
      //if there is no people in the adress book it will give a prompt
      else if(a == 5){
        if(book.size() == 0){
          System.out.println("\nThere are no entries");
        }
        else{
          boolean quit = false;
          do{
            try{
            System.out.println("\nSelect what index you need to edit");
            int ind =sc.nextInt();
            ind--;
            System.out.println("Select what you want to edit");
            System.out.println("1)First name\n2)Last name\n3)Adress\n4)Phone Number\n5)Email");
            int n = sc.nextInt();
            if(n == 1){
              Person old = book.get(ind);
              System.out.println("Enter a ew Name");
              sc.nextLine();
              String d = sc.nextLine();
              Person ad = new Person(d,old.getLast(),old.getAdress(),old.getNumber(),old.getEmail());
              book.set(ind,ad);
            }
            else if(n == 2){
              Person old = book.get(ind);
              Person ad = new Person(old.getFirst(),sc.nextLine(),old.getAdress(),old.getNumber(),old.getEmail());
              book.set(ind,ad);
            }
            else if(n == 3){
              Person old = book.get(ind);
              Person ad = new Person(old.getFirst(),old.getLast(),sc.nextLine(),old.getNumber(),old.getEmail());
              book.set(ind,ad);
            }
            else if(n == 4){
              Person old = book.get(ind);
              Person ad = new Person(old.getFirst(),old.getLast(),old.getAdress(),sc.nextLine(),old.getEmail());
              book.set(ind,ad);
            }
            else if(n == 5){
              Person old = book.get(ind);
              Person ad = new Person(old.getFirst(),old.getLast(),old.getAdress(),old.getNumber(),sc.nextLine());
              book.set(ind,ad);
            }
            else Integer.parseInt("throwsError");
            quit = false;
            }catch(Exception e){
              quit = true;
            }
          }while(quit);
        } 
      }
      /*else if(a == 6){
       boolean d = true;
       while(d) {
       System.out.println("Pease Enter The number the Corresponds With what you want to sort: ");
       System.out.println("1)First name\n2)Last name\n3)Adress\n4)Phone Number\n5)Email");
       try {
       int num = sc.nextInt();
       sort(num);
       d = false;
       }
       catch(Exception e) {
       };
       } 
       }*/
      
      //if they chose 4 it will remove their option
      else if(a ==4){
        if(file == null){
          System.out.println("\nPlease Select a file");
        }
        else{
          if(book.size() == 0){
            System.out.println("\nThere are no entries to remove");
          }
          else{
            while(true ) {
              System.out.println();
              System.out.println("Choose which entry number to remove");
              boolean as = false;
              try {
                int j = sc.nextInt();
                book.remove(j-1);
                as = true;
              }
              catch(Exception e) {};
              break;
            }
          }
        }
      }
      
      //it searches and traverses through the objects for the one they want to search
      else if(a == 7){
        System.out.println("\nChoose What to Search for");
        System.out.println("1)First name\n2)Last name\n3)Adress\n4)Phone Number\n5)Email");
        int num = sc.nextInt();
        //  sc.nextLine();
        System.out.println("What do you want to search with");
        sc.nextLine();
        String s = sc.nextLine();
        int i = 0;
        if(num == 1){
          boolean exist = false;
          for(Person n : book){
            if(n.getFirst().equals(s)){
              System.out.println((i+1) +") " + n.toString());
              exist = true;
            }
          i++;
          }
          if(!exist){
            System.out.println(book.size() + " " + book.get(0));
            System.out.println("Does Not Exist");
          }
        }
        else if(num == 2){
          for(Person n : book){
            if(n.getLast() == s)
              System.out.println(i +") " + n.toString());
            i++;
          }
        }
        else if(num == 3){
          for(Person n : book){
            if(n.getAdress() == s)
              System.out.println(i +") " + n.toString());
            i++;
          }
        }
        else if(num == 4){
          for(Person n : book){
            if(n.getNumber() == s)
              System.out.println(i +") " + n.toString());
            i++;
          }
        }
        else if(num == 5){
          for(Person n : book){
            if(n.getEmail() == s)
              System.out.println(i +") " + n.toString());
            i++;
          }
        }
        
      }
      //it outputs all people
      else if(a ==8) {
        System.out.println();
        read.read(file);
        ArrayList<Person> ppp = read.listPeople();
        int i = 1;
        for(Person s : ppp) {
          System.out.println(i +") " + s);
          i++;
        }
        System.out.println(ppp.size());
        System.out.println();
      }
      //allows user to leave the program and save 
      else if(a == 9){
        System.out.println("\nAre you sure want to quit without saving? (Y/N)");
        String k = sc.nextLine();
        if(k.equals("Y")){
          System.exit(0);
        }
        else if(k.equals("N")){
          save(file,add);
        }
      }
      
      
    }
  }
  //outputs all options
  public static void run(){
    System.out.println("Please Chose From the Options: ");
    System.out.println("1) Load from file"); //X
    System.out.println("2) Save to file");   //X
    System.out.println("3) Add an entry");   //X
    System.out.println("4) Remove an entry");  //X
    System.out.println("5) Edit an existing entry"); //X
    System.out.println("6) Sort the address book");//X
    System.out.println("7) Search for a specific entry");  //X
    System.out.println("8) Show Adress Book");  //X
    System.out.println("9) Quit"); //X
  }
  //saves
  public static void save(String file, addFile add)throws Exception{
    if(file!=null){ 
      for(Person pops: book){
        add.add(pops,file);
      }
    }
    else System.out.println("\nPlease Choose an Adress Book First\n");
  }
  public static void options(){
    System.out.println();
    System.out.println("Choose from the following Adress Book");
    System.out.println("1) Adress Book 1");
    System.out.println("2) Adress Book 2");
    System.out.println("3) Adress Book 3");
    System.out.println("4) Adress Book 4");
  }
  //sorts with the thing that is chosen to be sorted with
  public static void sort(int x) {
    
    if(x == 1) {
      book.sort(Comparator.comparing(Person::getFirst));
    }
    else if(x == 2) {
      book.sort(Comparator.comparing(Person::getLast));
    }
    else if(x == 3) {
      book.sort(Comparator.comparing(Person::getAdress));
    }
    else if(x == 4) {
      book.sort(Comparator.comparing(Person::getNumber));
    }
    else if(x == 5) {
      book.sort(Comparator.comparing(Person::getEmail));
    }
    
  }
  
}
//class to write to file
class addFile{
  public addFile(){
  }
  public void add(Person per,String files)throws Exception{
    String name = files; 
    String location = name + ".txt/";
    File file = new File(location); 
    
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(files,true))){
      //;
      bw.write(per.toString());
      bw.newLine(); 
      bw.close();
    } catch (Exception e) { 
      e.printStackTrace();
    }
  }
}
//class to read file
class readFile{
  ArrayList<Person> people;
  ArrayList<String> filess;
  public readFile(){
    people = new ArrayList<Person>();
  }
  public void read(String files)throws Exception{
    String name = files; 
    String location = name + ".txt/";
    File file = new File(location); 
    
    try (BufferedReader br = new BufferedReader(new FileReader(files))) {
      //;
      String line;
      while((line = br.readLine())!=null) {
        String pers[] = line.split(" ");
        people.add(new Person(pers[0],pers[1],pers[2] + " "+pers[3] +" "+pers[4],pers[5],pers[6]));
      }
      br.close();
    }
    catch (Exception e) {
      e.printStackTrace();
      
    }
    
    PrintWriter pr = new PrintWriter(new File(files));
    pr.close();
  }
  
  public ArrayList listPeople(){
    return people;
  }
  public ArrayList listFiles(){
    return filess;
  }
}
//person class with their info
class Person{
  private String fName;
  private String lName;
  private String adress;
  private String phoneNumber;
  private String email;
  public Person(String fName,String lName,String adress,String phoneNumber,String email){
    this.fName = fName;
    this.lName = lName;
    this.adress = adress;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }
  public String getFirst(){
    return fName;
  }
  public String getLast(){
    return lName;
  }
  public String getAdress(){
    return adress;
  }
  public String getNumber(){
    return phoneNumber;
  }
  public String getEmail(){
    return email;
  }
  
  public String setFirst(){
    return fName;
  }
  public String setLast(){
    return lName;
  }
  public String setAdress(){
    return adress;
  }
  public String setNumber(){
    return phoneNumber;
  }
  public String setEmail(){
    return email;
  }
  @Override
  public String toString(){
    return fName + " "+ lName+ " "+ adress + " "+phoneNumber+ " "+email;
  }
  
}