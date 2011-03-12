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
package es.uned.pfc.leant.subsumption.level0;

import es.uned.pfc.leant.subsumption.module.DistanceValue;
import es.uned.pfc.subsumption.InputPort;
import es.uned.pfc.subsumption.OutputPort;
import es.uned.pfc.subsumption.Port;
import es.uned.pfc.subsumption.Wire;
import es.uned.pfc.subsumption.impl.AbstractBehaviour;

/**
 * @author CaballeR
 *
 */
public class Behaviour0 extends AbstractBehaviour {
	public final static int SONAR_MODULE = 0;
	public final static int FORWARD_MODULE = 1;
	public final static int COLLIDE_MODULE = 2;
	public final static int COMPASS_MODULE = 3;
	public final static int TURN_MODULE = 4;
	
	
	private BottomSonarModule sonar;
	private ForwardModule forward;
	private CollideModule collide;
	private CompassModule compass;
	private TurnModule turn;
	
	public Behaviour0(int distanceThreshold, int sonarPort, char leftPort, char rightPort) {		
		
		
		this.name = "Behaviour 0";
		System.out.println("sonarPort:" + sonarPort + " leftPort:" + leftPort + " rightPort:" + rightPort);
		sonar = new BottomSonarModule(sonarPort);
		forward = new ForwardModule(leftPort, rightPort);
		collide = new CollideModule(distanceThreshold);
		compass = new CompassModule();
		turn = new TurnModule(leftPort, rightPort);
		
		modules.add(sonar);
		modules.add(forward);
		modules.add(collide);
		modules.add(compass);
		modules.add(turn);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void wire() {
		Wire<Port<DistanceValue>, DistanceValue> sonarWire = new Wire<Port<DistanceValue>, DistanceValue>();
		Wire<Port<StopAction>, StopAction> stopWire = new Wire<Port<StopAction>, StopAction>();
		Wire<Port<DirectionValue>, DirectionValue> directionWire = new Wire<Port<DirectionValue>, DirectionValue>();
		Wire<Port<MoveValue>, MoveValue> moveWire = new Wire<Port<MoveValue>, MoveValue>();
				
		
		//Sonar->Collide
		((OutputPort<DistanceValue>)sonar.getOutputPort(BottomSonarModule.DISTANCE_PORT)).connect(sonarWire);
		((InputPort<DistanceValue>)collide.getInputPort(CollideModule.DISTANCE_PORT)).connect(sonarWire);
		
		//Sonar->Compass
		((OutputPort<DistanceValue>)sonar.getOutputPort(BottomSonarModule.DISTANCE_PORT)).connect(sonarWire);
		((InputPort<DistanceValue>)compass.getInputPort(CollideModule.DISTANCE_PORT)).connect(sonarWire);		
		
		//Collide->Forward
		((OutputPort<StopAction>)collide.getOutputPort(CollideModule.STOP_PORT)).connect(stopWire);
		((InputPort<StopAction>)forward.getInputPort(ForwardModule.STOP_PORT)).connect(stopWire);
				
		//Compass->Turn
		((OutputPort<DirectionValue>)compass.getOutputPort(CompassModule.DIRECTION_PORT)).connect(directionWire);
		((InputPort<DirectionValue>)turn.getInputPort(TurnModule.DIRECTION_PORT)).connect(directionWire);
		
		//Turn->Forward
		((OutputPort<MoveValue>)turn.getOutputPort(TurnModule.MOVE_PORT)).connect(moveWire);
		((InputPort<MoveValue>)forward.getInputPort(ForwardModule.MOVE_PORT)).connect(moveWire);		
	}


}
