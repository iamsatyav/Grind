package suggestions;

public enum Check {
	OPEN("Open", 1),
	COMPLETED("Completed", 2);
	
	private final String text;
	private final int number;
	
	private Check(String text, int number) {
		this.text = text;
		this.number = number;
	}

	public String getText() {
		return text;
	}

	public int getNumber() {
		return number;
	}
	
}
