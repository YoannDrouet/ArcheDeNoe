package arche.main;

import arche.animaux.*;
import arche.bo.Arche;
import arche.bo.Verifs;
import arche.enumeration.Espece;
import arche.enumeration.Sexe;
import arche.exception.HorsBornesException;
import arche.exception.MemeEspeceException;
import arche.exception.MemeSexeException;
import arche.exception.PlusDePlaceException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Verifs verif = new Verifs();
        // Création d'une nouvelle arche
        Arche archeDeNoe = new Arche(8);

        int reponse_utilisateur_continuer;

        //Boucle tant que l'utilisateur souhaite rentrer plus d'animaux
        do {
            //Déclaration de l'animal à rentrer dans l'arche
            Animal animal_utilisateur = null;

            //Choix du nom de l'animal par l'utilisateur
            System.out.println("Quel est le nom de l'animal ?");
            String reponse_utilisateur_nom_animal = scan.nextLine();

            //On demande à l'utilisateur de le sexe de l'animal
            System.out.printf("Quel est le sexe de l'animal ? ");
            //Mise en forme de l'énumération Sexe sous forme de tableau
            Sexe[] tabSexe = Sexe.values();
            int reponse_utilisateur_sexe_animal;

            //Affichage des choix de l'utilisateur
            for (int i = 0; i < Sexe.values().length; i++) {
                System.out.printf("%d-%s ",i, tabSexe[i]);
            }
            System.out.println();

            //Boucle tant que l'utilisateur n'a pas entré une des réponses à disposition
            do {
                try {
                    reponse_utilisateur_sexe_animal = scan.nextInt();
                    //On vérifie que l'utilisateur a bien entré une réponse qui était à sa disposition
                    verif.intBorne(reponse_utilisateur_sexe_animal, Sexe.values().length - 1);
                    break;
                }
                //Exception si l'utilisateur entre autre chose qu'un des entiers à disposition
                catch (InputMismatchException e) {
                    System.err.println("Entrez un des nombres proposés");
                }
                //Exception si l'utilisateur entre un entier non compris dans ceux à sa disposition
                catch (HorsBornesException e) {
                    System.err.println(e.getMessage());
                } finally {
                    scan.nextLine();
                }
            }while (true);

            //On demande à l'utilisateur de l'espèce de l'animal
            System.out.println("Quel est l'espèce de l'animal ?");
            int reponse_utilisateur_espece_animal;
            //Mise en forme de l'énumération Espece sous forme de tableau
            Espece[] tabEspece = Espece.values();

            //Affichage des choix de l'utilisateur
            for (int i = 0; i < Espece.values().length; i++) {
                System.out.printf("%d-%s ", i, tabEspece[i]);
            }
            System.out.println();

            //Boucle tant que l'utilisateur n'a pas entré une des réponses à disposition
            do {
                try {
                    reponse_utilisateur_espece_animal = scan.nextInt();
                    //On vérifie que l'utilisateur a bien entré une réponse qui était à sa disposition
                    verif.intBorne(reponse_utilisateur_espece_animal, Espece.values().length - 1);
                    //Si oui on sort
                    break;
                }
                //Exception si l'utilisateur entre autre chose qu'un des entiers à disposition
                catch (InputMismatchException e) {
                    System.err.println("Entrez un des nombres proposés");
                }
                //Exception si l'utilisateur entre un entier non compris dans ceux à sa disposition
                catch (HorsBornesException e) {
                    System.err.println(e.getMessage());
                } finally {
                    scan.nextLine();
                }
            }while (true);

            //Initialise l'animal en fonction des choix de l'utilisateur
            switch (reponse_utilisateur_espece_animal) {
                //Création d'un Chat
                case 0:
                    animal_utilisateur = new Chat(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                    break;
                //Création d'un Chien
                case 1:
                    animal_utilisateur = new Chien(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                    break;
                //Création d'un Gorille
                case 2:
                    animal_utilisateur = new Gorille(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                    break;
                //Création d'un Lapin
                case 3:
                    animal_utilisateur = new Lapin(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                    break;
            }

            //Ajoute l'animal de l'utilisateur à l'Arche
            try {
                archeDeNoe.ajouterAnimal(animal_utilisateur);
            }
            //Exception lorsqu'il n'y a plus de place dans l'Arche
            catch (PlusDePlaceException e) {
                System.err.println(e.getMessage());
            }
            //Exception s'il y a déjà deux individus de la même espèce
            catch (MemeEspeceException e) {
                System.err.println(e.getMessage());
            }
            //Exception s'il y a déjà deux individus du même sexe et de la même espèce
            catch (MemeSexeException e) {
                System.err.println(e.getMessage());
            }

            //Demande à l'utilisateur s'il veut entrer un nouvel animal
            System.out.println("Souhaitez-vous ajouter un autre animal ? 1-OUI / autre-NON");
            do {
                //Vérifie que l'utilisateur à bien entré un entier
                try {
                    reponse_utilisateur_continuer = scan.nextInt();
                    break;
                }
                //Exception s'il l'utilisateur entre autre chose qu'un entier
                catch (InputMismatchException e) {
                    System.err.println("Entrez un des nombres proposés");
                }
                finally {
                    scan.nextLine();
                }
            }while (true);
        //Relance la boucle si l'utilisateur entre le nombre 1
        }while (reponse_utilisateur_continuer == 1);

        //Afficher les animaux à bord de l'Arche
        archeDeNoe.afficher();

        //Calcul et affiche les provosion à prévoir pour le temps de voyage souhaité
        archeDeNoe.stockAPrevoir(10);
    }
}
