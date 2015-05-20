/**
 * 
 */
package mytest.api.exception;

/**
 * Any exception within the app
 * @author mikulsky
 */
public class MyTestException extends Exception {

    private static final long serialVersionUID = -1841708013915805620L;

    /**
     * Constructs a new exception with the specified detail message and cause.
     * @param message error message
     * @param cause error cause
     */
    public MyTestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message
     * @param message error message
     */
    public MyTestException(String message) {
        super(message);
    }

}
