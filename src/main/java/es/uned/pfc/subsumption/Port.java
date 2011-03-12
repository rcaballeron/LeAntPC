/**
 * Proyecto Fin Carrera
 * Robot autónomo clasificador inspirado en el comportamiento de ciertas especies de hormigas
 * 
 * ALUMNO: Roque Caballero Navarro
 * DIRECTOR: Ángel Pérez de Madrid y Pablo
 * DEPARTAMENTO: Sistemas de Comunicación y Control
 *
 * ETSI INFORMÁTICA
 * UNED
 *
 * Creado el 02/02/2011 a las 20:12:53
 *
 *
 */
package es.uned.pfc.subsumption;


/**
 * @author rcaballero
 *
 */
public class Port<T extends Value> {
	/**
	 * Identifier of the port
	 */
	protected String id;
	
	/**
	 * Level in which the port is present
	 */
	protected int level;
	
	/**
	 * Wire which carries the signal
	 */
	protected Wire<Port<T>, T> wire;
	
	/**
	 * Value associated with the port
	 */
	protected T value;
	
	public Port(String id) {
		this.id = id;
	}
	
	public void connect(Wire<Port<T>, T> wire) {
		this.wire = wire;
	}

	public String getId() {
		return id;
	}
	
}
