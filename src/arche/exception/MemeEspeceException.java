package arche.exception;

/**Exception levé lorsque l'utilisateur veut rentrer un troisième animal d'une même espèce
 *
 * @author Yoann Drouet & Clément Duquenoy
 */
public class MemeEspeceException extends Exception{
    public MemeEspeceException() {
        super("Vous avez déjà deux animaux de cette expèce");
    }
}
