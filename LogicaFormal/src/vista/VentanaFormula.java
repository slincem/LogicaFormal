package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import controller.MetodoResolucion;
import controller.Verificacion;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */

/**
 * Clase que permite la visualización de la interfaz de usuario para el ingreso
 * de la fórmula proposicional
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
public class VentanaFormula extends javax.swing.JFrame implements
		ActionListener, MouseListener {
	/**
	 * Variable que representa al atributo jpanelBotones, que contiene los
	 * botones de la interfaz
	 */
	private JPanel jpanelBotones;

	/**
	 * Variables que representan los atributos correspondientes a los labels en
	 * la clase
	 */
	private JLabel lblSatisfaciblidad, lblFormulaInicial, lblFormulaClausal;

	/**
	 * Variables que representan los atributos correspondientes a los
	 * JEditorPane en la clase
	 */
	private JEditorPane txtpResolucion;
	private JButton btnBorrarLiteral;
	/**
	 * Variable que representa el atributos correspondientes al JTextArea en la
	 * clase
	 */
	private JTextArea txtFormaClausal, txtFormulaProposicional;

	/**
	 * Variables que representan los atributos correspondientes a los botones en
	 * la clase
	 */
	private JButton btnInstrucciones, btnOperadorImplicacion,
			btnOperadorDisyuncion, btnParentesisIzquierdo, btnLiteralS,
			btnLiteralR, btnLiteralT, btnLiteralQ, btnLiteralP,
			btnParentesisDerecho, btnAnalizar, btnOperadorBicondicional,
			btnOperadorNegacion, btnOperadorConjuncion, btnResolucion,
			btnBorrar;

	/**
	 * Variable que representa el atributo panelImagen, el cual es el panel que
	 * usa la ventana en su visualización y contiene los atributos de la clase
	 */
	private PanelImagenFondo panelImagen;

	/**
	 * Método que permite la inicialización de todo el código fuente, es decir,
	 * es el que hace posible la ejecución del algoritmo
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaFormula inst = new VentanaFormula();

				inst.setVisible(true);
			}
		});
	}

	/**
	 * Método constructor de la clase
	 */
	public VentanaFormula() {
		super();
		initGUI();
	}

	/**
	 * Método que permite la inicialización de la ventana que será mostrada al
	 * usuario y sus atributos
	 */
	private void initGUI() {
		try {

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			// panelImagen = new PanelImagenFondo(
			// "imagenes/Mt_gagazet_view_on_zanarkand.jpg");
			panelImagen = new PanelImagenFondo(
					"imagenes/silvermoon-1920x1200.jpg");
			getContentPane().add(panelImagen);
			panelImagen.setBounds(0, 0, 994, 649);
			this.setSize(1010, 688);
			setLayout(null);
			setLocationRelativeTo(null);
			{
				jpanelBotones = new JPanel();
				panelImagen.add(jpanelBotones);
				jpanelBotones.setBounds(7, 55, 194, 504);
				jpanelBotones.setOpaque(false);
				jpanelBotones.setLayout(null);
				{
					btnLiteralP = new JButton();
					jpanelBotones.add(btnLiteralP);
					btnLiteralP.setText("p");
					btnLiteralP.setBounds(109, 155, 50, 32);
					btnLiteralP.addActionListener(this);

				}
				{
					btnLiteralQ = new JButton();
					jpanelBotones.add(btnLiteralQ);
					btnLiteralQ.setText("q");
					btnLiteralQ.setBounds(33, 205, 50, 32);
					btnLiteralQ.addActionListener(this);
				}
				{
					btnLiteralR = new JButton();
					jpanelBotones.add(btnLiteralR);
					btnLiteralR.setText("r");
					btnLiteralR.setBounds(109, 205, 50, 32);
					btnLiteralR.addActionListener(this);
				}
				{
					btnLiteralS = new JButton();
					jpanelBotones.add(btnLiteralS);
					btnLiteralS.setText("s");
					btnLiteralS.setBounds(109, 107, 50, 32);
					btnLiteralS.addActionListener(this);
				}
				{
					btnLiteralT = new JButton();
					jpanelBotones.add(btnLiteralT);
					btnLiteralT.setText("t");
					btnLiteralT.setBounds(33, 155, 50, 32);
					btnLiteralT.addActionListener(this);
				}
				{
					btnInstrucciones = new JButton();
					jpanelBotones.add(btnInstrucciones);
					btnInstrucciones.setText("MANUAL DE USO");
					btnInstrucciones.setBounds(21, 358, 150, 34);
					btnInstrucciones.addActionListener(this);
				}
				{
					btnOperadorImplicacion = new JButton();
					jpanelBotones.add(btnOperadorImplicacion);
					btnOperadorImplicacion.setText("→");
					btnOperadorImplicacion.setBounds(109, 7, 50, 32);
					btnOperadorImplicacion.addActionListener(this);
				}
				{
					btnOperadorBicondicional = new JButton();
					jpanelBotones.add(btnOperadorBicondicional);
					btnOperadorBicondicional.setText("↔");
					btnOperadorBicondicional.setBounds(33, 7, 50, 32);
					btnOperadorBicondicional.addActionListener(this);
				}
				{
					btnAnalizar = new JButton();
					jpanelBotones.add(btnAnalizar);
					btnAnalizar.setText("Analizar");
					// ImageIcon ima = new ImageIcon(getClass().getResource(
					// "imagen/452170135.jpg"));
					// btnAnalizar.setIcon(ima);
					btnAnalizar.setBounds(34, 412, 126, 32);
					btnAnalizar.addActionListener(this);
				}
				{
					btnOperadorNegacion = new JButton();
					jpanelBotones.add(btnOperadorNegacion);
					btnOperadorNegacion.setText("¬");
					btnOperadorNegacion.setBounds(33, 107, 50, 32);
					btnOperadorNegacion.addActionListener(this);
				}
				{
					btnOperadorConjuncion = new JButton();
					jpanelBotones.add(btnOperadorConjuncion);
					btnOperadorConjuncion.setText("&");
					btnOperadorConjuncion.setBounds(109, 59, 50, 32);
					btnOperadorConjuncion.addActionListener(this);
				}
				{
					btnOperadorDisyuncion = new JButton();
					jpanelBotones.add(btnOperadorDisyuncion);
					btnOperadorDisyuncion.setText("v");
					btnOperadorDisyuncion.setBounds(33, 59, 50, 32);
					btnOperadorDisyuncion.addActionListener(this);
				}
				{
					btnResolucion = new JButton();
					jpanelBotones.add(btnResolucion);
					btnResolucion.setText("Aplicar resolución");
					btnResolucion.setBounds(22, 455, 147, 29);
					btnResolucion.addActionListener(this);
				}
				{
					btnBorrar = new JButton();
					jpanelBotones.add(btnBorrar);
					btnBorrar.setText("Borrar fórmula");
					btnBorrar.setBounds(34, 312, 126, 30);
					btnBorrar.addActionListener(this);
				}
				{
					btnBorrarLiteral = new JButton();
					jpanelBotones.add(btnBorrarLiteral);
					btnBorrarLiteral.setText("Borrar literal");
					btnBorrarLiteral.setBounds(34, 263, 126, 30);
					btnBorrarLiteral.addActionListener(this);
				}
			}

			{
				txtFormaClausal = new JTextArea();
				panelImagen.add(txtFormaClausal);
				txtFormaClausal.setBounds(172, 94, 289, 54);

				JScrollPane panel = new JScrollPane(txtpResolucion,
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				// panel.setBounds(219, 412, 751, 215);
				panel.setBounds(219, 149, 751, 261);

				panelImagen.add(panel);
				panel.setViewportView(txtFormaClausal);
				txtFormaClausal.setFont(new java.awt.Font("Gabriola", 0, 20));
				txtFormaClausal.setEditable(false);

			}
			{
				txtFormulaProposicional = new JTextArea();
				panelImagen.add(txtFormulaProposicional);
				txtFormulaProposicional.setBounds(172, 17, 289, 45);

				JScrollPane panel3 = new JScrollPane(txtFormulaProposicional,
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				panel3.setBounds(219, 46, 751, 56);
				txtFormulaProposicional.setEditable(false);

				panelImagen.add(panel3);
				panel3.setViewportView(txtFormulaProposicional);
				txtFormulaProposicional.setFont(new java.awt.Font(
						"Arial Unicode MS", 1, 20));

				txtFormulaProposicional.addMouseListener(this);

			}
			{
				txtpResolucion = new JTextPane();
				panelImagen.add(txtpResolucion);
				txtpResolucion.setBounds(172, 193, 295, 48);
				JScrollPane panel2 = new JScrollPane(txtpResolucion,
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				panel2.setBounds(219, 457, 751, 170);

				panelImagen.add(panel2);
				panel2.setFont(new java.awt.Font("Gabriola", 0, 22));
				panel2.setViewportView(txtpResolucion);
				txtpResolucion.setFont(new java.awt.Font("Gabriola", 1, 26));
				txtpResolucion.setEditable(false);
			}
			{
				lblFormulaInicial = new JLabel();
				panelImagen.add(lblFormulaInicial);
				lblFormulaInicial.setText("Fórmula a analizar");
				lblFormulaInicial.setBounds(224, 23, 131, 17);
				lblFormulaInicial.setForeground(new java.awt.Color(255, 255,
						255));
			}
			{
				lblFormulaClausal = new JLabel();
				panelImagen.add(lblFormulaClausal);
				lblFormulaClausal.setText("Formas de la fórmula");
				lblFormulaClausal.setBounds(224, 122, 176, 21);
				lblFormulaClausal.setForeground(new java.awt.Color(255, 255,
						255));
			}
			{
				lblSatisfaciblidad = new JLabel();
				panelImagen.add(lblSatisfaciblidad);
				lblSatisfaciblidad.setText("Satisfacibilidad de la fórmula");
				lblSatisfaciblidad.setBounds(219, 422, 181, 23);
				lblSatisfaciblidad.setForeground(new java.awt.Color(255, 255,
						255));
			}

		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	/**
	 * Método implementado por la clase para la detección de eventos generados
	 * por los botones, es decir, detecta cuando el usuario presiona clic sobre
	 * un botón
	 * 
	 * @param e
	 *            Acción del botón sobre el cual el usuario ha dado clic
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnInstrucciones) {

			JOptionPane
					.showMessageDialog(
							null,
							"     --- MANUAL DE USO ---     \n"
									+ "Ejemplos de fbfs para el algoritmo: \n"
									+ "			(p)&(q) \n"
									+ "			¬((¬(s))↔(r)) \n \n"
									+ "* PASOS PARA EL MANEJO: \n"
									+ "1. Marque el operador principal de la fórmula \n"
									+ "2. Dentro el/los paréntesis creados por el operador principal, agregue nuevamente el siguiente operador principal \n"
									+ "3. Repita el paso 2 hasta llegar a las letras proposicionales \n"
									+ "* Manejo del cursor: \n"
									+ "-> Para agregar operadores o letras, se debe señalar la posición en la cual"
									+ " se quiere poner dicho operador o letra. \n Se resaltará la posición para ayudar en este proceso \n"
									+ "* Borrado: \n"
									+ "-> El botón borrar fórmula eliminará completamente la fórmula proposicional ingresada, \n"
									+ "es decir, el campo quedará limpio para ingresar nuevamente \n"
									+ "-> El botón borrar literal permite borrar únicamente las letras proposicionales \n"
									+ "* CONSIDERACIONES: \n"
									+ "-> Para agregar una letra proposicional u operador lógico, se necesita señalar \n"
									+ "una posición correcta, y esta posición corresponde al paréntesis izquierdo \n"
									+ "de los que fueron creados por los diferentes operadores");
		}

		if (e.getSource() == btnOperadorBicondicional) {
			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert("()" + "↔" + "()",
						txtFormulaProposicional.getCaretPosition());

			} else {

				String txt = txtFormulaProposicional.getText();
				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (auxiliar2.equals(")")) {
							txtFormulaProposicional.insert("()" + "↔" + "()",
									txtFormulaProposicional.getCaretPosition());
						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el operador binario en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el operador binario en esa posición");
					}
				} else {

					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");

				}
			}
		}
		if (e.getSource() == btnOperadorConjuncion) {
			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(
						"()" + btnOperadorConjuncion.getText() + "()",
						txtFormulaProposicional.getCaretPosition());

			} else {
				String txt = txtFormulaProposicional.getText();
				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (auxiliar2.equals(")")) {
							txtFormulaProposicional.insert("()"
									+ btnOperadorConjuncion.getText() + "()",
									txtFormulaProposicional.getCaretPosition());

						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el operador binario en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el operador binario en esa posición");
					}
				} else {
					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");
				}
			}
		}
		if (e.getSource() == btnOperadorDisyuncion) {

			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(
						"()" + btnOperadorDisyuncion.getText() + "()",
						txtFormulaProposicional.getCaretPosition());

			} else {
				String txt = txtFormulaProposicional.getText();
				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (auxiliar2.equals(")")) {
							txtFormulaProposicional.insert("()"
									+ btnOperadorDisyuncion.getText() + "()",
									txtFormulaProposicional.getCaretPosition());

						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el operador binario en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el operador binario en esa posición");
					}
				}

				else {
					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");
				}
			}
		}
		if (e.getSource() == btnOperadorImplicacion) {

			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(
						"()" + btnOperadorImplicacion.getText() + "()",
						txtFormulaProposicional.getCaretPosition());
			} else {
				String txt = txtFormulaProposicional.getText();

				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (auxiliar2.equals(")")) {
							txtFormulaProposicional.insert("()"
									+ btnOperadorImplicacion.getText() + "()",
									txtFormulaProposicional.getCaretPosition());
						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el operador binario en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el operador binario en esa posición");
					}
				} else {
					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");
				}
			}
		}
		if (e.getSource() == btnOperadorNegacion) {
			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(btnOperadorNegacion.getText()
						+ "()", txtFormulaProposicional.getCaretPosition());
			} else {
				String txt = txtFormulaProposicional.getText();
				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (auxiliar2.equals(")")) {
							txtFormulaProposicional.insert(
									btnOperadorNegacion.getText() + "()",
									txtFormulaProposicional.getCaretPosition());
						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar la negación en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar la negación en esa posición");
					}
				}

				else {

					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");

				}
			}
		}

		if (e.getSource() == btnLiteralP) {
			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(btnLiteralP.getText(),
						txtFormulaProposicional.getCaretPosition());
			} else {
				String txt = txtFormulaProposicional.getText();

				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (!auxiliar2.equals("(")) {
							txtFormulaProposicional.insert(
									btnLiteralP.getText(),
									txtFormulaProposicional.getCaretPosition());
						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el literal en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el literal en esa posición");
					}

				} else {
					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");
				}
			}
		}
		if (e.getSource() == btnLiteralQ) {

			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(btnLiteralQ.getText(),
						txtFormulaProposicional.getCaretPosition());
			} else {
				String txt = txtFormulaProposicional.getText();
				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (!auxiliar2.equals("(")) {
							txtFormulaProposicional.insert(
									btnLiteralQ.getText(),
									txtFormulaProposicional.getCaretPosition());
						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el literal en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el literal en esa posición");
					}
				} else {
					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");
				}
			}
		}
		if (e.getSource() == btnLiteralR) {
			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(btnLiteralR.getText(),
						txtFormulaProposicional.getCaretPosition());
			} else {
				String txt = txtFormulaProposicional.getText();
				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (!auxiliar2.equals("(")) {
							txtFormulaProposicional.insert(
									btnLiteralR.getText(),
									txtFormulaProposicional.getCaretPosition());
						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el literal en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el literal en esa posición");
					}
				} else {
					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");
				}
			}
		}
		if (e.getSource() == btnLiteralS) {
			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(btnLiteralS.getText(),
						txtFormulaProposicional.getCaretPosition());
			} else {
				String txt = txtFormulaProposicional.getText();
				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (!auxiliar2.equals("(")) {
							txtFormulaProposicional.insert(
									btnLiteralS.getText(),
									txtFormulaProposicional.getCaretPosition());
						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el literal en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el literal en esa posición");
					}
				} else {
					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");
				}
			}
		}
		if (e.getSource() == btnLiteralT) {
			int d = txtFormulaProposicional.getCaretPosition();
			if (d == 0 && txtFormulaProposicional.getText().length() == 0) {
				txtFormulaProposicional.insert(btnLiteralT.getText(),
						txtFormulaProposicional.getCaretPosition());
			} else {
				String txt = txtFormulaProposicional.getText();
				if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
					String auxiliar = String.valueOf(txt.charAt(d - 1));
					if (!auxiliar.equals(")") && !auxiliar.equals("↔")
							&& !auxiliar.equals("→") && !auxiliar.equals("&")
							&& !auxiliar.equals("v") && !auxiliar.equals("¬")
							&& !auxiliar.equals("p") && !auxiliar.equals("q")
							&& !auxiliar.equals("r") && !auxiliar.equals("s")) {
						String auxiliar2 = String.valueOf(txt.charAt(d));
						if (!auxiliar2.equals("(")) {
							txtFormulaProposicional.insert(
									btnLiteralT.getText(),
									txtFormulaProposicional.getCaretPosition());
						} else {
							JOptionPane
									.showMessageDialog(null,
											"No es posible agregar el literal en esa posición");
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"No es posible agregar el literal en esa posición");
					}
				} else {
					JOptionPane
							.showMessageDialog(null,
									"No es posible agregar la negación en esa posición");
				}
			}
		}
		if (e.getSource() == btnAnalizar) {

			Verificacion verificacion = new Verificacion();

			String formula = txtFormulaProposicional.getText();

			if (verificacion.verificarFormula(formula)) {
				JOptionPane.showMessageDialog(null, "La fórmula es fbf");
			}

		}
		if (e.getSource() == btnResolucion) {
			Verificacion verificacion = new Verificacion();

			String formula = txtFormulaProposicional.getText();

			if (verificacion.verificarFormula(formula)) {
				MetodoResolucion metodoResolucion = new MetodoResolucion(
						formula);
				ArrayList formasYFormulas = metodoResolucion
						.aplicarMetodoDeResolucion();

				if (formasYFormulas.size() > 0) {

					txtFormaClausal.setText("Forma normal conjuntiva: "
							+ "\n"
							+ (String) formasYFormulas.get(0)
							+ "\n"
							+ "Forma clausal: "
							+ "\n"
							+ imprimirFormaClausal((ArrayList) formasYFormulas
									.get(1))
							+ "\n"
							+ "Forma clausal restringida:"
							+ "\n"
							+ imprimirFormaClausal((ArrayList) formasYFormulas
									.get(2)));

					txtpResolucion.setText("La fórmula es: " + "\n"
							+ (String) formasYFormulas.get(3));
				} else {

					JOptionPane.showMessageDialog(null,
							"La fórmula está mal formulada");
				}
			}

		}
		if (e.getSource() == btnBorrar) {
			txtFormulaProposicional.setText("");

		}
		if (e.getSource() == btnBorrarLiteral) {
			int d = txtFormulaProposicional.getCaretPosition();

			if (d > 0 && txtFormulaProposicional.getText().length() > 0) {
				String letra = String.valueOf(txtFormulaProposicional.getText()
						.charAt(d - 1));

				if (d > 1 && d <= txtFormulaProposicional.getText().length()) {
					String formula = txtFormulaProposicional.getText();
					if (letra.equals("p") || letra.equals("q")
							|| letra.equals("r") || letra.equals("s")
							|| letra.equals("t")) {
						txtFormulaProposicional
								.setText(formula.substring(0, d - 1)
										+ formula.substring(d, formula.length()));
					} else {
						JOptionPane.showMessageDialog(null,
								"El caracter no puede ser eliminado");
					}
				} else {
					if (letra.equals("p") || letra.equals("q")
							|| letra.equals("r") || letra.equals("s")
							|| letra.equals("t")) {
						txtFormulaProposicional.setText("");
					} else {
						JOptionPane.showMessageDialog(null,
								"No hay letras proposicionales para eliminar");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"No hay caracteres para eliminar");
			}
		}
	}

	/**
	 * Método implementado por la clase para la detección de eventos generados
	 * por el mouse, es decir, detecta cuando el usuario hace clic con el mouse
	 * sobre un área determinada
	 * 
	 * @param e
	 *            Acción del mouse cuando el usuario ha dado clic
	 */
	public void mousePressed(MouseEvent e) {

		txtFormulaProposicional.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				// int d = txtFormulaProposicional.getCaretPosition();
				// System.out.println(d);
				if (!txtFormulaProposicional.getText().trim().equals(""))
					if (e.getMark() == e.getDot() & e.getMark() > 0) {
						Highlighter resaltar = txtFormulaProposicional
								.getHighlighter();
						HighlightPainter paint = new DefaultHighlighter.DefaultHighlightPainter(
								Color.lightGray);
						resaltar.removeAllHighlights();
						try {
							resaltar.addHighlight(e.getMark() - 1, e.getMark(),
									paint);

						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			}
		});
	}

	/**
	 * Método implementado por la clase para la detección de eventos generados
	 * por el mouse, es decir, detecta cuando el usuario hace clic con el mouse
	 * sobre un área determinada
	 * 
	 * @param e
	 *            Acción del mouse cuando el usuario ha dado clic
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println(e.paramString()+"hola");
	}

	/**
	 * Método implementado por la clase para la detección de eventos generados
	 * por el mouse, es decir, detecta cuando el usuario hace clic con el mouse
	 * sobre un área determinada
	 * 
	 * @param e
	 *            Acción del mouse cuando el usuario ha dado clic
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// System.out.println(e.paramString()+"hola");
	}

	/**
	 * Método implementado por la clase para la detección de eventos generados
	 * por el mouse, es decir, detecta cuando el usuario hace clic con el mouse
	 * sobre un área determinada
	 * 
	 * @param e
	 *            Acción del mouse cuando el usuario ha dado clic
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// System.out.println(e.paramString()+"hola");
	}

	/**
	 * Método implementado por la clase para la detección de eventos generados
	 * por el mouse, es decir, detecta cuando el usuario hace clic con el mouse
	 * sobre un área determinada
	 * 
	 * @param e
	 *            Acción del mouse cuando el usuario ha dado clic
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// System.out.println(e.paramString()+"hola");
	}

	/**
	 * Método que se encarga de insertar las clausulas en un String para hacer
	 * más fácil la acción de mostrar
	 * 
	 * @param formaClausal
	 *            Fórmula a mostrar
	 * @return Clausulas dentro de un String
	 */
	public static String imprimirFormaClausal(ArrayList formaClausal) {

		String conjuntoClausal = "{";
		for (int i = 0; i < formaClausal.size(); i++) {

			ArrayList clausula = (ArrayList) formaClausal.get(i);

			for (int j = 0; j < clausula.size(); j++) {

				conjuntoClausal += clausula.get(j) + "v";

			}
			conjuntoClausal = conjuntoClausal.substring(0,
					conjuntoClausal.length() - 1);
			conjuntoClausal += ",";
		}

		conjuntoClausal = conjuntoClausal.substring(0,
				conjuntoClausal.length() - 1);
		conjuntoClausal += "}";

		return conjuntoClausal;

	}
}
