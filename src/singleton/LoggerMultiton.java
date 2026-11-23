package singleton;

import java.util.HashMap;
import java.util.Map;

public class LoggerMultiton {

	private int nbLoggedMessages;

	private static Map<String, LoggerMultiton> instances = new HashMap<>();

	private LoggerMultiton() {
		this.nbLoggedMessages = 0;
	}

	public static LoggerMultiton getInstance(String key) { 
		if (!instances.containsKey(key)) {
			instances.put(key, new LoggerMultiton());
		}
		return instances.get(key);
	}

	public void log(String msg) {
		this.nbLoggedMessages++;
		System.out.println("LOG" + this.nbLoggedMessages + ": " + msg);
	}
}
