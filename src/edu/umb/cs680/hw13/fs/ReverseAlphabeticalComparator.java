package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

    public int compare(FSElement alphaFS_1, FSElement alphaFS_2) {
        return alphaFS_2.getName().compareTo(alphaFS_1.getName());
    }

}