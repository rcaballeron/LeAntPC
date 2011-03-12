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
 * Creado el 02/02/2011 a las 19:53:05
 *
 *
 */
package es.uned.pfc.subsumption;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author rcaballero
 * @param <T>
 *
 */
public class Wire<P extends Port<T>, T extends Value> {	
	/**
	 * Source port
	 */
	protected OutputPort<T> source;
	
	/**
	 * Destination ports
	 */
	protected Collection<InputPort<T>> destinations = new ArrayList<InputPort<T>>();
	
//	public void addDestination(InputPort<T> port) {
//		if (port!= null && !destinations.contains(port)) {
//			destinations.add(port);
//		}
//	}
//	
//	public void removeDestination(P port) {
//		destinations.remove(port);
//	}
	
	public T getValue(){
		return source.getValue();
	}

	public OutputPort<T> getSource() {
		return source;
	}

	public void setSource(OutputPort<T> source) {
		this.source = source;
	}
}
