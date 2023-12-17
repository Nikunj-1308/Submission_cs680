package edu.umb.cs680.hw13.fs.util;

import java.util.LinkedList;
import edu.umb.cs680.hw13.fs.*;

public class FileSearchVisitor implements FSVisitor {

    public String fileName; // Name of the file
    public LinkedList<File> foundFileList = new LinkedList<File>(); // List of files found

    public FileSearchVisitor(String fileName) { // Parameterized Constructor
        this.fileName = fileName;
    }

    public void visit(Link link) {
        return;
    }

    public void visit(Directory dir) {
        return;
    }

    public void visit(File file) {
        if (file.getName().equals(fileName)) {
            foundFileList.add(file); // Add file if visited and file found
        }
    }

    public LinkedList<File> getFoundFiles() {   // Getter
        return foundFileList;
    }
}