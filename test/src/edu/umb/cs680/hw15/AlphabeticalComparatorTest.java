package edu.umb.cs680.hw15;

import java.util.List;
import edu.umb.cs680.hw15.fs.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

class AlphabeticalComparatorTest {

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

    }

    @Test
    public void verifyGetChildrenForRepoAsSrcTestReadme() {
        FSElement[] expected = {readme, src, test};
        Directory dir = repo;
        List<FSElement> element = dir.getChildren((FSElement alphaFS_1, FSElement alphaFS_2) -> alphaFS_1.getName().compareTo(alphaFS_2.getName()));
        Assertions.assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void verifyGetSubDirectoriesForRepoAsSrcTest() {
        Directory[] expected = {src, test};
        Directory dir = repo;
        List<Directory> element = dir.getSubDirectories((FSElement alphaFS_1, FSElement alphaFS_2) -> alphaFS_1.getName().compareTo(alphaFS_2.getName()));
        Assertions.assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void verifyGetFilesForSrcAsAAndB() {
        File[] expected = {a,b};
        Directory dir = src;
        List<File> element = dir.getFiles((FSElement alphaFS_1, FSElement alphaFS_2) -> alphaFS_1.getName().compareTo(alphaFS_2.getName()));
        Assertions.assertArrayEquals(expected, element.toArray());
    }

    @Test
    public void verifyGetFilesForSrcAsNotBAndA() {
        File[] expected = {b,a};
        Directory dir = src;
        List<File> element = dir.getFiles((FSElement alphaFS_1, FSElement alphaFS_2) -> alphaFS_1.getName().compareTo(alphaFS_2.getName()));
        Assertions.assertNotEquals(expected, element.toArray());
    }
}