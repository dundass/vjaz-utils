package launchpad;

import java.util.HashMap;
import java.util.Map;

public interface Launchpad {
	
	public static final int xSize = 9, ySize = 8;
	
	public static final Map<String, Integer> colourVels = new HashMap<String, Integer>(){{
		put("off", 12);
		put("OFF", 12);
		put("red", 13);
		put("RED", 15);
		put("amber", 29);
		put("AMBER", 63);
		put("yellow", 62);
		put("YELLOW", 62);
		put("green", 28);
		put("GREEN", 60);
	}};
	
	public static final int[] notesLinear = {0,  1,  2,  3,  4,  5,  6,  7,  8,
									  		 16, 17, 18, 19, 20, 21, 22, 23, 24,
									  		 32, 33, 34, 35, 36, 37, 38, 39, 40,
									  		 48, 49, 50, 51, 52, 53, 54, 55, 56,
									  		 64, 65, 66, 67, 68, 69, 70, 71, 72,
									  		 80, 81, 82, 83, 84, 85, 86, 87, 88,
									  		 96, 97, 98, 99, 100, 101, 102, 103, 104,
									  		 112, 113, 114, 115, 116, 117, 118, 119, 120};
	
	public static int getVelForColour(String colour) {
		return colourVels.get(colour);
	}
	
	public static int getNoteForXY(int x, int y) {
		return (y * 16) + x;
	}
	
	public static int getXForNote(int note) {
		return note % 16;
	}
	
	public static int getYForNote(int note) {
		return note / 16;
	}
}
