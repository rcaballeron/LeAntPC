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
 * Creado el 08.02.2011 a las 10:10:38
 *
 *
 */
package es.uned.pfc.leant.subsumption.module;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import es.uned.pfc.leant.util.Brick;
import es.uned.pfc.lejos.util.Console;
import es.uned.pfc.subsumption.Module;
import es.uned.pfc.subsumption.OutputPort;

/**
 * @author CaballeR
 *
 */
public abstract class AbstractSonarModule extends Module {
	public final static String DISTANCE_PORT = "OP_1";
	
	protected UltrasonicSensor sonar;
	protected int portNumber = -1;
	protected SensorPort port;
	protected OutputPort<DistanceValue> distancePort = new OutputPort<DistanceValue>(DISTANCE_PORT);
	
	public AbstractSonarModule(String name, int portNumber) {
		super(name);		
		if (portNumber < 1 || portNumber > 4) {
			throw new IllegalArgumentException("The port value should be between 1 and 4");
		}
		this.portNumber = portNumber;
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#configure()
	 */
	@Override
	public void configure() {
		Console.println("Configuring: " + this.name);
		
		port =  Brick.getSensonPort(portNumber);
		sonar = new UltrasonicSensor(port);
		//Continues ping mode
		sonar.continuous();
		//sonar.capture();
		
		outputPorts.add(distancePort);
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#reset()
	 */
	@Override
	public void reset() {
		resetOutputPorts();
		sonar.reset();
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#execute()
	 */
	@Override
	public abstract void execute();
}
