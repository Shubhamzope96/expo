package practicejava;

public class Animal implements Runnable{
	//Hashcode & equals difference 
	// all methods of Object class
	//
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("printed by " + Thread.currentThread().getName());
		for(int i=0;i<10;i++) {
			System.out.println("child thread");
		}
	}
	
	public void sound() {
		System.out.print("Animals like food ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog a = new Dog();
		a.sound();
		
		Animal c = new Cat();
		c.sound();
		
		Thread th = new Thread(a);
//		th.start();
		String s= new String("ma");
		String str = new String("nB");
		System.out.println(a.hashCode());
		System.out.println(s.hashCode());
		System.out.println(str.hashCode());
		System.out.println(Integer.valueOf(1).hashCode());
		System.out.println(Integer.valueOf(2).hashCode());
		System.out.println(s.equals(str));
		System.out.println(s==str);

	}
}

// Hashcode() uses farmula s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1] to calculate Hashcode
// equals checks whether actuals values in objects are identical or not.
// == checks if the two refferences (variables) points to the same Object. that is same memory location.
