package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudenteDAO {
	
	public Studente completamentoAutomatico(int matricola) {
		
		String sql = "SELECT * FROM studente WHERE matricola = ?";
		Studente s1 = null;
		
		try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, matricola);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			s1=new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
		}
		st.close();
		conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return s1;
		
		
	}
	
	
	public List<Corso> listaCorsiStudente(int matricola) {
		
		String sql = "SELECT C.codins, crediti,nome,pd FROM iscrizione I,corso C WHERE I.codins=C.codins AND I.matricola= ?";
		List<Corso> corsi = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				corsi.add(new Corso (rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd")));
			}
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return corsi;
		
	}
	

}
