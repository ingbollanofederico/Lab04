package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import java.util.*;

public class Model {
	
	public Studente avviaCompletamentoAutomatico(int matricola) {//RICORDA DI CONTROLLARE IL NULL
		
		StudenteDAO dao = new StudenteDAO();
		
		Studente s = dao.completamentoAutomatico(matricola);
		
		return s; 
	}
	
	public List<Studente> ricercaStudentiCorso(Corso corso){
		
		CorsoDAO c = new CorsoDAO();
		return c.getStudentiIscrittiAlCorso(corso);

	}
	
	public List<Corso> listAllCorso(){
		CorsoDAO c = new CorsoDAO();
		return c.getTuttiICorsi();
		
	}
	
	
	public List<Corso> ricercaCorsiStudente(int matricola){
		
		StudenteDAO s = new StudenteDAO();
		return s.listaCorsiStudente(matricola);

	}
	
	public boolean studenteCorso(int matricola, Corso corso) {
		CorsoDAO c = new CorsoDAO();
		return c.studenteInCorso(matricola, corso);
	}
	
	public boolean iscriviStudent(Studente studente, Corso corso){
		CorsoDAO c = new CorsoDAO();
		StudenteDAO s = new StudenteDAO();
		
		if(s.completamentoAutomatico(studente.getMatricola())==null) {
			return false;
		}
		
		if(c.getCorso(corso)==null) {
			return false;
		}
		
		if(c.studenteInCorso(studente.getMatricola(), corso)) {
			return false;
		}
		
		return c.inscriviStudenteACorso(studente, corso);
		
		
	}

}
