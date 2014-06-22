package personal.lock.packag;

public class Sachin {
	private static final String TAG = "SACHIN : ";
	private int odiRuns;
	private int testRuns;
	private Object odiRunsLock = new Object();
	private Object testRunsLock = new Object();

	public Sachin(int odiRuns, int testRuns) {
		super();
		this.odiRuns = odiRuns;
		this.testRuns = testRuns;
	}

	public void incOdiRuns() {
		synchronized (odiRunsLock) {
			odiRuns++;
			System.out.println(TAG + "ODI Runs have been increased to "
					+ odiRuns + ". Now sleeping for 500 milli seconds.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out
						.println(TAG
								+ "Interrupted Exception occured while I was sleeping inside incOdiRuns().");
			}
		}
	}

	public void decOdiRuns() {
		synchronized (odiRunsLock) {
			odiRuns--;
			System.out.println(TAG + "ODI Runs have been decreased to "
					+ odiRuns + ". Now sleeping for 400 milli seconds.");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				System.out
						.println(TAG
								+ "Interrupted Exception occured while I was sleeping inside decOdiRuns().");
			}
		}
	}

	public void incTestRuns() {
		synchronized (testRunsLock) {
			testRuns++;
		}
	}

	public void decTestRuns() {
		synchronized (testRunsLock) {
			testRuns--;
		}
	}

}
