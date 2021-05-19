package arche.exception;

/** Exception a lever lorsque l'utilisateur essaye d'ajouter un troisième animal d'une même espèce dans l'Arche
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public class MemeEspeceException extends Exception{
    public MemeEspeceException() {
        super("Vous avez déjà deux animaux de cette expèce");
    }
}
