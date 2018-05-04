import java.util.Scanner;
class Test{

public static void main(String args[]){
 Scanner userInput=new Scanner(System.in);
 
 orange userObj=new orange();
 
 System.out.println("Enter Your Name : ");
 
 String userName=userInput.nextLine();
 
 userObj.subMethod(userName);


}
}
