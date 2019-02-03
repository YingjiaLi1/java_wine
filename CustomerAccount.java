
public class CustomerAccount {
	//two attributes: customername, balance
	private String customername;
	private int balance;
	
	public CustomerAccount(String entername) {
	//a contructor
		customername = entername;
		balance = 0;
	}
	
	public String getCustomerName() {
		return customername;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int money) {
		//a  method that can accumulate the balance
		balance += money;
	}
	
	public String balanceFormat(int balance) {
		//convert the balance from int to double
		double dbalance = (double)balance/100;	
		//2 digits after the decimal point
		String balanceformat = String.format("%.2f", dbalance);
		//display the pounds symbol after the sign
		if(dbalance<0) {
			balanceformat = "-£"+(-dbalance);
		}else {
			balanceformat = "£"+dbalance;
		}
		return balanceformat;
	}
	
	public String toString() {
		//a toString method to display a customer account
		return customername+". Your balance is "+balanceFormat(balance);
	}
}
