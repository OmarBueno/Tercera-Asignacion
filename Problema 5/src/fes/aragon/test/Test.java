package fes.aragon.test;

import fes.aragon.utilerias.dinamicas.arbolbinario.nodos.ArbolBinarioExpresion;

public class Test {

	public static void main(String[] args) throws Exception {
		ArbolBinarioExpresion<String> arbol = new ArbolBinarioExpresion<>();
		String expresion = "+ 2 * 3 4";
		//+ 2 * 3 4
		//+ * A C B
		//* + 1 2 - 3 4
		/// * 4 - 5 2 - * 1 5 3
		//* / -8 -2 + -2 -2
		//- * + 2 8 10 * - 15 5 + 7 20
		String datos[] = expresion.split(" ");
		arbol.insertarExperion(datos);
		System.out.println("Fin");
		arbol.recorridoAmplitud();
		System.out.println("fin 2");
		System.out.println(arbol.evaluar());
		/*ArbolBinarioOrden<Integer> arbol2 = new ArbolBinarioOrden<>();
		arbol2.insertar(4);
		arbol2.insertar(1);
		arbol2.insertar(2);
		arbol2.insertar(3);
		arbol2.insertar(5);
		System.out.println("arbol 2");
		arbol2.recorridoAmplitud();
		System.out.println("fin 2");*/
	}

}
