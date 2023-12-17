package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.*;

public class CountingVisitor implements FSVisitor {
    private int numOfDir = 0; // Initialized to 0
    private int numOfFile = 0;
    private int numOfLink = 0;

    public void visit(Directory dir) {
        numOfDir++; // Increment number of Directories for function call
    }

    public void visit(File file) {
        numOfFile++; // Increment number of Files for function call
    }

    public void visit(Link link) {
        numOfLink++; // Increment number of links for function call
    }

    public int getDirNum() {    // Getters
        return numOfDir;
    }

    public int getFileNum() {
        return numOfFile;
    }

    public int getLinkNum() {
        return numOfLink;
    }
}