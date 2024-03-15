package edu.umb.cs681.hw01.fs;

public interface FSVisitor {
    public default void visit(Link link) {
    }

    public default void visit(Directory dir) {
    }

    public default void visit(File file) {
    }
}