package backend.take.home.quotely.exception;

/**
 * Base class for exceptions thrown when handling quotely request
 */
public class QuotelyException extends Exception {
    public QuotelyException (String message) {
        super(message);
    }
}
