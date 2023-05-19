/*

Developed by: Ayush Adhikari ;
Date: 11/28/2022 ;
Updated: 12/09/2022 ;

*/

//import java.io.*;
import java.util.*;

class Book{
    String name;
    String author;
    
    // constructor
    
    public Book(String nam, String writer){
        this.name = nam;
        this.author = writer;
    }
    
    //to return content of ArrayList in desired format in list.
    
    public String toString(){
        return "BOOK:" + this.name + " AUTHOR:"+ this.author;
    }
    
}

class library{
   
   // object and array list of objects of inner stu class 
   stu obj = new stu(0,0);     //asigning id and password initially to zero
    ArrayList<stu> students = new ArrayList<stu>();     //to store students as list 
    
    // declaring ArrayList varibles to store objects of book class
    ArrayList<Book> books = new ArrayList<Book>();
    
    
    //constructor to takes ArrayList of book class initially when objects of library is created
    public library(ArrayList<Book> book){
        this.books = book;
        
    }
    
    // add students
    public void addStu(int a, int b){
        
        stu s1 = new stu(a,b);
        this.students.add(s1);
        System.out.println("student added. Id no: " + s1.id  );
       
 // System.out.println(students);
    
    }
    
    
    
    //for log in
    public int login(int a, int b){
    
    //test object
    stu s1 = new stu(a,b);    
    
    int flag = 0;                   //to check id password is correct or not
    for(stu x: students){
       if(x.id == s1.id && x.pass == s1.pass)
     { 
        obj = x;
        System.out.println("logged in");
        flag =1;
     }
    }
        return flag;
    }    
    
    
    
    
    // methods to add, return, issue, see books that takes book object

    public void addBook(Book b){
        this.books.add(b);
        System.out.println("the book had been added.");
    }
    
    public void returnBook(Book b){
        this.books.add(b);
        obj.issuedBooks.remove(b);
        System.out.println("The book " + b.name + " has been returned.");
    }
    
    public void issueBook(Book b){
        obj.issuedBooks.add(b);
        this.books.remove(b);
        System.out.println("the book " + b.name + " has been issued.");
    }
    
    public void showAvailableBooks(){
        if ( books.isEmpty() )                    // to check if list is Empty. Otherwise, it returns [] (if list is empty) which is not so cool. Right!!
         {
            System.out.println("No books are available.");
            return;
         }
        System.out.println("Available books are: ");
        //System.out.println(books);
        
        for(Book x: books)
        {
            System.out.println("Book: " + x.name +"\r\t\t\t Author: " +x.author);
        }
        
    }
    
    public void showIssuedBooks(){
         if ( obj.issuedBooks.isEmpty() )
         {
            System.out.println("No books are issued.");
            return;
         }
         System.out.println("Issued Books are: ");
       // System.out.println(obj.issuedBooks);
        
          for(Book x: obj.issuedBooks )
        {
            System.out.println("Book: " + x.name +"\r\t\t\t\t Author: " +x.author);
        }
        
    }
    
      // method override. It takes directly name of book and author. No need to create object of book.   (should i Deprecate above methods??)
      public void addBook(String b, String c){
        Book bks = new Book(b, c);      // creates object of book using constructor of book class
        this.books.add(bks);            //adds book to the list
        System.out.println("the book had been added.");
    }
    
    public void returnBook(String b, String c){
        Book bks = new Book(b,c);
    
    int flag = 0;                       // to check if books are available or not
    
    /*searching books by equating it name and author name. 
    If objects are directly checked by equals method then it returns false even if the contents are 
    same because it checks the original address of objects.Since the location of newly created objects 
    and original object are not same. thus, returns false. So we have to search by content as shown below.
    */
    int size = obj.issuedBooks.size(); // to reduce time complexity
    for(int i = 0 ; i < size; i++){
        if (obj.issuedBooks.get(i).name.equalsIgnoreCase(bks.name)){
            this.books.add(obj.issuedBooks.get(i));            
            obj.issuedBooks.remove(obj.issuedBooks.get(i));       
            flag = 1;                   //flag updates if book is found
        }
    }
        if(flag == 0) {                          
            System.out.println("No books found");
        }
        else
           System.out.println("The book " + bks.name + " has been returned.");
      
       }
    
    public void issueBook(String b, String c){
        Book bks = new Book(b,c);

//same as above method but for issued ArrayList
        int flag = 0;
        for(int i = 0 ; i < books.size(); i++){
        if (books.get(i).name.equalsIgnoreCase(bks.name)){
            obj.issuedBooks.add(books.get(i));
            this.books.remove(books.get(i));
            flag = 1;
        }
    }
        if(flag == 0) {
            System.out.println("No books found");
        }
        else
        System.out.println("the book " + bks.name + " has been issued.");
    }
    
    
    //nested class for multiple user account
    
 class stu{
     int id;
     int pass;
 ArrayList<Book> issuedBooks = new ArrayList<Book>();
    stu(int a, int b){
        this.id = a;
        this.pass = b;
    }
    
    // to return in string format in arraylist of stu's object
    
    public String toString(){
       return  "id" + this.id;
   } 
    
 }




   
}

//Main

public class Main
{
    public static void main(String[] args) {
        ArrayList<Book> bk = new ArrayList<Book>();
    
    Book b1 = new Book("core java", "oracle");
    Book b2 = new Book("advanced java", "oracle");
    
    bk.add(b1);
    bk.add(b2);
    
    library l1 = new library(bk);
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Welcome to the library.");

// loop runs Infinitly until user wishes to exit
 while(true){
     clear();
 System.out.println("\n Enter your action \n 1.Add Book \n 2.Log in \n 3.Add Student \n\n Any other key to Exit...");
 System.out.println("\n");
 System.out.println("Enter your choice here...");
 
 int choice ;
 
 // input mismatch exception handling

try{
  choice = sc.nextInt();
}catch(Exception e){
    /*System.out.println("Please enter integer value.");
    System.out.println("Press any key to exit..");
    String exit = sc.nextLine();
    exit = sc.nextLine();
    */ choice = 4;
}

//decision making 
if ( choice == 1){
         
    String bookName = sc.nextLine();         // eats the \n line 
    System.out.println("Enter name of book: ");
     bookName = sc.nextLine();
    

    System.out.println("Enter name of Author: ");
    String authorName = sc.nextLine();
    
    
    l1.addBook(bookName , authorName);
    
    System.out.println("\nPress any key to return .");
    sc.nextLine(); 
      
}
else if (choice == 2){
    int id, pass;
            System.out.println("Enter log in ID:");
            id = sc.nextInt();
            
             System.out.println("Enter log in Password:");
            pass = sc.nextInt();
        
            int flag = l1.login(id,pass);
            if (flag == 1){
                
             First:
                while(true){
                    
                //user defined function to clear screen    
                clear();
                
                
                System.out.println("MENU \n 1.Available Books \n 2.Issue Book \n 3.Return Book \n 4.Issued Books \n 5.Log out");
               
               int choicee;
               
                // input mismatch exception handling

                try{
                  choicee = sc.nextInt();
                }catch(Exception e){
                  System.out.println("Please enter integer value.");
                  System.out.println("Press any key to log out..");
                  String exit = sc.nextLine();
                  exit = sc.nextLine();
                  choicee = 5;
                }  
               
               
               
               
                switch( choicee )
                 {
 
                    case 1:
                   {
                      l1.showAvailableBooks();
    
                      System.out.println("\nPress any key to return .");
                      
                      sc.nextLine();
                      break;
                    }
                   case 2:
                    {
                      String bookName;
                       String authorName;
  
                      bookName = sc.nextLine();
                       System.out.println("Enter name of book: ");
                      bookName = sc.nextLine();
                      System.out.println("Enter name of Author: ");
                      authorName = sc.nextLine();
    
                      l1.issueBook( bookName, authorName);
    
                      System.out.println("\nPress any key to return .");
                       sc.nextLine();
    
                        break;
                    }
                    case 3:
                    {
                      String bookName;
                      String authorName;
  
                      bookName = sc.nextLine();
                      System.out.println("Enter name of book: ");
                      bookName = sc.nextLine();
    
                      System.out.println("Enter name of Author: ");
                      authorName = sc.nextLine();
    
                      l1.returnBook(bookName , authorName);
  
                      System.out.println("\nPress any key to return .");
                     sc.nextLine();
  
                        break;
                    }
                    case 4:
                    {
                      l1.showIssuedBooks();
    
                      System.out.println("\nPress any key to return .");
                     sc.nextLine();
                      
    
                      break;
                    }
                    case 5:
                    {
            
                        break First;
            
                    }
 
                    default:
                    {
                      System.out.println(" Invalid choice. ");
    
                      System.out.println("Press any key to return .");
                      sc.nextLine();
    
                    }
                }
                
            }
                
            }
            else{
             System.out.println("Log in unsucessfull");
             System.out.println("\nPress any key to return .");
              sc.nextLine();
            }
            
                
            
            }

            else if (choice == 3)
            {
             int id, pass;
             System.out.println("Enter student ID:");
             id = sc.nextInt();
              
             System.out.println("Enter Password:");
             pass = sc.nextInt();
             
             l1.addStu(id,pass);
             
            
             System.out.println("\nPress any key to return .");
              sc.nextLine();
            }
            else
              {
                   System.out.println(" Thank you!!");
                   System.exit(0); 
              }


        }
    }


//function to clear screen
public static void clear()
    {
     System.out.print("\033[H\033[2J");
      System.out.flush();
    }

}
