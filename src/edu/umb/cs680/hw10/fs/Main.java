package edu.umb.cs680.hw10.fs;

import java.time.LocalDateTime;
import java.util.*;
import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.util.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();

        Directory repo = new Directory(null, "repo", 0, time);

        FileSearch fileSearchCommand = new FileSearch(new FileSearchVisitor("myTest.txt"), repo);
        fileSearchCommand.execute();
        List<File> foundFiles = fileSearchCommand.getVisitor().getFoundFiles();
        System.out.println("Number of files found: " + foundFiles.size());

        FileCrawling fileCrawlingCommand = new FileCrawling(new FileCrawlingVisitor(), repo);
        fileCrawlingCommand.execute();
        List<File> crawledFiles = fileCrawlingCommand.getVisitor().getFiles();
        System.out.println("Crawled files count: " + crawledFiles.size());
    }
}