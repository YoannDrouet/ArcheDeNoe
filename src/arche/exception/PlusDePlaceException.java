package arche.exception;

/** Exception a lever lorsque l'utilisateur essaye d'ajouter un animal alors qu'il n'y a plus de place dans l'Arche
 *
 * @author Yoann Drouet & Clément Duquenoy
 */
public class PlusDePlaceException extends Exception{
    public PlusDePlaceException() {
        super("Il n'y a plus de place dans l'Arche pour cet animal");
    }
}
