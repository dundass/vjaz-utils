package interfaces;

public class TextField {
	protected String buffer = "";
	
	public TextField() {
		
	}
	
	public String get() {
		return buffer;
	}
	
	public void addChar(char c) {
		buffer += c;
	}
	
	public void removeChar() {
		if(buffer.length() > 0) buffer = buffer.substring(0, buffer.length() - 1);
	}
	
	public void clear() {
		buffer = "";
	}
}
