package br.senai.sp.cfp127.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection con;
	
	public static Connection getConexao(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL ="jdbc:mysql://10.107.134.23:3306/db_inf2ta?useTimezone=true&serverTimezone=UTC";
			String user = "inf2ta";
			String pass = "123";
			con = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("Banco conectado");
		}catch(Exception e){
			System.out.println("ocorreu um erro");
			e.printStackTrace();
		}
		return con;
	}
}