package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import fes.aragon.modelo.Accion;
import fes.aragon.utilerias.archivos.Archivos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

public class FormularioController implements Initializable {
	@FXML
	private ComboBox<String> cmbTipo;
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
		String aux, aux2;
		if (cmbTipo.getSelectionModel().getSelectedIndex() == 0) {
			aux = "C";
		} else {
			aux = "V";
		}
		aux2 = aux + "," + Integer.parseInt(txtCantidad.getText()) + "," + Double.parseDouble(txtPrecio.getText()) + ","
				+ txtDia.getValue().getDayOfMonth();
		Archivos.setDato(aux2);
		cancelar(event);

	}

	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Compra", "Venta");
		cmbTipo.setItems(items);
		cmbTipo.getSelectionModel().select(0);

	}
}
