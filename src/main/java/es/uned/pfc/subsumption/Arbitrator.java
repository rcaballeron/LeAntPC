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
 * Creado el 03.02.2011 a las 17:42:05
 *
 *
 */
package es.uned.pfc.subsumption;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CaballeR
 *
 */
public class Arbitrator {
	private List<Behaviour> behaviours = new ArrayList<Behaviour>();
	private Monitor monitor;
	
	public Arbitrator(List<Behaviour> behaviours) {
		this.behaviours = behaviours;
	    monitor = new Monitor();
	    monitor.setDaemon(true);
	}
    
    /**
     * Finds the highest priority behavior that returns <B>true </B> to takeControl();
     * If this priority is higher than the active behavior, it calls active.suppress().
     * If there is no active behavior, calls suppress() on the most recently acrive behavior.
     */
    private class Monitor extends Thread {
    	
    }
    
	
}
