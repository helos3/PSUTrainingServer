package Application.model.exceptions;

import javax.ejb.ApplicationException;

/**
 * Created by Rushan on 04.04.2016.
 */
@ApplicationException(rollback = true)
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String entityName) {
        super("Сущность " + entityName + " не найдена");
    }
}
