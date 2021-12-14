package fes.aragon.utilerias.metodos;

import fes.aragon.utilerias.dinamicas.pila.PilaHanoi;
import javafx.scene.control.Alert;

public class Hanoi {
	private static String pasos = "";

	public static void hanoiRecu(int n, char origen, char destino, char auxiliar) {
		if (n == 1) {
			// System.out.println("mover un disco de: " + origen + " a: " + destino);
			pasos += "Mover un disco de: " + origen + " a: " + destino + "\n";
		} else {
			hanoiRecu(n - 1, origen, auxiliar, destino);
			// System.out.println("mover un disco de: " + origen + " a: " + destino);
			pasos += "Mover un disco de: " + origen + " a: " + destino + "\n";
			hanoiRecu(n - 1, auxiliar, destino, origen);
		}
	}

	public static String getPasos() {
		return pasos;
	}

	public static void setPasos(String pas) {
		pasos = pas;
	}

	public static String hanoiIteVisual(int n, char origen, char destino, char auxiliar) throws Exception {
		String datos[] = { "*********", " ******* ", "  *****  ", "   ***   ", "    *    " };
		PilaHanoi<String> pila1 = new PilaHanoi<>();
		PilaHanoi<String> pila2 = new PilaHanoi<>();
		PilaHanoi<String> pila3 = new PilaHanoi<>();
		for (String dato : datos) {
			pila1.insertar(dato);
		}
		int tope = 0;
		boolean band = false;
		char varAux;
		String pasos = "";
		PilaHanoi<Integer> pilaN = new PilaHanoi<>();
		PilaHanoi<Character> pilaO = new PilaHanoi<>();
		PilaHanoi<Character> pilaD = new PilaHanoi<>();
		PilaHanoi<Character> pilaX = new PilaHanoi<>();
		while (n > 0 && band == false) {
			while (n > 1) {
				tope++;
				pilaN.insertar(n);
				pilaO.insertar(origen);
				pilaD.insertar(destino);
				pilaX.insertar(auxiliar);
				n--;
				varAux = destino;
				destino = auxiliar;
				auxiliar = varAux;
			}
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Pasos");
			pasos += "Mover un disco de: " + origen + " a: " + destino + "\n";
			if (origen == 'A' && destino == 'B') {
				pila2.insertar(pila1.extraer());
				alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
						+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
				alert.showAndWait();
			} else if (origen == 'A' && destino == 'C') {
				pila3.insertar(pila1.extraer());
				alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
						+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
				alert.showAndWait();
			} else if (origen == 'B' && destino == 'A') {
				pila1.insertar(pila2.extraer());
				alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
						+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
				alert.showAndWait();
			} else if (origen == 'B' && destino == 'C') {
				pila3.insertar(pila2.extraer());
				alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
						+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
				alert.showAndWait();
			} else if (origen == 'C' && destino == 'A') {
				pila1.insertar(pila3.extraer());
				alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
						+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
				alert.showAndWait();
			} else if (origen == 'C' && destino == 'B') {
				pila2.insertar(pila3.extraer());
				alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
						+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
				alert.showAndWait();
			}
			band = true;
			if (tope > 0) {
				n = pilaN.extraer();
				origen = pilaO.extraer();
				destino = pilaD.extraer();
				auxiliar = pilaX.extraer();
				tope--;
				n--;
				if (origen == 'B' && destino == 'A') {
					pila1.insertar(pila2.extraer());
					alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
							+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
					alert.showAndWait();
				} else if (origen == 'B' && destino == 'C') {
					pila3.insertar(pila2.extraer());
					alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
							+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
					alert.showAndWait();
				} else if (origen == 'A' && destino == 'B') {
					pila2.insertar(pila1.extraer());
					alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
							+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
					alert.showAndWait();
				} else if (origen == 'A' && destino == 'C') {
					pila3.insertar(pila1.extraer());
					alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
							+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
					alert.showAndWait();
				} else if (origen == 'C' && destino == 'A') {
					pila1.insertar(pila3.extraer());
					alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
							+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
					alert.showAndWait();
				} else if (origen == 'C' && destino == 'B') {
					pila2.insertar(pila3.extraer());
					alert.setContentText("Mover un disco de: " + origen + " a: " + destino + "\n" + "Pila A: \n"
							+ pila1.imprimir() + "Pila B: \n" + pila2.imprimir() + "Pila C \n" + pila3.imprimir());
					alert.showAndWait();
				}
				varAux = origen;
				origen = auxiliar;
				auxiliar = varAux;
				band = false;
			}
		}
		return pasos;
	}
	public static String hanoiIte(int n, char origen, char destino, char auxiliar) throws Exception {
		int tope = 0;
		boolean band = false;
		char varAux;
		String pasos = "";
		PilaHanoi<Integer> pilaN = new PilaHanoi<>();
		PilaHanoi<Character> pilaO = new PilaHanoi<>();
		PilaHanoi<Character> pilaD = new PilaHanoi<>();
		PilaHanoi<Character> pilaX = new PilaHanoi<>();
		while (n > 0 && band == false) {
			while (n > 1) {
				tope++;
				pilaN.insertar(n);
				pilaO.insertar(origen);
				pilaD.insertar(destino);
				pilaX.insertar(auxiliar);
				n--;
				varAux = destino;
				destino = auxiliar;
				auxiliar = varAux;
			}
			pasos += "Mover un disco de: " + origen + " a: " + destino + "\n";
			band = true;
			if (tope > 0) {
				n = pilaN.extraer();
				origen = pilaO.extraer();
				destino = pilaD.extraer();
				auxiliar = pilaX.extraer();
				tope--;
				n--;
				varAux = origen;
				origen = auxiliar;
				auxiliar = varAux;
				band = false;
			}
		}
		return pasos;
	}
}
