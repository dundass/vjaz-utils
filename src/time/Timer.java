package time;

public class Timer {
	private long startTime, prevTime;
	private long interval;
	
	public Timer() {
		this(1000);
	}
	
	public Timer(long i) {
		interval = i;
		startTime = System.currentTimeMillis();
		prevTime = startTime;
	}
	
	public boolean elapsed() {
		boolean trig = false;
		if(System.currentTimeMillis() - prevTime > interval) {
			trig = true;
			prevTime = System.currentTimeMillis();
		}
		return trig;
	}
	
	public long getTime() {
		return (System.currentTimeMillis() - startTime);
	}
	
	public long getStartTime() {
		return startTime;
	}
	
	public long getPrevTime() {
		return prevTime;
	}
	
	public long getInterval() {
		return interval;
	}
	
	public void setInterval(long i) {
		interval = i;
	}
	
	public void reset() {
		startTime = System.currentTimeMillis();
		prevTime = startTime;
	}
}
