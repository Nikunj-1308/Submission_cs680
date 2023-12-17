package edu.umb.cs680.hw17.fs;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() // Additional member function, returns true for a instance of File
    {
        return true;
    }

    public boolean isLink() {
        return false; // A link is not a file
    }

    public void accept(FSVisitor v) {
        v.visit(this);
    }
}