package producer.consumer.packag;

import java.util.Random;

public class Consumer implements Runnable {
	private static final String TAG = "CONSUMER : ";
	private Buffer buffer;
	private String cName;

	public Consumer(Buffer buffer, String name) {
		this.buffer = buffer;
		this.cName = name;
	}

	public void run() {
		Random random = new Random();
		for (String message = buffer.take(cName); !message.equals("DONE"); message = buffer
				.take(cName)) {
			try {
				int randomSleepTime = random.nextInt(5000);
				System.out.println(TAG + cName + " aiwain slept for "
						+ randomSleepTime + " milli seconds");
				Thread.sleep(randomSleepTime);
				System.out.println(TAG + cName + " woke up again.");
			} catch (InterruptedException e) {
				System.out
						.println(TAG
								+ "Interrupted Exception occured while I was sleeping inside producer thread.");
			}
		}
		System.out.println(TAG + cName + " died.");
	}
}