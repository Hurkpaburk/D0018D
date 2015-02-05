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
	private ArrayList<SavingsAccount> account; // Static to share between all instances of Customer to avoid duplicate account number
	
	
	// Constructor
	public Customer(String theName, long thePersonnummer) {
		  name = theName;
		  personnummer = thePersonnummer;
		  account = new ArrayList<SavingsAccount>();
	}	
	
	// Default Constructor
	public Customer() {
		  name = "John Doe";
		  personnummer = 0000000000L;
		  account = new ArrayList<SavingsAccount>();
	}
	
	// Methods
	// Public Methods
	
	//------------------------------------------------------
	// Beskrivning: Add account 
	// Inparametrar: theAccountNumber - New account number, theAccountType - Account Type, theTransaction - Initial deposit
	// Returvärde: None
	//------------------------------------------------------
	public int addAccount(int theAccountNumber, String theAccountType, int theTransaction) {
		SavingsAccount tempAccount = existAccountNumber(theAccountNumber);
		if(tempAccount != null) {
			return -1;
		}
		else {
			account.add(new SavingsAccount(theAccountNumber, theAccountType, theTransaction));
			return theAccountNumber;
		}
	}

	//------------------------------------------------------
	// Beskrivning: Remove specific account
	// Inparametrar: theAccount - Account to be removed
	// ReturvÃ¤rde: None
	//------------------------------------------------------
	public void removeAccount(SavingsAccount theAccount) {
		account.remove(theAccount);
	}
	
	public String getAccountInfo(int theAccountNumber){
		SavingsAccount theAccount = existAccountNumber(theAccountNumber);
		if(theAccount != null) {
			return theAccount.toString();
		}
		else {
			return null;
		}
	}
	
	public SavingsAccount getAccount(int theAccountNumber){
		SavingsAccount theAccount = existAccountNumber(theAccountNumber);
		if(theAccount != null) {
			return theAccount;
		}
		else {
			return null;
		}
	}

	
	public String getCustomerName(){
		String info = new String(name);
		return info;
	}
	
	public long getCustomerPn(){
		return personnummer;
	}
	
	public String toString(){
		String customerInfo = new String(personnummer + ", " + name + "; ");
		StringBuilder info = new StringBuilder(customerInfo);
		for(SavingsAccount i: account) {
			 info.append("\n" + i.toString());
		}
		info.append("\n");
		return info.toString();
	}

	public void setCustomerName(String name){
		this.name = name;
	}


	// Private Methods

	private SavingsAccount existAccountNumber(int theAccountNumber) {
		for(SavingsAccount i: account) {
			if(theAccountNumber == i.getAccountNumber()) {
				return i;
			}
		}
		return null;
	}
}
