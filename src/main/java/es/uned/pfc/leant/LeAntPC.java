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
 * Creado el 10.02.2011 a las 15:35:55
 *
 *
 */
package es.uned.pfc.leant;

import static lejos.nxt.comm.RConsole.close;
import static lejos.nxt.comm.RConsole.open;
import static lejos.nxt.comm.RConsole.println;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import es.uned.pfc.leant.subsumption.level0.Behaviour0;
import es.uned.pfc.leant.subsumption.level1.Behaviour1;
import es.uned.pfc.subsumption.Behaviour;
import es.uned.pfc.subsumption.Robot;

/**
 * @author CaballeR
 *
 */
public class LeAntPC extends Frame implements Robot, KeyListener {
	private static boolean stop = false;
	private Behaviour level0;
	private Behaviour level1;
	private List<Behaviour> levels = new ArrayList<Behaviour>();
	
	public LeAntPC() {
		 level0 = new Behaviour0(7, 1, 'C', 'A');
		 level1 = new Behaviour1(10, 2, level0);
		 
		 levels.add(level0);
		 levels.add(level1);
	}
	

	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Robot#configure()
	 */
	public void configure() {
		for (Behaviour behaviour : levels) {			
			behaviour.configure();
		}
	}
	
	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Robot#init()
	 */
	public void init() {
		for (Behaviour behaviour : levels) {
			behaviour.init();
		}
	}
	


	/* (non-Javadoc)
	 * @see es.uned.pfc.subsumption.Robot#run()
	 */
	public void run() {
		this.setBounds(0,0, 300, 50);
		this.addKeyListener(this);
		this.setVisible(true);		
		
		while (!stop) {
			for (Behaviour behaviour : levels) {
				behaviour.run();
			}			
		}
		close();
	}
	
	public static void main(String[] args) {
		open();		
		
		LeAntPC ant = new LeAntPC();
		println("Configuring...");
		ant.configure();
		
		println("Initializing...");
		ant.init();
		
		println("Running...");
		ant.run();
		
		println("Stoppping...");
		ant.stop();
	}


	@Override
	public void keyTyped(KeyEvent e) {}


	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			stop = true;
		}		
	}


	@Override
	public void keyReleased(KeyEvent e) {}


	@Override
	public void stop() {
		for (Behaviour behaviour : levels) {
			behaviour.reset();		}
	}
}
