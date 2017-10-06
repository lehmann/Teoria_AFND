package br.ufsc.lehmann.teoria.util.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.ufsc.lehmann.teoria.Input;
import br.ufsc.lehmann.teoria.TransicaoND;

public class TransicaoNDArquivo implements TransicaoND {
	
	private TransicaoArquivo[] transicoes;
	private Character stringVazia;

	public TransicaoNDArquivo(TransicaoArquivo[] transicao, Character stringVazia) {
		transicoes = transicao;
		this.stringVazia = stringVazia;
	}

	@Override
	public String[] proximosEstados(String estado, Input simbolo) {
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < transicoes.length; i++) {
			if(transicoes[i].getEstado().equals(estado)) {
				if(transicoes[i].getSimbolo().equals(stringVazia)) {
					ret.addAll(Arrays.asList(transicoes[i].getProximosEstados()));
				} else if(!simbolo.isEmpty() && simbolo.get() == transicoes[i].getSimbolo().charValue()) {
					simbolo.consume();
					ret.addAll(Arrays.asList(transicoes[i].getProximosEstados()));
				}
			}
		}
		return ret.toArray(new String[ret.size()]);
	}

}
