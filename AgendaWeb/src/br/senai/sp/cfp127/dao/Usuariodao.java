package br.senai.sp.cfp127.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.senai.sp.cfp127.model.Usuario;

public class Usuariodao {

	private Usuario usuario;
	private PreparedStatement stm;
	private ResultSet rs;
	//usuario
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	//**** METODO PARA GRAVAR UM USUARIO NO BANCO
	
	public boolean gravar() {
		String sql = "INSERT INTO tbl_usuario ("
				+ "nome, email, senha, sexo, dtNascimento)"
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getSexo().substring(0, 1));
			stm.setString(5, usuario.getDtNascimento());
			stm.execute();	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	//Autenticar o usuario no banco
	public Usuario autenticar(String email, String senha) {
		this.usuario = new Usuario();
		
		String sql = "SELECT * FROM  tbl_usuario "
				+ "WHERE senha = ? AND email = ? ";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, senha);
			stm.setString(2, email);
			rs = stm.executeQuery();	
			
			if(rs.next()) {
				this.usuario.setCod(rs.getInt("cod"));
				this.usuario.setNome(rs.getString("nome"));
				this.usuario.setEmail(rs.getString("email"));
				this.usuario.setSexo(rs.getString("sexo"));
				this.usuario.setDtNascimento(rs.getString("dtNascimento"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return this.usuario;
	}
	
}