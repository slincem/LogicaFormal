package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.ConectorLogico;
import model.LetraProposicional;

/**
 * Clase que permite la verificación de la fórmula ingresada por el usuario.
 * Esta clase por medio de sus métodos, se encarga de analizar si la fórmula
 * está bien formada
 * 
 * @author Santiago Montaño Lince
 * @author Jesica Tapasco Velez
 * @author Luis David Chávez
 * 
 * @version 1.0
 * @since 2015 - 04 - 11
 * 
 */
public class Verificacion {

	/**
	 * Método encargado de la verificación de que la cantidad de paréntesis
	 * tanto derechos como izquierdos sea la misma
	 * 
	 * @param formula
	 *            Fórmula ingresada por el usuario para ser verificada
	 * @return boolean con true si son iguales y false en caso contrario
	 */
	public static boolean verificarParentesisIguales(String formula) {

		char[] caracteres = formula.toCharArray();

		int parentesisDer = 0;
		int parentesisIzq = 0;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == '(') {
				parentesisIzq++;
			}

			if (caracteres[i] == ')') {
				parentesisDer++;
			}

		}

		return (parentesisDer == parentesisIzq);
	}

	/**
	 * Método encargado de verificar si los símbolos en la fórmula son válidos
	 * 
	 * @param formula
	 *            Fórmula a ser analizada
	 * @return boolean con true en caso de que los símbolos sean válidos y false
	 *         en caso contrario
	 */
	public static boolean verificarSimbolosValidos(String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == '(' || caracteres[i] == ')'
					|| caracteres[i] == ConectorLogico.OPERADOR_CONJUNCION
					|| caracteres[i] == ConectorLogico.OPERADOR_NEGACION
					|| caracteres[i] == ConectorLogico.OPERADOR_IMPLICACION
					|| caracteres[i] == ConectorLogico.OPERADOR_BICONDICIONAL
					|| caracteres[i] == ConectorLogico.OPERADOR_DISYUNCION
					|| caracteres[i] == LetraProposicional.LETRA_P
					|| caracteres[i] == LetraProposicional.LETRA_Q
					|| caracteres[i] == LetraProposicional.LETRA_R
					|| caracteres[i] == LetraProposicional.LETRA_S
					|| caracteres[i] == LetraProposicional.LETRA_T) {

			}

			else {

				return false;

			}

		}
		return true;

	}

	/**
	 * Método encargado de verificar el correcto orden de los operadores
	 * 
	 * @param formula
	 *            Fórmula a ser analizada por el método
	 * @return boolean con true en caso de que el orden sea correcto y false en
	 *         caso contrario
	 */
	public static boolean verificarOrdenOperadores(String formula) {

		char[] caracteres = formula.toCharArray();

		return false;
	}

	/**
	 * Método encargado de verificar si el número de letras proposicionales
	 * corresponde al número de conectivos binarios en la fórmula
	 * 
	 * @param formula
	 *            Fórmula a ser analizada por el método
	 * @return boolean con true en caso del correcto número de los operandos,
	 *         que en este caso son letras proposicionales, con los operadores y
	 *         false en caso contrario
	 */
	public static boolean verificarNumeroLetrasProposicionalesPorConectivosBinarios(
			String formula) {

		char[] caracteres = formula.toCharArray();

		int numeroLetrasProposicionales = 0;
		int numeroOperadoresBinarios = 0;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == LetraProposicional.LETRA_P
					|| caracteres[i] == LetraProposicional.LETRA_Q
					|| caracteres[i] == LetraProposicional.LETRA_R
					|| caracteres[i] == LetraProposicional.LETRA_S
					|| caracteres[i] == LetraProposicional.LETRA_T) {
				numeroLetrasProposicionales++;
			}

			if (caracteres[i] == ConectorLogico.OPERADOR_CONJUNCION
					|| caracteres[i] == ConectorLogico.OPERADOR_IMPLICACION
					|| caracteres[i] == ConectorLogico.OPERADOR_BICONDICIONAL
					|| caracteres[i] == ConectorLogico.OPERADOR_DISYUNCION) {
				numeroOperadoresBinarios++;
			}

		}

		return (numeroLetrasProposicionales == (numeroOperadoresBinarios + 1));

	}

	/**
	 * Método encargado de verificar si el número de paréntesis corresponde al
	 * número de negaciones y operadores binarios existentes en la fórmula
	 * 
	 * @param formula
	 *            Fórmula a ser analizada por el método
	 * @return boolean con true en caso de que la verificación sea correcta y
	 *         false en caso contrario.
	 */
	public static boolean verificarNumeroParentesisAcordesANegacionesYOpBinarios(
			String formula) {

		char[] caracteres = formula.toCharArray();

		int numeroParentesis = 0;
		int numeroNegaciones = 0;
		int numeroOperadoresBinarios = 0;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == '(' || caracteres[i] == ')') {

				numeroParentesis++;
			}

			if (caracteres[i] == ConectorLogico.OPERADOR_NEGACION) {

				numeroNegaciones++;
			}

			if (caracteres[i] == ConectorLogico.OPERADOR_CONJUNCION
					|| caracteres[i] == ConectorLogico.OPERADOR_IMPLICACION
					|| caracteres[i] == ConectorLogico.OPERADOR_BICONDICIONAL
					|| caracteres[i] == ConectorLogico.OPERADOR_DISYUNCION) {

				numeroOperadoresBinarios++;

			}

		}

		return (numeroParentesis == ((2 * numeroNegaciones) + (4 * numeroOperadoresBinarios)));
	}

	/**
	 * Método que permite verificar el exceso de paréntesis en una letra
	 * proposicional
	 * 
	 * @param formula
	 *            Fórmula a ser analizada por el método para verificar que sus
	 *            letras proposicionales no tengan exceso de paréntesis
	 * @return true en caso de que las letras proposicionales tengan un número
	 *         correcto de paréntesis y false en caso contrario
	 * 
	 */
	public static boolean verificarExcesoParentesis(String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == LetraProposicional.LETRA_P
					|| caracteres[i] == LetraProposicional.LETRA_Q
					|| caracteres[i] == LetraProposicional.LETRA_R
					|| caracteres[i] == LetraProposicional.LETRA_S
					|| caracteres[i] == LetraProposicional.LETRA_T) {
				if ((i - 2) >= 0 && (i + 2) < caracteres.length) {
					if (caracteres[i - 2] == '(' && caracteres[i + 2] == ')') {
						return false;
					}
				}

				if ((i - 2) >= 0) {
					if (caracteres[i - 2] != ConectorLogico.OPERADOR_NEGACION) {
						if ((i - 3) >= 0 && (i + 3) < caracteres.length) {
							if (caracteres[i - 3] == '('
									&& caracteres[i + 3] == ')') {
								return false;
							}
						}
					}
				}
			}
		}
		return true;

	}

	/**
	 * Método encargado de la verificación de la información contenida dentro de
	 * los paréntesis, ya que esta debe cumplir con ciertas condiciones como no
	 * estar vacía.
	 * 
	 * @param formula
	 *            Fórmula a ser analizada por el método
	 * @return boolean con true si la información contenida en los paréntesis es
	 *         correcta y false en caso contrario.
	 */
	public static boolean verificarContenidoParentesisNoVacio(String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if ((i - 1) >= 0 && (i + 1) < caracteres.length) {

				if (caracteres[i] == '(' && caracteres[i + 1] == ')') {
					return false;
				}

			}
		}

		return true;
	}

	/**
	 * Método encargado de la verificación de verificar que la fórmula ingresada
	 * no contenga paréntesis contrarios juntos, debido a que no sería una fbf.
	 * 
	 * @param formula
	 *            Fórmula a ser analizada por el método
	 * @return boolean con true si no existe en la fórmula un momento en que se
	 *         de ")(", y false en caso contrario
	 */
	public static boolean verificarParentesisContrariosNoJuntos(String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if ((i - 1) >= 0 && (i + 1) < caracteres.length) {

				if (caracteres[i] == ')' && caracteres[i + 1] == '(') {

					return false;
				}
			}

		}
		return true;
	}

	/**
	 * Método encargado de verificar que en la fórmula no se encuentren dos
	 * letras proposicionales juntas
	 * 
	 * @param formula
	 *            Fórmula a ser analizada por el método
	 * @return true si no existen dos letras proposicionales juntas y false en
	 *         caso contrario.
	 */
	public static boolean verificarDosLetrasProposicionalesJuntas(String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if ((i - 1) >= 0 && (i + 1) < caracteres.length) {

				if (caracteres[i] == LetraProposicional.LETRA_P
						|| caracteres[i] == LetraProposicional.LETRA_Q
						|| caracteres[i] == LetraProposicional.LETRA_R
						|| caracteres[i] == LetraProposicional.LETRA_S
						|| caracteres[i] == LetraProposicional.LETRA_T) {

					if (caracteres[i - 1] == LetraProposicional.LETRA_P
							|| caracteres[i + 1] == LetraProposicional.LETRA_P
							|| caracteres[i - 1] == LetraProposicional.LETRA_Q
							|| caracteres[i + 1] == LetraProposicional.LETRA_Q
							|| caracteres[i - 1] == LetraProposicional.LETRA_R
							|| caracteres[i + 1] == LetraProposicional.LETRA_R
							|| caracteres[i - 1] == LetraProposicional.LETRA_S
							|| caracteres[i + 1] == LetraProposicional.LETRA_S
							|| caracteres[i - 1] == LetraProposicional.LETRA_T
							|| caracteres[i + 1] == LetraProposicional.LETRA_T) {

						return false;

					}
				}
			}
		}
		return true;
	}

	/**
	 * Método que permite verificar el contenido que se encuentra dentro de los
	 * paréntesis, que en este caso no debe ser un conector lógico sólo
	 * 
	 * @param formula
	 *            Fórmula a ser analizada por el método
	 * @return true en caso de que dentro de dos paréntesis izquierdo y derecho
	 *         no se encuentre únicamente un operador y false en caso contrario
	 */
	public static boolean verificarContenidoDentroDeParentesis(String formula) {

		char[] caracteres = formula.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {

			if ((i - 1) >= 0 && (i + 1) < caracteres.length) {
				if (caracteres[i] == ConectorLogico.OPERADOR_CONJUNCION
						|| caracteres[i] == ConectorLogico.OPERADOR_IMPLICACION
						|| caracteres[i] == ConectorLogico.OPERADOR_BICONDICIONAL
						|| caracteres[i] == ConectorLogico.OPERADOR_DISYUNCION
						|| caracteres[i] == ConectorLogico.OPERADOR_NEGACION) {
					if (caracteres[i - 1] == '(' && caracteres[i + 1] == ')') {
						return false;
					}
				}
			}

		}
		return true;
	}

	/**
	 * Método que permite verificar que una letra proposicional tenga sus
	 * paréntesis correspondientes
	 * 
	 * @param formula
	 *            Fórmula ingresada por el usuario para ser analizada por el
	 *            método.
	 * @return true en caso de que las letras tengan sus paréntesis
	 *         correspondientes y false en caso contrario.
	 */
	public static boolean verificarParentesisEnLetrasProposicionales(
			String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == LetraProposicional.LETRA_P
					|| caracteres[i] == LetraProposicional.LETRA_Q
					|| caracteres[i] == LetraProposicional.LETRA_R
					|| caracteres[i] == LetraProposicional.LETRA_S
					|| caracteres[i] == LetraProposicional.LETRA_T) {
				if ((i - 1) >= 0 && caracteres[i - 1] != '(') {

					return false;
				}

				if ((i + 1) < caracteres.length && caracteres[i + 1] != ')') {

					return false;

				}
			}
		}
		return true;

	}

	/**
	 * Método que permite verificar los paréntesis de las letras proposicionales
	 * en caso de que estas posean una negación
	 * 
	 * @param formula
	 *            Fórmula proposicional ingresada por el usuario para ser
	 *            analizada por el método
	 * @return true en caso de que los paréntesis de la letra proposicional se
	 *         encuentren en la posición correcta, en este caso, teniendo
	 *         negación
	 */
	public static boolean verificarParentesisDeLetrasConNegacion(String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if ((i - 2) >= 0 && (i + 2) < caracteres.length) {

				if (caracteres[i] == LetraProposicional.LETRA_P
						|| caracteres[i] == LetraProposicional.LETRA_Q
						|| caracteres[i] == LetraProposicional.LETRA_R
						|| caracteres[i] == LetraProposicional.LETRA_S
						|| caracteres[i] == LetraProposicional.LETRA_T) {

					if (caracteres[i - 2] == ConectorLogico.OPERADOR_NEGACION) {
						if (caracteres[i + 2] != ')') {
							return false;
						}
					}
				}
			}

		}
		return true;
	}

	/**
	 * Método que permite verificar que las negaciones esten en la posición
	 * correcta
	 * 
	 * @param formula
	 *            Fórmula ingresada por el usuario para ser analizada por el
	 *            método
	 * @return true en caso de que las negaciones se encuentren en la posición
	 *         correcta y false en caso contrario
	 * 
	 */
	public static boolean verificarPosicionDeNegacion(String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if ((i - 1) >= 0) {

				if (caracteres[i] == ConectorLogico.OPERADOR_NEGACION) {

					if (caracteres[i - 1] == ')') {
						return false;
					}
				}
			}

		}

		return true;
	}

	/**
	 * Método que permite verificar si los paréntesis de los operadores, en una
	 * operación binaria, están correctos
	 * 
	 * @param formula
	 *            Fórmula proposicional a ser analizada por el método
	 * @return true en caso de que los paréntesis de los operadores se
	 *         encuentren correctos y false en caso contrario
	 */
	public static boolean verificarParentesisEnOperacionesBinarias(
			String formula) {

		char[] caracteres = formula.toCharArray();

		for (int i = 0; i < caracteres.length; i++) {

			if ((i - 1) >= 0 && (i + 1) < caracteres.length) {

				if (caracteres[i] == ConectorLogico.OPERADOR_CONJUNCION
						|| caracteres[i] == ConectorLogico.OPERADOR_IMPLICACION
						|| caracteres[i] == ConectorLogico.OPERADOR_BICONDICIONAL
						|| caracteres[i] == ConectorLogico.OPERADOR_DISYUNCION) {

					if (caracteres[i - 1] != ')' || caracteres[i + 1] != '(') {
						return false;
					}

				}
			}
		}
		return true;
	}

	/**
	 * Método encargado de determinar si una fórmula proposicional es fbf
	 * 
	 * @param formula
	 *            Fórmula proposicional a ser analizada por el método
	 * @return true en caso de que la fórmula este bien formada y false en caso
	 *         contrario
	 */
	public boolean verificarFormula(String formula) {
		boolean verificacion = false;
		if (verificarParentesisIguales(formula)) {

			if (verificarSimbolosValidos(formula)) {

				if (verificarExcesoParentesis(formula)) {

					if (verificarContenidoDentroDeParentesis(formula)) {

						if (verificarDosLetrasProposicionalesJuntas(formula)) {

							if (verificarParentesisContrariosNoJuntos(formula)) {

								if (verificarParentesisEnLetrasProposicionales(formula)) {

									if (verificarNumeroLetrasProposicionalesPorConectivosBinarios(formula)) {

										if (verificarNumeroParentesisAcordesANegacionesYOpBinarios(formula)) {

											if (verificarParentesisDeLetrasConNegacion(formula)) {

												if (verificarPosicionDeNegacion(formula)) {

													if (verificarParentesisEnOperacionesBinarias(formula)) {

														verificacion = true;

													} else {
														JOptionPane
																.showMessageDialog(
																		null,
																		"Existen operaciones binarios mal expresadas");
													}

												} else {

													JOptionPane
															.showMessageDialog(
																	null,
																	"Negación en posición incorrecta");
												}
											} else {
												JOptionPane
														.showMessageDialog(
																null,
																"Existen letras proposicionales con negación mal formadas");
											}
										} else {
											JOptionPane
													.showMessageDialog(
															null,
															"El número de paréntesis no concuerda con el número de negaciones y operadores binarios");
										}

									} else {
										JOptionPane
												.showMessageDialog(null,
														"Faltan letras o conectivos binarios");
									}

								} else {
									JOptionPane
											.showMessageDialog(null,
													"Existen letras proposicionales sin sus paréntesis correspondientes");
								}

							} else {
								JOptionPane
										.showMessageDialog(null,
												"Existen paréntesis en posiciones incorrectas");
							}

						} else {
							JOptionPane.showMessageDialog(null,
									"Hay dos letras proposicionales juntas");
						}

					} else {
						JOptionPane
								.showMessageDialog(null,
										"Existe información dentro de los paréntesis no correspondiente");
					}

				} else {
					JOptionPane
							.showMessageDialog(null,
									"Existe un exceso de paréntesis en una letra proposicional");
				}

			} else {
				JOptionPane.showMessageDialog(null,
						"Existen símbolos no válidos");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Paréntesis desiguales");
		}
		return verificacion;
	}

}
