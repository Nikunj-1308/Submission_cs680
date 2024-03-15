package edu.umb.cs681.hw01.fs;

import java.util.LinkedList;

public class FileSystem {
    private FileSystem() {
        // Singleton class has private constructor
    }

    private static FileSystem filSys = null;

    public static FileSystem getFileSystem() // Returns an obj if not declared before
    {
        if (filSys == null) {
            filSys = new FileSystem();
        }
        return filSys;
    }

    private LinkedList<Directory> directory = new LinkedList<Directory>(); // Data Member

    public LinkedList<Directory> getRootDirs() { // Returns the Root Directory
        return directory;
    }

    public void appendRootDir(Directory root) { // Appends the instance to the Directory
        this.directory.add(root);
    }
}