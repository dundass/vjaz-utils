package launchpad;

public class LaunchLightsState implements Launchpad {

	private int[][] states = new int[xSize][ySize];
	
	public LaunchLightsState() {
		
	}
	
	public int getState(int x, int y) {
		return states[x][y];
	}
	
	public int[] getStates1D() {
		int[] s = new int[xSize * ySize];
		for(int i = 0; i < xSize; i++) {
			for(int j = 0; j < ySize; j++) {
				s[j * xSize + i] = states[i][j];
			}
		}
		return s;
	}
	
	public int[][] getStates() {
		return states;
	}
	
	public void setLight(int x, int y, String colour) {
		states[x][y] = Launchpad.getVelForColour(colour);
	}
	
	public void setLight(int note, String colour) {
		states[Launchpad.getXForNote(note)][Launchpad.getYForNote(note)] = Launchpad.getVelForColour(colour);
	}
	
	public void setLight(int x, int y, int vel) {
		states[x][y] = vel;
	}
	
	public void setLight(int note, int vel) {
		states[Launchpad.getXForNote(note)][Launchpad.getYForNote(note)] = vel;
	}
}
