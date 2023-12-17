package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.*;

public class FileCrawling implements FSCommand {
    private final FileCrawlingVisitor visitor;
    private final FSElement rootDir;

    public FileCrawling(FileCrawlingVisitor visitor, FSElement rootDir) {
        this.visitor = visitor;
        this.rootDir = rootDir;
    }

    @Override
    public void execute() {
        rootDir.accept(visitor);
    }

    public FileCrawlingVisitor getVisitor() {
        return visitor;
    }
}