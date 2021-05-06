package fr.eni.imc;

import java.util.Scanner;

public class ImcApp {
	
	/*Calcule l'IMC et indique la catégorie de poids
	Auteur : Sabrina SEDDIK
	Date : 25 janvier 2021*/

	public static void main(String[] args) {
		
		
		//Constantes
		final double POIDS_1 = 18.5;
		final double POIDS_2 = 25;
		final double POIDS_3 = 30;
		final double POIDS_4 = 35;
		final double POIDS_5 = 40;
		
		// Variables
		String categorie ;
		Scanner scan = new Scanner(System.in);
		short user = 1 ;
		
		
		// Interface utilisateur : entrée des données
		do {
			System.out.println();
			System.out.println("*** CALCUL D'UN INDICE DE MASSE CORPORELLE ***");
			System.out.println();
			
			System.out.println("Poids (en kg) ?");
			double poids = scan.nextDouble();
			
			System.out.println("Taille (en m) ?");
			double taille = scan.nextDouble();
			
			
			//Calcul de l'IMC et arrondi à 1 chiffre après la virgule 
			
			double imc = poids / Math.pow(taille, 2);
			imc *=  Math.pow(10, 1);                        // multiplication par 10 ^(nb de c. voulu après la virgule)
			imc = Math.round(imc);                         // arrondit à l'entier le plus proche
			imc /=  Math.pow(10, 1);                       // division par 10 ^ (nb de c. voulu après la virgule)
			
			
			// Détermination de la catégorie de poids
			
			if (imc >= POIDS_5) {
				categorie = "adiposité niveau III";
			}else if (imc >= POIDS_4)  {
				categorie = "adiposité niveau II";
			}else if (imc >= POIDS_3)  {
				categorie = "adiposité niveau I";
			}else if (imc >= POIDS_2)  {
				categorie = "surpoids";
			}else if (imc >= POIDS_1){
				categorie = "poids normal";
			}else {
				categorie = "carence pondérale"; 
			}
			
			
			// Interface utilisateur : affichage des données
				
			System.out.println("L'IMC est de " + imc + " kg/m² : " + categorie );
			System.out.println();
			
			
			//Affichage du menu
			
			do {
				System.out.println("Menu :");
				System.out.println("0 - Quitter le programme");
				System.out.println("1 - Refaire le calcul d'un IMC");
				user = scan.nextShort();
				
				// Choix utilisateur
				if (user != 0 & user != 1) {
					System.out.println("Erreur de saisie ...");
					System.out.println();
				}
			} while(user != 0 & user != 1);
			
		} while (user == 1);
		
		//Sortie du programme
		System.out.println();
		System.out.println("AU REVOIR ET À BIENTÔT");
		
		scan.close();
		
		
	}
	
}
