package DataTypes;

public final class VscriptBoolean extends VscriptObject<Boolean> {
    @Override
    public boolean isType(Object obj) {
        return false;
    }
}
