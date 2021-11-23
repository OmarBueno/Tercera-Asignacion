package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	private File archivoTxt;

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
	public void nuevaOperacion(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("Formulario.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void evaluar(ActionEvent event) {
		String aux = txtTexto.getText();
		Cartera c1 = new Cartera();
		if (archivoTxt != null) {
			try {
				File archivo = archivoTxt;
				FileReader fr;
				fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] arr = linea.split(",");
					Accion accion = new Accion(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]),
							Integer.parseInt(arr[3]));
					c1.insertar(accion);
				}
				System.out.println("Ganancia Total de compra y venta de acciones: $" + c1.getGananciaTotal());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Error al cargar archivo", "Erros", JOptionPane.ERROR_MESSAGE);
		}
	}
}
