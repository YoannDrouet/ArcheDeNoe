package arche.main;

import arche.animaux.*;
import arche.bo.Arche;
import arche.bo.SaisieUtitlisateur;
import arche.exception.MemeEspeceException;
import arche.exception.MemeSexeException;
import arche.exception.PlusDePlaceException;

/** Programme qui simule un "registre" pour l'Arche de Noé
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public class main {

    public static void main(String[] args){

        // Déclaration des instances
        SaisieUtitlisateur saisie = new SaisieUtitlisateur();

        // Déclaration des variables
        int reponse_utilisateur_continuer;


        ///// •  TRAITEMENT PRINCIPAL • /////


        // Création d'une nouvelle arche
        Arche archeDeNoe = new Arche(8);


        //// • Boucle d'ajout d'un animal par l'utilisateur • ////

        do {

            /// • Initialisation de l'animal à ajouter à l'Arche • ///

            Animal animal_utilisateur = saisie.AnimalUtilisateur();

            /// • Ajout de l'animal crée à l'Arche • ///

            try {
                archeDeNoe.ajouterAnimal(animal_utilisateur);
            }

            // Exception lorsqu'il n'y a plus de place dans l'Arche
            catch (PlusDePlaceException e) {
                System.err.println(e.getMessage());
            }

            // Exception s'il y a déjà deux individus de la même espèce dans l'Arche
            catch (MemeEspeceException e) {
                System.err.println(e.getMessage());
            }

            // Exception s'il y a déjà un individu du même sexe et de la même espèce dans l'Arche
            catch (MemeSexeException e) {
                System.err.println(e.getMessage());
            }

            /// • Demande à l'utilisateur s'il veut ajouter un nouvel animal • ///

            reponse_utilisateur_continuer = saisie.ajouterUnAutreAnimal();

        // Boucle tant que l'utilisateur souhaite ajouter un autre animal
        } while (reponse_utilisateur_continuer == 1);


        //// • Affichage final • ////

        // Affiche les animaux actuellement à bord de l'Arche
        archeDeNoe.afficher();

        // Calcule et affiche les provisions à prévoir pour le temps de voyage souhaité
        archeDeNoe.stockAPrevoir(10);
    }
}