package paquete;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {
	
	private Image imagen;
	
	public PanelFondo() {
		
	}
        
	public void paint(Graphics g) {
			imagen = new ImageIcon(getClass().getResource("/imagenes/fondoVenom.jpg")).getImage();
			
			g.drawImage(imagen,0,0, getWidth(), getHeight(), this);
			
			setOpaque(false);
			
			super.paint(g);
		}
}
