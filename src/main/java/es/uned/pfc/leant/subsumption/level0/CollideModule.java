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
 * Creado el 07.02.2011 a las 17:12:37
 *
 *
 */
package es.uned.pfc.leant.subsumption.level0;

import es.uned.pfc.leant.subsumption.module.DistanceValue;
import es.uned.pfc.subsumption.InputPort;
import es.uned.pfc.subsumption.Module;
import es.uned.pfc.subsumption.OutputPort;

/**
 * @author CaballeR
 *
 */
public class CollideModule extends Module {
	public final static String DISTANCE_PORT = "IP_1";
	public final static String STOP_PORT = "OP_1";
	
	private enum State {OK, WARNING};
	private State state = State.OK;	
	private DistanceValue lastDistanceValue;
	private int thresholdDistance;
	
	private InputPort<DistanceValue> distancePort = new InputPort<DistanceValue>(DISTANCE_PORT);
	private OutputPort<StopAction> stopPort = new OutputPort<StopAction>(STOP_PORT);

	/**
	 * @param name
	 */
	public CollideModule(int thresholdDistance) {
		super("Collide detection module");
		this.thresholdDistance = thresholdDistance;
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#configure()
	 */
	@Override
	public void configure() {
		inputPorts.add(distancePort);
		outputPorts.add(stopPort);
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#reset()
	 */
	@Override
	public void reset() {
		resetOutputPorts();
		state = State.OK;
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#execute()
	 */
	@Override
	public void execute() {
		DistanceValue currentDistance = distancePort.getValue();
		if (currentDistance != null && currentDistance.getDistance() <= thresholdDistance) {
			state = State.WARNING;
			stopPort.setValue(StopAction.getInstance());
			lastDistanceValue = currentDistance;
		} else {
			state = State.OK;
			stopPort.setValue(null);
		}
	}

}
