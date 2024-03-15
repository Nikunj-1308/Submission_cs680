package edu.umb.cs681.hw01.fs;

import java.time.LocalDateTime;

import edu.umb.cs681.hw01.fs.util.FileCrawlingVisitor;

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
}