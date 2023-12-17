package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.*;

public class Counting implements FSCommand {
    private final CountingVisitor visitor;
    private final FSElement rootDir;

    public Counting(CountingVisitor visitor, FSElement rootDir) {
        this.visitor = visitor;
        this.rootDir = rootDir;
    }

    @Override
    public void execute() {
        rootDir.accept(visitor);
    }
}