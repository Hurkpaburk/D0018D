
public class CreditAccount extends BankAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-02-27
	// Senast uppdaterad: 2015-02-27, Johan Bergström 
	// Beskrivning: Handle Credit Account class 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private double creditLimit = 5000;
	private double debtInterest = 7;
	
	// Constructor
	public CreditAccount(int theAccountNumber, int theTransaction) {
		  super(theAccountNumber, theTransaction);
		  accountType = "CreditAccount";
		  interestRate = 0.5;
	}	
	
	// Default Constructor
	public CreditAccount() {
		 super();
		 accountType = "CreditAccount";
		 interestRate = 0.5;
	}
	
	// Public methods
	
	//------------------------------------------------------
	// Beskrivning: get the account interest
	// Inparametrar: None
	// Returvärde: Interest - balance with interest
	//------------------------------------------------------
	public double getInterest() {
		double interest;
		if (balance <= 0) {
			interest = Math.round((balance*(debtInterest/100))*100)/100d; // Update 1, Lab2
			return interest;	
			
		}
		else {
			interest =  Math.round((balance*(interestRate/100))*100)/100d; // Update 1, Lab2
			return interest;
		}
	}

	//------------------------------------------------------
	// Beskrivning: Withdraw amount from balance 
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public boolean withdraw(double theTransaction) {
		if (balance-theTransaction >= -creditLimit) { // Balance after transaction has to be larger then zero
			balance = Math.round((balance - theTransaction)*100)/100d; // Update 1, Lab2
			transactions.add(getTime() + ", Withdraw: " + theTransaction + ", Balance: " + balance);
			return true;
		}
		else {
			return false;
		}
	}
}
	
