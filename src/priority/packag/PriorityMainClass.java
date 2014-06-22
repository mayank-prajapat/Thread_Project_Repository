package priority.packag;

class A extends Thread {
	public void run() {
		System.out.println("Thread A started");
		for (int i = 1; i <= 4; i++) {
			System.out.println("\t From ThreadA: A= " + i);
		}
		System.out.println("Exit from A");
	}
}

class B extends Thread {
	public void run() {
		System.out.println("Thread B started");
		for (int j = 1; j <= 4; j++) {
			System.out.println("\t From ThreadB: B=" + j);
		}
		System.out.println("Exit from B");
	}
}

class C extends Thread {
	public void run() {
		System.out.println("Thread C started");
		for (int k = 1; k <= 4; k++) {
			System.out.println("\t From ThreadC: C= " + k);
		}
		System.out.println("Exit from C");
	}
}

public class PriorityMainClass {
	public static void main(String args[]) {
		A threadA = new A();
		B threadB = new B();
		C threadC = new C();
		threadC.setPriority(Thread.MAX_PRIORITY);
		threadA.setPriority(Thread.MIN_PRIORITY);
		threadB.setPriority(threadA.getPriority() + 1);
		System.out.println("Started Thread A");
		threadA.start();
		System.out.println("Started Thread B");
		threadB.start();
		System.out.println("Started Thread C");
		threadC.start();
		System.out.println("End of main thread");
	}
}
