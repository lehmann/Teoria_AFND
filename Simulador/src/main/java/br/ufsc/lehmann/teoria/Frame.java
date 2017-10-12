package br.ufsc.lehmann.teoria;

public class Frame {
	String estadoAtual;
	Input input;

	public Frame(String estado, Input input) {
		estadoAtual = estado;
		this.input = input;
	}
}