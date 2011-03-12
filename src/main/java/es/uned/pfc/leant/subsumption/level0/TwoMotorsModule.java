package es.uned.pfc.leant.subsumption.level0;

import static lejos.nxt.comm.RConsole.println;
import lejos.robotics.TachoMotor;
import es.uned.pfc.leant.util.Brick;
import es.uned.pfc.subsumption.Module;

public abstract class TwoMotorsModule extends Module {
	protected char portName1 = 0;
	protected char portName2 = 0;
	//Necesario para compartir código
	protected TachoMotor motor1;
	protected TachoMotor motor2;
 

	public TwoMotorsModule(String name, char portName1, char portName2) {
		super(name);
		
		if (portName1 == portName2) {
			println("The ports should be different");
			throw new IllegalArgumentException("The port names should be different");			
		}
		if (portName1 < 'A' || portName1 > 'C') {
			println("Invalid port: " + portName1);
			throw new IllegalArgumentException("The portName1 should be between 'A' and 'C'");
		}
		if (portName2 < 'A' || portName2 > 'C') {
			println("Invalid port: " + portName2);
			throw new IllegalArgumentException("The portName2 should be between 'A' and 'C'");
		}
		
		this.portName1 = portName1;
		this.portName2 = portName2;
	}

	@Override
	public void configure() {
		motor1 = Brick.getTachoMotor(portName1);
		motor2 = Brick.getTachoMotor(portName2);
	}
	
	protected void stopMotors() {
		motor1.stop();
		motor2.stop();
	}
	
	

}
