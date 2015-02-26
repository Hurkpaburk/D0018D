
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
		  interestRate = 2;
	}	
	
	// Default Constructor
	public SavingsAccount() {
		 super();
		 accountType = "Sparkonto";
		 numWithdraws = 0;
		 interestRate = 2;
	}
	
	// Public methods
	
	//------------------------------------------------------
	// Beskrivning: Withdraw amount from balance 
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public void withdraw(double theTransaction) {

		double charge = 1.01;
		if (numWithdraws >= 1) { // Number of withdraws is larger then one
			if (balance-theTransaction*charge > 0) { // Balance after transaction has to be larger then zero
				balance = balance - theTransaction*charge;
				numWithdraws++;
				transactions.add(getTime() + ", Withdraw: " + theTransaction + ", Balance: " + balance);
			}
		}
		else {
			if (balance-theTransaction > 0) { // Balance after transaction has to be larger then zero
				balance = balance - theTransaction;
				numWithdraws++;
				transactions.add(getTime() + ", Withdraw: " + theTransaction + ", Balance: " + balance);
			}
		}
	}
}
