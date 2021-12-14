package fes.aragon.utilerias.dinamicas.arbolbinario.nodos;

import fes.aragon.utilerias.dinamicas.Cola.Cola;
import fes.aragon.utilerias.dinamicas.pila.Pila;

public class ArbolBinarioExpresion<E> {
	protected Nodo<E> raiz;

	public ArbolBinarioExpresion() {
		raiz = null;
	}

	public Nodo<E> getRaiz() {
		return raiz;
	}

	@SuppressWarnings("unchecked")
	public void insertarExperion(String[] datos) throws Exception {
		Nodo<String> nuevo = null;
		Nodo<String> ultimo = null;
		Pila<Nodo<String>> pila = new Pila<>();
		String simbolo = datos[0];
		nuevo = new Nodo<>(simbolo, "raiz");
		raiz = (Nodo<E>) nuevo;
		String sigMov = "izq";
		for (int i = 1; i < datos.length; i++) {
			simbolo = datos[i];
			ultimo = nuevo;
			nuevo = new Nodo<>(simbolo, "Padre= " + ultimo.dato);
			if (sigMov.equals("izq")) {
				nuevo.etiqueta = "Hijo izquierdo Padre= " + ultimo.dato;
				ultimo.izquierdo = nuevo;
				pila.insertar(ultimo);
			} else {
				ultimo = pila.extraer();
				nuevo.etiqueta = "Hijo derecho Padre= " + ultimo.dato;
				ultimo.derecho = nuevo;
			}
			if (simbolo.equals("+") || simbolo.equals("-") || simbolo.equals("*") || simbolo.equals("/")) {
				sigMov = "izq";
			} else {
				sigMov = "der";
			}
		}
	}

	public double evaluar() throws Exception {
		Pila<Nodo<String>> pila = new Pila<>();
		Nodo<String> ultimo = (Nodo<String>) raiz;
		if (esOperador((E) ultimo.derecho.dato) && esOperador((E) ultimo.izquierdo.dato)) {
			while (ultimo != null && esOperador((E) ultimo.dato)) {
				pila.insertar((Nodo<String>) ultimo);
				ultimo = ultimo.derecho;
			}
			ultimo = (Nodo<String>) raiz.izquierdo;
			while (ultimo != null && esOperador((E) ultimo.dato)) {
				pila.insertar((Nodo<String>) ultimo);
				ultimo = ultimo.izquierdo;
			}
		} else if (esOperador((E) ultimo.derecho.dato)) {
			while (ultimo != null && esOperador((E) ultimo.dato)) {
				pila.insertar((Nodo<String>) ultimo);
				ultimo = ultimo.derecho;
			}
		} else if (esOperador((E) ultimo.izquierdo.dato)) {
			while (ultimo != null && esOperador((E) ultimo.dato)) {
				pila.insertar((Nodo<String>) ultimo);
				ultimo = ultimo.izquierdo;
			}
		}
		while (!pila.estaVacia()) {
			Nodo<String> aux = pila.extraer();
			double dato2 = Double.parseDouble(aux.izquierdo.dato);
			double dato1 = Double.parseDouble(aux.derecho.dato);
			double op = 0.0;
			if (aux.dato.equals("+")) {
				op = dato2 + dato1;
			} else if (aux.dato.equals("-")) {
				op = dato2 - dato1;
			} else if (aux.dato.equals("/")) {
				op = dato2 / dato1;
			} else if (aux.dato.equals("*")) {
				op = dato2 * dato1;
			}
			aux.dato = String.valueOf(op);
		}
		return Double.parseDouble((String) raiz.dato);
	}

	public boolean esOperador(E dato) {
		if (dato.equals("+") || dato.equals("-") || dato.equals("*") || dato.equals("/")) {
			return true;
		} else {
			return false;
		}
	}

	public void imprimir(Nodo<E> n) {
		System.out.println(n.dato + " " + n.etiqueta);
	}

	public void recorridoAmplitud() throws Exception {
		Nodo<E> n = raiz;
		Cola<Nodo<E>> cola = new Cola<>();
		if (n != null) {
			cola.insertar(n);
			while (!cola.estaVacia()) {
				n = cola.extraer();
				imprimir(n);
				if (n.izquierdo != null) {
					cola.insertar(n.izquierdo);
				}
				if (n.derecho != null) {
					cola.insertar(n.derecho);
				}
			}
		}
	}
}
