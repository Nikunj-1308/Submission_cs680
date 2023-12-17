package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement>{
    public int compare(FSElement alphaFS_1, FSElement alphaFS_2){
        return Integer.compare(alphaFS_2.getSize(), alphaFS_1.getSize());
    }
}