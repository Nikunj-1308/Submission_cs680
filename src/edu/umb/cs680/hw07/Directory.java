package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<File> file = new LinkedList<File>();
    private LinkedList<Directory> subDirectory = new LinkedList<Directory>();
    private LinkedList<FSElement> children = new LinkedList<FSElement>(); // data field to reference files and
                                                                          // subdirectories in a directory

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) { // Public Parameterized
                                                                                            // Constructor
        super(parent, name, 0, creationTime);
    }

    public LinkedList<FSElement> getChildren() { // Returns the instance of list of FSElement
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() { // returns the number of files and subdirectories in a directory
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories() { // Returns a list of sub-directory
        for (FSElement element : children) {
            if (element.isDirectory()) {
                subDirectory.add((Directory) element);
            }
        }
        return subDirectory;
    }

    public LinkedList<File> getFiles() { // Returns a list of files
        for (FSElement child : children) {
            if (child.isFile()) {
                file.add((File) child);
            }
        }
        return file;
    }

    public int getTotalSize() { // Returns the total disk consumption by all the files and subdirectories under
                                // a directory
        int totalSize = 0;
        for (FSElement child : children) {
            if (child.isDirectory()) {
                totalSize = totalSize + ((Directory) child).getTotalSize(); // Recursive call for Directories, if
                                                                            // present
            } else {
                totalSize = totalSize + child.getSize();
            }
        }
        return totalSize;
    }

    public boolean isDirectory() { // Member function, returns true for a instance of Directory
        return true;
    }

    public boolean isFile() { // Member function, returns false for a instance of Directory
        return false;
    }
}