package br.ufsc.lehmann.teoria;

public interface AutomatoND {

	String[] estados();
	Character[] alfabeto();
	TransicaoND funcaoTransicao();
	String[] estadosFinais();
	String estadoInicial();
	
}
