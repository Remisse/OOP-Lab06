package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 939392286856532222L;	
	private double batteryLevel;
	
    /**
     * Builds a new instance of the exception.
     * 
     * @param batteryLevel
     * 			current battery level of the robot
     */
	public NotEnoughBatteryException(double batteryLevel) {
		super();
		this.batteryLevel = batteryLevel;
	}
	
	public String toString() {
		return "Can not perform operation: battery level too low (" + this.batteryLevel + ")";
	}
	
    public String getMessage() {
        return this.toString();
    }

}
