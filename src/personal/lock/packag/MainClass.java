package personal.lock.packag;

public class MainClass {

	private static final String TAG = "MAIN_CLASS : ";

	public static void main(String[] args) {
		Sachin sachin = new Sachin(500, 1000);

		Thread incOdiRunsThread = new Thread(new SachinRunnable(sachin, true));
		Thread decOdiRunsThread = new Thread(new SachinRunnable(sachin, false));
		System.out.println(TAG + "starting incOdiRunsThread.");
		incOdiRunsThread.start();
		System.out.println(TAG
				+ "incOdiRunsThread Started. Now starting decOdiRunsThread");
		decOdiRunsThread.start();
		System.out.println(TAG + "decOdiRunsThread started.");
	}
}
