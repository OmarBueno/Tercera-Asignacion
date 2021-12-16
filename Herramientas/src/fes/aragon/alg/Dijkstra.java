package fes.aragon.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import fes.aragon.utilerias.dinamicas.pila.Pila;

/**
 * Clase que implementa un grafo
 * 
 * @author Equipo 9 Sol Martinez Edith, Bueno Zaldivar Omar Alejandro
 *
 */
public class Dijkstra {
	private int matriz[][] = { { 0, 2, 0, 0, 0, 1, 0, 0 }, { 2, 0, 2, 2, 4, 0, 0, 0 }, { 0, 2, 0, 0, 3, 0, 0, 1 },
			{ 0, 2, 0, 0, 4, 3, 0, 0 }, { 0, 4, 3, 4, 0, 0, 7, 0 }, { 1, 0, 0, 3, 0, 0, 5, 0 },
			{ 0, 0, 0, 0, 7, 5, 0, 6 }, { 0, 0, 1, 0, 0, 0, 6, 0 } };
	private String T[] = { "a", "b", "c", "d", "e", "f", "g", "z" };
	private List<String> TT = new ArrayList<String>();
	private List<String> verticesCamino = new ArrayList<String>();
	private ArrayList<Vertice> grafo = new ArrayList<>();
	private Pila<String> pila = new Pila<>();

	/**
	 * Metodo que crea el grafo
	 */
	public void iniciarConfiguracion() {
		for (int i = 0; i < T.length; i++) {
			grafo.add(new Vertice(T[i], null));
			TT.add(T[i]);
		}
	}

	/**
	 * Metodo que devuelve los vertives adyacentes a otro
	 * 
	 * @param vertice Vertice a buscar
	 * @return Nodos adyacentes del vertice
	 */
	private ArrayList<String> adyacentes(String vertice) {
		int fila = posicionMatirizFilaColumna(vertice);
		ArrayList<String> adyacentes = new ArrayList<>();
		ArrayList<String> adyacentesDinamicos = new ArrayList<>();
		for (int i = 0; i < T.length; i++) {
			if (matriz[fila][i] > 0) {
				adyacentes.add(T[i]);
			}
		}
		for (String tt : TT) {
			for (String ad : adyacentes) {
				if (tt.equals(ad)) {
					adyacentesDinamicos.add(ad);
				}
			}
		}
		return adyacentesDinamicos;
	}

	/**
	 * Metodo que devuelve la posición de un vertice
	 * 
	 * @param vertice Vertice a buscar
	 * @return Posicion en la fila o columna
	 */
	private int posicionMatirizFilaColumna(String vertice) {
		int indice = -1;
		for (int i = 0; i < T.length; i++) {
			if (T[i].equals(vertice)) {
				indice = i;
			}
		}
		return indice;
	}

	/**
	 * Metodo que devuelve el peso entre dos vertices
	 * 
	 * @param v1 Vertice 1
	 * @param v2 Verttice 2
	 * @return Peso
	 */
	private int peso(String v1, String v2) {
		int filaColumnaV1 = posicionMatirizFilaColumna(v1);
		int filaColumnaV2 = posicionMatirizFilaColumna(v2);
		int peso = matriz[filaColumnaV1][filaColumnaV2];
		return peso;
	}

	/**
	 * Metodo para cambiar la etiqueta de un vertice
	 * 
	 * @param nodo  Vertice a cambiar
	 * @param valor Valor a cambiar
	 */
	private void cambiarEtiqueta(String nodo, int valor) {
		for (Vertice vv : grafo) {
			if (vv.getNombre().equals(nodo)) {
				vv.setEtiqueta(valor);
				break;
			}
		}
	}

	/**
	 * Metodo que devuelve la etiqueta de un nodo
	 * 
	 * @param nodo Nodo a bucar
	 * @return Etiqueta
	 */
	private Integer obtenerEtiqueta(String nodo) {
		for (Vertice vv : grafo) {
			if (vv.getNombre().equals(nodo)) {
				return vv.getEtiqueta();
			}
		}
		return null;
	}

	/**
	 * Funcion que devuelve el minimo entre 2 numeros
	 * 
	 * @param a Numero 1
	 * @param b Numero 2
	 * @return El minimo
	 */
	private Integer minimo(Integer a, Integer b) {
		if (a == null) {
			return b;
		} else if (a > b) {
			return b;
		} else {
			return a;
		}
	}

	/**
	 * Metodo que busca el nodo con valor minimo dentro del grafo
	 * 
	 * @return El nodo con valor minimo
	 */
	private String buscarMinimo() {
		Integer minimo = null;
		ArrayList<Vertice> etiquetas = new ArrayList<>();
		ArrayList<Adyacente> listaAdyacentes = new ArrayList<>();
		for (int i = 0; i < TT.size(); i++) {
			for (Vertice v : grafo) {
				if (v.getNombre().equals(TT.get(i))) {
					etiquetas.add(v);
				}
			}
		}
		for (int i = 0; i < etiquetas.size(); i++) {
			if (etiquetas.get(i).getEtiqueta() != null) {
				listaAdyacentes.add(new Adyacente(etiquetas.get(i).getNombre(), etiquetas.get(i).getEtiqueta()));
			}
		}
		minimo = listaAdyacentes.get(0).getValor();
		int minimo2 = 0;
		if (listaAdyacentes.size() > 1) {
			for (int i = 0; i < listaAdyacentes.size(); i++) {
				if (listaAdyacentes.get(i).getValor() < minimo) {
					minimo2 = i;
					minimo = listaAdyacentes.get(i).getValor();
				}
			}
		} else {
			minimo2 = 0;
		}
		return listaAdyacentes.get(minimo2).getNombre();
	}

	/**
	 * Metodo que elimina un vertice
	 * 
	 * @param nodo Vertice a eliminar
	 */
	private void eliminarNodo(String nodo) {
		for (int i = 0; i < TT.size(); i++) {
			if (TT.get(i).equals(nodo)) {
				TT.remove(i);
				break;
			}
		}
	}

	/**
	 * Metodo que indica si un nodo pertenece al gafo
	 * 
	 * @param nodo Nodo a buscar
	 * @return True si pertenece, False si no pertenece
	 */
	private boolean pertenece(String nodo) {
		for (String dato : TT) {
			if (dato.equals(nodo)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que asigna los pesos a los nodos
	 * 
	 * @param inicio Nodo inicial
	 * @param fin    Nodo final
	 * @throws Exception Error
	 */
	public void implementar(String inicio, String fin) throws Exception {
		cambiarEtiqueta(inicio, 0);
		while (pertenece(fin)) {
			String v = buscarMinimo();
			this.verticesCamino.add(v);
			eliminarNodo(v);
			ArrayList<String> adyacentes = adyacentes(v);
			for (String x : adyacentes) {
				cambiarEtiqueta(x, minimo(obtenerEtiqueta(x), obtenerEtiqueta(v) + peso(v, x)));
			}
		}
		camino(inicio, fin);
	}

	/**
	 * Metodo que indica el nodo minimo adyacente con menor peso
	 * 
	 * @param listaAdyacentes Nodos adyacentes
	 * @return Minimo adyacente
	 */
	private String minimoAdyacentes(ArrayList<String> listaAdyacentes) {
		int minimo = obtenerEtiqueta(listaAdyacentes.get(0));
		int minimo2 = 0;
		if (listaAdyacentes.size() > 1) {
			for (int i = 0; i < listaAdyacentes.size(); i++) {
				if (obtenerEtiqueta(listaAdyacentes.get(i)) < minimo) {
					minimo2 = i;
					minimo = obtenerEtiqueta(listaAdyacentes.get(i));
				}
			}
		} else {
			minimo2 = 0;
		}
		return listaAdyacentes.get(minimo2);

	}

	/**
	 * MEtodo que busca el camino mas corto de un vertice a otro
	 * 
	 * @param inicio Vertice inicial
	 * @param fin    Vertice final
	 * @throws Exception Error
	 */
	public void camino(String inicio, String fin) throws Exception {
		TT.clear();
		for (int i = 0; i < T.length; i++) {
			TT.add(T[i]);
		}
		while (pertenece(inicio)) {
			if (fin.equals(inicio)) {
				break;
			}
			ArrayList<String> adyacentes = adyacentes(fin);
			eliminarNodo(fin);
			pila.insertar(fin);
			fin = minimoAdyacentes(adyacentes);
		}
		pila.insertar(fin);
	}

	/**
	 * Metodo que indica las instrucciones del recorrito
	 * 
	 * @return Instrucciones
	 */
	public String instrucciones() {
		int recorridoT = 0;
		String camino = "";
		while (!pila.estaVacia()) {
			try {
				String aux = pila.extraer();
				String aux2 = pila.extraer();
				int recorrido = obtenerEtiqueta(aux2) - obtenerEtiqueta(aux);
				recorridoT += recorrido;
				camino += "Pasa de: " + aux + " a: " + aux2 + " Con un recorrido de: " + recorrido + "\n";
				pila.insertar(aux2);
			} catch (Exception e) {
			}
		}
		camino += "Recorrido Total: " + recorridoT;
		return camino;
	}

}
