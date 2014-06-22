package producer.consumer.packag;

import java.util.Random;

public class Producer implements Runnable {
	private static final String TAG = "PRODUCER : ";
	private Buffer buffer;
	private String pName;
	private String[] producerMessages;

	public Producer(Buffer buffer, String pName, String[] producerMessages) {
		this.buffer = buffer;
		this.pName = pName;
		this.producerMessages = producerMessages;
	}

	public void run() {
		Random random = new Random();
		for (int i = 0; i < producerMessages.length; i++) {
			buffer.put(producerMessages[i], pName);
			try {
				int randomSleepTime = random.nextInt(5000);
				System.out.println(TAG + pName + " aiwain slept for "
						+ randomSleepTime + " milli seconds");
				Thread.sleep(randomSleepTime);
				System.out.println(TAG + pName + " woke up again.");
			} catch (InterruptedException e) {
				System.out
						.println(TAG
								+ "Interrupted Exception occured while I was sleeping inside producer thread.");
			}
		}
		buffer.put("DONE", pName);
		System.out.println(TAG + pName + " died.");
	}
}
