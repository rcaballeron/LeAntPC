/**
 * Proyecto Fin Carrera
 * Robot autÃ³nomo clasificador inspirado en el comportamiento de ciertas especies de hormigas
 * 
 * ALUMNO: Roque Caballero Navarro
 * DIRECTOR: Ã�ngel PÃ©rez de Madrid y Pablo
 * DEPARTAMENTO: Sistemas de ComunicaciÃ³n y Control
 *
 * ETSI INFORMÃ�TICA
 * UNED
 *
 * Creado el 07.02.2011 a las 17:09:58
 *
 *
 */
package es.uned.pfc.leant.subsumption.level1;

import es.uned.pfc.leant.subsumption.level0.Behaviour0;
import es.uned.pfc.leant.subsumption.level0.BottomSonarModule;
import es.uned.pfc.leant.subsumption.level0.CollideModule;
import es.uned.pfc.leant.subsumption.level0.DirectionValue;
import es.uned.pfc.leant.subsumption.level0.TurnModule;
import es.uned.pfc.leant.subsumption.module.DistanceValue;
import es.uned.pfc.lejos.util.Console;
import es.uned.pfc.subsumption.Behaviour;
import es.uned.pfc.subsumption.InputPort;
import es.uned.pfc.subsumption.OutputPort;
import es.uned.pfc.subsumption.Port;
import es.uned.pfc.subsumption.SuppressorWire;
import es.uned.pfc.subsumption.Wire;
import es.uned.pfc.subsumption.impl.AbstractBehaviour;

/**
 * @author CaballeR
 *
 */
public class Behaviour1 extends AbstractBehaviour {
	public final static int DETECTOR = 0;
	//public final static int AVOID = 1;
	
	private BottomSonarModule sonar;
	//private AvoidModule avoid;
	private TurnModule turn;
	private LightDetectorModule detector;
	
	public Behaviour1(int distanceThreshold, int detectorPort, Behaviour behaviour0) {
		this.name = "Behaviour 1";
		Console.println("detectorPort:" + detectorPort);
		
		//sonar = new TopSonarModule(sonarPort);
		//avoid = new AvoidModule(distanceThreshold);
		detector = new LightDetectorModule(detectorPort, distanceThreshold);
		turn = (TurnModule)behaviour0.getModule(Behaviour0.TURN_MODULE);
		sonar = (BottomSonarModule)behaviour0.getModule(Behaviour0.SONAR_MODULE);
		
		modules.add(detector);
		//modules.add(avoid);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void wire() {
		Wire<Port<DistanceValue>, DistanceValue> sonarWire = new Wire<Port<DistanceValue>, DistanceValue>();
		SuppressorWire<Port<DirectionValue>, DirectionValue> directionWire = new SuppressorWire<Port<DirectionValue>, DirectionValue>();
				
		
		//Sonar->Detector
		((OutputPort<DistanceValue>)sonar.getOutputPort(BottomSonarModule.DISTANCE_PORT)).connect(sonarWire);
		((InputPort<DistanceValue>)detector.getInputPort(LightDetectorModule.DISTANCE_PORT)).connect(sonarWire);
		
				
		//Detector->Turn
		((OutputPort<DirectionValue>)detector.getOutputPort(LightDetectorModule.DIRECTION_PORT)).connect(directionWire);
		((InputPort<DirectionValue>)turn.getInputPort(TurnModule.DIRECTION_PORT)).connect(directionWire);
	}

}
