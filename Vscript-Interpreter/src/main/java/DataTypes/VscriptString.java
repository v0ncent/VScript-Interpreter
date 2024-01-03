package DataTypes;

import lombok.NonNull;

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

    public String center(@NonNull int length,@NonNull char character) {
        int lengthOfTrailingCharacters = Math.abs(this.value.length() - length) / 2;
        StringBuilder builder = new StringBuilder();

        final String repeat = String.valueOf(character).repeat(Math.max(0, lengthOfTrailingCharacters));

        builder.append(repeat);
        builder.append(this.value);
        builder.append(repeat);

        return builder.toString();
    }

//    public int Count(@NonNull String value, Integer from, Integer to) {
//        if (!this.value.contains(value)) {
//            return 0;
//        }
//
//        int count = 0;
//        int start;
//        int end;
//        String[] characters = this.value.split("");
//        if (from != null && to != null) {
//            start = from;
//            end = to;
//        } else {
//            start = 0;
//            end = characters.length;
//        }
//
//        if (start < 0 || end > characters.length) {
//            throw new IndexOutOfBoundsException();
//        }
//
//        for (int i = start; i < end; i++) {
//
//
//
//        }
//
//    }
}
