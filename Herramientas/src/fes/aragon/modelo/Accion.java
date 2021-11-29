package fes.aragon.modelo;

/**
 * Accion que representa una accion
 * 
 * @author omar1
 *
 */
public class Accion {
	private String tipo;
	private int cantidad;
	private double precio;
	private int dia;

	public Accion(String tipo, int cantidad, double precio, int dia) {
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
		this.dia = dia;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}