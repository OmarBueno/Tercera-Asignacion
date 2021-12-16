package fes.aragon.alg;

/**
 * Clase que representa un nodo adyacente
 * @author Equipo 9 Sol Martinez Edith, Bueno Zaldivar Omar Alejandro *
 */
public class Adyacente {
	private String nombre;
	private Integer valor;

	public Adyacente(String nombre, Integer valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
