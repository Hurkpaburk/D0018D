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
	
	
	
	//------------------------------------------------------
	// Beskrivning: Main function will take user input and decide 
	// if calculate string (menu function) or exit program shall be done.
	// Inparametrar: None 
	// Returvärde: None
	//------------------------------------------------------
	public void addAccount(int theAccountNumber, String theAccountType, int theTransaction) {
		account.add(new SavingsAccount(theAccountNumber, theAccountType, theTransaction));
	}
	
	public void removeAccount(SavingsAccount theAccount) {
		account.remove(theAccount);
	}

	public StringBuilder getCustomerInfo(){
		String temp = new String(personnummer + ", " + name + ", ");
		StringBuilder info = new StringBuilder(temp);
		for(int i = 0; i<account.size();i++) {
			 info.append(account.get(i).getAccountInfo() + ", ");
		}
	return info;
	}
}

