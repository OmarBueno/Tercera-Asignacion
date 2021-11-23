package fes.aragon.test;

import fes.aragon.utilerias.dinamicas.Cola.*;

public class Test {

	public static void main(String[] args) throws Exception {
		// 1,1,2,3,4,5,6,7,8
		ColaCircular<Integer> cola = new ColaCircular<>();
		for (int i = 1; i <= 8; i++) {
			cola.insertar(i);
		}
		cola.matar(8, 8);
		// regla = 1-cola.extraer();
		
		System.out.println(cola.extraer());
	}

}