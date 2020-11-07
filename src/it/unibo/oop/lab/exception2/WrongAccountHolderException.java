package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7190620326792084901L;
	
	private int owner;
	private int illegal;
	
	public WrongAccountHolderException(final int owner, final int illegal) {
		super();
		this.owner = owner;
		this.illegal = illegal;
	}
	
	public String toString() {
		return this.illegal + ": trying to access wrong account (" + this.owner + ")";
	}

	public String getMessage() {
		return this.toString();
	}
}
