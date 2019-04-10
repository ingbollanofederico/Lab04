package it.polito.tdp.lab04.DAO;

import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		Corso c = new Corso("01KSUPG", 8, "Gestione dell'innovazione e sviluppo prodotto", 2);
		List<Studente> l = cdao.getStudentiIscrittiAlCorso(c);
		
		for(Studente ss : l) {
			System.out.println(ss);
		}

	}

}
