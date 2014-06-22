package interrupt.packag;

import producer.consumer.packag.Buffer;

public class Producer_N implements Runnable {
	private int messagesToBeAdded;
	private Buffer buffer;
	private String producerName = "PRODUCER_";

	public Producer_N(int messagesToBeAdded, Buffer buffer) {
		super();
		this.messagesToBeAdded = messagesToBeAdded;
		this.buffer = buffer;
		this.producerName = producerName + messagesToBeAdded;
	}

	@Override
	public void run() {
		for (int i = 0; i < messagesToBeAdded; i++) {
			String messageToBePut = producerName + "_" + i;
			buffer.put(messageToBePut, producerName);
			try {
				System.out.println(producerName + " aiwain slept for " + 400
						+ " milli seconds");
				Thread.sleep(400);
			} catch (InterruptedException e) {
				System.out
						.println(producerName
								+ " : Interrupted Exception occured while I was sleeping inside thread.");
			}
		}
		System.out.println(producerName + " : Died ");
	}

}
