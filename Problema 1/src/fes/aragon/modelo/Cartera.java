package fes.aragon.modelo;

import fes.aragon.utilerias.dinamicas.Cola.Cola;

public class Cartera extends Cola<Accion> {
	private int acciones = 0;
	private double gananciaTotal = 0.0;

	public Cartera() {
	}

	public void insertar(Accion dato) {
		if (dato.getTipo().equals("C") || dato.getTipo().equals("c")) {
			acciones += dato.getCantidad();
			super.insertar(dato);
			System.out.println("El dia: " + dato.getDia() + " se compraron: " + dato.getCantidad() + " acciones por: $"
					+ dato.getPrecio() + " ahora cuenta con: " + acciones + " acciones");
		} else {
			if (acciones >= dato.getCantidad()) {
				System.out.println("El dia: " + dato.getDia() + " se vendieron: " + dato.getCantidad() + " acciones");
				double ganancia = 0.0;
				int vendidas = dato.getCantidad();
				acciones -= vendidas;
				while (vendidas > 0) {
					try {
						Accion aux = elementoSuperior();
						double diferencia = dato.getPrecio() - aux.getPrecio();
						if (vendidas >= aux.getCantidad()) {
							ganancia += (aux.getCantidad() * diferencia);
							vendidas -= aux.getCantidad();
							System.out.println("Se vendieron: " + aux.getCantidad() + " acciones con una ganancia de: $"
									+ diferencia + " por accion. Acciones del dia: " + aux.getDia());
							extraer();
						} else {
							int sobrantes = aux.getCantidad() - vendidas;
							ganancia += (vendidas * diferencia);
							System.out.println("Se vendieron: " + vendidas + " Acciones con una ganancia de: "
									+ diferencia + " por accion Acciones del dia: " + aux.getDia());
							vendidas = 0;
							Accion restante = elementoSuperior();
							restante.setCantidad(sobrantes);
							// extraer();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				gananciaTotal += ganancia;
				System.out.println("Ganancia total de la transaccion: " + ganancia);
			} else {
				System.out.println("No cuenta con suficientes acciones para vender");
			}
		}
	}

	public int getAcciones() {
		return acciones;
	}

	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}

	public double getGananciaTotal() {
		return gananciaTotal;
	}

	public void setGananciaTotal(double gananciaTotal) {
		this.gananciaTotal = gananciaTotal;
	}

}
