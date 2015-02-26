
public class CreditAccount extends BankAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-02-18
	// Senast uppdaterad: 2015-02-18, Johan Bergström 
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
		if (balance <= 0) {
			System.out.println("***** H�R SALDO NEGATIVT *****");
			System.out.println(balance*(debtInterest/100));
			return balance*(debtInterest/100);	
			
		}
		else {
			return balance*(interestRate/100);
		}
	}

	//------------------------------------------------------
	// Beskrivning: Withdraw amount from balance 
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public boolean withdraw(double theTransaction) {
		if (balance-theTransaction >= -creditLimit) { // Balance after transaction has to be larger then zero
			balance = balance - theTransaction;
			transactions.add(getTime() + ", Withdraw: " + theTransaction + ", Balance: " + balance);
			return true;
		}
		else {
			return false;
		}
	}
}
	
