package practicejava;

public class Dog extends Animal implements Runnable{

	public void sound() {
		System.out.println("Dog like chiken ");
	}
	
	public void run() {
		System.out.println("printed by " + Thread.currentThread().getName());
		for(int i=0;i<10;i++) {
			System.out.println("Dog thread");
		}
	}
}
