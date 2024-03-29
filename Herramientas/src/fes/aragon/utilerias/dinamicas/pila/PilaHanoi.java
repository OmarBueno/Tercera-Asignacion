package fes.aragon.utilerias.dinamicas.pila;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

/**
 * Clase que crea una Pila
 *
 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
 *
 * @param <E> Tipo de datos a almacenar
 */
public class PilaHanoi<E> {
	private ListaSimple<E> pila = new ListaSimple<>();
	// private ListaSimple<E> elementos = new ListaSimple<>();

	/**
	 * elimina los elementos de la pila
	 */
	public void borrar() {
		pila = new ListaSimple<>();
	}

	/**
	 * Intica si la pila esta vacia
	 * 
	 * @return True si es vacia False si tiene elementos
	 */
	public boolean estaVacia() {
		return pila.esVacia();
	}

	/**
	 * Inserta un elemento a la pila
	 * 
	 * @param dato Elemento a insertar
	 */
	public void insertar(E dato) {
		pila.agregarEnCola(dato);
	}

	/**
	 * Extrae el ultimo elemento agregado de la pila
	 * 
	 * @return Ultimo dato de la pila
	 * @throws Exception Pila Vacia
	 */
	public E extraer() throws Exception {
		E tmp = null;
		if (!estaVacia()) {
			tmp = pila.obtenerCola();
			pila.eliminarEnCola();
			;
		} else {
			throw new Exception("Pila Vacia");
		}
		return tmp;

	}

	/**
	 * Devuelve el elemento superior de la pila
	 * 
	 * @return Elemento Superior
	 * @throws Exception Pila Vacia
	 */
	public E elementoSuperior() throws Exception {
		E tmp = null;
		if (!estaVacia()) {
			tmp = pila.obtenerCola();
		} else {
			throw new Exception("Pila Vacia");
		}
		return tmp;
	}

	public String imprimir() throws Exception {
		String info="";
		ListaSimple<E> elementos = new ListaSimple<>();
		while (!pila.esVacia()) {
			elementos.agregarEnCola(extraer());
		}
		for (int i = 0; i < elementos.getLongitud(); i++) {
			//System.out.println(elementos.obtenerNodo(i));
			info+=elementos.obtenerNodo(i)+"\n";
		}
		for (int i = elementos.getLongitud() - 1; i >= 0; i--) {
			insertar(elementos.obtenerNodo(i));
		}
		return info;
	}

}
