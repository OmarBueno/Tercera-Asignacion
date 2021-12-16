package fes.aragon.alg;

/**
 * Clase que simula un vertice de un grafo
 * 
 * @author Equipo 9 Sol Martinez Edith, Bueno Zaldivar Omar Alejandro
 *
 */
public class Vertice {
	private String nombre;
	private Integer etiqueta;

	public Vertice(String nombre, Integer etiqueta) {
		super();
		this.nombre = nombre;
		this.etiqueta = etiqueta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Integer etiqueta) {
		this.etiqueta = etiqueta;
	}

}
