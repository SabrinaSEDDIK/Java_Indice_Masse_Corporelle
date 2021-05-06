package fr.eni.imc;

import java.util.Scanner;

public class ImcApp2 {

	/*
	 * Calcule l'IMC et indique la catégorie de poids
	 * Auteur : Sabrina SEDDIK 
	 * Date : 28 janvier 2021
	 */

	// CONSTANTES GLOBALES

	static final double PALIER_1 = 18.5;
	static final double PALIER_2 = 25;
	static final double PALIER_3 = 30;
	static final double PALIER_4 = 35;
	static final double PALIER_5 = 40;

	// FONCTION 1 : calcul de l'IMC

	public static double imc(double poids, double taille) {

		double res = poids / Math.pow(taille, 2);

		// arrondi à 1 chiffre après la virgule
		res *= Math.pow(10, 1);
		res = Math.round(res);
		res /= Math.pow(10, 1);

		return res;

	}

	// FONCTION 2 : pose le diagnostic selon l'IMC

	public static String diagnosticIMC(double imc) {
		String categorie;
		if (imc >= PALIER_5) {
			categorie = "adiposité niveau III";
		} else if (imc >= PALIER_4) {
			categorie = "adiposité niveau II";
		} else if (imc >= PALIER_3) {
			categorie = "adiposité niveau I";
		} else if (imc >= PALIER_2) {
			categorie = "surpoids";
		} else if (imc >= PALIER_1) {
			categorie = "poids normal";
		} else {
			categorie = "carence pondérale";
		}
		return categorie;
	}

	// FONCTION PRINCIPALE

	public static void main(String[] args) {

		// Constantes
		final double BORNE_INF_POIDS = 20;
		final double BORNE_SUP_POIDS = 300;
		final double BORNE_INF_TAILLE = 0.50;
		final double BORNE_SUP_TAILLE = 2.60;

		// Variables
		Scanner scan = new Scanner(System.in);
		short user = 1;
		double poids = 20;
		double taille = 0.5;

		// Interface utilisateur : entrée des données
		do {
			System.out.println();
			System.out.println("*** CALCUL D'UN INDICE DE MASSE CORPORELLE ***");
			System.out.println();

			// poids
			boolean saisieOk = false;
			do {
				try {
					System.out.println("Poids (en kg) ?");
					poids = Double.parseDouble(scan.next().replace(",", ".")); // Format point et format virgule
																				// acceptés
					// teste si le Double saisi fait partie de l'intervalle accepté
					if (poids < BORNE_INF_POIDS || poids > BORNE_SUP_POIDS) {
						System.out.println("Veuillez saisir un nombre entre " + BORNE_INF_POIDS + " kg et "
								+ BORNE_SUP_POIDS + " kg");
						System.out.println();
					} else {
						saisieOk = true;
					}
				} catch (NumberFormatException exc) {
					System.out.println();
					System.out.println(
							"Veuillez saisir un nombre entre " + BORNE_INF_POIDS + " kg et " + BORNE_SUP_POIDS + " kg");
					System.out.println();
					scan.nextLine();
				}
			} while (!saisieOk);

			// taille
			saisieOk = false;
			do {
				try {
					System.out.println("Taille (en m) ?");
					taille = Double.parseDouble(scan.next().replace(",", ".")); // Format point et format virgule
																				// acceptés
					// teste si le Double saisi fait partie de l'intervalle accepté
					if (taille < BORNE_INF_TAILLE || taille > BORNE_SUP_TAILLE) {
						System.out.println("Veuillez saisir un nombre entre " + BORNE_INF_TAILLE + " m et "
								+ BORNE_SUP_TAILLE + " m.");
						System.out.println();
					} else {
						saisieOk = true;
					}
				} catch (NumberFormatException exc) {
					System.out.println();
					System.out.println("Veuillez saisir un nombre entre " + BORNE_INF_TAILLE + " m et "
							+ BORNE_SUP_TAILLE + " m.");
					System.out.println();
					scan.nextLine();
				}
			} while (!saisieOk);

			// Stockage de l'imc dans une variable (appel fonction)
			double imcUser = imc(poids, taille);

			// Interface utilisateur : affichage des données
			System.out.println("L'IMC est de " + imcUser + " kg/m² : " + diagnosticIMC(imcUser));
			System.out.println();

			// Affichage du menu
			do {
				System.out.println("Menu :");
				System.out.println("0 : Quitter le programme");
				System.out.println("1 : Relancer le programme");
				user = scan.nextShort();

				// Gestion d'erreur
				if (user != 0 & user != 1) {
					System.out.println("Erreur de saisie ...");
					System.out.println();
				}
			} while (user != 0 & user != 1);

		} while (user == 1);

		// Sortie du programme
		System.out.println();
		System.out.println("AU REVOIR ET À BIENTÔT");

		scan.close();

	}

}
