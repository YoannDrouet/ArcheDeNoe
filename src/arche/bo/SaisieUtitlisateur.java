package arche.bo;

import arche.animaux.*;
import arche.enumeration.Espece;
import arche.enumeration.Sexe;
import arche.exception.HorsBornesException;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Classe qui représente une saisie utilisateur et un traitement associé
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public class SaisieUtitlisateur {

    // Déclaration des instances
    private static Scanner scan = new Scanner(System.in);
    private static Verifs verif = new Verifs();

    // Déclaration des variables
    private static Espece[] tabEspece = Espece.values();
    private static Sexe[] tabSexe = Sexe.values();

    /** Méthode qui demande à l'utilisateur de saisir le nom de l'animal à ajouter
     *
     * @return String
     */
    public String NomAnimal(){

        /// • Demande du nom de l'animal à l'utilisateur • ///

        System.out.println("Quel est le nom de l'animal ?");
        String nomAnimal = scan.nextLine();

        return nomAnimal;
    }

    /** Méthode qui demande à l'utilisateur de saisir le sexe de l'animal à ajouter
     *  et qui boucle tant que celui-ci n'a pas saisi une réponse valide
     *
     * @return int
     */
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

    /** Méthode qui demande à l'utilisateur de saisir l'espèce de l'animal à ajouter
     *  et qui boucle tant que celui-ci n'a pas saisi une réponse valide
     *
     * @return int
     */
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

        return reponse_utilisateur_espece_animal;
    }

    /** Méthode d'ajout d'un nouvel animal saisi par l'utilisateur
     *  (demande du nom, du sexe et de l'espèce de l'animal à ajouter)
     *
     * @return Animal
     */
    public Animal animalUtilisateur(){

        // Initialisation de l'animal à return
        Animal animal_utilisateur = null;

        // Appel de la méthode pour renseigner le nom
        String nom = this.NomAnimal();

        // Appel de la méthode pour renseigner le sexe
        int sexe = this.SexeAnimal();

        // Appel de la méthode pour renseigner l'espèce'
        int espece = this.EspeceAnimal();

        /// • Création de l'animal en fonction des saisies de l'utilisateur • ///

        switch (espece) {

            // Création d'un Chat
            case 0:
                animal_utilisateur = new Chat(nom, tabSexe[sexe]);
                break;

            // Création d'un Chien
            case 1:
                animal_utilisateur = new Chien(nom, tabSexe[sexe]);
                break;

            // Création d'un Gorille
            case 2:
                animal_utilisateur = new Gorille(nom, tabSexe[sexe]);
                break;

            // Création d'un Lapin
            case 3:
                animal_utilisateur = new Lapin(nom, tabSexe[sexe]);
                break;
        }
        return animal_utilisateur;
    }

    /** Méthode qui demande à l'utilisateur si il veut ajouter un autre animal à l'Arche,
     *  ou si il souhaite s'arrêter là.
     *
     * @return int
     */
    public int ajouterUnAutreAnimal(){

        int reponse_utilisateur_continuer;

        System.out.println("Souhaitez-vous ajouter un autre animal ? 0-NON / 1-OUI");
        do {
            try {
                reponse_utilisateur_continuer = scan.nextInt();
                break;
            }
            // Exception si l'utilisateur a saisi autre chose qu'un entier
            catch (InputMismatchException e) {
                System.err.println("Entrez un des nombres proposés");
            }
            finally {
                scan.nextLine();
            }
            // Boucle tant que l'utilisateur n'a pas saisi une réponse valide
        } while (true);

        return  reponse_utilisateur_continuer;
    }


}
