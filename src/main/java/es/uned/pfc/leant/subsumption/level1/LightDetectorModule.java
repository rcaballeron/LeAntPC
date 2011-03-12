package es.uned.pfc.leant.subsumption.level1;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import es.uned.pfc.leant.subsumption.level0.DirectionValue;
import es.uned.pfc.leant.subsumption.module.DistanceValue;
import es.uned.pfc.leant.util.Brick;
import es.uned.pfc.lejos.util.Console;
import es.uned.pfc.subsumption.InputPort;
import es.uned.pfc.subsumption.Module;
import es.uned.pfc.subsumption.OutputPort;

public class LightDetectorModule extends Module {
	public final static String DISTANCE_PORT = "IP_1";
	public final static String DIRECTION_PORT = "OP_1";
	
	private enum State {OFF, ON};
	private State state = State.OFF;		
	private SensorPort port;
	private LightSensor light;
	private int portNumber = -1;
	private int thresholdDistance;
	
	private InputPort<DistanceValue> distancePort = new InputPort<DistanceValue>(DISTANCE_PORT);
	private OutputPort<DirectionValue> directionPort = new OutputPort<DirectionValue>(DIRECTION_PORT);
	

	public LightDetectorModule(int portNumber, int thresholdDistance) {
		super("Light detector module");
		if (portNumber < 1 || portNumber > 4) {
			throw new IllegalArgumentException("The port value should be between 1 and 4");
		}
		this.portNumber = portNumber;
		this.thresholdDistance = thresholdDistance;
		
	}

	@Override
	public void configure() {
		port =  Brick.getSensonPort(portNumber);
		light = new LightSensor(port);
		light.setFloodlight(false);
		
		inputPorts.add(distancePort);
		outputPorts.add(directionPort);
	}

	@Override
	public void reset() {
		resetOutputPorts();
		light.setFloodlight(false);		
	}

	@Override
	public void execute() {
		DistanceValue currentDistance = distancePort.getValue();
		if (currentDistance != null && currentDistance.getDistance() <= thresholdDistance) {
			light.setFloodlight(true);
			state = State.ON;
			int value = light.getLightValue();
			Console.println("Light value: " + value);
		} else {
			if (state == State.ON) {
				light.setFloodlight(false);
				state = State.OFF;
			}			
			directionPort.setValue(null);
		}	
	}
}
