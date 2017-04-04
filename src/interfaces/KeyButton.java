package interfaces;

public class KeyButton extends Button {
	public char key;
	
	public KeyButton(char k) {
		key = k;
	}
	
	public void push(char c) {
		if(c == key) push();
	}
}
