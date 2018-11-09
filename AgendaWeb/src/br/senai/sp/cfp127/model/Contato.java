package br.senai.sp.cfp127.model;

public class Contato {
	//pojo ou bim, codigo java simples (começo te tudo);
	
		private int codContato;
		private Usuario usuario;
		private String nome;
		private String email;
		private String endeco;
		private String telefone;

		
		//codigo Contato
	public int getCodContato() {
		return codContato;
	}

	public void setCodContato(int codContato) {
		this.codContato = codContato;
	}

	
	// codigo Usuario
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//nome do contato
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//Email do contato
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//endeço do contato
	public String getEndeco() {
		return endeco;
	}

	public void setEndeco(String endeco) {
		this.endeco = endeco;
	}

	//telefone do contato
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
		
		
}
