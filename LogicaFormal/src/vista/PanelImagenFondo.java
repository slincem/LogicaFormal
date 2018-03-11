package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase que permite la creaci�n de un panel gen�rico para que sea usado por la
 * ventana de ingreso de f�rmulas
 * 
 * @author Santiago Monta�o Lince
 * @author Jesica Tapasco Velez
 * @author Luis David Ch�vez
 * 
 * @version 1.0
 * @since 2015 - 04 - 11
 * 
 */
@SuppressWarnings("serial")
public class PanelImagenFondo extends JPanel {

	/**
	 * Variable que representa el atributo imagen de la clase
	 */
	private ImageIcon imagen;

	/**
	 * Variable que representa el atributo nombre de la clase
	 */
	private String nombre;

	/**
	 * M�todo constructor, que recibe el nombre de la imagen que contendr�n los
	 * paneles creados de esta clase.
	 * 
	 * @param nombre
	 *            nombre de la imagen
	 */

	public PanelImagenFondo(String nombre) {
		this.nombre = nombre;
		this.setLayout(null);
	}

	/**
	 * M�todo que pinta la imagen en el panel.
	 * 
	 * @param g
	 *            Variable que permite asignar el tama�o, la altura y la imagen
	 *            al panel
	 */
	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);
	}

}
