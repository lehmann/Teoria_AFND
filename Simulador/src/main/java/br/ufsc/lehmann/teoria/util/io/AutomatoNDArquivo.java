package br.ufsc.lehmann.teoria.util.io;

import br.ufsc.lehmann.teoria.AutomatoND;
import br.ufsc.lehmann.teoria.TransicaoND;

public class AutomatoNDArquivo implements AutomatoND {

	private String estadoInicial;
	private String[] estadosFinais;
	private TransicaoArquivo[] transicao;
	private String[] alfabeto;
	private String[] estados;
	private String stringVazia = "";

	public String getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public String[] getEstadosFinais() {
		return estadosFinais;
	}

	public void setEstadosFinais(String[] estadosFinais) {
		this.estadosFinais = estadosFinais;
	}

	public TransicaoArquivo[] getTransicao() {
		return transicao;
	}

	public void setTransicao(TransicaoArquivo[] transicao) {
		this.transicao = transicao;
	}

	public String[] getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String[] alfabeto) {
		this.alfabeto = alfabeto;
	}

	public String[] getEstados() {
		return estados;
	}

	public void setEstados(String[] estados) {
		this.estados = estados;
	}

	public String[] estados() {
		return this.estados;
	}

	public String[] alfabeto() {
		return this.alfabeto;
	}

	public TransicaoND funcaoTransicao() {
		return new TransicaoNDArquivo(this.transicao, this.stringVazia);
	}

	public String[] estadosFinais() {
		return this.estadosFinais;
	}

	public String estadoInicial() {
		return this.estadoInicial;
	}

	public void setStringVazia(String stringVazia) {
		this.stringVazia = stringVazia;
	}

	public String getStringVazia() {
		return stringVazia;
	}

}
