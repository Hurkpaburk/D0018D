
public class SavingsAccount extends BankAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-02-05
	// Senast uppdaterad: 2015-02-05, Johan Bergström 
	// Beskrivning: Handle Savings Account class 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private int numWithdraws;
	
	// Constructor
	public SavingsAccount(int theAccountNumber, int theTransaction) {
		  super(theAccountNumber, theTransaction);
		  accountType = "Sparkonto";
		  numWithdraws = 0;
	}	
	
	// Default Constructor
	public SavingsAccount() {
		 super();
		 accountType = "Sparkonto";
		 numWithdraws = 0;
	}
	
	// Public methods
	
	//------------------------------------------------------
	// Beskrivning: Withdraw amount from balance 
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public void withdraw(double theTransaction) {
		
		if (numWithdraws >= 1) {
			balance = balance - theTransaction*1.01;
		}
		else {
			balance = balance - theTransaction;
		}
		numWithdraws++;
		transactions.add(date.format(date) + ", Wtihdraw: " + theTransaction + ", Balance: " + balance);

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


