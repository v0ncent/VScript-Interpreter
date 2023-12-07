package Functionalities.Instructions.Params;

public final class UnparsedParam {
    private final String rawUnparsedParams;
    private String[] parsedParams;
    private boolean isParsed;

    public UnparsedParam(String rawUnparsedParams) {
        this.rawUnparsedParams = rawUnparsedParams;
        this.parsedParams = null;
        this.isParsed = false;
    }

    public String getRawUnparsedParam() {
        return rawUnparsedParams;
    }

    public boolean isParsed() {
        return isParsed;
    }

    public String[] getParsedParams() {
        return parsedParams;
    }

    public void setParsed(boolean parsed) {
        isParsed = parsed;
    }

    public void setParsedParams(String[] parsedParams) {
        this.parsedParams = parsedParams;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return ((UnparsedParam) obj).rawUnparsedParams.equals(this.rawUnparsedParams);
    }
}
