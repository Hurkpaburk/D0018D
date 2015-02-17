
public class CreditAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-02-18
	// Senast uppdaterad: 2015-02-18, Johan Bergström 
	// Beskrivning: Handle Credit Account class 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private int  accountNumber;
	private double balance;
	private String accountType;
	private static final double interestRate = 2;
	
	// Constructor
	public CreditAccount(int theAccountNumber, String theAccountType, int theTransaction) {
		  accountNumber = theAccountNumber;
		  accountType = theAccountType;
		  balance = balance + theTransaction;
	}	
	
	// Default Constructor
	public CreditAccount() {
		  accountNumber = 0000;
		  accountType = "Sparkonto";
		  balance = 0;
	}
	
	// Public methods
	
	//------------------------------------------------------
	// Beskrivning: Withdraw amount from balance 
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public void withdraw(double theTransaction) {
		balance = balance - theTransaction;
	}
	
	//------------------------------------------------------
	// Beskrivning: deposit amount from balance
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public void deposit(double theTransaction) {
		balance = balance + theTransaction;
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
	// Beskrivning: get the account information
	// Inparametrar: None
	// Returvärde: info - Account information
	//------------------------------------------------------
	public String toString(){
		
		String accountInfo = new String(accountNumber + ", " + balance + ", " + accountType + ", " + interestRate);
		return accountInfo;
	}
}
	
