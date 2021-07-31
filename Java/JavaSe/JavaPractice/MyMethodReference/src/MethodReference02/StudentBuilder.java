package MethodReference02;

@FunctionalInterface
public interface StudentBuilder {
    Student build(String name, int age);
}
