package fes.aragon.utilerias.archivos;

import java.io.*;

import javax.swing.JOptionPane;

import javafx.scene.control.TextArea;
import javafx.stage.*;

/**
 * Clase para manejar archivos con JavaFx
 * 
 * @author omar1
 *
 */
public class Archivos {
	private static String dato;

	/**
	 * Metodo que abre el selector de archivos para seleccionar
	 * 
	 * @param txtTexto Area de texto para escribir informacion
	 * @return Archivo seleccionado
	 */
	public static File buscar(TextArea txtTexto) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Archivo");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt", "*.txt"),
				new FileChooser.ExtensionFilter("TXT", "*.TXT"));
		File archivo = fileChooser.showOpenDialog(null);
		if (archivo != null) {
			FileReader fr = null;
			BufferedReader br = null;
			String texto = "";
			try {
				fr = new FileReader(archivo);
				br = new BufferedReader(fr);
				String st = br.readLine();
				while (st != null) {
					texto = texto + st + "\n";
					st = br.readLine();
				}
			} catch (Exception e) {
				txtTexto.appendText(e.toString());
			} finally {
				try {
					fr.close();
				} catch (Exception e2) {
					txtTexto.appendText(e2.toString());
				}
			}
			txtTexto.appendText(texto);
			return archivo;
		} else {
			JOptionPane.showMessageDialog(null, "Error al cargar archivo", "Erros", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	/**
	 * Metodo para guardar archivos
	 * 
	 * @param txtTexto Area de texto para leer
	 */
	public static void guardar(TextArea txtTexto) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialFileName("datos.txt");
		File file = fileChooser.showSaveDialog(null);
		if (file != null) {
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
				fw = new FileWriter(file, false);
				bw = new BufferedWriter(fw);
				String texto = txtTexto.getText();
				bw.write(texto, 0, texto.length());
			} catch (Exception e) {
				txtTexto.appendText(e.toString());
			} finally {
				try {
					bw.close();
				} catch (Exception e2) {
					txtTexto.appendText(e2.toString());
				}
			}
		}
	}

	/**
	 * Metodo para recuperar el dato guardado
	 * 
	 * @return Dato guardado
	 */
	public static String getDato() {
		return dato;
	}

	/**
	 * Metodo para insetar dato
	 * 
	 * @param dato Dato a insertar
	 */
	public static void setDato(String dato) {
		Archivos.dato = dato;
	}

}
