package br.ufsc.lehmann.teoria.util.io;

public class TransicaoArquivo {

	private String estado;
	private Character simbolo;
	private String[] proximosEstados;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Character getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(Character simbolo) {
		this.simbolo = simbolo;
	}
	public String[] getProximosEstados() {
		return proximosEstados;
	}
	public void setProximosEstados(String[] proximosEstados) {
		this.proximosEstados = proximosEstados;
	}
}
