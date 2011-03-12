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
 * Creado el 07.02.2011 a las 16:27:14
 *
 *
 */
package es.uned.pfc.leant.subsumption.level0;

import es.uned.pfc.subsumption.Value;

/**
 * @author CaballeR
 *
 */
public class MoveAction extends Value {
	private boolean forward;
	private int speed;
	private int degree;

	/**
	 * @param description
	 */
	public MoveAction(boolean forward) {
		super("Move action");
		this.forward = forward;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public boolean isForward() {
		return forward;
	}

}
