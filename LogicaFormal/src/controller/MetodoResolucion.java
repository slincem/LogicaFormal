package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ConectorLogico;

/**
 * Clase que se encarga de aplicar el método de resolución, por medio de sus
 * métodos, en los cuales hace uso de los axiomas
 * 
 * @author Santiago Montaño Lince
 * @author Jesica Tapasco Velez
 * @author Luis David Chávez
 * 
 * @version 1.0
 * @since 2015 - 04 - 11
 * 
 */
public class MetodoResolucion {

	/**
	 * Variable que representa el atributo axioma de la clase
	 */
	private Axioma axioma = new Axioma();

	/**
	 * Variable que representa el atributo fórmula de la clase
	 */
	private String formula;

	/**
	 * Método constructor de la clase
	 * 
	 * @param formula
	 *            Fórmula proposicional ingresada por el usuario
	 */
	public MetodoResolucion(String formula) {
		// TODO Auto-generated constructor stub

		this.formula = formula;
	}

	/**
	 * Método que permite aplicar el método de resolución a la fórmula después
	 * de llevarla a su forma clausal
	 * 
	 * @param formula
	 *            Fórmula bien formada ingresada por el usuario para aplicar el
	 *            método de resolución
	 * @return Fórmula después de aplicar el método de resolución
	 */
	public ArrayList aplicarMetodoDeResolucion() {

		ArrayList formasYFormulas = new ArrayList<>();

		try {
			formasYFormulas = axioma.aplicarResolucion(formula);
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(null,
							"El método de resolución no puede ser aplicado a la fórmula");

		}

		return formasYFormulas;
	}

	/**
	 * Método que permite obtener el valor de la variable fórmula
	 * 
	 * 
	 * @return Fórmula proposicional ingresada por el usuario
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * Método que permite asignar un valor a la variable fórmula
	 * 
	 * @param formula
	 *            Fórmula proposicional ingresada por el usuario
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

}
