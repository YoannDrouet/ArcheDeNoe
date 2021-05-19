package arche.interfaces;

import arche.enumeration.RegimeAlimentaire;

/** Interface à implémenter sur les animaux Herbivores
 *
 * <ul>
 *     <li><b>nombreVegetauxJournalier :</b> Le nombre de végétaux journalier consommés par chaque herbivore</li>
 *     <li><b>regimeAlimentaire :</b> Un des régimes alimentaires disponible dans l'énumération RegimeAlimentaire</li>
 * </ul>
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public interface Herbivore {

    int nombreVegetauxJournalier = 10;
    RegimeAlimentaire regimeAlimentaire = RegimeAlimentaire.HERBIVORE;
}
