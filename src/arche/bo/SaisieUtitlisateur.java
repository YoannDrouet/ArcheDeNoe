package arche.bo;

import arche.animaux.*;
import arche.enumeration.Espece;
import arche.enumeration.Sexe;
import arche.exception.HorsBornesException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SaisieUtitlisateur {
    private static Scanner scan = new Scanner(System.in);
    private static Verifs verif = new Verifs();
    private static Espece[] tabEspece = Espece.values();
    private static Sexe[] tabSexe = Sexe.values();

    public String NomAnimal(){
        /// • Demande du nom de l'animal à l'utilisateur • ///
        System.out.println("Quel est le nom de l'animal ?");
        String nomAnimal = scan.nextLine();

        return nomAnimal;
    }

    public int SexeAnimal(){
        /// • Demande du sexe de l'animal à l'utilisateur • ///

        int reponse_utilisateur_sexe_animal;

        // Affichage de la question
        System.out.printf("Quel est le sexe de l'animal ? ");

        // Affichage des choix possibles
        for (int i = 0; i < Sexe.values().length; i++) {
            System.out.printf("%d-%s ",i, tabSexe[i]);
        }
        System.out.println();

        do {
            try {
                reponse_utilisateur_sexe_animal = scan.nextInt();

                // Vérifie que l'utilisateur a bien saisi une réponse valide
                verif.intBorne(reponse_utilisateur_sexe_animal, Sexe.values().length - 1);

                // Si oui on sort
                break;
            }

            // Exception si l'utilisateur a saisi autre chose qu'un entier
            catch (InputMismatchException e) {
                System.err.println("Entrez un des nombres proposés");
            }

            // Exception si l'utilisateur a saisi un entier non compris dans ceux à sa disposition
            catch (HorsBornesException e) {
                System.err.println(e.getMessage());
            }
            finally {
                scan.nextLine();
            }

            // Boucle tant que l'utilisateur n'a pas saisi une réponse valide
        } while (true);

        return reponse_utilisateur_sexe_animal;
    }

    public int EspeceAnimal(){
        /// • Demande de l'espèce de l'animal à l'utilisateur • ///

        int reponse_utilisateur_espece_animal;

        // Affichage de la question
        System.out.println("Quel est l'espèce de l'animal ?");

        // Affichage des choix possibles
        for (int i = 0; i < Espece.values().length; i++) {
            System.out.printf("%d-%s ", i, tabEspece[i]);
        }
        System.out.println();

        do {
            try {
                reponse_utilisateur_espece_animal = scan.nextInt();

                // Vérifie que l'utilisateur a bien saisi une réponse valide
                verif.intBorne(reponse_utilisateur_espece_animal, Espece.values().length - 1);

                // Si oui on sort
                break;
            }
            // Exception si l'utilisateur a saisi autre chose qu'un entiers
            catch (InputMismatchException e) {
                System.err.println("Entrez un des nombres proposés");
            }

            // Exception si l'utilisateur a saisi un entier non compris dans ceux à sa disposition
            catch (HorsBornesException e) {
                System.err.println(e.getMessage());

            }
            finally {
                scan.nextLine();
            }

            // Boucle tant que l'utilisateur n'a pas saisi une réponse valide
        } while (true);

        return reponse_utilisateur_espece_animal
    }

    public Animal AnimalUtilisateur(){
        String nom = this.NomAnimal();


            int sexe = this.SexeAnimal();
            int espece = this.EspeceAnimal();

        /// • Initialisation de l'animal en fonction des saisies de l'utilisateur • ///

        switch (reponse_utilisateur_espece_animal) {

            // Création d'un Chat
            case 0:
                animal_utilisateur = new Chat(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                break;

            // Création d'un Chien
            case 1:
                animal_utilisateur = new Chien(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                break;

            // Création d'un Gorille
            case 2:
                animal_utilisateur = new Gorille(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                break;

            // Création d'un Lapin
            case 3:
                animal_utilisateur = new Lapin(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                break;
        }
        return animal







    }

    public int saisie
}
