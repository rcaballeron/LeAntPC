package es.uned.pfc.leant.subsumption.level1;

import es.uned.pfc.leant.subsumption.level0.DirectionValue;
import es.uned.pfc.leant.subsumption.module.DistanceValue;
import es.uned.pfc.leant.util.BotMath;
import es.uned.pfc.subsumption.InputPort;
import es.uned.pfc.subsumption.Module;
import es.uned.pfc.subsumption.OutputPort;

public class AvoidModule extends Module {
	public final static String DIRECTION_PORT = "OP_1";
	public final static String DISTANCE_PORT = "IP_1";
	
	private InputPort<DistanceValue> distancePort = new InputPort<DistanceValue>(DISTANCE_PORT);
	private OutputPort<DirectionValue> directionPort = new OutputPort<DirectionValue>(DIRECTION_PORT);
	private int thresholdDistance;
	

	public AvoidModule(int thresholdDistance) {
		super("Avoid module");
		this.thresholdDistance = thresholdDistance;
	}

	@Override
	public void configure() {
		inputPorts.add(distancePort);
		outputPorts.add(directionPort);
	}

	@Override
	public void reset() {
		resetOutputPorts();
	}

	@Override
	public void execute() {
		/*
		 * Si las dos medidas de distancia da valores parecidos, es que los dos sónares están detectando
		 * el mismo objeto, o eso suponemos, por lo tanto intentamos esquivarlo. Si el sonar superior no
		 * detectata nada, no tenemos entrada en el puerto, y el de abajo sí, no hacemos nada, seguimos
		 * acercándonos a él. Si es, finalmente, sólo el sonar superior el que detecta algo, actuamos al
		 * igual que en el primer caso, intentaremos esquivar el objeto.
		 */
		DistanceValue currentDistance = distancePort.getValue();
		if (currentDistance != null && currentDistance.getDistance() <= thresholdDistance) {
			DirectionValue heading = new DirectionValue(2, BotMath.randomAngle(60));
			directionPort.setValue(heading);
		} else {
			directionPort.setValue(null);
		}
		
	}

}
