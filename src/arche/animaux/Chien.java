package arche.animaux;

import arche.enumeration.Espece;
import arche.enumeration.RegimeAlimentaire;
import arche.enumeration.Sexe;
import arche.interfaces.Carnivore;

/** Classe qui représente un Chien, qui est un animal, et qui est carnivore
 *
 * <ul>
 *     <li><b>espèce :</b> L'espèce de l'animal - Espece</li>
 * </ul>
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public class Chien extends Animal implements Carnivore {

    // Attributs d'instance
    private Espece espece = Espece.CHIEN;

    // Méthode

    /** Constructeur avec tous les paramètres
     *
     * @param nom String
     * @param sexe Sexe
     */
    public Chien(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    /** Méthode d'affichage des informations de l'instance
     */
    @Override
    public void afficher() {
        System.out.printf("%s%n  espèce : %s%n  sexe : %s%n  régime alimentaire : %s%n", this.nom.toUpperCase(), this.espece, this.sexe, this.regimeAlimentaire);
    }

    @Override
    public Espece getEspece() {
        return espece;
    }

    @Override
    public RegimeAlimentaire getRegimeAlimentaire(){
        return this.regimeAlimentaire;
    }
}
