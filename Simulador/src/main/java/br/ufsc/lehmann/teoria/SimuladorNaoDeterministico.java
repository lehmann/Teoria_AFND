package br.ufsc.lehmann.teoria;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SimuladorNaoDeterministico {

	public boolean aceitacao(AutomatoND automato, String entrada) {
		LinkedList<Frame> processar = new LinkedList<>();
		processar.add(new Frame(automato.estadoInicial(), new Input(entrada)));
		Frame frame = null;
		while(!processar.isEmpty()) {
			frame = processar.removeFirst();
			Input input = frame.input;
			String estadoAtual = frame.estadoAtual;
			if(!input.isEmpty()) {
				if(!Arrays.asList(automato.alfabeto()).contains(input.get()))
					throw new IllegalArgumentException("Elemento encontrado não pertence ao alfabeto");
			} else {
				if(Arrays.asList(automato.estadosFinais()).contains(estadoAtual)) {
					return true;
				}
			}
			String[] proximosEstados = automato.funcaoTransicao().proximosEstados(estadoAtual, input);
			if(proximosEstados != null && proximosEstados.length > 0) {
				processar.addAll(Arrays.asList(proximosEstados).stream().map(e -> new Frame(e, input.clone())).collect(Collectors.toList()));
			}
		}
		return false;
	}
	
	private static class Frame {
		private String estadoAtual;
		private Input input;

		public Frame(String estado, Input input) {
			estadoAtual = estado;
			this.input = input;
		}
	}
}
