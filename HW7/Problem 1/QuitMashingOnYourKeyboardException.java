package javaWork;

public class QuitMashingOnYourKeyboardException extends IllegalArgumentException {
	public String msg;
	
	public QuitMashingOnYourKeyboardException() {
		System.out.println("QuitMashingOnYourKeyboardException thrown");
	}
	
	public QuitMashingOnYourKeyboardException(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		System.out.println();
		return msg;
	}

}
