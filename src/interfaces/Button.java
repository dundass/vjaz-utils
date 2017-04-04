package interfaces;

public class Button {
	public boolean state = false;
	
	public void push() {
		state = true;
	}
	
	public void release() {
		state = false;
	}
}
