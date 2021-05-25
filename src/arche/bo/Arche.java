package arche.bo;

import arche.animaux.Animal;
import arche.enumeration.RegimeAlimentaire;
import arche.exception.MemeEspeceException;
import arche.exception.MemeSexeException;
import arche.exception.PlusDePlaceException;
import arche.interfaces.Carnivore;
import arche.interfaces.Herbivore;

import java.util.ArrayList;


/** Classe qui représente une arche, qui contient des animaux.
 *
 * <ul><li><b>capacite</b> : La capacité maximale d'animaux<br>qu'une arche peut contenir</li></ul>
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public class Arche {

    // Déclaration des instances
    SaisieUtitlisateur saisie = new SaisieUtitlisateur();

    // Attributs de classe
    ArrayList<Animal> liste_animaux;

    // Méthodes

    /** Constructeur
     *
     */
    public Arche() {
        this.liste_animaux = new ArrayList<>();
    }


    /** Méthode qui vérifie si un animal de même espèce et de même sexe se trouve déjà à bord,<br>
     *  OU que le nombre maximum d'individus de la même espèce (2) se trouve déjà à bord.
     *
     * @param animal Animal
     * @return boolean
     * @throws MemeEspeceException si le nombre maximum d'individus de la même espèce (2) se trouve déjà à bord.
     * @throws MemeSexeException si un animal de même espèce et de même sexe se trouve déjà à bord.
     */
    public boolean dejaMemeAnimal(Animal animal) throws MemeEspeceException, MemeSexeException{

        // Initialisation du compteur d'animaux de la même espèce déjà présents à bord
        int cpt = 0;
        int i = 0;
        boolean reponse = false;

        // Pour chaque case du tableau
        /*while (true) {

            // Si la case n'est pas null et qu'elle est occupée par un animal de la même espèce que celui en paramètre
            if (liste_animaux.get(i) != null && liste_animaux.get(i).getEspece() == animal.getEspece()){

                // On incrémente le compteur d'animaux de la même espèce déjà à bord
                cpt ++;

                // Si ce nombre arrive à deux (limite par espèce)
                if (cpt == 2){
                    // Levée d'exception
                    throw new MemeEspeceException();
                }

                // Si un animal de même espèce et de même sexe occupe cette case
                if (liste_animaux.get(i).getSexe() == animal.getSexe()){
                    // Levée d'exception
                    throw new MemeSexeException();
                }
            }
            i += 1;
        }*/
        // Si l'animal peut être ajouté :
        return reponse;
    }

    /** Ajoute l'animal en paramètre dans l'arche (avec vérification qu'il puisse vraiment être ajouté).
     *
     * @throws MemeEspeceException si le nombre maximum d'individus de la même espèce (2) se trouve déjà à bord.
     * @throws MemeSexeException si un animal de même espèce et de même sexe se trouve déjà à bord.
     */
    public void ajouterAnimal() throws MemeEspeceException, MemeSexeException{

        System.out.println();
        System.out.println("Entrez les informations de l'animal à faire monter dans l'Arche");
        System.out.println();

        Animal animal_a_ajouter = saisie.animalUtilisateur();

        if (!dejaMemeAnimal(animal_a_ajouter)){
            liste_animaux.add(animal_a_ajouter);
            System.out.printf("• %s a été ajouté à l'Arche%n%n", animal_a_ajouter.getNom());
        }
    }

    /** Méthode qui enlève l'animal saisi par l'utilisateur de l'Arche.
     */
    public void enleverAnimal(){

        System.out.println();
        System.out.println("Entrez les informations de l'animal à faire descendre de l'Arche");
        System.out.println();

        Animal animal_a_enlever = saisie.animalUtilisateur();


                if (liste_animaux.contains(animal_a_enlever)) {
                    liste_animaux.remove(animal_a_enlever);

                    System.out.printf("%s est bien descendu de l'Arche.%n", animal_a_enlever.getNom());
                }
                else {
                    System.out.println("Cet animal n'est pas dans l'Arche");
                }
    }

    /** Méthode d'affichage des informations de chaque animal de l'Arche
     */
    public void afficher(){
        System.out.println();
        System.out.println("*** Animaux présents dans l'arche : ***");
        System.out.println();
        int i = 0;
        while (true) {
            if (liste_animaux.get(i) != null){
                liste_animaux.get(i).afficher();
                System.out.println();
            }
            else {
                break;
            }
            i += 1;
        }
    }

    /** Méthode qui calcule et affiche la quantité de nourriture à prévoir pour le voyage,
     *  en fonction des animaux présents dans l'Arche et du nombre de jour de voyage.
     *
     * @param jourDeVoyage int
     */
    public void stockAPrevoir(int jourDeVoyage){

        int kgViandeJournalier = 0;
        int nbVegetauxJournalier = 0;

        int i = 0;

        while (true) {

            // Si la case du tableau n'est pas null
            if (liste_animaux.get(i) != null){
                //Si le régime alimentaire de l'animal est Herbivore
                if (liste_animaux.get(i).getRegimeAlimentaire() == RegimeAlimentaire.HERBIVORE){
                    // On ajoute au total journalier des besoins en végétaux ceux de l'animal de cette case
                    nbVegetauxJournalier += Herbivore.nombreVegetauxJournalier;
                }

                //Si le régime alimentaire de l'animal est Carnivore
                else if (liste_animaux.get(i).getRegimeAlimentaire() == RegimeAlimentaire.CARNIVORE){
                    // On ajoute au total journalier des besoins en viande ceux de l'animal de cette case
                    kgViandeJournalier += Carnivore.quantiteViandeJournaliere;
                }
            }
            else {
                break;
            }
            i += 1;
        }

        // On multiplie les besoins journaliers par le nombre de jours de voyage
        kgViandeJournalier *= jourDeVoyage;
        nbVegetauxJournalier *= jourDeVoyage;

        // Affichage des besoins de l'Arche pour le voyage
        System.out.printf("Il faut prévoir %dkg de viande et %d végétaux%n", kgViandeJournalier*jourDeVoyage, nbVegetauxJournalier*jourDeVoyage);
    }
}
