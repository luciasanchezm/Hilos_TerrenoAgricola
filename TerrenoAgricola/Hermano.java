package Hilos.TerrenoAgricola;

import Hilos.*;

public class Hermano extends Thread {
	private int noHermano;
	private Semaforo S;
	private Hectarea [] hectareas;
	private static int noHectareas;
	private String imageText;
	
	public Hermano(int noHermano, Hectarea [] hectareas, String imageText) {
		this.noHermano = noHermano;
		this.hectareas = hectareas;
		this.imageText = imageText;
		noHectareas = hectareas.length;
	}
	
	public void run() {
		int noHec;
		while(noHectareas>0) {
			noHec = Rutinas.nextInt(0, 99);
			hectareas[noHec].semaforo.Espera();
			if(hectareas[noHec].selected) {
				hectareas[noHec].semaforo.Libera();
				continue;
			}
			hectareas[noHec].Select(imageText);
			hectareas[noHec].semaforo.Libera();
			try {
				sleep(500);
			} catch (Exception e) {System.out.println("Wait no funcionó");}
			noHectareas--;
		}
	}
}