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
    public boolean resteDeLaPlace(Animal animal) throws PlusDePlaceException{
        // Si la dernière case du tableau d'animaux n'est pas remplie
        if (capaciteArche[capaciteArche.length-1] == null){
            return true;
        }else {
            throw new PlusDePlaceException();
        }
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
     * @param animal Animal
     * @throws PlusDePlaceException si il n'y a plus de place dans l'arche.
     * @throws MemeEspeceException si le nombre maximum d'individus de la même espèce (2) se trouve déjà à bord.
     * @throws MemeSexeException si un animal de même espèce et de même sexe se trouve déjà à bord.
     */
    public void ajouterAnimal(Animal animal) throws PlusDePlaceException, MemeEspeceException, MemeSexeException{
        if (resteDeLaPlace(animal) && !dejaMemeAnimal(animal)){
            for (int i = 0; i < capaciteArche.length; i++) {
                if (capaciteArche[i] == null){
                    capaciteArche[i] = animal;
                    System.out.printf("• %s a été ajouté à l'Arche%n%n", animal.getNom());
                    break;
                }
            }
        }
    }

    /** Méthode d'affichage des informations de chaque animal de l'Arche
     */
    public void afficher(){
        for (int i = 0; i < capaciteArche.length; i++) {
            if (capaciteArche[i] != null){
                capaciteArche[i].afficher();
                System.out.println();
            }else {
                break;
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
            // Si cette case est vide c'est qu'il n'y a plus d'animaux, donc on sort
            else {
                break;
            }
        }

        // On multiplie les besoins journaliers par le nombre de jours de voyage
        kgViandeJournalier *= jourDeVoyage;
        nbVegetauxJournalier *= jourDeVoyage;

        // Affichage des besoins de l'Arche pour le voyage
        System.out.printf("Il faut prévoir %dkg de viande et %d végétaux", kgViandeJournalier*jourDeVoyage, nbVegetauxJournalier*jourDeVoyage);
    }
}
