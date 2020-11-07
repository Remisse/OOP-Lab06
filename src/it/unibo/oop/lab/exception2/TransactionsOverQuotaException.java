package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5186015990336694793L;
	
	public TransactionsOverQuotaException() {
		super();
	}
	
	public String toString() {
		return "ATM limit reached!";
	}
	
	public String getMessage() {
		return this.toString();
	}

}
