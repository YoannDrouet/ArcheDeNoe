package arche.exception;

/**Exception levé lorsque l'utilisateur essaye de rentrer un deuxième animal du même sexe et de la même espèce
 *
 * @author Yoann Drouet & Clément Duquenoy
 */
public class MemeSexeException extends Exception{
    public MemeSexeException() {
        super("Vous avez déjà un animal de cette race et de ce sexe");
    }
}
