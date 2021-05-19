package arche.interfaces;

import arche.enumeration.RegimeAlimentaire;

/** Interface à implémenter sur les animaux Carnivores
 *
 * <ul>
 *     <li><b>quantiteViandeJournaliere :</b> Le nombre de kilos de viandes journalier consommés par chaque carnivore</li>
 *     <li><b>regimeAlimentaire :</b> Un des régimes alimentaires disponible dans l'énumération RegimeAlimentaire</li>
 * </ul>
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public interface Carnivore {

    int quantiteViandeJournaliere = 30;
    RegimeAlimentaire regimeAlimentaire = RegimeAlimentaire.CARNIVORE;
}
