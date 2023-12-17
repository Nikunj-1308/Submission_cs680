package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<File> file = new LinkedList<File>();

    private LinkedList<Link> link = new LinkedList<Link>();

    private LinkedList<Directory> subDirectory = new LinkedList<Directory>();

    private LinkedList<FSElement> children = new LinkedList<FSElement>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) { // Parameterized Constructor
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories() { // Returns a list of SubDirectories
        for (FSElement element : children) {
            if (element.isDirectory()) {
                subDirectory.add((Directory) element);
            }
        }
        return subDirectory;
    }

    public LinkedList<File> getFiles() { // Returns a list of Files
        for (FSElement child : children) {
            if (child.isFile()) {
                file.add((File) child);
            }
        }
        return file;
    }

    public LinkedList<Link> getLinks() { // Returns a list of Link
        for (FSElement child : children) {
            if (child.isLink()) {
                link.add((Link) child);
            }
        }
        return link;
    }

    public int getTotalSize() { // Returns total size(including that of child(SubDirectory/File))
        int totalSize = 0;
        for (FSElement child : children) {
            if (child.isDirectory()) {
                totalSize = totalSize + ((Directory) child).getTotalSize();
            } else {
                totalSize = totalSize + child.getSize();
            }
        }
        return totalSize;
    }

    public boolean isDirectory() {
        return true;
    }

    public boolean isFile() {
        return false;
    }

    public boolean isLink() {
        return false; // Directory isn't a Link
    }

    public void accept(FSVisitor v) {
        v.visit(this);
        for (FSElement e : this.children) {
            e.accept(v);
        }
    }
}