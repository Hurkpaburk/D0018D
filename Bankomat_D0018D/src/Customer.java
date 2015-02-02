import java.math.*;
import java.util.*;

public class Customer {
	//****************************************************************** 
	// Programmerare: Johan Bergstr�m, johbef-4@student.ltu.se
	// Datum: 2015-01-29
	// Senast uppdaterad: 2015-01-29, Johan Bergstr�m 
	// Beskrivning: Present Account information 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private String name;
	private String personnummer;
	private ArrayList<SavingsAccount> account;
	
	// Constructor
	public Customer(String theName, String thePersonnummer) {
		  name = theName;
		  personnummer = thePersonnummer;
		  account = new ArrayList<SavingsAccount>();
	}	
	
	
	public Customer() {
		  name = "John Doe";
		  personnummer = "000000-0000";
		  account = new ArrayList<SavingsAccount>();
	}
	
	// Methods
	// Public Methods
	
	//------------------------------------------------------
	// Beskrivning: Main function will take user input and decide 
	// if calculate string (menu function) or exit program shall be done.
	// Inparametrar: None 
	// Returv�rde: None
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

	public StringBuilder getCustomerInfo(){
		String temp = new String(personnummer + ", " + name + ", ");
		StringBuilder info = new StringBuilder(temp);
		for(SavingsAccount i: account) {
			 info.append(i.getAccountInfo() + ", ");
		}
	return info;
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
