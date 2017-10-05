package br.ufsc.lehmann.teoria;

import java.util.Arrays;
import java.util.LinkedList;

public class SimuladorNaoDeterministico {

	public boolean aceitacao(AutomatoND automato, String entrada) {
		LinkedList<String> processar = new LinkedList<String>();
		processar.add(automato.estadoInicial());
		String estadoAtual = null;
		while(!processar.isEmpty()) {
			estadoAtual = processar.removeFirst();
			Character simbolo = null;
			if(!entrada.isEmpty()) {
				simbolo = entrada.charAt(0);
				assert Arrays.asList(automato.alfabeto()).contains(simbolo) : "Elemento encontrado não pertence ao alfabeto";
				entrada = entrada.substring(1);
			} else {
				if(Arrays.asList(automato.estadosFinais()).contains(estadoAtual)) {
					return true;
				}
			}
			String[] proximosEstados = automato.funcaoTransicao().proximosEstados(estadoAtual, simbolo);
			if(proximosEstados != null && proximosEstados.length > 0) {
				processar.addAll(Arrays.asList(proximosEstados));
			}
		}
		if(entrada.isEmpty() && Arrays.asList(automato.estadosFinais()).contains(estadoAtual)) {
			return true;
		}
		return false;
	}
}
