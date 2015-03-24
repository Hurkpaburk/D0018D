import java.util.*;

public class Customer {
	//****************************************************************** 
	// Programmerare: Johan Bergstrˆm, johbef-4@student.ltu.se
	// Datum: 2015-02-27
	// Senast uppdaterad: 2015-02-27, Johan Bergstr√∂m 
	// Beskrivning: Handle Account information class 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private String name;
	private long personnummer;
	private ArrayList<BankAccount> account; // Update 1, Lab2
	
	
	// Constructor
	public Customer(String theName, long thePersonnummer) {
		  name = theName;
		  personnummer = thePersonnummer;
		  account = new ArrayList<BankAccount>();
	}	
	
	// Default Constructor
	public Customer() {
		  name = "John Doe";
		  personnummer = 0000000000L;
		  account = new ArrayList<BankAccount>();
	}
	
	// Methods
	// Public Methods
	
	//------------------------------------------------------
	// Beskrivning: ADDED FOR LAB 3: Get all Customer Accounts
	// Inparametrar: None
	// Returv√§rde: ArrayList with Accounts 
	//------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public ArrayList<BankAccount> getAccounts()
	{
		return (ArrayList<BankAccount>) account.clone();
	}
	
	
	//------------------------------------------------------
	// Beskrivning: Add account 
	// Inparametrar: theAccountNumber - New account number, theAccountType - Account Type, theTransaction - Initial deposit
	// Returv‰rde: theAccountNumber - Account Number, -1 if not created
	//------------------------------------------------------
	
	public int addAccount(int theAccountNumber, String theAccountType, int theTransaction) {
		BankAccount tempAccount = existAccountNumber(theAccountNumber);
		if(tempAccount != null) { // Check if account exists
			return -1;
		}
		else if(theAccountType == "Sparkonto") { // Account does not exist, create new Sparkonto
			account.add(new SavingsAccount(theAccountNumber, theTransaction));
			return theAccountNumber;
		}
		else if (theAccountType == "Kreditkonto") { // Account does not exist, create new Kreditkonto
			account.add(new CreditAccount(theAccountNumber, theTransaction));
			return theAccountNumber;
		}
		else { 
			return -1;
		}
	}

	//------------------------------------------------------
	// Beskrivning: Remove specific account
	// Inparametrar: theAccount - Account to be removed
	// Returv√§rde: None
	//------------------------------------------------------
	public void removeAccount(BankAccount theAccount) {
		account.remove(theAccount);
	}

	//------------------------------------------------------
	// Beskrivning: Get account information as a string
	// Inparametrar: theAccountNumber - Account number
	// Returv‰rde: Account Information
	//------------------------------------------------------
	public String getAccountInfo(int theAccountNumber){
		BankAccount theAccount = existAccountNumber(theAccountNumber);
		if(theAccount != null) { // Check if count exists
			return theAccount.toString(); 
		}
		else {
			return new String("No matching Account for Customer!");
		}
	}
	
	//------------------------------------------------------
	// Beskrivning: Get the account object
	// Inparametrar: theAccountNumber - New account number
	// Returv‰rde: savingsAccount - Account object
	//------------------------------------------------------
	public BankAccount getAccount(int theAccountNumber){
		BankAccount theAccount = existAccountNumber(theAccountNumber);
		if(theAccount != null) { // Check if account exists
			return theAccount;
		}
		else {
			return null;
		}
	}

	//------------------------------------------------------
	// Beskrivning: Get the customer name 
	// Inparametrar: None
	// Returv‰rde: Customer name
	//------------------------------------------------------	
	public String getCustomerName(){
		String info = new String(name);
		return info;
	}
	
	//------------------------------------------------------
	// Beskrivning: Get the customer personnummer 
	// Inparametrar: None
	// Returv‰rde: Customer personnummer
	//------------------------------------------------------		
	public long getCustomerPn(){
		return personnummer;
	}
	
	//------------------------------------------------------
	// Beskrivning: Get the customer information, name, personummer and accounts
	// Inparametrar: None
	// Returv‰rde: Customer Information
	//------------------------------------------------------	
	public String toString(){
		String customerInfo = new String(personnummer + ", " + name + "; ");
		StringBuilder info = new StringBuilder(customerInfo); // Stringbuilder to enable append of accounts
		for(BankAccount i: account) { // loop over accounts
			 info.append("\n" + i.toString()); 
		}
		info.append("\n");
		return info.toString();
	}

	//------------------------------------------------------
	// Beskrivning: Sets customer name 
	// Inparametrar: name - New name of the customer
	// Returv‰rde: None
	//------------------------------------------------------	
	public void setCustomerName(String name){
		this.name = name;
	}


	// Private Methods

	//------------------------------------------------------
	// Beskrivning: Check is account number exists
	// Inparametrar: theAccountNumber - Account number
	// Returv‰rde: Account number object
	//------------------------------------------------------	
	private BankAccount existAccountNumber(int theAccountNumber) {
		for(BankAccount i: account) { // Go over list with accounts
			if(theAccountNumber == i.getAccountNumber()) { 
				return i; // return object
			}
		}
		return null;
	}
}
