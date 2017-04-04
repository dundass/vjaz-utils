package interfaces;

public class KeyIncrementer {
	public int val = 0;
	public char up, down;
	
	public KeyIncrementer(char u, char d) {
		up = u;
		down = d;
	}
	
	public void push(char c) {
		if(c == up) val = 1;
		else if(c == down) val = -1;
	}
	
	public void release() {
		val = 0;
	}
}
