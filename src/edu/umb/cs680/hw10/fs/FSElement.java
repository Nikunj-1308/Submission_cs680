package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;
import java.util.Optional;

public abstract class FSElement {
    private Directory parent_dir; // Private Data member of type Directory

    protected String name; // File name

    protected int size; // File size

    protected LocalDateTime creationTime; // File Creation Time

    public FSElement(Directory parent_dir, String name, int size, LocalDateTime creationTime) {
        if (parent_dir != null) {
            parent_dir.appendChild(this);
        }

        else {
            this.parent_dir = null;
        }

        if (isDirectory() || isLink()) {
            this.size = 0; // For a directory or a link, size is 0
        }

        else {
            this.size = size;
        }

        this.name = name;

        this.creationTime = creationTime;
    }

    public Directory getParent() {
        return this.parent_dir;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    protected void setParent(Directory parent) {
        this.parent_dir = parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    abstract public boolean isDirectory();

    abstract public boolean isFile();

    abstract public boolean isLink();

    abstract public void accept(FSVisitor v);

    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();

        Directory root = new Directory(null, "root", 0, time);
        Directory home = new Directory(root, "home", 0, time);
        Directory apps = new Directory(home, "apps", 0, time);
        Directory myApp = new Directory(apps, "myApp", 0, time);
        Directory workCode = new Directory(myApp, "workCode", 0, time);
        Directory misc = new Directory(home, "misc", 0, time);

        File sampleCodeA = new File(myApp, "sampleCodeA", 1, time);
        File sampleCodeB = new File(myApp, "sampleCodeB", 1, time);
        File sampleCodeC = new File(workCode, "sampleCodeC", 1, time);

        File sampleCodeL = new File(apps, "sampleCodeA", 1, time);
        File sampleCodeM = new File(apps, "sampleCodeB", 1, time);

        File sampleCodeZ = new File(misc, "sampleCodeC", 1, time);

        Optional<Directory> optionalDirectory = Optional.ofNullable(apps.getParent());

        System.out.println("Directory: " + root.getName());
        System.out.println("Size: " + root.getSize());
        System.out.println("Creation Time: " + root.getCreationTime());
        System.out.println("Parent: " + root.getParent());
        System.out.println("Total size: " + root.getTotalSize());
    }
}