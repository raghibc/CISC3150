package javaWork;

public class ThreadABCs {

	public static void main(String[] args) {

		Tasks task1 = new Tasks();
		Tasks task2 = new Tasks();
		Tasks task3 = new Tasks();
		Tasks task4 = new Tasks();
		

		
		for(int i = 0; i < 7; i++) {
			Thread thread1 = new Thread(task1);
			Thread thread2 = new Thread(task2);
			Thread thread3 = new Thread(task3);
			Thread thread4 = new Thread(task4);
			thread1.start();
			try {
				thread1.join(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			thread2.start();
			try {
				thread2.join(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			thread3.start();
			try {
				thread3.join(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			thread4.start();
			try {
				thread4.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}


class Tasks implements Runnable {
	private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
								'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private static int currentPos = 0;
	
	public void run() {
		printLetter();
	}
	
	public void printLetter() {
		try {
		 if(currentPos < letters.length) {
			System.out.println(letters[currentPos++]);
			Thread.sleep(1000);
		 }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
   