package fes.aragon.utilerias.dinamicas.Cola;

public class ColaVerdugo<E> extends Cola<E> {
	private int datos = 0;

	public ColaVerdugo() {
	}

	@Override
	public void insertar(E dato) {
		super.insertar(dato);
		datos++;
	}

	@Override
	public E extraer() throws Exception {
		datos--;
		return super.extraer();
	}

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
