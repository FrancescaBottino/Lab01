package it.polito.tdp.parole;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtPerformance;

    @FXML
    void doCancella(ActionEvent event) {
    	
    	//elimina una parola
    	String selezionata= txtResult.getSelectedText();
    	
    	double start = System.nanoTime();
    	
    	elenco.removeParola(selezionata);
    	
    	double stop= System.nanoTime();
    	
    	String ris=elenco.toString();    
 	    txtResult.setText(ris);
 	    
 	    txtPerformance.setText("Cancella: "+ (stop-start)/10e9 +" secondi");

    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String parola=txtParola.getText();
    	
    	double start = System.nanoTime();
    	
    	if(!parola.equals("")) {
    	
    		elenco.addParola(parola);
    	
    	    String ris="";
    	
    	    elenco.getElenco();
    	
    	    ris=elenco.toString();
    	    
    	    double stop= System.nanoTime();
    	    
    	    txtResult.setText(ris);
    	    txtParola.setText("");
    	    txtPerformance.setText("Inserisci: "+ (stop-start)/10e9 +" secondi");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	double start = System.nanoTime();
    	elenco.reset();
    	double stop= System.nanoTime();
    	
        txtResult.setText("");
 	    txtParola.setText("");
 	    txtPerformance.setText("Reset: "+ (stop-start)/10e9 +" secondi");

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco=new Parole();

    }
}


