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
 * Creado el 03/02/2011 a las 00:30:10
 *
 *
 */
package es.uned.pfc.subsumption;

/**
 * @author rcaballero
 *
 */
public abstract class Value {
	private String description;

	/**
	 * @param description
	 */
	public Value(String description) {
		super();
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
