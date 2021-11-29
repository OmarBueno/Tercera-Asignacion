package fes.aragon.utilerias.metodos;

import fes.aragon.utilerias.dinamicas.pila.Pila;

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

	public static String hanoiIte(int n, char origen, char destino, char auxiliar) throws Exception {
		int tope = 0;
		boolean band = false;
		char varAux;
		String pasos = "";
		Pila<Integer> pilaN = new Pila<>();
		Pila<Character> pilaO = new Pila<>();
		Pila<Character> pilaD = new Pila<>();
		Pila<Character> pilaX = new Pila<>();
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
			// System.out.println("Mover un disco de: " + origen + " a: " + destino);
			pasos += "Mover un disco de: " + origen + " a: " + destino + "\n";
			band = true;
			if (tope > 0) {
				n = pilaN.extraer();
				origen = pilaO.extraer();
				destino = pilaD.extraer();
				auxiliar = pilaX.extraer();
				tope--;
				// System.out.println("Mover un disco de: " + origen + " a: " + destino);
				pasos += "Mover un disco de: " + origen + " a: " + destino + "\n";
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
