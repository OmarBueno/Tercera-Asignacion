package fes.aragon.except;

/**
 * Clase que maneja excepciones
 * 
 * @author Equipo 9 Sol Martinez Edith, Bueno Zaldivar Omar Alejandro
 *
 */
public class IndiceFueraDeRango extends Exception {
	private static final long serialVersionUID = 1L;

	public IndiceFueraDeRango(String msg) {
		super(msg);
	}
}
