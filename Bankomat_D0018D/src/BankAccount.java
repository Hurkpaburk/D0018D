import java.text.*;
import java.util.*;


public abstract class BankAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-02-27
	// Senast uppdaterad: 2015-02-27, Johan Bergström 
	// Beskrivning: Handle Bank Account class 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	protected int  accountNumber;
	protected double balance;
	protected String accountType;
	protected double interestRate;
	protected ArrayList<String> transactions;
	protected DateFormat  date; 

	
	// Constructor
	public BankAccount(int theAccountNumber, double theTransaction) {
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
	// Beskrivning: get the account interest
	// Inparametrar: None
	// Returvärde: Interest - balance with interest
	//------------------------------------------------------
	abstract double getInterest();
	
	//------------------------------------------------------
	// Beskrivning: deposit amount from balance
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public void deposit(double theTransaction) {
		balance = Math.round((balance + theTransaction)*100)/100d; // Update 1, Lab2
		transactions.add(getTime() + ", " + GUI.DEPOSIT + ": " + theTransaction + ", Balance: " + balance);
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
	// Beskrivning: get transaction history
	// Inparametrar: None
	// Returvärde: info - transaction history
	//------------------------------------------------------
	public String getTransactions() {

		StringBuilder info = new StringBuilder(toString()); // Stringbuilder to enable append of accounts
		for(String i: transactions) { // loop over accounts
			 info.append("\n" + i.toString()); 
		}
		info.append("\n");
		return info.toString();
	}
	
	//------------------------------------------------------
	// Beskrivning: set new transaction time stamp on last transaction
	// Inparametrar: time - New time stamp
	// Returvärde: None
	//------------------------------------------------------
	public void setTransactionTime(String time) {

		String trans = transactions.get(transactions.size()-1);
		System.out.println("Old trans: " + trans);
		String[] accInfo = trans.split(",\\s+"); // regexp to get text in array
		System.out.println(accInfo[0] + "----" + time);
		trans = trans.replace(accInfo[0], time);
		System.out.println("New trans: " + trans);
		transactions.set(transactions.size()-1, trans);
	}
		
	//------------------------------------------------------
	// Beskrivning: get the account information
	// Inparametrar: None
	// Returvärde: info - Account information
	//------------------------------------------------------
	public String toString() {
		
		String accountInfo = new String(GUI.KONTONUMMER + ": " + accountNumber + ", Saldo: " + balance + ", Kontotyp: " + accountType + ", R�ntesats: " + interestRate);
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