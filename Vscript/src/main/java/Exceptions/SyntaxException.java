package Exceptions;

public final class SyntaxException extends VscriptException{
    public SyntaxException(String error, int stackTrace) {
        super(error, stackTrace);
    }
}
