package edu.umb.cs680.hw17.fs;

public interface FSVisitor {
    public default void visit(Link link) {}

    public default void visit(Directory dir) {}

    public default void visit(File file) {}
}