package producer.consumer.packag;

import java.util.ArrayList;

public class Buffer {
	private static final String TAG = "BUFFER : ";
	private ArrayList bufferMessages = new ArrayList();
	private int bufferLength = 4;

	public synchronized String take(String consumerName) {
		System.out.println(TAG + consumerName
				+ " is trying to take a message from buffer.");
		while (bufferMessages.size() == 0) {
			try {
				System.out.println(TAG + "Buffer is empty. " + consumerName
						+ " has to wait.");
				wait();
				System.out.println(TAG + "wait is over for " + consumerName);
			} catch (InterruptedException e) {
				System.out
						.println(TAG
								+ "Interrupted Exception occured while I was waiting inside take().");
			}
		}
		String takenMessage = bufferMessages.get(0).toString();
		bufferMessages.remove(0);
		System.out.println(TAG + consumerName + " has taken \"message = "
				+ takenMessage + " \" from buffer.");
		System.out.println(TAG
				+ "notifying producers that buffer is not full now.");
		notifyAll();
		return takenMessage;
	}

	public synchronized void put(String message, String producerName) {
		System.out.println(TAG + producerName
				+ " is trying to put the message \" " + message
				+ " \" into buffer.");
		while (bufferMessages.size() == bufferLength) {
			try {
				System.out.println(TAG + "Buffer is already full. "
						+ producerName + " has to wait");
				wait();
				System.out.println(TAG + "wait is over for " + producerName);
			} catch (InterruptedException e) {
				System.out
						.println(TAG
								+ "Interrupted Exception occured while I was waiting inside put().");
			}
		}
		bufferMessages.add(message);
		System.out.println(TAG + producerName + " has put \"message = "
				+ message + " \" into buffer.");
		System.out.println(TAG
				+ "notifying consumers that buffer is not empty now.");
		notifyAll();
	}

}
