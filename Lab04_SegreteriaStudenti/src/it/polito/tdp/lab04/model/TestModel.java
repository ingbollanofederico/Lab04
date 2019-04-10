package it.polito.tdp.lab04.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		//completamento automatico
		int matricola = 151528;
		Studente s = model.avviaCompletamentoAutomatico(matricola);
		System.out.println(s);
		
		/*Corso c = new Corso("02PBVPG", 8, "Analisi dei sistemi economici", 1);
		List<Studente> l = model.ricercaStudentiCorso(c);
		
		for(Studente ss : l) {
			System.out.println(ss);
		}*/
		
		Corso c = new Corso("01KSUPG", 8, "Gestione dell'innovazione e sviluppo prodotto", 2);
		List<Studente> l = model.ricercaStudentiCorso(c);
		
		
		List<Corso> cc = model.listAllCorso();
		System.out.println(cc);
		
		Studente st = new Studente(161245,null,null,null);
		Corso cr = new Corso("02PBVPG", 8, "Analisi dei sistemi economici", 1);
		boolean trovato = model.iscriviStudent(st, cr);
		
		System.out.println(trovato);

		
		
	}

}
