import java.math.*;
import java.util.*;

public class Customer {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-01-29
	// Senast uppdaterad: 2015-01-29, Johan Bergström 
	// Beskrivning: Present Account information 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private String name;
	private long personnummer;
	private static ArrayList<SavingsAccount> account;
	
	// Constructor
	public Customer(String theName, long thePersonnummer) {
		  name = theName;
		  personnummer = thePersonnummer;
		  account = new ArrayList<SavingsAccount>();
	}	
	
	
	public Customer() {
		  name = "John Doe";
		  personnummer = 0000000000;
		  account = new ArrayList<SavingsAccount>();
	}
	
	// Methods
	// Public Methods
	
	//------------------------------------------------------
	// Beskrivning: Main function will take user input and decide 
	// if calculate string (menu function) or exit program shall be done.
	// Inparametrar: None 
	// Returvärde: None
	//------------------------------------------------------
	public void addAccount(int theAccountNumber, String theAccountType, int theTransaction) {
		if(existAccountNumber(theAccountNumber)) {
			System.out.println("Account number: " + theAccountNumber + " exists!\n"
					+ "No new Account Created");
		}
		else {
			account.add(new SavingsAccount(theAccountNumber, theAccountType, theTransaction));
		}
	}

	public void removeAccount(SavingsAccount theAccount) {
		account.remove(theAccount);
	}

	public String getCustomerName(){
		String info = new String(name);
		return info;
	}
	
	public long getCustomerPn(){
		return personnummer;
	}
	
	public String getCustomerInfo(){
		String temp = new String(personnummer + ", " + name + ", ");
		StringBuilder info = new StringBuilder(temp);
		for(SavingsAccount i: account) {
			 info.append("\n" + i.getAccountInfo()+ ";");
		}
	return info.toString();
	}
	
	
	
	
	// Private Methods

	private boolean existAccountNumber(int theAccountNumber) {
		boolean temp = false;
		for(SavingsAccount i: account) {
			if(theAccountNumber == i.getAccountNumber()) {
				temp = true;
				break;
			}
		}
		return temp;
	}
}
