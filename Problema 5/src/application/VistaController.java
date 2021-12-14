package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
	@FXML
	private TextArea txtArbol;

	// Event Listener on Button[#btnEvaluar].onAction
	@FXML
	public void evaluar(ActionEvent event) {
		ArbolBinarioExpresion<String> arbol = new ArbolBinarioExpresion<>();
		String expresion = txtExpresion.getText();
		String datos[] = expresion.split(" ");
		try {
			arbol.insertarExperion(datos);
			arbol.recorridoAmplitud();
			txtResultado.clear();
			txtResultado.setText(String.valueOf(arbol.evaluar()));

			txtArbol.clear();
			txtArbol.setText(arbol.getConstruccion());
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error en la expresion");
			alert.setContentText("Revise la expresión, los caracteres deben estar separados por espacios");
			alert.showAndWait();

		}
	}

	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void salir(ActionEvent event) {
		System.exit(0);
	}
}
