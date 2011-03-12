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
package es.uned.pfc.leant.subsumption.level0;

import es.uned.pfc.leant.subsumption.module.AbstractSonarModule;
import es.uned.pfc.leant.subsumption.module.DistanceValue;
import es.uned.pfc.lejos.util.Console;

/**
 * @author CaballeR
 *
 */
public class BottomSonarModule extends AbstractSonarModule {
	public final static String DISTANCE_PORT = "OP_1";
	
	
	public BottomSonarModule(int portNumber) {
		super("Bottom Ultrasonic sensor", portNumber);		
	}


	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Module#execute()
	 */
	@Override
	public void execute() {
		int distance = sonar.getDistance();
		Console.println("BSM: " + distance);
		if (distance < 255) {
			//TODO: Quizás puede ser mejor crear un objeto estático distancia
			//al que se le va modificando el valor. Es por temas de la ausencia
			//de GC;
			distancePort.setValue(new DistanceValue(distance));
		} else {
			distancePort.setValue(null);
		}
	}	
}
