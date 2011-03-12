package lejos.nxt.comm;

/**
 * Implementación conveniente de la clase RConsole basada en System
 * @author rcaballero
 *
 */
public class RConsole {
	public static void open() {
		System.out.println("Consola abierta...");
	}
	
	public static void close() {
		System.out.println("Consola cerrada...");
	}
	
	public static void print(String s) {
		System.out.print(s);
	}
	
	public static void println(String s) {
		System.out.println(s);
	}
}
