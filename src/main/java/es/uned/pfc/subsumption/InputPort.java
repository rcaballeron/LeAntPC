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
 * Creado el 02/02/2011 a las 21:01:56
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
public class InputPort<T extends Value> extends Port<T> {
	/**
	 * Group of suppression wires
	 */
	private Collection<SuppressorWire<Port<T>, T>> suppressors = new ArrayList<SuppressorWire<Port<T>, T>>();
	
	
	/**
	 * @param id
	 */
	public InputPort(String id) {
		super(id);
	}

	public void connect(Wire<Port<T>, T> wire) {
		if (wire instanceof SuppressorWire<?, ?>) {
			suppressors.add((SuppressorWire<Port<T>, T>)wire);
		} else {
			super.connect(wire);
		}
		//wire.addDestination(this);
	}
	
	public T getValue() {
		boolean overwriteInput = false;
		
		//En caso de existir varias línea supresoras, se devuelve el valor de la última activa
		for (SuppressorWire<Port<T>, T> suppressor : suppressors) {
			if (suppressor.isActive())
				overwriteInput = true;
				value = suppressor.getValue();			
		}
		
		if (!overwriteInput && wire != null) {
			value = wire.getValue();
		}
		
		return value;
	}
}
