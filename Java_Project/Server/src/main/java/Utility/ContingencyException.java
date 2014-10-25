package nifury.mysql;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ContingencyException extends RuntimeException {

    public ContingencyException(String message) {
        super(message);
        //TODO Log
    }

    public ContingencyException(String message, Throwable cause) {
        super(message, cause);
        //TODO Log
    }

}
