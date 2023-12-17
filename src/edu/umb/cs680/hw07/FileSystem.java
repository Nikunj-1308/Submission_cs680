package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem filSys = null;    //Instance of the Class FileSystem
    private LinkedList<Directory> directory = new LinkedList<Directory>();

    private FileSystem() {} // Singleton class has private constructor

    public static FileSystem getFileSystem() // Returns an obj if not declared before
    {
        if (filSys == null) {
            filSys = new FileSystem();
        }
        return filSys;
    }

    public LinkedList<Directory> getRootDirs() { // Returns the Root Directory
        return directory;
    }

    public void appendRootDir(Directory root) { // Appends the instance to the Directory
        this.directory.add(root);
    }
}