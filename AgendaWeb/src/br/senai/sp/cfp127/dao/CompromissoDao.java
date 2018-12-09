package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Contato;

public class CompromissoDao {
	private Compromisso compromisso;
	private PreparedStatement stm;
	private ResultSet rs;
	
	
	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public ArrayList<Compromisso> getCompromisso(int codUsuario, int status){
		ArrayList<Compromisso> compromisso = new ArrayList<>();
		
		String sql = "SELECT * FROM tbl_compromisso "
				+ "WHERE cod_usuario = ? AND status = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codUsuario);
			stm.setInt(2, status);
			rs = stm.executeQuery();
			
			while(rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCodCompromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setData(rs.getString("data"));
				this.compromisso.setHoraInicio(rs.getString("horaInicio"));
				this.compromisso.setHoraFim(rs.getString("horaFim"));
				this.compromisso.setDescricao(rs.getString("descricao"));
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
				this.compromisso.setStatus(rs.getInt("status"));
				compromisso.add(this.compromisso);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexao.fecharConexao();
		}
		
		return compromisso;
	}
	
	//pegar Ordem
	public ArrayList<Compromisso> CompromissoProximo(int codUsuario){
		ArrayList<Compromisso> compromisso = new ArrayList<>();
		
		String sql = "SELECT * FROM tbl_compromisso "
				+ "WHERE cod_usuario = ? ORDER BY data AND horaInicio LIMIT 3";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codUsuario);
			rs = stm.executeQuery();
			
			while(rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCodCompromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setData(rs.getString("data"));
				this.compromisso.setHoraInicio(rs.getString("horaInicio"));
				this.compromisso.setHoraFim(rs.getString("horaFim"));
				this.compromisso.setDescricao(rs.getString("descricao"));
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
				this.compromisso.setStatus(rs.getInt("status"));
				compromisso.add(this.compromisso);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexao.fecharConexao();
		}
		
		return compromisso;
	}
	
	
	//GRAVAR COMPROMISSO
	public boolean gravar(Compromisso compromisso) {
		System.out.println(">>>>>>>>>>>>>>>" + compromisso.getUsuario().getCod());
		String sql = "INSERT INTO tbl_compromisso ("
				+ "cod_usuario, titulo, data, horaInicio, horaFim, descricao, prioridade, status)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, compromisso.getUsuario().getCod());
			stm.setString(2, compromisso.getTitulo());
			stm.setString(3, compromisso.getData());
			stm.setString(4, compromisso.getHoraInicio());
			stm.setString(5, compromisso.getHoraFim());
			stm.setString(6, compromisso.getDescricao());
			stm.setInt(7, compromisso.getPrioridade());
			stm.setInt(8, compromisso.getStatus());
			stm.execute();	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			Conexao.fecharConexao();
		}
		
	}
	
	
	//selecionar o comprmisso
	public Compromisso  exibir(int codCompromisso){
		
		String sql = "SELECT * FROM tbl_compromisso "
				+ "WHERE cod_compromisso = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codCompromisso);
			rs = stm.executeQuery();
			
			if(rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCodCompromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setData(rs.getString("data"));
				this.compromisso.setHoraInicio(rs.getString("horaInicio"));
				this.compromisso.setHoraFim(rs.getString("horaFim"));
				this.compromisso.setDescricao(rs.getString("descricao"));
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
				this.compromisso.setStatus(rs.getInt("status"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexao.fecharConexao();
		}
		
		return compromisso;
	}
	
	
	public boolean atualizar(Compromisso compromisso) {
		String sql = "UPDATE tbl_compromisso SET "
				+ "titulo = ?, "
				+ "data = ?, "
				+ "horaInicio = ?, "
				+ "horaFim = ?, "
				+ "descricao = ?, "
				+ "prioridade = ?, "
				+ "status = ? "
				+ "WHERE cod_compromisso = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, compromisso.getTitulo());
			stm.setString(2, compromisso.getData());
			stm.setString(3, compromisso.getHoraInicio());
			stm.setString(4, compromisso.getHoraFim());
			stm.setString(5, compromisso.getDescricao());
			stm.setInt(6, compromisso.getPrioridade());
			stm.setInt(7, compromisso.getStatus());
			stm.setInt(8, compromisso.getCodCompromisso());
			stm.execute();	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			Conexao.fecharConexao();
		}
		
	}
	
	
	
	
	
	//Atualizar os status do compromisso
	
	public boolean atualizarStatus(int status, int codCompromisso) {
		String sql = "UPDATE tbl_compromisso SET status = ? WHERE cod_compromisso = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, status);
			stm.setInt(2, codCompromisso);
			stm.execute();	
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			Conexao.fecharConexao();
		}
		
	}
	
	
	
	
}
