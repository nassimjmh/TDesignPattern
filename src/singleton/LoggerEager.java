package singleton;

public class LoggerEager {

	private int nbLoggedMessages;

	private static LoggerEager uniqueInstance = new LoggerEager(); // eager instantiation

	private LoggerEager() {
		this.nbLoggedMessages = 0;
	}

	public static LoggerEager getInstance() { // synchronized
		return uniqueInstance;
	}

	public void log(String msg) { // synchronized
		this.nbLoggedMessages++;
		System.out.println("LOG" + this.nbLoggedMessages + ": " + msg);
	}

}
