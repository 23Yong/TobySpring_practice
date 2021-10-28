package springbook.learningteset.template;

public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
