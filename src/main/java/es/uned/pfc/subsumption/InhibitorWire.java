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
 * Creado el 02/02/2011 a las 20:20:20
 *
 *
 */
package es.uned.pfc.subsumption;

/**
 * @author rcaballero
 *
 */
public class InhibitorWire<P extends Port<T>, T extends Value> extends Wire<P, T> {
	private long initialTime;
	private long duration = -1;
	
	public void inhibit(long duration) {
		this.duration = duration;
		initialTime = System.currentTimeMillis();
	}
	
	public boolean isActive() {
		//La primera condición evita la llamada al sistema y la suma
		if ((duration != -1) && (System.currentTimeMillis() < (initialTime + duration))) {
			return true;
		} else {
			duration = -1;
			return false;
		}
	}
}
