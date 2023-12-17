package edu.umb.cs680.hw10;

import  org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;

class FileCrawlingVisitorTest {
	private static FileCrawlingVisitor fileCrawlingVisitor;
	static LocalDateTime time = LocalDateTime.now();
	
	static Directory repo;

    static Directory src;
    static File a;
    static File b;

    static Directory test;
    static Directory srcTest;
    static File aTest;
    static File bTest;

    static File readme;

    static Link linkToReadMe;

    @BeforeAll
    static void setUpFileSystemStructureBeforeTest() {
        repo = new Directory(null, "repo", 0, time);

        src = new Directory(repo, "src", 0, time);
        a = new File(src, "A.java", 1, time);
        b = new File(src, "B.java", 1, time);

        test = new Directory(repo, "test", 0, time);
        srcTest = new Directory(test, "src", 0, time);
        aTest = new File(srcTest, "ATest.java", 1, time);
        bTest = new File(srcTest, "BTest.java", 1, time);

        readme = new File(repo, "readme.md", 1, time);
        linkToReadMe = new Link(srcTest, "rm.md", 1, time, readme);

		fileCrawlingVisitor = new FileCrawlingVisitor();
        repo.accept(fileCrawlingVisitor);
    }

    @Test
    public void verifyVisitedFilesCountAs6() {
        int expected = 6;
        Assertions.assertEquals(expected, fileCrawlingVisitor.getFiles().size());
    }

    @Test
    public void verifyVisitedLinkPresentForFileCrawlingVisitor() {
        Directory testDir = repo.getSubDirectories().get(1);
        Directory srcDir = testDir.getSubDirectories().get(0);

        Link expectedLink = srcDir.getLinks().get(0);

        Assertions.assertEquals(expectedLink, fileCrawlingVisitor.getLinks().get(0));
        //Assertions.assertTrue(fileCrawlingVisitor.getLinks().contains(linkToReadMe));
    }
}