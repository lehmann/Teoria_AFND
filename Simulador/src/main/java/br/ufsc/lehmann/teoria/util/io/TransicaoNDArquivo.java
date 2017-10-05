package br.ufsc.lehmann.teoria.util.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.ufsc.lehmann.teoria.TransicaoND;

public class TransicaoNDArquivo implements TransicaoND {
	
	private TransicaoArquivo[] transicoes;

	public TransicaoNDArquivo(TransicaoArquivo[] transicao) {
		transicoes = transicao;
	}

	@Override
	public String[] proximosEstados(String estado, Character simbolo) {
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < transicoes.length; i++) {
			if(transicoes[i].getEstado().equals(estado)) {
				if(simbolo == null) {
					if(transicoes[i].getSimbolo() == null) {
						ret.addAll(Arrays.asList(transicoes[i].getProximosEstados()));
					}
				} else {
					if(simbolo.charValue() == transicoes[i].getSimbolo().charValue()) {
						ret.addAll(Arrays.asList(transicoes[i].getProximosEstados()));
					}
				}
			}
		}
		return ret.toArray(new String[ret.size()]);
	}

}
