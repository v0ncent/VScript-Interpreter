package Exceptions;

public final class NoInstructionGivenException extends VscriptException {
    public NoInstructionGivenException(String error, int stackTrace) {
        super(error, stackTrace);
    }
}
