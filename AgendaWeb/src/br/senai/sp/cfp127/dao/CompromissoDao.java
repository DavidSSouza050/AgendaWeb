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

	public ArrayList<Compromisso> getCompromisso(int codUsuario){
		ArrayList<Compromisso> compromisso = new ArrayList<>();
		
		String sql = "SELECT * FROM tbl_compromisso "
				+ "WHERE cod_usuario = ? ORDER BY prioridade";
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
		}
		
		return compromisso;
	}
	
	
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
		}
		
	}
	
	
}
