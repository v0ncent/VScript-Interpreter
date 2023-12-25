package DataTypes;

public abstract class VscriptObject<T> {
    public abstract boolean isType(Object obj);

    @SuppressWarnings("unchecked")
    protected T getObjectType() {
        return (T) Object.class;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
