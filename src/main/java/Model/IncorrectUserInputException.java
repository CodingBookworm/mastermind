package Model;

public class IncorrectUserInputException extends RuntimeException {
    public IncorrectUserInputException(String errorMessage) {
        super(errorMessage);
    }
}
