package arche.exception;

/**Exception levé lorsque l'utilisateur entre un entier qui n'est pas dans les proposition qui lui sont faîtes
 *
 * @author Yoann Drouet & Clément Duquenoy
 */
public class HorsBornesException extends Exception {
    public HorsBornesException() {
        super("Entrez un des nombres demandés");
    }
}
