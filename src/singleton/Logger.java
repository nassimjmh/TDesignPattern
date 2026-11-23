package singleton;

public class Logger {
  private int nbLoggedMessages;
  public Logger() {  
    this.nbLoggedMessages = 0;
  }
  public void log(String msg) {
    this.nbLoggedMessages++;
    System.out.println("LOG" + this.nbLoggedMessages + ": " + msg);
  }
}