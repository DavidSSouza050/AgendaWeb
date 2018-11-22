package br.senai.sp.cfp127.model;

public class Compromisso {
	
	private int codComprimisso;
	private Usuario usuario;
	private String titulo;
	private String horaInicio;
	private String horaFim;
	private String descricao;
	private int prioridade;

	
	//Código Compromisso
	public int getCodComprimisso() {
		return codComprimisso;
	}

	public void setCodComprimisso(int codComprimisso) {
		this.codComprimisso = codComprimisso;
	}

	//Usuario
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// titulo
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	//Horario inicial
	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	//Hora de fim
	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	
	//Descrição do compromisso
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	//Prioridade do compromisso 
	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	
	
}
