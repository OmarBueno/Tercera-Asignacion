package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import fes.aragon.utilerias.metodos.Hanoi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class VistaController implements Initializable {
	@FXML
	private TextField txtDiscos;
	@FXML
	private Button btnPasos;
	@FXML
	private Button btnSalir;
	@FXML
	private ComboBox<String> cmbLLamadas;
	@FXML
	private TextArea txtPasos;

	// Event Listener on Button[#btnPasos].onAction
	@FXML
	public void pasos(ActionEvent event) {
		if (!txtDiscos.getText().isEmpty()) {
			try {
				if (cmbLLamadas.getSelectionModel().getSelectedIndex() == 0) {
					Hanoi.setPasos("");
					Hanoi.hanoiRecu(Integer.parseInt(txtDiscos.getText()), 'A', 'B', 'C');
					txtPasos.clear();
					txtPasos.setText(Hanoi.getPasos());
				} else if (cmbLLamadas.getSelectionModel().getSelectedIndex() == 2) {
					txtDiscos.setText("5");
					txtPasos.clear();
					txtPasos.setText(Hanoi.hanoiIteVisual(5, 'A', 'B', 'C'));
				} else {
					txtPasos.clear();
					txtPasos.setText(Hanoi.hanoiIte(Integer.parseInt(txtDiscos.getText()), 'A', 'B', 'C'));
				}
			} catch (NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Debe ingresar Un numero entero valido");
				alert.showAndWait();
			} catch (Exception e) {
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debe ingresar el numero de discos");
			alert.showAndWait();
		}
	}

	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void salir(ActionEvent event) {
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Recursivas", "Iterativas", "Visual 5 discos");
		cmbLLamadas.setItems(items);
		cmbLLamadas.getSelectionModel().select(0);
	}
}
