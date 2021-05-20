package arche.bo;

import arche.animaux.Animal;
import arche.enumeration.RegimeAlimentaire;
import arche.exception.MemeEspeceException;
import arche.exception.MemeSexeException;
import arche.exception.PlusDePlaceException;
import arche.interfaces.Carnivore;
import arche.interfaces.Herbivore;


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
    Animal[] capaciteArche;

    // Méthodes

    /** Constructeur avec tous les paramètres.
     *
     * @param capacite int
     */
    public Arche(int capacite) {
        this.capaciteArche = new Animal[capacite];
    }

    /** Méthode qui vérfie s'il reste de la place dans l'Arche
     *
     * @return boolean
     */
    public boolean resteDeLaPlace() throws PlusDePlaceException{

        // Si une des cases du tableau d'animaux est vide
        for (int i = 0; i < capaciteArche.length; i++) {
            if (capaciteArche[i] == null) {
                return true;
            }
        }
        throw new PlusDePlaceException();
    }

    /** Méthode qui vérifie si un animal de même espèce et de même sexe se trouve déjà à bord,<br>
     *  OU que le nombre maximum d'individus de la même espèce (2) se trouve déjà à bord.
     *
     * @param animal Animal
     * @return boolean
     * @throws PlusDePlaceException si il n'y a plus de place dans l'arche.
     * @throws MemeEspeceException si le nombre maximum d'individus de la même espèce (2) se trouve déjà à bord.
     * @throws MemeSexeException si un animal de même espèce et de même sexe se trouve déjà à bord.
     */
    public boolean dejaMemeAnimal(Animal animal) throws PlusDePlaceException, MemeEspeceException, MemeSexeException{

        // Initialisation du compteur d'animaux de la même espèce déjà présents à bord
        int cpt = 0;

        // Pour chaque case du tableau
        for (int i = 0; i < capaciteArche.length; i++) {

            // Si la case n'est pas null et qu'elle est occupée par un animal de la même espèce que celui en paramètre
            if (capaciteArche[i] != null && capaciteArche[i].getEspece() == animal.getEspece()){

                // On incrémente le compteur d'animaux de la même espèce déjà à bord
                cpt ++;

                // Si ce nombre arrive à deux (limite par espèce)
                if (cpt == 2){
                    // Levée d'exception
                    throw new MemeEspeceException();
                }

                // Si un animal de même espèce et de même sexe occupe cette case
                if (capaciteArche[i].getSexe() == animal.getSexe()){
                    // Levée d'exception
                    throw new MemeSexeException();
                }
            }
        }
        // Si l'animal peut être ajouté :
        return false;
    }

    /** Ajoute l'animal en paramètre dans l'arche (avec vérification qu'il puisse vraiment être ajouté).
     *
     * @throws PlusDePlaceException si il n'y a plus de place dans l'arche.
     * @throws MemeEspeceException si le nombre maximum d'individus de la même espèce (2) se trouve déjà à bord.
     * @throws MemeSexeException si un animal de même espèce et de même sexe se trouve déjà à bord.
     */
    public void ajouterAnimal() throws PlusDePlaceException, MemeEspeceException, MemeSexeException{

        System.out.println();
        System.out.println("Entrez les informations de l'animal à faire monter dans l'Arche");
        System.out.println();

        Animal animal_a_ajouter = saisie.animalUtilisateur();

        if (resteDeLaPlace() && !dejaMemeAnimal(animal_a_ajouter)){
            for (int i = 0; i < capaciteArche.length; i++) {
                if (capaciteArche[i] == null){
                    capaciteArche[i] = animal_a_ajouter;
                    System.out.printf("• %s a été ajouté à l'Arche%n%n", animal_a_ajouter.getNom());
                    break;
                }
            }
        }
    }

    /** Méthode qui enlève l'animal saisi par l'utilisateur de l'Arche.
     */
    public void enleverAnimal(){

        System.out.println();
        System.out.println("Entrez les informations de l'animal à faire descendre de l'Arche");
        System.out.println();

        Animal animal_a_enlever = saisie.animalUtilisateur();

        boolean animalEnleve = false;

        for (int i = 0; i < capaciteArche.length; i++) {
            if (capaciteArche[i] != null){
                if (capaciteArche[i].animauxPareils(animal_a_enlever)) {
                    capaciteArche[i] = null;
                    animalEnleve = true;
                    System.out.printf("%s est bien descendu de l'Arche.%n", animal_a_enlever.getNom());
                    break;
                }
            }
        }
        if (!animalEnleve) {
            System.out.println("Cet animal n'est pas dans l'Arche");
        }
    }

    /** Méthode d'affichage des informations de chaque animal de l'Arche
     */
    public void afficher(){
        System.out.println();
        System.out.println("*** Animaux présents dans l'arche : ***");
        System.out.println();
        for (int i = 0; i < capaciteArche.length; i++) {
            if (capaciteArche[i] != null){
                capaciteArche[i].afficher();
                System.out.println();
            }
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

        for (int i = 0; i < capaciteArche.length; i++) {

            // Si la case du tableau n'est pas null
            if (capaciteArche[i] != null){
                //Si le régime alimentaire de l'animal est Herbivore
                if (capaciteArche[i].getRegimeAlimentaire() == RegimeAlimentaire.HERBIVORE){
                    // On ajoute au total journalier des besoins en végétaux ceux de l'animal de cette case
                    nbVegetauxJournalier += Herbivore.nombreVegetauxJournalier;
                }

                //Si le régime alimentaire de l'animal est Carnivore
                else if (capaciteArche[i].getRegimeAlimentaire() == RegimeAlimentaire.CARNIVORE){
                    // On ajoute au total journalier des besoins en viande ceux de l'animal de cette case
                    kgViandeJournalier += Carnivore.quantiteViandeJournaliere;
                }
            }
        }

        // On multiplie les besoins journaliers par le nombre de jours de voyage
        kgViandeJournalier *= jourDeVoyage;
        nbVegetauxJournalier *= jourDeVoyage;

        // Affichage des besoins de l'Arche pour le voyage
        System.out.printf("Il faut prévoir %dkg de viande et %d végétaux%n", kgViandeJournalier*jourDeVoyage, nbVegetauxJournalier*jourDeVoyage);
    }
}
