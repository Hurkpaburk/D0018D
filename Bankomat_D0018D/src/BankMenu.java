/**
 * Labb 1 - Testar klasserna Account och Customer via BankLogic
 * Susanne Fahlman, susanne.fahlman@ltu.se
 * Notera att denna klass kan komma att f�r�ndras under kursens g�ng 
 * s� du ska alltid kolla s� att du har den senaste versionen innan du l�mnar in
 * Senast �ndrad: 2013-10-08
 */

import java.util.Scanner;
public class BankMenu
{
	private BankLogic bank = new BankLogic();
	
	//-----------------------------------------------------------------------------------
	// K�r igenom ett testscenario
	//-----------------------------------------------------------------------------------
	public void test()
	{
		System.out.println("H�r testas all funktionalitet. Notera att utskriften OK! betyder att testet\n" +
				"gick igenom medan FEL! betyder att testet misslyckades och din kod m�ste ses �ver.\n" +
				"Koden i denna testklass ska inte �ndras!");
		
		// Skriver ut bankinfo
		printBank();

		// Skapar testkunder...
		addCustomer("Karl Karlsson", 8505221898L, true );
		addCustomer("Donald Duck",   8505221898L, false);
		addCustomer("Pelle Persson", 6911258876L, true );	
		addCustomer("Lotta Larsson", 7505121231L, true );	
		
		// Skriver ut en lista med kunder
		printBank();
		
		// Byt namn p� kund
		changeName("Kalle Karlsson", 8505221898L, true);
		
		// Byt namn p� kund som inte finns...
		changeName("Olle Karlsson", 9905221898L, false);
		
		// Ssriver ut kund med konton
		printCustomer(8505221898L);
		
		// Skapa konton
		addSavingsAccount(8505221898L);	// 1001
		addSavingsAccount(6911258876L);	// 1002
		addSavingsAccount(8505221898L);	// 1003	
		addSavingsAccount(7505121231L); // 1004
		
		// SKriver ut kunderna inklusive konton
		printCustomer(8505221898L);
		printCustomer(6911258876L);
		printCustomer(7505121231L);

		// S�tter in 700 kr p� konto 1002 (ska ej g� pga fel konto�gare)
		deposit(8505221898L, 1002, 700, false);		
		
		// S�tter in 500 kr p� konto 1001
		deposit(8505221898L, 1001, 500, true);						
		
		// Ta ut 500 kr  p� konto 1001
		withdraw(8505221898L, 1001, 500, true);						
	
		// Ta ut 1 kr  p� konto 1001 (ska ej g�)
		withdraw(8505221898L, 1001, 1, false);
	
		// S�tter in 1000 kr  p� konto 1001
		deposit(8505221898L, 1001, 1000, true);	
		
		// Skriver ut kunderna inklusive konton
		printCustomer(8505221898L);
		printCustomer(6911258876L);
		printCustomer(7505121231L);
		
		// Skriv ut kontoinformation
		printAccount(8505221898L, 1001);
		printAccount(8505221898L, 1002);	// G�r ej pga fel konto�gare
		
		// Avslutar konto
		closeAccount(8505221898L, 1001);	
		
		printBank();
		
		// S�tter in 5000 kr p� konto 1003
		deposit(8505221898L, 1003, 5000, true);							
		
		// S�tter in 5000 kr p� konto 1003
		deposit(8505221898L, 1003, 5000, true);	
		printBank();

		addSavingsAccount(7505121231L); // Skapar konto 1005
		
		printCustomer(8505221898L);
		printCustomer(6911258876L);
		printCustomer(7505121231L);

		
		// S�tter in 1000 kr p� konto 1005
		deposit(7505121231L, 1005, 1000, true);		
		
		// Tar ut 100 kr tre g�nger p� konto 1005
		withdraw(7505121231L, 1005, 100, true);
		withdraw(7505121231L, 1005, 100, true);						
		withdraw(7505121231L, 1005, 100, true);	
		
		printBank();
		
		// Skriv ut kontoinformation
		printCustomer(7505121231L);
				
		// Tar bort kund
		removeCustomer(7505121231L);
	
		printBank();
		printAccount(6911258876L, 1003);

		// Ins�ttningen g�r inte pga fel konto�gare
		deposit(6911258876L, 1003, 900, false);
		
		// S�tter in 900 kr p� konto 1002
		deposit(6911258876L, 1002, 900, true);

		printCustomer(8505221898L);
		printCustomer(6911258876L);
		printCustomer(7505121231L);

		// Tar ut 900 kr fr�n konto 1002
		withdraw(6911258876L, 1002, 900, true);
		
		// Tar bort kund
		removeCustomer(6911258876L);
		printBank();
		
		// Tar bort kund
		removeCustomer(8505221898L);
		printBank();
	}
	
	/**
	 * Hj�lpmetod f�r att skriva ut kundlistan
	 */
	private void printBank()
	{
		System.out.println("\n## BANKEN INNEH�LLER ##");
		System.out.println(bank.infoBank());
	}
	
	/**
	 * Hj�lpmetod f�r att skriva ut en kund
	 * @param pNr - Personnummer
	 */
	private void printCustomer(long pNr)
	{
		System.out.println("\n# UTSKRIFT AV KUND\t" + pNr);
		System.out.println(bank.infoCustomer(pNr));
	}
	
	/**
	 * Hj�lpmetod f�r att skriva ut information om ett konto
	 * @param pNr - Personnummer
	 * @param accountId - Kontonummer
	 */
	private void printAccount(long pNr, int accountId)
	{
		System.out.println("\n# UTSKRIFT AV KONTO\t" + pNr + "\t" + accountId);
		System.out.println(bank.infoAccount(pNr, accountId));
	}
	
	/**
	 * Hj�lpmetod som skapar upp en kund samt skriver ut om testet blev godk�nt
	 * @param name - Kundens namn (f�r och efternamn)
	 * @param pNr  - Kundens personnummer
	 * @param check - skicka in true om det borde fungera eller false om det inte borde g� skapa kund
	 */
	private void addCustomer(String name, long pNr, boolean check)
	{
		System.out.println("# SKAPA KUND\t" + pNr + "\t" + name);
		if(bank.addCustomer(name, pNr) == check)		
			System.out.println("\t- OK!");
		else
			System.out.println("\t- FEL!");
	}

	/**
	 * Hj�lpmetod som byter namn p� en kund samt skriver ut om testet blev godk�nt
	 * @param name - Kundens namn (f�r och efternamn)
	 * @param pNr  - Kundens personnummer
	 * @param check - skicka in true om det borde fungera eller false om det inte borde g� skapa kund
	 */
	private void changeName(String name, long pNr, boolean check)
	{
		System.out.println("# �NDRA NAMN\t" + pNr + "\t" + name);
		if(bank.changeCustomerName(name, pNr) == check)		
			System.out.println("\t- OK!");
		else
			System.out.println("\t- FEL!");
	}


	/**
	 * Hj�lpmetod som skapar upp ett konto samt skriver ut OK! om kontot skapades eller FEL! om kontot inte skapades
	 * Konto kan bara skapas om man kunden existerar
	 * @param pNr - konto�garen
	 */
	private void addSavingsAccount(long pNr)
	{
		int id = bank.addSavingsAccount(pNr);
		System.out.println("# SKAPA KONTO\t" + pNr + "\t" + id);
		if(id == -1)
			System.out.println("\t- FEL!");
		else
			System.out.println("\t- OK!");
	}

		
	/**
	 * Hj�lpmetod som s�tter in pengar p� konto samt skriver ut om testet blev godk�nt
	 * Ska bara g� g�ra om man skickar in personnummer och kontonummer som h�r ihop
	 * @param pNr - konto�garen
	 * @param accountId - kontonummret
	 * @param amount  - belopp
	 * @param check - skicka in true om det borde fungera eller false om det inte borde g� s�tta in pengar
	 */
	private void deposit(long pNr, int accountId, int amount, boolean check)
	{
		System.out.println("# INS�TTNING\t" + pNr + "\t" + accountId + "\t" + amount + " kr");
		if(bank.deposit(pNr, accountId, amount) == check)							
			System.out.println("\t- OK!");
		else
			System.out.println("\t- FEL!");
	}
	
	/**
	 * Hj�lpmetod som tar ut pengar fr�n konto samt skriver ut om testet blev godk�nt
	 * Ska bara g� g�ra om man skickar in personnummer och kontonummer som h�r ihop samt om belopp finns
	 * @param pNr - konto�garen
	 * @param accountId - kontonummret
	 * @param amount  - belopp
	 * @param check - skicka in true om det borde fungera eller false om det inte borde g� s�tta in pengar
	 */
	private void withdraw(long pNr, int accountId, int amount, boolean check)
	{
		System.out.println("# UTTAG\t" + pNr + "\t" + accountId + "\t-" + amount + " kr");
		if(bank.withdraw(pNr, accountId, amount) == check)							
			System.out.println("\t- OK!");
		else
			System.out.println("\t- FEL!");
	}
	
	/**
	 * Hj�lpmetod som st�nger ett konto samt skriver ut information inklusive r�nta man f�r
	 * Ska bara g� g�ra om man skickar in personnummer och kontonummer som h�r ihop
	 * @param pNr - kund�garen
	 * @param accountId - kontonummret
	 */
	private void closeAccount(long pNr, int accountId)
	{
		System.out.println("# AVSLUTA KONTO\t" + pNr + "\t" + accountId);
		System.out.println(bank.closeAccount(pNr, accountId));							
	}
		
	/**
	 * Hj�lpmetod som tar bort en kund inklusive konton fr�n banken
	 * @param pNr - kund
	 */
	private void removeCustomer(long pNr)
	{
		System.out.println("# TA BORT KUND (+ KONTON)\t" + pNr);
		System.out.println(bank.removeCustomer(pNr));				
	}

	/**
	 * Skapar en instans av BankMenu-klassen och k�r ig�ng menyn
	 * @param	args	argument anv�nds inte
	 */
	public static void main(String[] args)
	{
		
		BankMenu bankMenu = new BankMenu();
		bankMenu.test();
	}
}