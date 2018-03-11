package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Clase que se encargada de aplicar los axiomas a una fórmula proposicional y
 * determinar la diferentes formas de la fórmula
 * 
 * @author Santiago Montaño Lince
 * @author Jesica Tapasco Vélez
 * @author Luis David Chávez
 * 
 * @version 1.0
 * @since 2015 - 04 - 11
 * 
 */
public class Axioma {

	private static int posicionClausulas = 0;

	/**
	 * Método que permite aplicar el método de resolución. Aquí se toma la forma
	 * normal conjuntiva, la forma clausal, la forma clausal restringida, y el
	 * resultado del método de resolución
	 * 
	 * @param formula
	 *            Fórmula proposicional a aplicar el método
	 * @return ArrayList que contiene en su posición 0 la FNC, en la 1 la forma
	 *         clausal, en la 2 la forma clausal restringida y e la 3 el
	 *         resultado del método de resolución
	 */
	public static ArrayList aplicarResolucion(String formula) {

		ArrayList formulasYFormas = new ArrayList<>();

		String anterior = "";

		while (!anterior.equals(formula)) {
			try {
				anterior = formula;
				formula = aplicarAxiomaNueveLeyDelBicondicional(formula);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"La fórmula proposicional está mal formulada");
			}

		}

		anterior = "";
		while (!anterior.equals(formula)) {
			try {
				anterior = formula;
				formula = AplicarAxiomaOchoLeyCondicional(formula);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"La fórmula proposicional está mal formulada");
			}

		}

		anterior = "";
		while (!anterior.equals(formula)) {
			try {
				anterior = formula;
				formula = aplicarAxiomaSieteLeyDeMorgan(formula);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"La fórmula proposicional está mal formulada");
			}

		}

		anterior = "";
		while (!anterior.equals(formula)) {
			try {
				anterior = formula;
				formula = aplicarEliminacionDeDobleNegacion(formula);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"La fórmula proposicional está mal formulada");
			}

		}

		anterior = "";
		while (!anterior.equals(formula)) {

			try {
				anterior = formula;
				formula = aplicarAxiomaDosLeyDistributiva(formula);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"La fórmula proposicional está mal formulada");
			}

		}

		anterior = "";
		while (!anterior.equals(formula)) {
			try {
				anterior = formula;
				formula = aplicarAxiomaUnoLeyAsociativa(formula);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"La fórmula proposicional está mal formulada");
			}

		}

		formulasYFormas.add(formula);
		// System.out.println(formula);

		ArrayList formaClausal = transformarAFormaClausal(formula);
		formulasYFormas.add((ArrayList) formaClausal.clone());

		// System.out.println(imprimirFormaClausal(formaClausal));

		ArrayList formaClausalClonada = (ArrayList) formaClausal.clone();

		// System.out
		// .println(imprimirFormaClausal(eliminarLiteralesRepetidosEnFormaClausal(formaClausal)));

		ArrayList formaClausalRestringida = new ArrayList<>();

		for (int i = 0; i < formaClausal.size(); i++) {

			ArrayList clausulaClon = (ArrayList) (formaClausalClonada.get(i));
			formaClausalRestringida.add((ArrayList) clausulaClon.clone());
		}

		formaClausalRestringida = eliminarLiteralesRepetidosEnFormaClausal(formaClausalRestringida);
		formulasYFormas.add(formaClausalRestringida);

		ArrayList formaClausalRestringidaAuxMR = new ArrayList<>();

		formaClausalRestringidaAuxMR.addAll(formaClausalRestringida);

		formaClausalRestringidaAuxMR = eliminarLiteralesPuros(formaClausalRestringidaAuxMR);

		String satisfacibilidad = "";
		if (aplicarMetodoDeResolucion(formaClausalRestringidaAuxMR)) {
			satisfacibilidad = "Insatisfacible";
		} else {
			satisfacibilidad = "Satisfacible";
		}
		formulasYFormas.add(satisfacibilidad);

		// formulasYFormas
		// .add(aplicarMetodoResolucionJC(formaClausalRestringidaAuxMR));
		return formulasYFormas;

	}

	/**
	 * Método que permite aplicar la ley asociativa a una fórmula proposicional
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * 
	 * @return Fórmula proposicional luego de aplicar la ley, o el mismo en caso
	 *         de poder ser aplicada la ley
	 */
	public static String aplicarAxiomaUnoLeyAsociativa(String formula) {

		while (encontrarParentesisAdelanteDeLetraProposicional(formula) != -1
				|| encontrarParentesisAtrasDeLetraProposicional(formula) != -1) {

			int posicionAsociativaAdelante = encontrarParentesisAdelanteDeLetraProposicional(formula);
			int posicionAsociativaAtras = encontrarParentesisAtrasDeLetraProposicional(formula);

			if (posicionAsociativaAdelante != -1
					&& (formula.charAt(posicionAsociativaAdelante) == ')')) {

				if ((posicionAsociativaAdelante + 1) < formula.length()) {

					String parteAnterior = formula.substring(0,
							posicionAsociativaAdelante);
					String partePosterior = formula.substring(
							posicionAsociativaAdelante + 1, formula.length());

					formula = parteAnterior + partePosterior;
				} else {

					formula = formula.substring(0, formula.length() - 1);
				}

			}

			if (posicionAsociativaAtras != -1
					&& (formula.charAt(posicionAsociativaAtras) == '(')) {

				if ((posicionAsociativaAtras - 1) >= 0) {

					String parteAnterior = formula.substring(0,
							posicionAsociativaAtras);
					String partePosterior = formula.substring(
							posicionAsociativaAtras + 1, formula.length());

					formula = parteAnterior + partePosterior;
				} else {
					formula = formula.substring(1, formula.length());
				}
			}
		}

		return formula;

	}

	/**
	 * Método que permite aplicar el axioma correspondiente a la ley
	 * distributiva
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * 
	 * @return Fórmula luego de aplicar la ley distributiva, o la misma, en caso
	 *         de no poderse aplicar la ley
	 */
	public static String aplicarAxiomaDosLeyDistributiva(String formula) {

		for (int i = 0; i < formula.length(); i++) {

			if (formula.charAt(i) == '&') {

				int posicionOperadorPrincipalAdelante = encontrarOperadorPrincipal(
						formula, i) + 2;
				int posicionOperadorPrincipalAtras = encontrarParteADescomponer(
						formula, i) - 2;

				if ((posicionOperadorPrincipalAdelante - 2) != -1
						&& posicionOperadorPrincipalAdelante < formula.length()
						&& formula.charAt(posicionOperadorPrincipalAdelante) == 'v') {

					int posicionOperandoPostConjuncion = encontrarOperadorPrincipal(
							formula, posicionOperadorPrincipalAdelante);

					int posicionOperandoPreConjuncion = encontrarParteADescomponer(
							formula, posicionOperadorPrincipalAdelante);

					String operandoA = formula.substring(
							posicionOperadorPrincipalAtras + 2, i);

					String operandoB = formula.substring(i + 1,
							posicionOperadorPrincipalAdelante - 1);

					String operandoC = formula.substring(
							posicionOperadorPrincipalAdelante + 1,
							posicionOperandoPostConjuncion + 1);

					String descomposicion = "(" + operandoA + "v" + operandoC
							+ ")" + "&" + "(" + operandoB + "v" + operandoC
							+ ")";

					String cadenaARemplazar = formula.substring(
							posicionOperandoPreConjuncion,
							posicionOperandoPostConjuncion + 1);

					formula = formula.replace(cadenaARemplazar, descomposicion);

					i = 0;

				}

				else if ((posicionOperadorPrincipalAtras) >= 0
						&& formula.charAt(posicionOperadorPrincipalAtras) == 'v') {

					int posicionOperandoPostConjuncion = encontrarOperadorPrincipal(
							formula, posicionOperadorPrincipalAtras);

					int posicionOperandoPreConjuncion = encontrarParteADescomponer(
							formula, posicionOperadorPrincipalAtras);

					String operandoA = formula.substring(
							posicionOperadorPrincipalAtras + 2, i);

					String operandoB = formula.substring(i + 1,
							posicionOperadorPrincipalAdelante - 1);

					String operandoC = formula.substring(
							posicionOperandoPreConjuncion,
							posicionOperadorPrincipalAtras);

					String descomposicion = "(" + operandoC + "v" + operandoA
							+ ")" + "&" + "(" + operandoC + "v" + operandoB
							+ ")";

					String cadenaARemplazar = formula.substring(
							posicionOperandoPreConjuncion,
							posicionOperandoPostConjuncion + 1);

					formula = formula.replace(cadenaARemplazar, descomposicion);

					i = 0;

				}
			}

		}

		return formula;
	}

	/**
	 * Método que permite aplicar el axioma correspondiente a la ley de Morgan
	 * 
	 * @param formula
	 * 
	 *            Fórmula proposicional
	 * @return Fórmula proposicional luego de aplicar el axioma, o la misma, en
	 *         caso de no poder ser aplicado
	 */
	public static String aplicarAxiomaSieteLeyDeMorgan(String formula) {

		int posicion = encontrarNegacion(formula);
		String operadorChanged = "";

		if (posicion != -1) {

			if (formula.charAt(posicion) == '¬') {

				int posicionOperadorPrincipal = encontrarOperadorPrincipal(
						formula, posicion + 2) + 1;

				if (formula.charAt(posicionOperadorPrincipal) == 'v') {
					operadorChanged = "&";
				}

				else if (formula.charAt(posicionOperadorPrincipal) == '&') {
					operadorChanged = "v";
				}

				else {

				}

				int posicionPrimerOperando = encontrarParteADescomponer(
						formula, posicionOperadorPrincipal);
				int posicionSegundoOperando = encontrarOperadorPrincipal(
						formula, posicionOperadorPrincipal);

				String formulaAnt = formula.substring(posicionPrimerOperando,
						posicionOperadorPrincipal);
				String formulaDesp = formula.substring(
						posicionOperadorPrincipal + 1,
						posicionSegundoOperando + 1);

				String descomposicion = "(" + "¬" + formulaAnt + ")"
						+ operadorChanged + "(" + "¬" + formulaDesp + ")";

				String cadenaAReemplazar = formula.substring(posicion,
						posicionSegundoOperando + 2);

				formula = formula.replace(cadenaAReemplazar, descomposicion);
			}

		}

		return formula;
	}

	/**
	 * Método que permite aplicar el axioma de la ley del condicional
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @return fórmula luego de aplicar el axioma del condicional, o la misma
	 *         fórmula en caso de no existir este operador en la fórmula
	 */
	public static String AplicarAxiomaOchoLeyCondicional(String formula) {

		int posicion = encontrarOperadorCondicional(formula);

		if (posicion != -1) {

			if (formula.charAt(posicion) == '→') {

				int posicionPrimerOperando = encontrarParteADescomponer(
						formula, posicion);
				int posicionSegundoOperando = encontrarOperadorPrincipal(
						formula, posicion);

				String formulaAnt = formula.substring(posicionPrimerOperando,
						posicion);
				String formulaDesp = formula.substring(posicion + 1,
						posicionSegundoOperando + 1);

				String descomposicion = "(" + "¬" + formulaAnt + ")" + "v"
						+ formulaDesp;

				String cadenaAReemplazar = formula.substring(
						posicionPrimerOperando, posicionSegundoOperando + 1);

				formula = formula.replace(cadenaAReemplazar, descomposicion);

			}
		}

		else {

		}

		return formula;

	}

	/**
	 * Método que permite aplicar el axioma de la ley del bicondicional
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @return fórmula luego de aplicar el axioma del bicondicional, o la misma
	 *         fórmula en caso de no existir este operador en la fórmula
	 */
	public static String aplicarAxiomaNueveLeyDelBicondicional(String formula) {

		int posicion = encontrarOperadorBicondicional(formula);

		if (posicion != -1) {

			if (formula.charAt(posicion) == '↔') {

				int posicionPrimerOperando = encontrarParteADescomponer(
						formula, posicion);
				int posicionSegundoOperando = encontrarOperadorPrincipal(
						formula, posicion);

				String formulaAnt = formula.substring(posicionPrimerOperando,
						posicion);
				String formulaDesp = formula.substring(posicion + 1,
						posicionSegundoOperando + 1);

				String descomposicion = "(" + formulaAnt + "→" + formulaDesp
						+ ")" + "&" + "(" + formulaDesp + "→" + formulaAnt
						+ ")";

				String cadenaAReemplazar = formula.substring(
						posicionPrimerOperando, posicionSegundoOperando + 1);

				formula = formula.replace(cadenaAReemplazar, descomposicion);

			}
		}

		else {

		}

		return formula;

	}

	/**
	 * Método que permite eliminar la doble negación (en caso de existir) en una
	 * fórmula proposicional
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @return String con la fórmula proposicional después de eliminar sus
	 *         negaciones, o la misma fórmula en caso de no existir
	 */
	public static String aplicarEliminacionDeDobleNegacion(String formula) {

		int posicion = encontrarNegacionEnDobleNegacion(formula);

		if (posicion != -1) {

			if (formula.charAt(posicion) == '¬') {

				if ((formula.charAt(posicion + 4) == 'p'
						|| formula.charAt(posicion + 4) == 'q'
						|| formula.charAt(posicion + 4) == 'r'
						|| formula.charAt(posicion + 4) == 's' || formula
						.charAt(posicion + 4) == 't') && posicion == 0) {

					int posicionOperadorPrincipal = encontrarOperadorPrincipal(
							formula, posicion + 2) + 1;

					int posicionPrimerOperando = encontrarParteADescomponer(
							formula, posicionOperadorPrincipal - 1);

					String formulaAnt = formula.substring(
							posicionPrimerOperando, posicionOperadorPrincipal);

					String descomposicion = formulaAnt;

					String cadenaAReemplazar = formula.substring(posicion,
							posicionOperadorPrincipal + 1);

					formula = formula
							.replace(cadenaAReemplazar, descomposicion);
				} else {

					int posicionOperadorPrincipal = encontrarOperadorPrincipal(
							formula, posicion + 2) + 1;

					int posicionPrimerOperando = encontrarParteADescomponer(
							formula, posicionOperadorPrincipal - 1);

					String formulaAnt = formula.substring(
							posicionPrimerOperando + 1,
							posicionOperadorPrincipal - 1);

					String descomposicion = formulaAnt;

					String cadenaAReemplazar = formula.substring(posicion,
							posicionOperadorPrincipal + 1);

					formula = formula
							.replace(cadenaAReemplazar, descomposicion);

				}
			}
		}
		return formula;

	}

	/**
	 * Método que permite encontrar la posición de un operador condicional
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @return Posición en la que se encuentra el operador condicional
	 */
	public static int encontrarOperadorCondicional(String formula) {

		char[] caracteres = formula.toCharArray();
		int posicion = -1;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == '→') {

				posicion = i;
				return posicion;

			}
		}

		return posicion;
	}

	/**
	 * Método que permite encontrar la posición de una disyunción en la fórmula
	 * proposicional
	 * 
	 * @param formula
	 *            Fórmula proposicional a encontrar disyunción
	 * @param posConjuncion
	 *            Posición en la cual se empezará a buscar la conjunción, en
	 *            este caso, desde una conjunción para la aplicación de la ley
	 *            distributiva
	 * @return posición de la conjunción, o -1 en caso de no existir
	 */
	public static int encontrarDisyuncionAdelante(String formula,
			int posConjuncion) {

		int posicion = -1;

		for (int i = posConjuncion; i < formula.length(); i++) {

			if (formula.charAt(i) == 'v') {

				posicion = i;
				return posicion;
			}
		}

		return posicion;

	}

	/**
	 * Método que permite encontrar una disyunción, pero haciendo el recorrido
	 * de manera inversa, es decir, recorriendo la fórmula proposicional hacia
	 * atrás
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @param posConjuncion
	 *            Posición en la que comenzará el análisis, en este caso una
	 *            conjunción, debido a que se usará para aplicar la ley
	 *            distributiva
	 * @return Posición de la conjunción en el recorrido inverso
	 */
	public static int encontrarDisyuncionAtras(String formula, int posConjuncion) {

		int posicion = -1;

		for (int i = posConjuncion; i < formula.length(); i--) {

			if (formula.charAt(i) == 'v') {

				posicion = i;
				return posicion;
			}
		}

		return posicion;
	}

	/**
	 * Método que permite encontrar la posición en la cual se encuentra una
	 * conjunción
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @return Posición en la que se encuentra la conjunción
	 */
	public static int encontrarConjuncion(String formula) {

		int posicion = -1;

		for (int i = 0; i < formula.length(); i++) {

			if (formula.charAt(i) == '&') {

				posicion = i;
				return posicion;
			}
		}

		return posicion;

	}

	/**
	 * Método que permite encontrar negaciones que están negando a su vez otra
	 * negación
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @return Posición de la negación que está negando otra negación
	 */
	public static int encontrarNegacionEnDobleNegacion(String formula) {

		char[] caracteres = formula.toCharArray();
		int posicion = -1;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == '¬') {

				if (caracteres[i + 2] == '¬') {
					posicion = i;
					return posicion;
				}
			}
		}

		return posicion;
	}

	/**
	 * Método que permite encontrar la posición de una negación, que no está
	 * negando doblemente
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @return posición de la negación que no está negando doblemente.
	 */
	public static int encontrarNegacion(String formula) {

		char[] caracteres = formula.toCharArray();
		int posicion = -1;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == '¬') {

				if (caracteres[i + 2] == '(') {
					posicion = i;
					return posicion;
				}
			}
		}

		return posicion;
	}

	/**
	 * Método que permite encontrar la posición de un operador bicondicional
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @return Posición en la que se encuentra el operador bicondicional
	 */
	public static int encontrarOperadorBicondicional(String formula) {

		char[] caracteres = formula.toCharArray();
		int posicion = -1;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == '↔') {

				posicion = i;
				return posicion;

			}
		}

		return posicion;
	}

	/**
	 * Método encargado de encontrar el operando derecho de una operación
	 * binaria o el operador principal, dependiendo de la posición determinada
	 * de donde partirá
	 * 
	 * @param formula
	 *            Fórmula proposicional
	 * @param posicion
	 *            Posición de la cual se empezará a buscar ya sea el operando
	 *            derecho o el operador principal
	 * @return Posición del paréntesis que cubre el operador derecho, o una
	 *         posición anterior al operador principal, ya sea el caso.
	 * 
	 */
	public static int encontrarOperadorPrincipal(String formula, int posicion) {

		int numParentesis = 0;
		boolean pasoAct = false;
		int posicionOperadorPrincipal = 0;

		char[] caracteres = formula.toCharArray();

		for (int i = posicion; i < caracteres.length; i++) {

			if (caracteres[i] == '(') {
				numParentesis++;
				pasoAct = true;
			}
			if (caracteres[i] == ')') {
				numParentesis--;
			}

			if (numParentesis == 0 && pasoAct) {

				posicionOperadorPrincipal = i;
				return posicionOperadorPrincipal;
			}

		}
		return -1;
	}

	/**
	 * Método que permite encontrar el operando izquierdo de una operación
	 * binaria
	 * 
	 * @param formula
	 *            Fórmula proposicional a encontrar su operador izquierdo
	 * @param posicion
	 *            posición del operador binario
	 * @return posición del paréntesis que abarca al operando izquierdo
	 */
	public static int encontrarParteADescomponer(String formula, int posicion) {

		int numParentesis = 0;
		boolean pasoAct = false;
		int posicionParentesisInicial = 0;

		char[] caracteres = formula.toCharArray();

		for (int i = posicion; i > 0; i--) {

			if (caracteres[i] == '(') {
				numParentesis++;

			}
			if (caracteres[i] == ')') {
				pasoAct = true;
				numParentesis--;
			}

			if (numParentesis == 0 && pasoAct) {

				posicionParentesisInicial = i;
				return posicionParentesisInicial;
			}

		}

		return 0;

	}

	/**
	 * Método encargado de encontrar paréntesis izquierdos de los cuales es
	 * posible su eliminación para aplicar ley asociativa
	 * 
	 * @param formula
	 *            Fórmula proposicional a encontrar sus paréntesis con posible
	 *            eliminación
	 * @return posición de el paréntesis a eliminar, con -1 en caso de no
	 *         existir
	 */
	public static int encontrarParentesisAtrasDeLetraProposicional(
			String formula) {

		char[] caracteres = formula.toCharArray();
		int posicionParentesisPrincipalAtras = -1;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == 'p' || caracteres[i] == 'q'
					|| caracteres[i] == 'r' || caracteres[i] == 's'
					|| caracteres[i] == 't') {

				if ((i - 2) >= 0 && caracteres[i - 2] == '¬') {

					if ((i - 3) >= 0 && caracteres[i - 3] == '(') {
						posicionParentesisPrincipalAtras = i - 3;

						if ((posicionParentesisPrincipalAtras - 1) >= 0
								&& (formula
										.charAt(posicionParentesisPrincipalAtras - 1) == '(')) {

							posicionParentesisPrincipalAtras = posicionParentesisPrincipalAtras - 1;

							if ((posicionParentesisPrincipalAtras != 0
									&& (posicionParentesisPrincipalAtras - 1) >= 0 && formula
										.charAt(posicionParentesisPrincipalAtras - 1) != '&')) {
								return posicionParentesisPrincipalAtras;
							}
						}
					}
				}

				else if ((i - 2) >= 0 && caracteres[i - 2] == '(') {
					posicionParentesisPrincipalAtras = i - 1;
					if ((posicionParentesisPrincipalAtras - 1) >= 0
							&& (formula
									.charAt(posicionParentesisPrincipalAtras - 1) == '(')) {

						posicionParentesisPrincipalAtras = posicionParentesisPrincipalAtras - 1;

						if ((posicionParentesisPrincipalAtras != 0
								&& (posicionParentesisPrincipalAtras - 1) >= 0 && formula
									.charAt(posicionParentesisPrincipalAtras - 1) != '&')) {
							return posicionParentesisPrincipalAtras;
						}
					}

				}

			}
		}

		return -1;
	}

	/**
	 * Método encargado de encontrar paréntesis derechos de los cuales es
	 * posible su eliminación para aplicar ley asociativa
	 * 
	 * @param formula
	 *            Fórmula proposicional a encontrar sus paréntesis con posible
	 *            eliminación
	 * @return posición del paréntesis a eliminar, con -1 en caso de no existir
	 * 
	 */
	public static int encontrarParentesisAdelanteDeLetraProposicional(
			String formula) {

		char[] caracteres = formula.toCharArray();
		int posicionParentesisPrincipalAdelante = -1;

		for (int i = 0; i < caracteres.length; i++) {

			if (caracteres[i] == 'p' || caracteres[i] == 'q'
					|| caracteres[i] == 'r' || caracteres[i] == 's'
					|| caracteres[i] == 't') {

				if ((i - 2) >= 0 && caracteres[i - 2] == '¬') {

					if ((i + 3) < caracteres.length && caracteres[i + 3] == ')') {
						posicionParentesisPrincipalAdelante = i + 3;

						if ((posicionParentesisPrincipalAdelante != (formula
								.length() - 1) && ((posicionParentesisPrincipalAdelante + 1) < formula
								.length() && formula
								.charAt(posicionParentesisPrincipalAdelante + 1) != '&'))) {
							return posicionParentesisPrincipalAdelante;
						}

					}
				}

				else if ((i + 2) < caracteres.length
						&& caracteres[i + 2] == ')') {
					posicionParentesisPrincipalAdelante = i + 2;

					if ((posicionParentesisPrincipalAdelante) < formula
							.length()
							&& (formula
									.charAt(posicionParentesisPrincipalAdelante) == ')')) {

						// posicionParentesisPrincipalAdelante =
						// posicionParentesisPrincipalAdelante + 1;

						if ((posicionParentesisPrincipalAdelante != (formula
								.length() - 1) && ((posicionParentesisPrincipalAdelante + 1) < formula
								.length() && formula
								.charAt(posicionParentesisPrincipalAdelante + 1) != '&'))) {
							return posicionParentesisPrincipalAdelante;
						}
					}
				}

			}
		}

		return -1;
	}

	/**
	 * Método que permite convertir una fórmula en su forma normal conjuntiva a
	 * su forma clausal
	 * 
	 * @param formula
	 *            Fórmula en su forma normal conjuntiva
	 * @return Fórmula en su forma clausal
	 */
	public static ArrayList<ArrayList> transformarAFormaClausal(String formula) {

		ArrayList clausula = new ArrayList<>();
		int contadorClausulas = 1;
		for (int i = 0; i < formula.length(); i++) {

			if (formula.charAt(i) == '&') {
				contadorClausulas++;
			}
		}

		while (contadorClausulas > clausula.size()) {

			clausula.add(extraerClausulas(formula, posicionClausulas));
		}

		posicionClausulas = 0;

		return clausula;
	}

	/**
	 * Método encargado de extraer cada una de las cláusulas de la FNC
	 * 
	 * @param formula
	 *            Fórmula en forma normal conjuntiva
	 * @param i
	 *            Posición de donde se comenzará a extraer las clausulas
	 * @return Clausula contenida desde el punto de análisis
	 * 
	 */
	public static ArrayList extraerClausulas(String formula, int i) {

		String literal = "";

		ArrayList clausula = new ArrayList<>();

		for (int j = i; j < formula.length(); j++) {

			if (formula.charAt(j) == '&') {
				posicionClausulas = j + 1;
				break;

			}
			if (formula.charAt(j) == 'p' || formula.charAt(j) == 'q'
					|| formula.charAt(j) == 'r' || formula.charAt(j) == 's'
					|| formula.charAt(j) == 't') {

				if (j - 2 >= 0 && formula.charAt(j - 2) == '¬') {

					String letra = "¬" + formula.charAt(j);
					clausula.add(letra);

				} else {

					String letra = String.valueOf(formula.charAt(j));
					clausula.add(letra);
				}
			}
		}

		return clausula;
	}

	/**
	 * Método que permite imprimir una forma clausal
	 * 
	 * @param formaClausal
	 *            Forma clausal a ser impresa
	 * @return String con la forma correcta de impresión de la forma clausal
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

	// formula esa: (pvq) si solo si (rv¬q)
	/**
	 * Método que permite eliminar los literales repetidos en una clausula
	 * 
	 * @param formaClausal
	 *            ArrayList que contiene a su vez cada ArrayList con las
	 *            cláusulas de la fórmula
	 * @return Forma Clausal con sus cláusulas sin literales repetidos
	 */
	public static ArrayList eliminarLiteralesRepetidosEnFormaClausal(
			ArrayList formaClausal) {

		ArrayList formaClausalAux = new ArrayList<>();

		for (int i = 0; i < formaClausal.size(); i++) {

			ArrayList clausula = (ArrayList) formaClausal.get(i);

			for (int j = 0; j < clausula.size(); j++) {

				String letra = (String) clausula.get(j);

				for (int k = j + 1; k < clausula.size(); k++) {

					if (letra.equals(clausula.get(k))) {
						clausula.remove(k);
						j = 0;
						break;
					}
				}

			}

			formaClausalAux.add(clausula);
		}

		return formaClausalAux;
	}

	/**
	 * Método que permite aplicar el método de resolución a una forma clausal y
	 * determinar si es satisfacible o insatisfacible
	 * 
	 * @param formaClausal
	 *            Forma clausal de la fórmula inicial ingresada por el usuario
	 * @return true en caso de ser insatisfacible y false en caso contrario
	 */
	public static boolean aplicarMetodoDeResolucion(ArrayList formaClausal) {

		boolean insatisfacibilidad = true;

		if (formaClausal.size() == 1) {

			insatisfacibilidad = false;
		}

		for (int i = 0; i < formaClausal.size(); i++) {

			ArrayList clausula = (ArrayList) formaClausal.get(i);

			for (int j2 = 0; j2 < clausula.size(); j2++) {

				String letra = (String) clausula.get(j2);

				// p, ¬q¬r, qr
				// p, ¬p, r
				if (letra.length() == 2) {
					letra = letra.substring(1, letra.length());
				} else {
					letra = "¬" + letra;
				}
				int clausulasRevisadas = 0;
				for (int j = 0; j < formaClausal.size(); j++) {

					if (i != j) {
						boolean contenido = false;

						ArrayList clausulaDiferente = (ArrayList) formaClausal
								.get(j);
						if (clausulaDiferente.contains(letra)) {
							contenido = true;
							break;
						}

						clausulasRevisadas++;

						if (clausulasRevisadas == (formaClausal.size() - 1)
								&& contenido == false) {

							insatisfacibilidad = false;
							return insatisfacibilidad;

						}
					}
				}

			}
		}

		return insatisfacibilidad;

	}

	/**
	 * Método que se encarga de eliminar los literales puros de la forma clausal
	 * restringida
	 * 
	 * @param formaClausal
	 *            Forma clausal restringida
	 * @return Forma clausal restringida sin las cláusulas que poseían literales
	 *         puros
	 */
	public static ArrayList eliminarLiteralesPuros(ArrayList formaClausal) {

		// ArrayList formaClausalSinPuros = new ArrayList<>();

		ArrayList literalesPuros = new ArrayList<>();

		for (int i = 0; i < formaClausal.size(); i++) {

			ArrayList clausula = (ArrayList) formaClausal.get(i);

			for (int j2 = 0; j2 < clausula.size(); j2++) {

				String letra = (String) clausula.get(j2);

				String opuesto = "";

				// p, ¬q¬r, qr
				// p, ¬p, r
				if (letra.length() == 2) {
					opuesto = letra.substring(1, letra.length());
				} else {
					opuesto = "¬" + letra;
				}
				int clausulasRevisadas = 0;
				for (int j = 0; j < formaClausal.size(); j++) {

					if (i != j) {
						boolean contenido = false;

						ArrayList clausulaDiferente = (ArrayList) formaClausal
								.get(j);
						if (clausulaDiferente.contains(opuesto)) {
							contenido = true;
							break;
						}

						clausulasRevisadas++;

						if (clausulasRevisadas == (formaClausal.size() - 1)
								&& contenido == false) {

							if (!literalesPuros.contains(letra)) {

								literalesPuros.add(letra);
							}

						}

					}
				}
			}

		}

		for (int j = 0; j < formaClausal.size(); j++) {

			ArrayList clausulaAVerificar = (ArrayList) formaClausal.get(j);

			for (int i = 0; i < literalesPuros.size(); i++) {

				if (clausulaAVerificar.contains(literalesPuros.get(i))) {
					formaClausal.remove(j);
					j = 0;
					break;
				}

			}
		}

		return formaClausal;
	}

}
