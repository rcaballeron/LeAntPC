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
 * Creado el 05/02/2011 a las 18:48:05
 *
 *
 */
package es.uned.pfc.subsumption.impl;

import es.uned.pfc.subsumption.Behaviour;
import es.uned.pfc.subsumption.Module;
import static lejos.nxt.comm.RConsole.*;

/**
 * @author rcaballero
 *
 */
public abstract class AbstractBehaviour extends Behaviour {
	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Behaviour#configure()
	 */
	@Override
	public void configure() {
		println("Configuring behaviour: " + name);
		for (Module module : modules) {
			println("Configuring module: " + module.getName());
			module.configure();
		}
		this.wire();
	}

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Behaviour#init()
	 */
	@Override
	public void init() {
		for (Module module : modules) {
			module.reset();
		}
	}


	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Behaviour#run()
	 */
	@Override
	public void run() {
		for (Module module : modules) {
			module.execute();
		}
	}
	
	@Override
	public Module getModule(int module) {
		if (module >= 0 && module < modules.size()) {
			return modules.get(module);
		} else {
			return null;
		}
	}
}
