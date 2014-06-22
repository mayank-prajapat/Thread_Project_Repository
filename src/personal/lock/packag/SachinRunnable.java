package personal.lock.packag;

public class SachinRunnable implements Runnable {
	private Sachin sachin;
	private boolean isIncrease;

	public SachinRunnable(Sachin sachin, boolean isIncrease) {
		super();
		this.sachin = sachin;
		this.isIncrease = isIncrease;
	}

	@Override
	public void run() {
		if (isIncrease) {
			for (int i = 0; i < 10; i++) {
				sachin.incOdiRuns();
			}
		} else {
			for (int i = 0; i < 10; i++) {
				sachin.decOdiRuns();
			}
		}
	}
}