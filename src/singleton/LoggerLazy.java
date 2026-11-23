package singleton;

public class LoggerLazy {

	private int nbLoggedMessages;

	private static LoggerLazy uniqueInstance = null;

	private LoggerLazy() {
		this.nbLoggedMessages = 0;
	}

	public static LoggerLazy getInstance() { // synchronized
		if (uniqueInstance == null) {
			uniqueInstance = new LoggerLazy(); // lazy instantiation
		}
		return uniqueInstance;
	}

	public void log(String msg) { // synchronized
		this.nbLoggedMessages++;
		System.out.println("LOG" + this.nbLoggedMessages + ": " + msg);
	}
	
}
