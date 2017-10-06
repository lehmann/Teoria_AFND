package br.ufsc.lehmann.teoria;

public class Input {
	
	private String input;

	public Input(String input) {
		this.input = input;
	}

	public Character get() {
		return input.charAt(0);
	}
	
	public void consume() {
		input = input.substring(1);
	}

	public boolean isEmpty() {
		return input == null || input.isEmpty();
	}
	
	public Input clone() {
		return new Input(input);
	}
}
