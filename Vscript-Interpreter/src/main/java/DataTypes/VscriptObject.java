package DataTypes;

import java.util.Objects;

public class VscriptObject<T> {
    public T value;

    public VscriptObject() {
        this(null);
    }

    public VscriptObject(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public Class<T> getType() {
        return (Class<T>) Object.class;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return ((VscriptObject<?>) obj).value.equals(this.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
