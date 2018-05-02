package javaWork;

public class UserIsADumbassException extends IllegalArgumentException {
	public String msg;
	
	public UserIsADumbassException() {
		System.out.println("UserIsADumbassException thrown");
	}
	
	public UserIsADumbassException(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		System.out.println();
		return msg;
	}
	
}
	