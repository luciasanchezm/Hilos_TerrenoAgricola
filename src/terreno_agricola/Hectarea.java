package terreno_agricola;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Hectarea extends JPanel {
	private int noHectarea, calidad;
	private JLabel texto;
	private Image imagenHermano;
	Semaforo semaforo;
	boolean selected;
	
	public Hectarea(int noHectarea, int calidad) {
		this.noHectarea = noHectarea;
		this.calidad = calidad;
		semaforo = new Semaforo(1);
		selected = false;
		
		createInterface();
	}
	
	public void createInterface() {
		setBorder(BorderFactory.createRaisedBevelBorder());
		setPreferredSize(new Dimension(142, 86));
		texto = new JLabel(this.noHectarea+"");
		texto.setFont(new Font("Arial", Font.BOLD, 20));
		add(texto);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		String nombreImagen = null;
		int noAleatorio = Rutinas.nextInt(1,2);
		switch(calidad) {
		case 1:
			nombreImagen = noAleatorio==1?"TerrenoAgricola1.png":"TerrenoAgricola1-.png";
			break;
		case 2:
			nombreImagen = noAleatorio==1?"TerrenoAgricola2.png":"TerrenoAgricola2-.png";
			break;
		case 3:
			nombreImagen = noAleatorio==1?"TerrenoAgricola3.png":"TerrenoAgricola3-.png";
			break;
		}
		Image imagen =  new ImageIcon(nombreImagen).getImage();
		g.drawImage(imagen, 0, 0, 142, 86, this);
		g.setColor(Color.WHITE);
		g.drawString(texto.getText(), 65, 20);
		if(selected)
			g.drawImage(imagenHermano, 45, 30, this);
	}
	
	public void Select(String imagenHermano) {
		setBorder(BorderFactory.createLoweredBevelBorder());
		selected = true;
		this.imagenHermano = Rutinas.AjustarImagen(imagenHermano, 50, 50).getImage();
		repaint();
	}
}