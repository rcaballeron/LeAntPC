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
 * Creado el 08.02.2011 a las 13:40:39
 *
 *
 */
package es.uned.pfc.leant.subsumption.level0;

import lejos.robotics.TachoMotor;
import es.uned.pfc.leant.util.BotMath;
import es.uned.pfc.subsumption.InputPort;
import es.uned.pfc.subsumption.OutputPort;

/**
 * @author CaballeR
 *
 */
public class TurnModule extends TwoMotorsModule {
	public final static String DIRECTION_PORT = "IP_1";
	public final static String MOVE_PORT = "OP_1";
	
	private enum State {STOPPED, TURNING};
	private State state = State.STOPPED;	
	private InputPort<DirectionValue> directionPort = new InputPort<DirectionValue>(DIRECTION_PORT);
	private OutputPort<MoveValue> movePort = new OutputPort<MoveValue>(MOVE_PORT);
	
	private TachoMotor leftMotor;
	private TachoMotor rightMotor;

	

	/**
	 * @param name
	 */
	public TurnModule(char rightPortName, char leftPortName) {
		super("Turn module", rightPortName, leftPortName);
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#configure()
	 */
	@Override
	public void configure() {
		super.configure();
		
		leftMotor = motor1;
		rightMotor = motor2;
		
		leftMotor.setSpeed(100);
		rightMotor.setSpeed(100);
		
		inputPorts.add(directionPort);
		outputPorts.add(movePort);
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#reset()
	 */
	@Override
	public void reset() {
		stopMotors();
		resetOutputPorts();
		state = State.STOPPED;
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#execute()
	 */
	@Override
	public void execute() {
		DirectionValue directionValue = directionPort.getValue();		
		
		if (directionValue != null) {
			int normalizedphase = BotMath.normalRelativeAngle(directionValue.getPhase());
			if (normalizedphase != 0) {
				if (normalizedphase > 0) {
					rightMotor.stop();
					leftMotor.rotate(normalizedphase, true);
				} else {
					leftMotor.stop();
					rightMotor.rotate(Math.abs(normalizedphase), true);					
				}
				state = State.TURNING;
			}
			
			//Send move value
			movePort.setValue(new MoveValue(directionValue.getModule(), true));
		} else {
			if (leftMotor.isMoving() || rightMotor.isMoving()) {
				state = State.TURNING;
			} else {
				state = State.STOPPED;
			}
		}
	}
}
