package fes.aragon.test;

import fes.aragon.utilerias.dinamicas.pila.Pila;

public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("----------Hannoi recursivo-----------");
		hanoiRecu(5, 'A', 'B', 'C');
		System.out.println("----------Hannoi iterativo-----------");
		hanoiIte(5, 'A', 'B', 'C');
	}

	public static void hanoiRecu(int n, char origen, char destino, char auxiliar) {
		
		if (n == 1) {
			System.out.println("mover un disco de: " + origen + " a: " + destino);
		} else {
			hanoiRecu(n - 1, origen, auxiliar, destino);
			System.out.println("mover un disco de: " + origen + " a: " + destino);
			hanoiRecu(n - 1, auxiliar, destino, origen);
		}
	}

	public static void hanoiIte(int n, char origen, char destino, char auxiliar) throws Exception {
		int tope = 0;
		boolean band = false;
		char varAux;
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
			System.out.println("Mover un disco de: " + origen + " a: " + destino);
			band = true;
			if (tope > 0) {
				n = pilaN.extraer();
				origen = pilaO.extraer();
				destino = pilaD.extraer();
				auxiliar = pilaX.extraer();
				tope--;
				System.out.println("Mover un disco de: " + origen + " a: " + destino);
				n--;
				varAux = origen;
				origen = auxiliar;
				auxiliar = varAux;
				band = false;
			}
		}
	}
}
