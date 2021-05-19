package arche.exception;

/**Exception levé lorsque l'utilisateur essaye d'entré un animal alors que qu'il n'y a plus de place dans l'Arche
 *
 * @author Yoann Drouet & Clément Duquenoy
 */
public class PlusDePlaceException extends Exception{
    public PlusDePlaceException() {
        super("Il n'y a plus de place dans l'Arche pour cet animal");
    }
}
