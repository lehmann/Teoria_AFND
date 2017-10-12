package br.ufsc.lehmann.teoria;

public interface TransicaoND {

	Frame[] proximosEstados(String estado, Input simbolo);
}
