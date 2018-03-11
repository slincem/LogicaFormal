package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase que permite la creación de un panel genérico para que sea usado por la
 * ventana de ingreso de fórmulas
 * 
 * @author Santiago Montaño Lince
 * @author Jesica Tapasco Velez
 * @author Luis David Chávez
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
	 * Método constructor, que recibe el nombre de la imagen que contendrán los
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
	 * Método que pinta la imagen en el panel.
	 * 
	 * @param g
	 *            Variable que permite asignar el tamaño, la altura y la imagen
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
