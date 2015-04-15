
public class SavingsAccount extends BankAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-02-27
	// Senast uppdaterad: 2015-02-27, Johan Bergström 
	// Beskrivning: Handle Savings Account class 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private int numWithdraws;
	
	// Constructor
	public SavingsAccount(int theAccountNumber, double theTransaction) {
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
	// Beskrivning: get the account interest
	// Inparametrar: None
	// Returvärde: Interest - balance with interest
	//------------------------------------------------------
	public double getInterest() {
		double interest;
		interest = Math.round((balance*(interestRate/100))*100)/100d; // Update 1, Lab2
		return interest;
	}
	
	//------------------------------------------------------
	// Beskrivning: Withdraw amount from balance 
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public boolean withdraw(double theTransaction) {
		boolean temp = false;
		double charge = 1.01;
		if (numWithdraws >= 1) { // Number of withdraws is larger then one
			if (balance-theTransaction*charge >= 0) { // Balance after transaction has to be larger then zero
				balance = Math.round((balance - theTransaction*charge)*100)/100d; // Update 1, Lab2
				numWithdraws++;
				transactions.add(getTime() + ", Withdraw: " + theTransaction + ", Balance: " + balance); 
				temp = true;
			}
		}
		else {
			if (balance-theTransaction >= 0) { // Balance after transaction has to be larger then zero
				balance = Math.round((balance - theTransaction)*100)/100d; // Update 1, Lab2
				numWithdraws++;
				transactions.add(getTime() + ", Withdraw: " + theTransaction + ", Balance: " + balance);
				temp = true;
			}
		}
		return temp;
	}
}
