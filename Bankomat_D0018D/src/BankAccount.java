import java.text.*;
import java.util.*;


public abstract class BankAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-02-18
	// Senast uppdaterad: 2015-02-18, Johan Bergström 
	// Beskrivning: Handle Bank Account class 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	protected int  accountNumber;
	protected double balance;
	protected String accountType;
	protected double interestRate;
	protected static ArrayList<String> transactions;
	protected DateFormat  date; 

	
	// Constructor
	public BankAccount(int theAccountNumber, int theTransaction) {
		  accountNumber = theAccountNumber;
		  accountType = "Default";
		  balance = balance + theTransaction;
		  transactions = new ArrayList<String>();
	}	
	
	// Default Constructor
	public BankAccount() {
		  accountNumber = 0000;
		  accountType = "Default";
		  balance = 0;
		  transactions = new ArrayList<String>();
	}
	
	// Public methods
	
	//------------------------------------------------------
	// Beskrivning: Withdraw amount from balance 
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	abstract boolean withdraw(double theTransaction);
	
	//------------------------------------------------------
	// Beskrivning: deposit amount from balance
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public void deposit(double theTransaction) {
		balance = balance + theTransaction;
		transactions.add(getTime() + ", Deposit: " + theTransaction + ", Balance: " + balance);
	}
	
	//------------------------------------------------------
	// Beskrivning: get the account balance
	// Inparametrar: None
	// Returvärde: balance - Account balance
	//------------------------------------------------------
	public double getBalance() {
		return balance;
	}
	
	//------------------------------------------------------
	// Beskrivning: get the account number
	// Inparametrar: None
	// Returvärde: accountNumber - Account number
	//------------------------------------------------------
	public int getAccountNumber() {
		return accountNumber;
	}
	
	//------------------------------------------------------
	// Beskrivning: get the account interest
	// Inparametrar: None
	// Returvärde: Interest - balance with interest
	//------------------------------------------------------
	public double getInterest() {
		return balance*(interestRate/100);
	}
	
	//------------------------------------------------------
	// Beskrivning: get transaction history
	// Inparametrar: None
	// Returvärde: info - transaction history
	//------------------------------------------------------
	public String getTransactions() {

		String accountInfo = new String();
		StringBuilder info = new StringBuilder(toString()); // Stringbuilder to enable append of accounts
		for(String i: transactions) { // loop over accounts
			 info.append("\n" + i.toString()); 
		}
		info.append("\n");
		return info.toString();
	}
	
	//------------------------------------------------------
	// Beskrivning: get account type
	// Inparametrar: None
	// Returvärde: info - account type
	//------------------------------------------------------
	public String getaccountType() {

		String accountInfo = new String(accountType);
		return accountInfo;
	}
	
	//------------------------------------------------------
	// Beskrivning: get the account information
	// Inparametrar: None
	// Returvärde: info - Account information
	//------------------------------------------------------
	public String toString() {
		
		String accountInfo = new String("Kontonummer: " + accountNumber + ", Saldo: " + balance + ", Kontotyp: " + accountType + ", R�ntesats: " + interestRate);
		return accountInfo;
	}	


	// Protected methods
	//------------------------------------------------------
	// Beskrivning: Get date and time
	// Inparametrar: None
	// Returvärde: time - Date and time
	//------------------------------------------------------
	protected String getTime() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY HH:mm:ss");   
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}
}