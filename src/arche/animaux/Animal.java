package arche.animaux;

import arche.enumeration.Espece;
import arche.enumeration.RegimeAlimentaire;
import arche.enumeration.Sexe;

/** Classe qui représente un animal
 *
 * <ul>
 *     <li><b>nom :</b> Le nom de l'animal -  String</li>
 *     <li><b>sexe :</b> Le sexe de l'animal - Sexe</li>
 * </ul>
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public abstract class Animal {

    // Attributs d'instance
    protected String nom;
    protected Sexe sexe;

    // Méthodes

    /** Constructeur avec tous les paramètres.
     *
     * @param nom String
     * @param sexe Sexe
     */
    public Animal(String nom, Sexe sexe) {
        this.nom = nom;
        this.sexe = sexe;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public String getNom() {
        return nom;
    }

    // Méthodes abstraites à déclarer dans les classes enfants
    public abstract Espece getEspece();

    public abstract void afficher();

    public abstract RegimeAlimentaire getRegimeAlimentaire();
}
