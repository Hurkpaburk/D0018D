import java.util.*;

public class TestFile {
	
	public static void main(String []args){
		
		System.out.println("START OF ACCOUNT TEST!");
		int theAccountNumber = 1234;		
		String theAccountType = "Sparkonto";
		int theTransaction = 10;
		
		SavingsAccount testAccount = new SavingsAccount(theAccountNumber, theAccountType, theTransaction);
		SavingsAccount testAccountTwo = new SavingsAccount();
		SavingsAccount testAccountThree = new SavingsAccount(theAccountNumber, theAccountType, theTransaction);

		System.out.println(testAccount.getBalance());
		System.out.println(testAccount.toString());
		System.out.println(testAccount.getInterest());
		System.out.println(testAccount.getAccountNumber());
		
		double deposit = 15;
		
		testAccount.deposit(deposit);
		System.out.println(testAccount.getBalance());
		
		double withdraw = 15;
		testAccount.withdraw(withdraw);
		System.out.println(testAccount.getBalance());
		
		System.out.println(testAccountTwo.getBalance());
		System.out.println(testAccountTwo.toString());
		System.out.println(testAccountTwo.getInterest());
		System.out.println(testAccountTwo.getAccountNumber());
		

		System.out.println(testAccountThree.getBalance());
		System.out.println(testAccountThree.toString());
		System.out.println(testAccountThree.getInterest());
		System.out.println(testAccountThree.getAccountNumber());
		System.out.println("END OF ACCOUNT TEST!");
		
		System.out.println("START OF CUSTOMER TEST!");
		Customer customer1 = new Customer("Pelle Persson", 4612204321L);
		Customer customer2 = new Customer();
		Customer customer3 = new Customer("Eva Dahlgren", 6006091234L);
		
		System.out.println(customer1.toString());
		System.out.println(customer2.toString());
		System.out.println(customer3.toString());
		
		customer1.addAccount(1, "Test", 20);
		customer1.addAccount(3, "Test", 0);
		customer2.addAccount(12, "Test2", 10);
		customer3.addAccount(12, "Test3", 1);
		
		System.out.println(customer1.toString());
		System.out.println(customer2.toString());
		System.out.println(customer3.toString());
		
		

		
	}
}