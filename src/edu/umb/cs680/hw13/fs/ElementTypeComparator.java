package edu.umb.cs680.hw13.fs;

import java.util.Comparator;

public class ElementTypeComparator implements Comparator<FSElement>{
    public int compare(FSElement element1, FSElement element2) {
        if (element1.isDirectory() && !element2.isDirectory()) {
            return -1;
        } 
        
        else if (!element1.isDirectory() && element2.isDirectory()) {
            return 1;
        } 
        
        else {
            if (!element1.isDirectory() && !element2.isDirectory()) {
                return element1.getName().compareTo(element2.getName());
            } 
            
            else if (element1 instanceof Link && !(element2 instanceof Link)) {
                return 1; 
            } 
            
            else if (!(element1 instanceof Link) && element2 instanceof Link) {
                return -1;
            } 
            
            else {
                return element1.getName().compareTo(element2.getName());
            }
        }
    }
}