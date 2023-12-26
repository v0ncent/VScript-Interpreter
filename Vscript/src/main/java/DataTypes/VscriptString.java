package DataTypes;

public final class VscriptString extends VscriptObject<String> {
    public VscriptString(String value) {
        super(value);
    }

    public String handleConcatenation(Object[] toConcat) {

        return null;
    }

    public String capitalize() {
        return this.value.substring(0, 1).toUpperCase() + this.value.substring(1);
    }

    public String center(int length, char character) {
        int lengthOfTrailingCharacters = Math.abs(this.value.length() - length) / 2;
        StringBuilder builder = new StringBuilder();

        final String repeat = String.valueOf(character).repeat(Math.max(0, lengthOfTrailingCharacters));

        builder.append(repeat);
        builder.append(this.value);
        builder.append(repeat);

        return builder.toString();
    }
}
