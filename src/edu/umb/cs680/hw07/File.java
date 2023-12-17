package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime) // Public Parameterized Constructor
    {
        super(parent, name, size, creationTime);
    }

    public boolean isFile() // Additional member function, returns true for a instance of File
    {
        return true;
    }

    public boolean isDirectory() // Member function, returns false for a instance of File
    {
        return false;
    }

}