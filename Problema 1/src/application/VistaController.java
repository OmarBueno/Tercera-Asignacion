package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import fes.aragon.modelo.Accion;
import fes.aragon.modelo.Cartera;
import fes.aragon.utilerias.archivos.Archivos;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VistaController {
	@FXML
	private TextArea txtTexto;
	@FXML
	private Button btnCargar;
	@FXML
	private Button btnGuardar;
	@FXML
	private Button btnOperacion;
	@FXML
	private Button btnEvaluar;
	@FXML
	private Button btnActualizzar;
	private File archivoTxt;
	public static boolean insertar = false;

	// Event Listener on Button[#btnCargar].onAction
	@FXML
	public void cargarArchivo(ActionEvent event) {
		txtTexto.clear();
		this.archivoTxt = Archivos.buscar(this.txtTexto);
	}

	// Event Listener on Button[#btnGuardar].onAction
	@FXML
	public void guardarArchivo(ActionEvent event) {
		Archivos.guardar(txtTexto);

	}

	// Event Listener on Button[#btnOperacion].onAction
	@FXML
	public void nuevaOperacion(ActionEvent event) throws IOException, InterruptedException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Formulario.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.showAndWait();
		actualizar(event);
	}

	@FXML
	void actualizar(ActionEvent event) {
		if (Archivos.getDato() != null) {
			txtTexto.appendText(Archivos.getDato() + "\n");
			Archivos.setDato(null);
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@FXML
	void evaluar(ActionEvent event) {
		if (!txtTexto.getText().isEmpty()) {
			String aux = txtTexto.getText();
			String datos[] = aux.split("\n");
			Cartera c1 = new Cartera();
			for (String string : datos) {
				String[] arr = string.split(",");
				Accion accion = new Accion(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]),
						Integer.parseInt(arr[3]));
				c1.insertar(accion);
			}
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Evaluacion");
			alert.setContentText(c1.instrucciones + "\n" + "Ganancia Total de compra y venta de acciones: $"
					+ c1.getGananciaTotal());
			alert.showAndWait();

		} else {
			JOptionPane.showMessageDialog(null, "Debe introducir datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
