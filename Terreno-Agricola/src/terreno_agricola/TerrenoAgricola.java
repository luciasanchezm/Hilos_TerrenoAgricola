package terreno_agricola;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TerrenoAgricola extends JFrame implements ActionListener {
	
	private int noHectareas = 100;
	private int noHermanos = 3;
	private Hectarea [] hectareas;
	private Hermano [] vectorHermanos;
	private JPanel panelHectareas;
	private JButton btnIniciar;
	private String [] nombres = {"Hermano1.png", "Hermano2.png", "Hermano3.png"};
	
	public TerrenoAgricola() {
		super("REPARTICIÓN DE HECTÁREAS");
		hectareas = new Hectarea [noHectareas];
		vectorHermanos = new Hermano[noHermanos];
		panelHectareas = new JPanel();
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setPreferredSize(new Dimension(100, 30));
		
		setLayout(new FlowLayout());
		setSize(1500, 1000); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		panelHectareas.setLayout(new GridLayout(10, 10, 5, 5));
		
		crearHectareas();
		add(panelHectareas, BorderLayout.CENTER);
		add(btnIniciar, BorderLayout.SOUTH);
		btnIniciar.addActionListener(this);
		
		setVisible(true);
	}
	
	public void crearHectareas() {
		for (int i = 0; i < noHectareas; i++) {
			hectareas[i] = new Hectarea(i+1,Rutinas.nextInt(1,3));
			panelHectareas.add(hectareas[i]);
		}
		for (int i = 0; i < vectorHermanos.length; i++)
			vectorHermanos[i] = new Hermano(i+1, hectareas, nombres[i]);
	}
	
	public boolean hayaVivos() {
		for (int i = 0; i < vectorHermanos.length; i++)
			if(!vectorHermanos[i].isAlive())
				return false;
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		for (int i = 0; i < vectorHermanos.length; i++)
			vectorHermanos[i].start();
		btnIniciar.setEnabled(false);
	}
	
	public static void main(String [] a) {
		new TerrenoAgricola();
	}
}