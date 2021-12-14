package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import fes.aragon.utilerias.dinamicas.arbolbinario.nodos.ArbolBinarioExpresion;
import javafx.event.ActionEvent;

public class VistaController {
	@FXML
	private TextField txtExpresion;
	@FXML
	private TextField txtResultado;
	@FXML
	private Button btnEvaluar;
	@FXML
	private Button btnSalir;

	// Event Listener on Button[#btnEvaluar].onAction
	@FXML
	public void evaluar(ActionEvent event) {
		ArbolBinarioExpresion<String> arbol = new ArbolBinarioExpresion<>();
		String expresion = txtExpresion.getText();
		String datos[] = expresion.split(" ");
		try {
			arbol.insertarExperion(datos);
			txtResultado.clear();
			txtResultado.setText(String.valueOf(arbol.evaluar()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");

		}
	}

	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void salir(ActionEvent event) {
		System.exit(0);
	}
}
