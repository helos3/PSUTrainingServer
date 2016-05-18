package Application.model.exceptions;



/**
 * Created by Rushan on 04.04.2016.
 */
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String entityName) {
        super("Запись " + entityName + " не найдена");
    }
}
