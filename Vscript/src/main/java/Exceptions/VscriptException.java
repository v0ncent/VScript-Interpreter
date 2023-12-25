package Exceptions;

public class VscriptException extends Exception{
    private final String error;
    private final int stackTrace;

    public VscriptException(String error, int stackTrace) {
        super(String.format("%s\nexception at line %d",error, stackTrace));
        this.error = error;
        this.stackTrace = stackTrace;
    }

    public String getError() {
        return error;
    }

    public int stackTrace() {
        return stackTrace;
    }
}
