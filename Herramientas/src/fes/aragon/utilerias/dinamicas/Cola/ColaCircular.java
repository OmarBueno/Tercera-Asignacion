package fes.aragon.utilerias.dinamicas.Cola;

public class ColaCircular<E> extends Cola<E> {
	private int datos = 0;

	public ColaCircular() {
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

	public void matar(int k, int n) throws Exception {
		if (datos > 1) {
			if(datos==n) {
				extraer();
			}
			for (int i = 1; i < k; i++) {
				E aux = extraer();
				System.out.println("Vive: "+aux);
				insertar(aux);
			}
			System.out.println("Muere: "+extraer());
			matar(k, n);
		}
	}
}
