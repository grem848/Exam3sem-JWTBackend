package exceptions;


public class NotFoundException extends Exception{

    /**
     *
     * @param message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     *
     */
    public NotFoundException() {
        super("Requested item could not be found");
    }  
}