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
 * Creado el 10.02.2011 a las 15:34:29
 *
 *
 */
package es.uned.pfc.subsumption;

/**
 * @author CaballeR
 *
 */
public interface Robot {
	public void configure();
	public void init();
	public void run();
	public void stop();
}
