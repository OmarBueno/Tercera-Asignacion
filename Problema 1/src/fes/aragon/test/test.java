package fes.aragon.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fes.aragon.modelo.Accion;
import fes.aragon.modelo.Cartera;

public class test {
	public static void main(String[] args) {
		/*Accion a1 = new Accion("C", 100, 20, 1);
		Accion a2 = new Accion("C", 150, 25, 2);
		Accion a3 = new Accion("V", 250, 30, 3);
		Accion a4 = new Accion("C", 300, 30, 4);
		Accion a5 = new Accion("V", 250, 10, 5);*/
		Cartera c1 = new Cartera();
		/*c1.insertar(a1);
		c1.insertar(a2);
		c1.insertar(a3);
		c1.insertar(a4);
		c1.insertar(a5);*/

		try {
			File archivo = new File("datos/datos.txt");
			FileReader fr;
			fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] arr = linea.split(",");
				Accion accion = new Accion(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]),
						Integer.parseInt(arr[3]));
				c1.insertar(accion);
			}
			System.out.println("Ganancia Total de compra y venta de acciones: $"+c1.getGananciaTotal());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
