package ua.opnu;

public class GenericThreeTuple<T, V, S> {
    private final GenericTwoTuple<T, V> twoTuple;
    public final S three;

    public GenericThreeTuple(T first, V second, S three) {
        this.twoTuple = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    public T getFirst() {
        return twoTuple.first;
    }

    public V getSecond() {
        return twoTuple.second;
    }

    @Override
    public String toString() {
        return "(" + twoTuple.first + ", " + twoTuple.second + ", " + three + ")";
    }
}