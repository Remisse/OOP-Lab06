package it.unibo.oop.lab.exception2;

public class NotEnoughFundsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6795258447248091011L;
	private double funds;
	private double required;
	
	public NotEnoughFundsException(final double currentFunds, final double required) {
		super();
		this.funds = currentFunds;
		this.required = required;
	}
	
	public String toString() {
		return "Required funds: " + this.required + "; available: " + this.funds;
	}
	
	public String getMessage() {
		return this.toString();
	}
}
