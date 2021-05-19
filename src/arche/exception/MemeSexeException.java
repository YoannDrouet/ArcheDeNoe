package arche.exception;

/** Exception a lever lorsque l'utilisateur essaye d'ajouter un deuxième animal du même sexe et de la même espèce dans l'Arche
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public class MemeSexeException extends Exception{
    public MemeSexeException() {
        super("Vous avez déjà un animal de cette race et de ce sexe");
    }
}
