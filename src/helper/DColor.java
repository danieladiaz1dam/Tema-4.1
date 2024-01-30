package helper;

public class DColor {
	int red, green, blue;
	
	public DColor(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public String toString() {
		return "\u001B[38;2;%d;%d;%dm".formatted(red, green, blue);
	}
	
	public static String colorizedBlock(int red, int green, int blue) {
		return String.format("\u001B[48;2;%d;%d;%dm \u001B[0m", red, green, blue);
	}
	
	public static String colorizedBlock(DColor c) {
		return String.format("\u001B[48;2;%d;%d;%dm \u001B[0m", c.red, c.green, c.blue);
	}
	
	public String block() {
		return String.format("\u001B[48;2;%d;%d;%dm  \u001B[0m", red, green, blue);
	}
}
