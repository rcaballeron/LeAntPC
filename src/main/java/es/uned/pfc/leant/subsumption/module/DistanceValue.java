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
 * Creado el 08.02.2011 a las 10:56:10
 *
 *
 */
package es.uned.pfc.leant.subsumption.module;

import es.uned.pfc.subsumption.Value;

/**
 * @author CaballeR
 *
 */
public class DistanceValue extends Value {
	private int value;

	/**
	 * @param description
	 */
	public DistanceValue(int distance) {
		super("Distance value");
		this.value = distance;
	}
	
	public int getDistance() {
		return value;
	}

}
