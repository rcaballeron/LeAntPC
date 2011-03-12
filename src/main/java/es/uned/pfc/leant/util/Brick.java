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
 * Creado el 27/02/2011 a las 18:45:50
 *
 *
 */
package es.uned.pfc.leant.util;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.TachoMotor;

/**
 * @author rcaballero
 *
 */
public class Brick {
	public static SensorPort getSensonPort(int portNumber) {
		SensorPort port = null;
		
		if (portNumber < 1 || portNumber > 4) {
			throw new IllegalArgumentException("The port value should be between 1 and 4");
		} else {		
			switch(portNumber) {
				case 1:
					port = SensorPort.S1;
					break;
				case 2:
					port = SensorPort.S2;
					break;
				case 3:
					port = SensorPort.S3;
					break;
				case 4:
					port = SensorPort.S4;
					break;
			}
		}
		return port;
	}
	
	public static TachoMotor getTachoMotor(char portName) {
		TachoMotor motor = null;
		
		if (portName < 'A' || portName > 'C') {
			throw new IllegalArgumentException("The port name should be between A and C");
		} else {		
			switch(portName) {
				case 'A':
					motor = Motor.A;
					break;
				case 'B':
					motor = Motor.B;
					break;
				case 'C':
					motor = Motor.C;
					break;
			}
		}
		return motor;
	}
	

}
