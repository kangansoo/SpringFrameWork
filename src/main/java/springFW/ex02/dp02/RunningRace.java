package springFW.ex02.dp02;

public abstract class RunningRace {
	
	private void ready() {
		System.out.println("준비");
	}
	
	protected abstract void run();
	
	private void finish() {
		System.out.println("결승선");
	}
	
	public void race() {
		ready();
		run();
		finish();
	}
}
