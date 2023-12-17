package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.*;

import java.util.*;

public class FileCrawlingVisitor implements FSVisitor {
    private LinkedList<File> fileList = new LinkedList<File>();

    private LinkedList<Link> linkList = new LinkedList<Link>();


    public void visit(Link link) {
        link.getTarget().accept(this);
        linkList.add(link);
        return;
    }

    public void visit(Directory dir) {
        return;
    }

    public void visit(File file) {
        fileList.add(file);
    }

    public LinkedList<File> getFiles() {
        return fileList;
    }

    public LinkedList<Link> getLinks() {
        return linkList;
    }
}