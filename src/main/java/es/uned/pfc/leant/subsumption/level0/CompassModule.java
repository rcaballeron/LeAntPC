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
 * Creado el 09/02/2011 a las 19:05:55
 *
 *
 */
package es.uned.pfc.leant.subsumption.level0;

import es.uned.pfc.leant.subsumption.module.DistanceValue;
import es.uned.pfc.subsumption.InputPort;
import es.uned.pfc.subsumption.Module;
import es.uned.pfc.subsumption.OutputPort;

/**
 * @author rcaballero
 *
 */
public class CompassModule extends Module {
	public final static String DIRECTION_PORT = "OP_1";
	public final static String DISTANCE_PORT = "IP_1";
	
	private InputPort<DistanceValue> distancePort = new InputPort<DistanceValue>(DISTANCE_PORT);
	private OutputPort<DirectionValue> directionPort = new OutputPort<DirectionValue>(DIRECTION_PORT);

	/**
	 * @param name
	 */
	public CompassModule() {
		super("Compass module");
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#configure()
	 */
	@Override
	public void configure() {
		inputPorts.add(distancePort);
		outputPorts.add(directionPort);
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#reset()
	 */
	@Override
	public void reset() {
		resetOutputPorts();		
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#execute()
	 */
	@Override
	public void execute() {
		// TODO Si montamos el robot con dos sónares, uno alto para detectar otros robots
		// y otro bajo para detectar los objetos, el módulo puede calcular una dirección
		//para acercarse a otros robots o a los objetos atendiendo a las medidas recibidas
		//Por ahora sólo produce distancias estándar
		directionPort.setValue(DirectionValue.defaultDirection);
		
	}

}
