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
 * Creado el 05/02/2011 a las 18:54:13
 *
 *
 */
package es.uned.pfc.leant.subsumption.level0;

import lejos.robotics.TachoMotor;
import es.uned.pfc.lejos.util.Console;
import es.uned.pfc.subsumption.InputPort;

/**
 * @author rcaballero
 *
 */
public class ForwardModule extends TwoMotorsModule {
	public final static String MOVE_PORT = "IP_1";
	public final static String STOP_PORT = "IP_2";
	
	private enum State {STOPPED, MOVING};
	private State state = State.STOPPED;
	private InputPort<MoveValue> movePort = new InputPort<MoveValue>(MOVE_PORT);
	private InputPort<StopAction> stopPort = new InputPort<StopAction>(STOP_PORT);
	//Necesario para compartir código
	private TachoMotor leftMotor;
	private TachoMotor rightMotor;


	/**
	 * @param name
	 */
	public ForwardModule(char rightPortName, char leftPortName) {
		super("Forward module", rightPortName, leftPortName);
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
	 * @see es.uned.pfc.subsumption.Module#configure()
	 */
	@Override
	public void configure() {
		super.configure();
		
		leftMotor = motor1;
		rightMotor = motor2;
		
		leftMotor.setSpeed(100);
		rightMotor.setSpeed(100);		
		
		inputPorts.add(movePort);		
		inputPorts.add(stopPort);
	}
	
	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#execute()
	 */
	@Override
	public void execute() {
		MoveValue moveValue = movePort.getValue();
		StopAction stopAction = stopPort.getValue();
		
		//Hay que comprobar porque puede que la última orden siga ejecutándose
		if (rightMotor.isMoving() || leftMotor.isMoving()) {
			state = State.MOVING;
		} else {
			state = State.STOPPED;
		}
		
		if (stopAction != null) {
			Console.println("Stopping robot" );
			stopMotors();
			state = State.STOPPED;
			//La stopAction prevalece sobre el movimiento
			return;
		} else if (moveValue != null && state != State.MOVING) {
			Console.println("Avanza robot" );
			//motor.setSpeed(moveValue.getSpeed());
			//Motor.A.rotate(action.getDegree());
			if (moveValue.isForward()) { 
				if (moveValue.getModule() == -1) {
					rightMotor.forward();
					leftMotor.forward();					
				} else {
					//TODO Hay que ver cómo pasar de unidades a grados. Mirar código
					rightMotor.rotate(moveValue.getModule() * 360, true);
					leftMotor.rotate(moveValue.getModule() * 360, true);
					
//					try {
//						synchronized (this) {
//							Thread.currentThread().wait(50);							
//						}											
//					} catch (InterruptedException ie) {}
				}						
			}
			state = State.MOVING;
		}
	}
}
