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
 * Creado el 03.02.2011 a las 17:08:53
 *
 *
 */
package es.uned.pfc.subsumption;

import java.util.ArrayList;

/**
 * @author CaballeR
 *
 */
public abstract class Behaviour {
	protected String name;
	protected ArrayList<Module> modules = new ArrayList<Module>();
			
	public final void reset() {
		for (Module	module : modules) {
			module.reset();
		}
	}
		
	public abstract void configure();	
	public abstract void init();
	public abstract void run();
	public abstract Module getModule(int module);
	
	protected abstract void wire();

	public String getName() {
		return name;
	}
}
