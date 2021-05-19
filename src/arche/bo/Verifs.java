package arche.bo;

import arche.exception.HorsBornesException;

/** Classe permettant de vérifier si la saisie de l'utilisateur est bien comprise entre les bornes qui lui sont proposées.
 *  Lève une exception personnalisée si ce n'est pas le cas
 *
 * @author Yoann Drouet & Clément Duquenoy
 */
public class Verifs {

    // Méthodes

    /** Vérifie que l'entier test se situe bien entre 0 et la borne comprise.
     *
     * @param test int
     * @param borne_max int
     * @throws HorsBornesException
     */
    public void intBorne(int test, int borne_max) throws HorsBornesException{
        if (test < 0 || test  > borne_max){
            throw new HorsBornesException();
        }
    }
}
