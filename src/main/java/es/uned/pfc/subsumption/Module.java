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
 * Creado el 02/02/2011 a las 19:52:42
 *
 *
 */
package es.uned.pfc.subsumption;

import static lejos.nxt.comm.RConsole.println;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author rcaballero
 *
 */
public abstract class Module {	
	protected String name;
	
	@SuppressWarnings("rawtypes")
	protected Collection<InputPort> inputPorts = new ArrayList<InputPort>();
	
	@SuppressWarnings("rawtypes")
	protected Collection<OutputPort> outputPorts = new ArrayList<OutputPort>();
	
	protected ResetPort resetPort;
	
	public Module(String name) {
		this.name = name;
	}
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void resetOutputPorts() {
		for (OutputPort outputPort	: outputPorts) {
			outputPort.setValue(null);
		}
	}
	
	public abstract void configure();
	
	@SuppressWarnings("rawtypes")
	public InputPort getInputPort(String id) {
		println("Getting input port: " + id);
		return (InputPort) getPort(id, inputPorts);
	}
	
	@SuppressWarnings("rawtypes")
	public OutputPort getOutputPort(String id) {
		println("Getting output port: " + id);
		return (OutputPort) getPort(id, outputPorts);
	}
	public abstract void reset();
	public abstract void execute();
	
	@SuppressWarnings("rawtypes")
	private Port getPort(String id, Collection<? extends Port> ports) {
		Port port = null;
		boolean notFound = true;
		
		Iterator<? extends Port> iter = ports.iterator();
		while (iter.hasNext() && notFound) {
			port = iter.next();
			println("Checking port: " + port.getId());
			if (port.getId().equals(id)) {
				notFound = false; 
			}
		}
		
		if (notFound) {
			println("Port not found: " + id);
			return null;
		} else {
			println("Port found: " + id);
			return port;
		}
		
	}

	public String getName() {
		return name;
	}
}