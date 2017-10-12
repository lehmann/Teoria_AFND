package br.ufsc.lehmann.teoria.util.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.lehmann.teoria.Frame;
import br.ufsc.lehmann.teoria.Input;
import br.ufsc.lehmann.teoria.TransicaoND;

public class TransicaoNDArquivo implements TransicaoND {
	
	private TransicaoArquivo[] transicoes;
	private String stringVazia;

	public TransicaoNDArquivo(TransicaoArquivo[] transicao, String stringVazia) {
		transicoes = transicao;
		this.stringVazia = stringVazia;
	}

	@Override
	public Frame[] proximosEstados(String estado, Input simbolo) {
		List<Frame> ret = new ArrayList<>();
		for (int i = 0; i < transicoes.length; i++) {
			if(transicoes[i].getEstado().equals(estado)) {
				if(transicoes[i].getSimbolo().equals(stringVazia)) {
					ret.addAll(Arrays.asList(transicoes[i].getProximosEstados()).stream().map(e -> new Frame(e, simbolo.clone())).collect(Collectors.toList()));
				} else if(!simbolo.isEmpty() && simbolo.get().equals(transicoes[i].getSimbolo())) {
					Input consumed = simbolo.clone();
					consumed.consume();
					ret.addAll(Arrays.asList(transicoes[i].getProximosEstados()).stream().map(e -> new Frame(e, consumed.clone())).collect(Collectors.toList()));
				}
			}
		}
		return ret.toArray(new Frame[ret.size()]);
	}

}
