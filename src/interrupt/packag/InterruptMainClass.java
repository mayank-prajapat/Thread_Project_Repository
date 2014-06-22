package interrupt.packag;

import producer.consumer.packag.Buffer;

public class InterruptMainClass {
	private static final String TAG = "INTERRUPT_MAIN_CLASS : ";

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Thread addTwoMessagesInToBuffer = new Thread(new Producer_N(2, buffer));
		System.out.println(TAG + "starting thread addTwoMessagesInToBuffer");
		addTwoMessagesInToBuffer.start();

		System.out.println(TAG
				+ "Waiting for addTwoMessagesInToBuffer thread to finish");
		while (addTwoMessagesInToBuffer.isAlive()) {
			try {
				System.out
						.println(TAG
								+ "addTwoMessagesInToBuffer thread is Alive. Joining this thread for 0.5 seconds");
				addTwoMessagesInToBuffer.join(500);
			} catch (InterruptedException e) {
				System.out
						.println(TAG
								+ "Interrupted Exception occured while I joined addTwoMessagesInToBuffer thread for 0.5 seconds.");
			}
			System.out
					.println(TAG
							+ "0.5 Seconds over. Interrupting addTwoMessagesInToBuffer thread.");
			addTwoMessagesInToBuffer.interrupt();
			try {
				System.out
						.println(TAG
								+ "joining addTwoMessagesInToBuffer thread to let it finish after interruption.");
				addTwoMessagesInToBuffer.join();
			} catch (InterruptedException e) {
				System.out
						.println(TAG
								+ "Interrupted Exception occured while I joined addTwoMessagesInToBuffer thread to let it finish after interruption.");
			}
		}
		System.out.println(TAG + "addTwoMessagesInToBuffer thread finished");
	}

}
