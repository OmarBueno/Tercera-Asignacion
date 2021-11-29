package fes.aragon.test;

import fes.aragon.utilerias.dinamicas.pila.Pila;

public class Test02 {

	public static void main(String[] args) throws Exception {
		Pila<Integer> pila = new Pila<>();
		pila.insertar(1);
		pila.insertar(2);
		pila.insertar(3);
		pila.insertar(4);
		pila.insertar(5);
		pila.imprimir();
		System.out.println("---------");
		while (!pila.estaVacia()) {
			System.out.println(pila.extraer());
		}
		int n = 5;
		int aux = n;
		Pila<String> pila1 = new Pila<>();
		Pila<String> pila2 = new Pila<>();
		Pila<String> pila3 = new Pila<>();
		for (int i = 0; i < n; i++) {
			String cadena = "";
			for (int j = aux; j > 0; j--) {
				cadena += "*";

			}
			aux--;
			pila1.insertar(cadena);
		}
		System.out.println("--------");
		pila1.imprimir();
	}

}
