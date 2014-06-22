package volatil.packag;

public class MainClassForVolatile {
	private static final String TAG = "MAIN_CLASS_FOR_VOLATILE : ";
	private static volatile int MY_INT = 0;

	public static void main(String[] args) {
		new ChangeListener().start();
		System.out.println(TAG + "ChangeListener thread started.");
		new ChangeMaker().start();
		System.out.println(TAG + "ChangeMaker thread started.");
	}

	static class ChangeListener extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while (local_value < 5) {
				if (local_value != MY_INT) {
					local_value = MY_INT;
					System.out.println("ChangeListener : "
							+ "Got Change for MY_INT. local_value = "
							+ local_value);
				}
			}
		}
	}

	static class ChangeMaker extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while (MY_INT < 5) {
				System.out.println("ChangeMaker : "
						+ "Incrementing MY_INT to : " + (local_value + 1));
				MY_INT = ++local_value;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
