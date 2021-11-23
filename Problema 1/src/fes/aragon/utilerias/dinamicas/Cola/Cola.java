package fes.aragon.utilerias.dinamicas.Cola;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

	/**
	 * Clase que crea una cola
	 *
	 * @author Equipo 9 Bueno Zaldivar Omar Alejandro y Sol Martinez Edith
	 *
	 * @param <E> Tipo de datos a almacenar
	 */
public class Cola<E> {
	private ListaSimple<E> cola = new ListaSimple<>();

	/**
	 * elimina los elementos de la cola
	 */
	public void borrar() {
		cola = new ListaSimple<>();
	}

	/**
	 * Intica si la cola esta vacia
	 * 
	 * @return True si es vacia False si tiene elementos
	 */
	public boolean estaVacia() {
		return cola.esVacia();
	}

	/**
	 * Inserta un elemento a la cola
	 * 
	 * @param dato Elemento a insertar
	 */
	public void insertar(E dato) {
		cola.agregarEnCola(dato);
	}

	/**
	 * Extrae el ultimo elemento agregado de la cola
	 * 
	 * @return Ultimo dato de la cola
	 * @throws Exception cola Vacia
	 */
	public E extraer() throws Exception {
		E tmp = null;
		if (!estaVacia()) {
			tmp = cola.obtenerCabeza();
			cola.eliminarEnCabeza();
		} else {
			throw new Exception("cola Vacia");
		}
		return tmp;

	}

	/**
	 * Devuelve el elemento superior de la cola
	 * 
	 * @return Elemento Superior
	 * @throws Exception cola Vacia
	 */
	public E elementoSuperior() throws Exception {
		E tmp = null;
		if (!estaVacia()) {
			tmp = cola.obtenerCabeza();
		} else {
			throw new Exception("cola Vacia");
		}
		return tmp;
	}

}
