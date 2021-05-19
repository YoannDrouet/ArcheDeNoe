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
        // Crée une nouvelle arche
        Arche archeDeNoe = new Arche(8);

        // Création et ajout des animaux

        /*// Chats
        Animal chat01 = new Chat("Chat 01", Sexe.MALE);
        archeDeNoe.ajouterAnimal(chat01);

        Animal chat02 = new Chat("Chat 02", Sexe.MALE);
        archeDeNoe.ajouterAnimal(chat02);

        Animal chat03 = new Chat("Chat 03", Sexe.FEMELLE);
        archeDeNoe.ajouterAnimal(chat03);

        Animal chat04 = new Chat("Chat 04", Sexe.FEMELLE);
        archeDeNoe.ajouterAnimal(chat04);

        // Chiens
        Animal chien01 = new Chien("Chien 01", Sexe.MALE);
        archeDeNoe.ajouterAnimal(chien01);

        Animal chien02 = new Chien("Chien 02", Sexe.MALE);
        archeDeNoe.ajouterAnimal(chien02);

        Animal chien03 = new Chien("Chien 03", Sexe.FEMELLE);
        archeDeNoe.ajouterAnimal(chien03);

        Animal chien04 = new Chien("Chien 04", Sexe.FEMELLE);
        archeDeNoe.ajouterAnimal(chien04);

        // Gorilles
        Animal Gorille01 = new Gorille("Gorille 01", Sexe.MALE);
        archeDeNoe.ajouterAnimal(Gorille01);

        Animal Gorille02 = new Gorille("Gorille 02", Sexe.MALE);
        archeDeNoe.ajouterAnimal(Gorille02);

        Animal Gorille03 = new Gorille("Gorille 03", Sexe.FEMELLE);
        archeDeNoe.ajouterAnimal(Gorille03);

        Animal Gorille04 = new Gorille("Gorille 04", Sexe.FEMELLE);
        archeDeNoe.ajouterAnimal(Gorille04);

        // Lapins
        Animal Lapin01 = new Lapin("Lapin 01", Sexe.MALE);
        archeDeNoe.ajouterAnimal(Lapin01);

        Animal Lapin02 = new Lapin("Lapin 02", Sexe.MALE);
        archeDeNoe.ajouterAnimal(Lapin02);

        Animal Lapin03 = new Lapin("Lapin 03", Sexe.FEMELLE);
        archeDeNoe.ajouterAnimal(Lapin03);

        Animal Lapin04 = new Lapin("Lapin 04", Sexe.FEMELLE);
        archeDeNoe.ajouterAnimal(Lapin04);

        Animal yoann = new Gorille("Yoann", Sexe.MALE);
        archeDeNoe.ajouterAnimal(yoann);*/

        int reponse_utilisateur_continuer = 1;


        //Boucle tant que l'utilisateur souhaite rentrer plus d'animaux
        while (reponse_utilisateur_continuer == 1) {

            Animal animal_utilisateur = null;

            System.out.println("Quel est le nom de l'animal ?");
            String reponse_utilisateur_nom_animal = scan.nextLine();

            int reponse_utilisateur_sexe_animal;
            System.out.printf("Quel est le sexe de l'animal ? ");
            Sexe[] tabSexe = Sexe.values();
            for (int i = 0; i < Sexe.values().length; i++) {
                System.out.printf("%d-%s ",i, tabSexe[i]);
            }
            System.out.println();
            while (true) {
                try {
                    reponse_utilisateur_sexe_animal = scan.nextInt();
                    verif.intBorne(reponse_utilisateur_sexe_animal, Sexe.values().length - 1);
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Entrez un des nombres proposés");
                } catch (HorsBornesException e) {
                    System.err.println(e.getMessage());
                } finally {
                    scan.nextLine();
                }
            }

            int reponse_utilisateur_espece_animal;
            System.out.println("Quel est l'espèce de l'animal ?");
            Espece[] tabEspece = Espece.values();
            for (int i = 0; i < Espece.values().length; i++) {
                System.out.printf("%d-%s ", i, tabEspece[i]);
            }
            System.out.println();
            while (true) {
                try {
                    reponse_utilisateur_espece_animal = scan.nextInt();
                    verif.intBorne(reponse_utilisateur_espece_animal, Espece.values().length - 1);
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Entrez un des nombres proposés");
                } catch (HorsBornesException e) {
                    System.err.println(e.getMessage());
                } finally {
                    scan.nextLine();
                }
            }

            switch (reponse_utilisateur_espece_animal) {
                case 0:
                    animal_utilisateur = new Chat(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                    break;
                case 1:
                    animal_utilisateur = new Chien(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                    break;
                case 2:
                    animal_utilisateur = new Gorille(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                    break;
                case 3:
                    animal_utilisateur = new Lapin(reponse_utilisateur_nom_animal, tabSexe[reponse_utilisateur_sexe_animal]);
                    break;
            }

            try {
                archeDeNoe.ajouterAnimal(animal_utilisateur);
            } catch (PlusDePlaceException e) {
                System.err.println(e.getMessage());
            } catch (MemeEspeceException e) {
                System.err.println(e.getMessage());
            } catch (MemeSexeException e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Souhaitez-vous ajouter un autre animal ? 1-OUI / autre-NON");
            while (true) {
                try {
                    reponse_utilisateur_continuer = scan.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Entrez un des nombres proposés");
                }
                finally {
                    scan.nextLine();
                }

            }
        }


            //Insérer un animal
        //Afficher les animaux à bord de l'Arche
        archeDeNoe.afficher();

        archeDeNoe.stockAPrevoir(10);
    }
}
