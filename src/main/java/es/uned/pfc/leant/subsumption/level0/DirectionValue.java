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
 * Creado el 09/02/2011 a las 19:10:23
 *
 *
 */
package es.uned.pfc.leant.subsumption.level0;

import es.uned.pfc.subsumption.Value;

/**
 * @author rcaballero
 *
 */
public class DirectionValue extends Value {
	public static DirectionValue defaultDirection = new DirectionValue(2, 0);
	/** units to move */
	private int module;
	
	/** heading angle */
	private int phase;

	/**
	 * @param description
	 */
	public DirectionValue(int module, int phase) {
		super("Direction vector");
		this.module = module;
		this.phase = phase;		
	}

	public int getModule() {
		return module;
	}

	public int getPhase() {
		return phase;
	}

}
