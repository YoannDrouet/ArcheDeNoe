package arche.interfaces;

import arche.enumeration.RegimeAlimentaire;

/**Interface Herbivore qui implémente certaines classes animale
 *
 * <ul>
 *     <li><b>nombreVegetauxJournalier :</b> Le nombre de végétaux journalier consommés par chaque herbivore</li>
 *     <li><b>regimeAlimentaire :</b> Un des régimes alimentaires disponible dans l'énumération RegimeAlimentaire</li>
 * </ul>
 *
 * @author Yoann Drouet & Clément Duquenoy
 */
public interface Herbivore {

    int nombreVegetauxJournalier = 10;
    RegimeAlimentaire regimeAlimentaire = RegimeAlimentaire.HERBIVORE;
}
