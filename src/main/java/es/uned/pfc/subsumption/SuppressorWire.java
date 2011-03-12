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
 * Creado el 02/02/2011 a las 20:21:44
 *
 *
 */
package es.uned.pfc.subsumption;


/**
 * @author rcaballero
 *
 */
public class SuppressorWire<P extends Port<T>, T extends Value> extends Wire<P, T> {
	/**
	 * Value which suppress the original one
	 */
	private T value;	
	private long initialTime;
	private long duration = -1;
	
	public void suppress(T suppressorValue, long duration) {
		this.value = suppressorValue;
		this.duration = duration;
		initialTime = System.currentTimeMillis();
	}
	
	public boolean isActive() {
		//La primera condición evita la llamada al sistema y la suma
		if ((duration != -1) && (System.currentTimeMillis() < (initialTime + duration))) {
			return true;
		} else {
			duration = -1;
			value = null;
			return false;
		}
	}
	
	@Override
	public T getValue(){
		return value;
	}
	
}
