package fes.aragon.except;

/**
 * Clase que maneja excepciones
 * 
 * @author omar1
 *
 */
public class IndiceFueraDeRango extends Exception {
	private static final long serialVersionUID = 1L;

	public IndiceFueraDeRango(String msg) {
		super(msg);
	}
}
