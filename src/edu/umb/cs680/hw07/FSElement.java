package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.Optional;

public abstract class FSElement {
    
    protected String name;

    protected int size; // File size

    protected LocalDateTime creationTime;

    private Directory parent_dir; //State the parent of the instance

    public FSElement(Directory parent_dir, String name, int size, LocalDateTime creationTime) { //Parameterized Constructor
        
        this.name = name;

        if (isDirectory()) {
            this.size = 0; // For a directory, size is 0
        } 
        
        else {
            this.size = size;
        }

        this.creationTime = creationTime;

        if (parent_dir == null) {
            this.parent_dir = null; 
        } 
        
        else {
            parent_dir.appendChild(this);
        }
    }

    public Directory getParent() {  // Getters
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

    abstract public boolean isDirectory();

    protected void setParent(Directory parent) {    // Setters
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

    abstract public boolean isFile();

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