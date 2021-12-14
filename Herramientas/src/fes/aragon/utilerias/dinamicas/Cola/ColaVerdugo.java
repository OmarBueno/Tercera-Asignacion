package fes.aragon.utilerias.dinamicas.Cola;

/**
 * Clase que extiende de Cola para problema de verdugo
 * 
 * @author Equipo 9 Sol Martinez Edith, Bueno Zaldivar Omar Alejandro
 *
 * @param <E> Tipo de datp
 */
public class ColaVerdugo<E> extends Cola<E> {
	private int datos = 0;

	public ColaVerdugo() {
	}

	/**
	 * Inserta un dato
	 */
	@Override
	public void insertar(E dato) {
		super.insertar(dato);
		datos++;
	}

	/**
	 * Extrae un dato
	 */
	@Override
	public E extraer() throws Exception {
		datos--;
		return super.extraer();
	}

	/**
	 * Regla a seguir para salvar el amigo
	 * @param k Cada cuanto se matara
	 * @param n Numero de personas
	 * @throws Exception Error
	 */
	public void regla(int k, int n) throws Exception {
		if (datos > 1) {
			if (datos == n) {
				extraer();
			}
			for (int i = 1; i < k; i++) {
				E aux = extraer();
				insertar(aux);
			}
			extraer();
			regla(k, n);
		}
	}
	/**
	 * Metodo para salvar al amigo
	 * @param k cada cuanto se mata
	 * @param n numero de personas
	 * @param amigo posicion del amigo
	 * @return A quien matar primero
	 * @throws Exception Error
	 */
	public String salvarAmigo(int k, int n, int amigo) throws Exception {
		ColaVerdugo<Integer> cola = new ColaVerdugo<>();
		for (int i = 1; i <= n; i++) {
			cola.insertar(i);
		}
		cola.regla(k, n);
		int regla = cola.extraer() - 1;
		int inicio = amigo - regla;
		if (inicio == 0) {
			inicio = n;
		} else if (inicio < 0) {
			inicio = n + inicio;
		}
		return "Debe matar primero a: " + inicio;
	}
}
