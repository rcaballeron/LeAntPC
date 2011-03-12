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
 * Creado el 02/02/2011 a las 21:02:22
 *
 *
 */
package es.uned.pfc.subsumption;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author rcaballero
 *
 */
public class OutputPort<T extends Value> extends Port<T> {
	/**
	 * @param id
	 */
	public OutputPort(String id) {
		super(id);
	}

	/**
	 * Group of inhibition lines
	 */
	private Collection<InhibitorWire<Port<T>, T>> inhibitors = new ArrayList<InhibitorWire<Port<T>, T>>();
	
	public void connect(Wire<Port<T>, T> wire) {
		super.connect(wire);
		wire.setSource(this);
	}
	
	public T getValue() {
		boolean cancelOutput = false;
		
		for (InhibitorWire<Port<T>, T> inhibitor : inhibitors) {
			if (inhibitor.isActive())
				cancelOutput = true;
		}
		
		if (cancelOutput) {
			return null;
		} else {
			return value;
		}		
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}
