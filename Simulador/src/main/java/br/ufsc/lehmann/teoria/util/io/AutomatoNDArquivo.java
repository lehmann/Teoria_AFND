package br.ufsc.lehmann.teoria.util.io;

import br.ufsc.lehmann.teoria.AutomatoND;
import br.ufsc.lehmann.teoria.TransicaoND;

public class AutomatoNDArquivo implements AutomatoND {

	private String estadoInicial;
	private String[] estadosFinais;
	private TransicaoArquivo[] transicao;
	private Character[] alfabeto;
	private String[] estados;
	private Character stringVazia;

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

	public Character[] getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(Character[] alfabeto) {
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

	public Character[] alfabeto() {
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

	public void setStringVazia(Character stringVazia) {
		this.stringVazia = stringVazia;
	}

	public Character getStringVazia() {
		return stringVazia;
	}

}
