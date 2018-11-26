package br.senai.sp.cfp127.model;

public class Compromisso {
	
	private int codCompromisso;
	private Usuario usuario;
	private String titulo;
	private String data;
	private String horaInicio;
	private String horaFim;
	private String descricao;
	private int prioridade;
	private int status;

	//Data
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	//concluido
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	//C�digo Compromisso
	public int getCodCompromisso() {
		return codCompromisso;
	}

	public void setCodCompromisso(int codCompromisso) {
		this.codCompromisso = codCompromisso;
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

	
	//Descri��o do compromisso
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
