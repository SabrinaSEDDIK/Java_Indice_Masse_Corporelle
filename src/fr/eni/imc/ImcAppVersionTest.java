package fr.eni.imc;

public class ImcAppVersionTest {
	/*
	 * Calcule l'IMC et indique la catégorie de poids 
	 * Auteur : Sabrina SEDDIK 
	 * Date : 28 janvier 2021
	 */

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

		// CONSTANTES
		final double PALIER_1 = 18.5;
		final double PALIER_2 = 25;
		final double PALIER_3 = 30;
		final double PALIER_4 = 35;
		final double PALIER_5 = 40;

		// Variable
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

		// tests des fonctions imc et diagnosticIMC

		// test 1 : carence pondérale
		double pds1 = 36.5;
		double taille1 = 1.6;
		double imc1 = imc(pds1, taille1);
		System.out.println("IMC : " + imc1 + " Diagnostic : " + diagnosticIMC(imc1));

		// test 2 : poids normal
		double pds2 = 59;
		double taille2 = 1.6;
		double imc2 = imc(pds2, taille2);
		System.out.println("IMC : " + imc2 + " Diagnostic : " + diagnosticIMC(imc2));

		// test 3 : surpoids
		double pds3 = 69;
		double taille3 = 1.6;
		double imc3 = imc(pds3, taille3);
		System.out.println("IMC : " + imc3 + " Diagnostic : " + diagnosticIMC(imc3));

		// test 4 : adiposité niv 1
		double pds4 = 87.2;
		double taille4 = 1.6;
		double imc4 = imc(pds4, taille4);
		System.out.println("IMC : " + imc4 + " Diagnostic : " + diagnosticIMC(imc4));

		// test 4 : adiposité niv 2
		double pds5 = 92;
		double taille5 = 1.6;
		double imc5 = imc(pds5, taille5);
		System.out.println("IMC : " + imc5 + " Diagnostic : " + diagnosticIMC(imc5));

		// test 4 : adiposité niv 3
		double pds6 = 115.5;
		double taille6 = 1.6;
		double imc6 = imc(pds6, taille6);
		System.out.println("IMC : " + imc6 + " Diagnostic : " + diagnosticIMC(imc6));

		// test des bornes
		
		System.out.println();
		System.out.println();
		

		System.out.println(diagnosticIMC(18.4)); // carence pondérale
		System.out.println(diagnosticIMC(18.5)); // poids normal
		System.out.println(diagnosticIMC(24.9));
		System.out.println(diagnosticIMC(25)); // surpoids
		System.out.println(diagnosticIMC(29.9));
		System.out.println(diagnosticIMC(30)); // adiposité niv 1
		System.out.println(diagnosticIMC(34.5));
		System.out.println(diagnosticIMC(35)); // adiposité niv 2
		System.out.println(diagnosticIMC(39.9));
		System.out.println(diagnosticIMC(40)); // adiposité niv 3
	}
}