package application;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

public class FormularioController {
	@FXML
	private ComboBox cmbTipo;
	@FXML
	private DatePicker txtDia;
	@FXML
	private TextField txtCantidad;
	@FXML
	private TextField txtPrecio;
	@FXML
	private Button btnRegistrar;
	@FXML
	private Button btnCancelar;

	// Event Listener on Button[#btnRegistrar].onAction
	@FXML
	public void registrar(ActionEvent event) {
		
	}
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
}
