package javaWork;

public class AlgebraFailException extends IllegalArgumentException {
	public String msg;
	
	public AlgebraFailException() {
		System.out.println("AlgebraFailException thrown");
	}
	
	public AlgebraFailException(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		System.out.println();
		return msg;
	}
	
}
	