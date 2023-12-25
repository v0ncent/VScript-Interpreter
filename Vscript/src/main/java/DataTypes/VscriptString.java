package DataTypes;

public final class VscriptString extends VscriptObject<String> {


    @Override
    public boolean isType(Object obj) {
        return obj.getClass().equals(this.getObjectType());
    }
}
