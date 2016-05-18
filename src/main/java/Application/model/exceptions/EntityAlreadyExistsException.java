package Application.model.exceptions;
/**
 * Created by Rushan on 04.04.2016.
 */
public class EntityAlreadyExistsException extends Exception {

    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String entityName) {
        super("Запись " + entityName + " уже существует");
    }


}
