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
 * Creado el 07.02.2011 a las 16:58:57
 *
 *
 */
package es.uned.pfc.leant.subsumption.level0;

import es.uned.pfc.subsumption.Value;

/**
 * @author CaballeR
 *
 */
public class StopAction extends Value {
	private static StopAction instance = new StopAction();

	/**
	 * @param description
	 */
	private StopAction() {
		super("Stop Action");
	}
	
	public static StopAction getInstance() {
		return instance;
	}

}
