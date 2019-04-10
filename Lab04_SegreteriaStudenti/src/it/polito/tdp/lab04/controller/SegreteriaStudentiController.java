package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> cmboxSelezionaCorso;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnGenera;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtAreaResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	
    	try {
    	
    		Studente s = model.avviaCompletamentoAutomatico(Integer.parseInt(this.txtMatricola.getText()));
        	
        	if(s==null) {
        		this.txtAreaResult.appendText("La matricola inserita non è presente!\n");
        	}else {
    		
        		List<Corso> list = model.ricercaCorsiStudente(Integer.parseInt(this.txtMatricola.getText()));
    	
        		for(Corso c : list) {
        			this.txtAreaResult.appendText(c.toString()+"\n");
        		}
        	}
    		
    	}catch (NumberFormatException e) {
		this.txtAreaResult.appendText("Inserisci una matricola. Non fare il furbo!\n");
    	}
    
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	
    	//controllo utente che non inserisce nulla
    	if(this.cmboxSelezionaCorso.getValue()==null) {
    		this.txtAreaResult.appendText("Non è stato selezionato un corso!\n");
    		return;
    	}
    
    	
    	if(this.txtMatricola.getText().compareTo("")==0) {
    		Corso c = this.cmboxSelezionaCorso.getValue();
    		List<Studente> list = model.ricercaStudentiCorso(c);
    	
    		for(Studente s : list) {
    			this.txtAreaResult.appendText(s.toString()+"\n");
    	}
    }else {
    	
    	try {
    		boolean trovato = model.studenteCorso(Integer.parseInt(this.txtMatricola.getText()), this.cmboxSelezionaCorso.getValue());
    		
    		if(trovato==true) {
    			this.txtAreaResult.appendText("Lo studente "+this.txtMatricola.getText()+" è registrato al corso "+this.cmboxSelezionaCorso.getValue().getNome()+"\n");
    		}else {
    			this.txtAreaResult.appendText("Lo studente "+this.txtMatricola.getText()+" NON è registrato al corso "+this.cmboxSelezionaCorso.getValue().getNome()+"\n");
    		}
    		
    		
    	}catch (NumberFormatException e) {
    		this.txtAreaResult.appendText("Inserisci una matricola. Non fare il furbo!\n");
    	}
    }

    }

    @FXML
    void doGenera(ActionEvent event) {
    	
    	try {
    	Studente s = model.avviaCompletamentoAutomatico(Integer.parseInt(this.txtMatricola.getText()));
    	
    	if(s==null) {
    		this.txtAreaResult.appendText("La matricola inserita non è presente. Inserire la matricola corretta o aggiungere la nuova matricola!\n");
    	}else {
    		this.txtCognome.setText(s.getCognome());
    		this.txtNome.setText(s.getNome());
    	}
    	}catch (NumberFormatException e) {
    		this.txtAreaResult.appendText("Inserisci una matricola. Non fare il furbo!\n");
    	}
    	

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	if(this.txtMatricola.getText().compareTo("")==0 || this.cmboxSelezionaCorso.getValue()==null) {
    		this.txtAreaResult.appendText("Inserisci una matricola o seleziona un corso!\n");
    	}else {
    
    	boolean inserimento = false;
    	
    	try {
    	Studente s = new Studente(Integer.parseInt(txtMatricola.getText()), "","","");
    	Corso c = this.cmboxSelezionaCorso.getValue();
    	
    	inserimento= model.iscriviStudent(s, c);
    			
    	}catch (NumberFormatException e) {
    		this.txtAreaResult.appendText("Inserisci una matricola. Non fare il furbo!\n");
    	}

    	if(inserimento) {
    		this.txtAreaResult.appendText("La matricola "+this.txtMatricola.getText()+" è stata iscritta al corso "+this.cmboxSelezionaCorso.getValue()+"\n");
    	}else {
    		this.txtAreaResult.appendText("Non è stato possibile iscrivere la matricola "+this.txtMatricola.getText()+" al corso "+this.cmboxSelezionaCorso.getValue()+"\n");
    	}
    	
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtAreaResult.clear();
    	this.txtCognome.clear();
    	this.txtNome.clear();
    	this.txtMatricola.clear();
    	this.cmboxSelezionaCorso.getSelectionModel().clearSelection();

    }

    @FXML
    void initialize() {
        assert cmboxSelezionaCorso != null : "fx:id=\"cmboxSelezionaCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtAreaResult != null : "fx:id=\"txtAreaResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }



	public void setModel(Model model) { //COME SI SA LA COMBOBOX!!!
		this.model=model;
		
		this.cmboxSelezionaCorso.getItems().addAll(model.listAllCorso());
	}
}
