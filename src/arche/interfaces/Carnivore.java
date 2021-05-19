package arche.interfaces;

import arche.enumeration.RegimeAlimentaire;

/**Interface Carnivore qui implémente certaines classes animale
 *
 * <ul>
 *     <li><b>quantiteViandeJournaliere :</b> Le nombre de kilos de viandes journalier consommés par chaque carnivore</li>
 *     <li><b>regimeAlimentaire :</b> Un des régimes alimentaires disponible dans l'énumération RegimeAlimentaire</li>
 * </ul>
 *
 * @author Yoann Drouet & Clément Duquenoy
 */
public interface Carnivore {

    int quantiteViandeJournaliere = 30;
    RegimeAlimentaire regimeAlimentaire = RegimeAlimentaire.CARNIVORE;
}
