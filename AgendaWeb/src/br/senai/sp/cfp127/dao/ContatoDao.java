package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.cfp127.model.Contato;

public class ContatoDao {
		private Contato contato;
		private PreparedStatement stm;
		private ResultSet rs;
		
		
		
		public Contato getContato() {
			return contato;
		}


		public void setContato(Contato contato) {
			this.contato = contato;
		}


		public ArrayList<Contato> getContatos(int codUsuario){
			ArrayList<Contato> contatos = new ArrayList<>();
			
			String sql = "SELECT * FROM tbl_contato "
					+ "WHERE cod_usuario = ? ORDER BY nome";
			try {
				stm = Conexao.getConexao().prepareStatement(sql);
				stm.setInt(1, codUsuario);
				rs = stm.executeQuery();
				
				while(rs.next()) {
					this.contato = new Contato();
					this.contato.setCodContato(rs.getInt("cod_contato"));
					this.contato.setNome(rs.getString("nome"));
					this.contato.setTelefone(rs.getString("telefone"));
					this.contato.setEmail(rs.getString("email"));
					this.contato.setEndereco(rs.getString("endereco"));
					contatos.add(this.contato);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return contatos;
		}
		
		
		// Cadastrar contato
		
		public boolean gravar(Contato contato) {
			System.out.println(">>>>>>>>>>>>>>>" + contato.getUsuario().getCod());
			String sql = "INSERT INTO tbl_contato ("
					+ "cod_usuario, nome, telefone, email, endereco)"
					+ "VALUES (?, ?, ?, ?, ?)";
			try {
				stm = Conexao.getConexao().prepareStatement(sql);
				stm.setInt(1, contato.getUsuario().getCod());
				stm.setString(2, contato.getNome());
				stm.setString(3, contato.getTelefone());
				stm.setString(4, contato.getEmail());
				stm.setString(5, contato.getEndereco());
				stm.execute();	
				return true;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		//Selecionar Contato
		public Contato getContato(int codContato){
			
			String sql = "SELECT * FROM tbl_contato "
					+ "WHERE cod_contato = ?";
			try {
				stm = Conexao.getConexao().prepareStatement(sql);
				stm.setInt(1, codContato);
				rs = stm.executeQuery();
				
				if(rs.next()) {
					this.contato = new Contato();
					this.contato.setCodContato(rs.getInt("cod_contato"));
					this.contato.setNome(rs.getString("nome"));
					this.contato.setTelefone(rs.getString("telefone"));
					this.contato.setEmail(rs.getString("email"));
					this.contato.setEndereco(rs.getString("endereco"));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return contato;
		}
		
		
		//Atualizar contato
		
		public boolean atualizar(Contato contato) {
			String sql = "UPDATE tbl_contato SET "
					+ "nome = ?,"
					+ "telefone = ?,"
					+ "email = ?, "
					+ "endereco = ? "
					+ "WHERE cod_contato = ?";
			try {
				stm = Conexao.getConexao().prepareStatement(sql);
				stm.setString(1, contato.getNome());
				stm.setString(2, contato.getTelefone());
				stm.setString(3, contato.getEmail());
				stm.setString(4, contato.getEndereco());
				stm.setInt(5, contato.getCodContato());
				stm.execute();	
				return true;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		
		
		// Excluir contato
		
		public boolean excluir(int codContato) {
			String sql = "DELETE FROM tbl_contato WHERE cod_contato = ?";
			
			try {
				stm = Conexao.getConexao().prepareStatement(sql);
				stm.setInt(1, codContato);
				stm.execute();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		
		
}