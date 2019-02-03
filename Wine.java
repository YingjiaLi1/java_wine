
public class Wine {
	//four attributes: winename, amount, price, winemoney
	private String winename;
	private int amount;
	private int price;
	private int winemoney;
	
	public Wine(String wname,int nwine,int wprice) {
		//a constructor
		winename = wname;
		amount = nwine;
		price = wprice;
	}
	
	public String getWineName() {
		return winename;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setWineName(String wn) {
		winename = wn;
	}
	
	public void setAmount(int nw) {
		amount = nw;
	}
	
	public void setPrice(int wp) {
		price = wp;
	}
	
	public int countWineMoney(int wprice1) {
		/*check if the customer wants to buy a wine or return a wine
		 * if the customer wants to buy a wine, the quantity(amount) is positive
		 * the total cost is the unit price times amount
		 * if the customer wants to return a wine, the quantity(amount) is negative
		 * the customer gets back 80% of the total price
		 * and the total cost is the unit price times amount times 80%*/
		
		if(amount<0) {
			winemoney = (int) (((wprice1*amount))*0.8);
			
		}else {
			winemoney = (wprice1*amount);
		}
		return winemoney;
	}
	
	public String winemoneyFormat(int  winemoney) {
		//convert winemoney from int to double
		double dmoney = (double) winemoney/100;
		//2 digits after the decimal point
		String winemoneyformat = String.format("%.2f", dmoney);
		//display the pounds symbol after the sign
		if(dmoney<0) {
			winemoneyformat = "-£"+(-dmoney);
		}else {
			winemoneyformat = "£"+dmoney;
		}
		return winemoneyformat;
	}
	
	public String toString() {
		//a toString method to display a wine
		return winename+" ("+winemoneyFormat(price)+"), "
	+amount+" units, total cost = "+winemoneyFormat(winemoney);
	}
}
