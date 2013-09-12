package cse.maven.sample.exception;

public class InvalidNICInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNICInputException() {
		super("Invalid NIC number entered.");
	}
}
