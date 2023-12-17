package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) { // Parameterized
                                                                                                         // Constructor
        super(parent, name, size, creationTime);
        this.target = target;
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    // Setters
    public void setTarget(FSElement target) {
        this.target = target;
    }

    // Getters
    public FSElement getTarget() {
        return this.target;
    }

    public int getTargetSize() {
        return target.getSize();
    }

    public boolean isTargetDirectory() { // Returns if the instance of the FS Element is a Directory
        return target.isDirectory();
    }

    public boolean isTargetFile() { // Returns if the instance of the FS Element is a File
        return target.isFile();
    }

    public boolean isTargetLink() { // Returns if the instance of the FS Element is a Link
        return target.isLink();
    }

    public void accept(FSVisitor v) {
        v.visit(this);
    }
}