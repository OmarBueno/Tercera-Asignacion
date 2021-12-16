package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import fes.aragon.alg.Dijkstra;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class VistaController {
	@FXML
	private TextField txtInicio;
	@FXML
	private TextField txtFin;
	@FXML
	private TextArea txtCamino;
	@FXML
	private Button btnEvaluar;
	@FXML
	private Button btnSalir;

	// Event Listener on Button[#btnEvaluar].onAction
	@FXML
	public void evaluar(ActionEvent event) {
		Dijkstra app = new Dijkstra();
		app.iniciarConfiguracion();
		try {
			app.implementar(txtInicio.getText(), txtFin.getText());
			txtCamino.setText(app.instrucciones());
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Revise la entrada de datos");
			alert.showAndWait();
		}
	}

	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void salir(ActionEvent event) {
		System.exit(0);
	}
}
