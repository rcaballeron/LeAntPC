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
 * Creado el 05/03/2011 a las 16:26:20
 *
 *
 */
package es.uned.pfc.leant.util;

/**
 * @author rcaballero
 *
 */
public class BotMath {
	/**
	 * Da el ángulo relativo entre -pi <--> pi respecto de uno dado.
	 * Da el ángulo más corto de desplazamiento para llegar al ángulo dado
	 * como parámetro.
	 * Si ang=200, entonces el relativo es -160
	 * Si ang=-200, entonces el relativo es 160
	 * 
	 * @param angle
	 * @return
	 */
	public static int normalRelativeAngle(int angle) {
		int relativeAngle = angle % 360;
		if (relativeAngle <= -180)
			return 180 + (relativeAngle % 180);
		else if (relativeAngle > 180)
			return -180 + (relativeAngle % 180);
		else
			return relativeAngle;
	}
	
	public static int randomAngle(int angle) {
		int newAngle = (int)(Math.random() * angle * 2);
		return newAngle > angle ? -(newAngle - angle):newAngle;
	}
}
