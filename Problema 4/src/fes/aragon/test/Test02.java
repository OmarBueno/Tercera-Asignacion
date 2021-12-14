package fes.aragon.test;

import fes.aragon.utilerias.dinamicas.pila.PilaHanoi;

public class Test02 {

	public static void main(String[] args) throws Exception {
		PilaHanoi<Integer> pila = new PilaHanoi<>();
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
		String datos[] = { "*********", " ******* ", "  *****  ", "   ***   ", "    *    " };
		PilaHanoi<String> pila1 = new PilaHanoi<>();
		PilaHanoi<String> pila2 = new PilaHanoi<>();
		PilaHanoi<String> pila3 = new PilaHanoi<>();
		for (String dato : datos) {
			pila1.insertar(dato);
		}
		System.out.println("--------");
		pila1.imprimir();
		System.out.println("----------Hannoi iterativo-----------");
		hanoiIte(5, 'A', 'B', 'C');
	}

	public static void hanoiIte(int n, char origen, char destino, char auxiliar) throws Exception {
		int tope = 0;
		boolean band = false;
		char varAux;
		String datos[] = { "*********", " ******* ", "  *****  ", "   ***   ", "    *    " };
		PilaHanoi<String> pila1 = new PilaHanoi<>();
		PilaHanoi<String> pila2 = new PilaHanoi<>();
		PilaHanoi<String> pila3 = new PilaHanoi<>();
		for (String dato : datos) {
			pila1.insertar(dato);
		}
		PilaHanoi<Integer> pilaN = new PilaHanoi<>();
		PilaHanoi<Character> pilaO = new PilaHanoi<>();
		PilaHanoi<Character> pilaD = new PilaHanoi<>();
		PilaHanoi<Character> pilaX = new PilaHanoi<>();
		while (n > 0 && band == false) {
			while (n > 1) {
				tope++;
				pilaN.insertar(n);
				pilaO.insertar(origen);
				pilaD.insertar(destino);
				pilaX.insertar(auxiliar);
				n--;
				varAux = destino;
				destino = auxiliar;
				auxiliar = varAux;
			}
			System.out.println("Mover un disco de: " + origen + " a: " + destino);
			if (origen == 'A' && destino == 'B') {
				pila2.insertar(pila1.extraer());
				System.out.println("Pila A:");
				pila1.imprimir();
				System.out.println("Pila B:");
				pila2.imprimir();
			} else if (origen == 'A' && destino == 'C') {
				pila3.insertar(pila1.extraer());
				System.out.println("Pila A:");
				pila1.imprimir();
				System.out.println("Pila C:");
				pila3.imprimir();
			} else if (origen == 'B' && destino == 'A') {
				pila1.insertar(pila2.extraer());
				System.out.println("Pila A:");
				pila1.imprimir();
				System.out.println("Pila B:");
				pila2.imprimir();
			} else if (origen == 'B' && destino == 'C') {
				pila3.insertar(pila2.extraer());
				System.out.println("Pila B:");
				pila2.imprimir();
				System.out.println("Pila C:");
				pila3.imprimir();
			} else if (origen == 'C' && destino == 'A') {
				pila1.insertar(pila3.extraer());
				System.out.println("Pila C:");
				pila3.imprimir();
				System.out.println("Pila A:");
				pila1.imprimir();
			} else if (origen == 'C' && destino == 'B') {
				pila2.insertar(pila3.extraer());
				System.out.println("Pila C:");
				pila3.imprimir();
				System.out.println("Pila B:");
				pila2.imprimir();
			}

			band = true;
			if (tope > 0) {
				n = pilaN.extraer();
				origen = pilaO.extraer();
				destino = pilaD.extraer();
				auxiliar = pilaX.extraer();
				tope--;
				System.out.println("Mover un disco de: " + origen + " a: " + destino);
				n--;
				if (origen == 'B' && destino == 'A') {
					pila1.insertar(pila2.extraer());
					System.out.println("Pila A:");
					pila1.imprimir();
					System.out.println("Pila B:");
					pila2.imprimir();
				} else if (origen == 'B' && destino == 'C') {
					pila3.insertar(pila2.extraer());
					System.out.println("Pila B:");
					pila2.imprimir();
					System.out.println("Pila C:");
					pila3.imprimir();
				} else if (origen == 'A' && destino == 'B') {
					pila2.insertar(pila1.extraer());
					System.out.println("Pila A:");
					pila1.imprimir();
					System.out.println("Pila B:");
					pila2.imprimir();
				} else if (origen == 'A' && destino == 'C') {
					pila3.insertar(pila1.extraer());
					System.out.println("Pila A:");
					pila1.imprimir();
					System.out.println("Pila C:");
					pila3.imprimir();
				} else if (origen == 'C' && destino == 'A') {
					pila1.insertar(pila3.extraer());
					System.out.println("Pila C:");
					pila3.imprimir();
					System.out.println("Pila A:");
					pila1.imprimir();
				} else if (origen == 'C' && destino == 'B') {
					pila2.insertar(pila3.extraer());
					System.out.println("Pila C:");
					pila3.imprimir();
					System.out.println("Pila B:");
					pila2.imprimir();
				}
				varAux = origen;
				origen = auxiliar;
				auxiliar = varAux;
				band = false;
			}
		}
	}

	public static void hanoiRecu(int n, char origen, char destino, char auxiliar) {

		if (n == 1) {
			System.out.println("mover un disco de: " + origen + " a: " + destino);
		} else {
			hanoiRecu(n - 1, origen, auxiliar, destino);
			System.out.println("mover un disco de: " + origen + " a: " + destino);
			hanoiRecu(n - 1, auxiliar, destino, origen);
		}
	}

}
