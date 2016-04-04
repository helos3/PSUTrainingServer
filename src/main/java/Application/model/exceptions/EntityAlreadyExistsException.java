package Application.model.exceptions;

import javax.ejb.ApplicationException;

/**
 * Created by Rushan on 04.04.2016.
 */
@ApplicationException(rollback = true)
public class EntityAlreadyExistsException extends Exception {

    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String entityName) {
        super("Сущность " + entityName + " уже существует");
    }


}
