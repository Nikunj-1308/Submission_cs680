package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement>{
    public int compare(FSElement alphaFS_1, FSElement alphaFS_2){
        return alphaFS_2.getModifiedTime().compareTo(alphaFS_1.getModifiedTime());
    }
}