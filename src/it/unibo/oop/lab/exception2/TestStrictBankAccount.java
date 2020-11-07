package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
	@Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	final int MAX_NTRANSACTIONS = 10;
    	
    	AccountHolder holder1 = new AccountHolder("Gigi", "Proietti", 1);
    	AccountHolder holder2 = new AccountHolder("Marco", "Travaglio", 2);
    	BankAccount acc1 = new StrictBankAccount(holder1.getUserID(), 10000, MAX_NTRANSACTIONS);
    	BankAccount acc2 = new StrictBankAccount(holder2.getUserID(), 10000, MAX_NTRANSACTIONS);
    	
    	try {
    		acc1.withdraw(holder2.getUserID(), 1000);
    	} catch (WrongAccountHolderException e) {
    		System.err.println(e);
    	}
    	assertEquals(10000.0, acc1.getBalance(), 0.0);
    	
    	try {
    		acc2.withdraw(holder2.getUserID(), 20000);
    	} catch (NotEnoughFundsException e) {
    		System.err.println(e);
    	}
    	assertEquals(10000.0, acc1.getBalance(), 0.0);
    	
    	for (int i = 0; i < MAX_NTRANSACTIONS*10; i++) {
    		try {
    			acc2.withdrawFromATM(holder2.getUserID(), 50);
    		} catch (TransactionsOverQuotaException e) {
        		System.err.println(e);
        	}
    	}
    	assertEquals(9500.0, acc1.getBalance(), 500.0);
    }
}
