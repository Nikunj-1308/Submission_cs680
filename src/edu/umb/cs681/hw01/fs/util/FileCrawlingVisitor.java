package edu.umb.cs681.hw01.fs.util;

import edu.umb.cs681.hw01.fs.*;

import java.util.*;
import java.util.stream.Stream;

public class FileCrawlingVisitor implements FSVisitor {
    private LinkedList<File> fileList = new LinkedList<File>();

    public void visit(Link link) {
        return;
    }

    public void visit(Directory dir) {
        // for (FSElement element : dir.getChildren()) {
        // element.accept(this);
        // }
        return;
    }

    public void visit(File file) {
        fileList.add(file);
        // System.out.println("In" , );
    }

    public LinkedList<File> getFiles() {
        return fileList;
    }

    public Stream<File> files() {
        return fileList.stream();
    }
}