package br.ufsc.lehmann.teoria.util.io;

public class TransicaoArquivo {

	private String estado;
	private String simbolo;
	private String[] proximosEstados = new String[0];
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public String[] getProximosEstados() {
		return proximosEstados;
	}
	public void setProximosEstados(String[] proximosEstados) {
		this.proximosEstados = proximosEstados;
	}
}
