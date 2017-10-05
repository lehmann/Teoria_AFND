package br.ufsc.lehmann.teoria;

public interface AutomatoND {

	String[] estados();
	char[] alfabeto();
	TransicaoND funcaoTransicao();
	String[] estadosFinais();
	String estadoInicial();
	
}
