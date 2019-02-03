import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class AssEx1 {

	public static void main(String[] args) {
		enterCustomer();	//do the enterCustomer() method
	}
	
	public static void enterCustomer() {
		//create a new customer account, the user enters the name of a customer
		System.out.println("Customer name:");
		Scanner s1 = new Scanner(System.in);
		String custname = s1.nextLine();
		CustomerAccount customerone = new CustomerAccount(custname);
		
		/*the user enters the initial balance
		 * Positive balances mean that the customer owes money to the merchant
		 * negative means the merchant owes money to the customer
		 * convert the balance into an int*/
		System.out.println("Customer balance:");
		double custbalance = s1.nextDouble();
		int custbalance1 = (int)(custbalance*100);
		customerone.setBalance(custbalance1);

		//display customerone's account information
		System.out.println("Welcome "+customerone);
		
		//store the initial balance into a String
		String content1 = customerone.getCustomerName()+". Your balance is "+customerone.balanceFormat(custbalance1);
		//call the enterWine method
		enterWine(customerone,content1);

	}
	
	public static void enterWine(CustomerAccount cusone, String content1) {
		String winename;
		Scanner s2 = new Scanner(System.in);
		String wineline = "";

		//loop indefinitely so the user could enter a wine name, quantity and price
		while(true){
			System.out.println("Please enter wine name:");
			 winename = s2.nextLine();
			 //if the wine name is blank, the loop is terminated
			 if(winename.equals("")) {
				 break;
			 }
			 //store the quantity and unit price
			System.out.println("Please enter number (-ve for returns)");
			int ncount = s2.nextInt();
			 
			System.out.println("Please enter price per bottle");
			double wprice = s2.nextDouble();
			int wprice1 = (int)(100*wprice);//store the unit price as an int
					
			//a new wine has been created
			Wine wine1 = new Wine(winename,ncount,wprice1);	
			//count the total cost of the wine (as an int), check the user wants to buy a wine or return it
			int winemoney = wine1.countWineMoney(wprice1);
			//update the balance 
			cusone.setBalance(winemoney);
			//store the wine into a String
			wineline += wine1.toString()+", new balance = "+cusone.balanceFormat(cusone.getBalance())+'\n';
			
			//display customerone's account
			System.out.println(cusone);
			s2.nextLine();
			//call the fileWriter method
			writeFile(content1,wineline);
		}
	}
	
	public static void writeFile(String cusone, String wl) {
		/*use exception for the file writer
		 * a summary of the customer's account and wines could be stored in a new file
		 * the new file's name is "statement.txt"
		 * close the file at the end of the program
		 */
		try {
			String content = "";
			FileWriter statement = new FileWriter("statement.txt");
			content = cusone+'\n'+wl;	//display the customer's account and wines that he/she bought or returned.
			statement.write(content);
			statement.flush();
			statement.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
