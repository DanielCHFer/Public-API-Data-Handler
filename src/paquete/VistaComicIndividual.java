package paquete;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VistaComicIndividual extends JFrame {

	private static final long serialVersionUID = 1L;
	PanelFondo fondo = new PanelFondo();

	/**
	 * Create the panel.
	 */
	public VistaComicIndividual() {
		
		this.setContentPane(fondo);
		
		
	}

}
