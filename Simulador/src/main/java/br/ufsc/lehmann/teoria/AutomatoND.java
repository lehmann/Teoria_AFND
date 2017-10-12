package br.ufsc.lehmann.teoria;

public interface AutomatoND {

	String[] estados();
	String[] alfabeto();
	TransicaoND funcaoTransicao();
	String[] estadosFinais();
	String estadoInicial();
	
}
