package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {
    public int compare(FSElement alphaFS_1, FSElement alphaFS_2){
        return alphaFS_1.getName().compareTo(alphaFS_2.getName());
    }
}