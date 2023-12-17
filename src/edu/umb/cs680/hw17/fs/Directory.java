package edu.umb.cs680.hw17.fs;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.time.LocalDateTime;

public class Directory extends FSElement {
    private LinkedList<File> file = new LinkedList<File>();

    private LinkedList<Directory> subDirectory = new LinkedList<Directory>();

    private LinkedList<FSElement> children = new LinkedList<FSElement>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) { // Parameterized Constructor
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren()
    {
        return this.children;
    }

    public List<FSElement> getChildren(Comparator<FSElement> comp) {
        return this.children.stream()
                .sorted(comp)
                .collect(Collectors.toList());
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return this.children.size();
    }

    public List<Directory> getSubDirectories() { // Returns a list of SubDirectories
        return this.children.stream()
                .filter(FSElement::isDirectory)
                .map(element -> (Directory) element)
                .collect(Collectors.toList());
    }

    public List<Directory> getSubDirectories(Comparator<FSElement> comp) {
        return getSubDirectories().stream()
                .sorted(comp)
                .collect(Collectors.toList());
    }

    public List<File> getFiles() {  // Returns a list of Files
        return this.children.stream()
                .filter(FSElement::isFile)
                .map(element -> (File) element)
                .collect(Collectors.toList());
    }

    public List<File> getFiles(Comparator<FSElement> comp) {
        return getFiles().stream()
                .sorted(comp)
                .collect(Collectors.toList());
    }

    public int getTotalSize() {     // Returns total size(including that of child(SubDirectory/File))
        return this.children.stream()
            .mapToInt(child -> child.isDirectory() ? ((Directory) child).getTotalSize() : child.getSize()).sum();
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