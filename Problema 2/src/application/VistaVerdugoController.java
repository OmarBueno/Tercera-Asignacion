package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import fes.aragon.utilerias.dinamicas.Cola.ColaVerdugo;
import javafx.event.ActionEvent;

public class VistaVerdugoController {
	@FXML
	private TextField txtPrisioneros;
	@FXML
	private Button btnEvaluar;
	@FXML
	private TextField txtPasos;
	@FXML
	private TextField txtAmigo;
	@FXML
	private Button btnSalir;

	// Event Listener on Button[#btnEvaluar].onAction
	@FXML
	public void evaluar(ActionEvent event) {
		try {
			if (!txtAmigo.getText().isEmpty() && !txtPrisioneros.getText().isEmpty() && !txtPasos.getText().isEmpty()) {
				ColaVerdugo<Integer> cola = new ColaVerdugo<>();
				int n = Integer.parseInt(txtPrisioneros.getText());
				int k = Integer.parseInt(txtPasos.getText());
				int a = Integer.parseInt(txtAmigo.getText());
				if (a <= n) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Evaluacion");
					alert.setContentText(cola.salvarAmigo(k, n, a));
					alert.showAndWait();
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error de formato");
					alert.setContentText("La posicion del amigo excede el numero de prisioneros");
					alert.showAndWait();
				}
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error de formato");
				alert.setContentText("Debe ingresar datos");
				alert.showAndWait();
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error de formato");
			alert.setContentText("Debe ingresar numeros enteros");
			alert.showAndWait();
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Error");
			alert.showAndWait();
		}

	}

	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void salir(ActionEvent event) {
		System.exit(0);
	}
}
