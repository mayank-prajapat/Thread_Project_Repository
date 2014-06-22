package producer.consumer.packag;

public class ProducerConsumerMainClass {
	private static final String TAG = "MAIN_CLASS : ";

	public static void main(String[] args) {
		Buffer buffer = new Buffer();

		String firstProducerMessages[] = { "firstProducerMessage1" };
		String secondProducerMessages[] = { "secondProducerMessage1" };
		System.out.println(TAG + "starting first producer thread.");
		(new Thread(new Producer(buffer, "FIRST_PRODUCER",
				firstProducerMessages))).start();
		System.out
				.println(TAG
						+ "first producer thread started. Now starting first consumer thread.");
		(new Thread(new Consumer(buffer, "FIRST_CONSUMER"))).start();
		System.out.println(TAG + "first consumer thread started");

		System.out.println(TAG + "starting second producer thread.");
		(new Thread(new Producer(buffer, "SECOND_PRODUCER",
				secondProducerMessages))).start();
		System.out
				.println(TAG
						+ "second producer thread started. Now starting second consumer thread.");
		(new Thread(new Consumer(buffer, "SECOND_CONSUMER"))).start();
		System.out.println(TAG + "second consumer thread started");
	}
}
