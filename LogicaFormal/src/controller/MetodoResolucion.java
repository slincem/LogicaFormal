package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ConectorLogico;

/**
 * Clase que se encarga de aplicar el m�todo de resoluci�n, por medio de sus
 * m�todos, en los cuales hace uso de los axiomas
 * 
 * @author Santiago Monta�o Lince
 * @author Jesica Tapasco Velez
 * @author Luis David Ch�vez
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
	 * Variable que representa el atributo f�rmula de la clase
	 */
	private String formula;

	/**
	 * M�todo constructor de la clase
	 * 
	 * @param formula
	 *            F�rmula proposicional ingresada por el usuario
	 */
	public MetodoResolucion(String formula) {
		// TODO Auto-generated constructor stub

		this.formula = formula;
	}

	/**
	 * M�todo que permite aplicar el m�todo de resoluci�n a la f�rmula despu�s
	 * de llevarla a su forma clausal
	 * 
	 * @param formula
	 *            F�rmula bien formada ingresada por el usuario para aplicar el
	 *            m�todo de resoluci�n
	 * @return F�rmula despu�s de aplicar el m�todo de resoluci�n
	 */
	public ArrayList aplicarMetodoDeResolucion() {

		ArrayList formasYFormulas = new ArrayList<>();

		try {
			formasYFormulas = axioma.aplicarResolucion(formula);
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(null,
							"El m�todo de resoluci�n no puede ser aplicado a la f�rmula");

		}

		return formasYFormulas;
	}

	/**
	 * M�todo que permite obtener el valor de la variable f�rmula
	 * 
	 * 
	 * @return F�rmula proposicional ingresada por el usuario
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * M�todo que permite asignar un valor a la variable f�rmula
	 * 
	 * @param formula
	 *            F�rmula proposicional ingresada por el usuario
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

}
