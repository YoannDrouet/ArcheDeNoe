package arche.exception;

/** Exception a lever lorsque l'utilisateur a saisi une réponse qui est hors des bornes imposées
 *
 * @author Yoann Drouet & Clément Duquenoy
 * @version 1.0
 */
public class HorsBornesException extends Exception {
    public HorsBornesException() {
        super("Entrez un des nombres demandés");
    }
}
