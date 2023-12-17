package edu.umb.cs680.hw07;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DirectoryTest {
    static LocalDateTime localTime = LocalDateTime.now();

    static Directory repo;

    static Directory src;
    static File a;
    static File b;

    static Directory test;
    static Directory srcTest;
    static File aTest;
    static File bTest;

    static File readme;

    @BeforeAll
    static void setUpFileSystemStructureBeforeTest() {
        repo = new Directory(null, "repo", 0, localTime);

        src = new Directory(repo, "src", 0, localTime);
        a = new File(src, "A.java", 1, localTime);
        b = new File(src, "B.java", 1, localTime);

        test = new Directory(repo, "test", 0, localTime);
        srcTest = new Directory(test, "src", 0, localTime);
        aTest = new File(srcTest, "ATest.java", 1, localTime);
        bTest = new File(srcTest, "BTest.java", 1, localTime);

        readme = new File(repo, "readme.md", 1, localTime);
    }

    private String[] dirToStringArray(Directory d) { // Converts Directory details to String
        Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
        String[] dirInfo = { d.getName(), Integer.toString(d.getSize()),
                optionalDirectory.isPresent() ? d.getParent().getName() : null };
        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityRepo() {
        String expected[] = { "repo", "0", null };
        String[] actual = dirToStringArray(repo);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualitySrc() {
        String[] expected = { "src", "0", "repo" };
        String[] actual = dirToStringArray(src);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityTest() {
        String expected[] = { "test", "0", "repo" };
        String[] actual = dirToStringArray(test);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityTestSrc() {
        String expected[] = { "src", "0", "test" };
        String[] actual = dirToStringArray(srcTest);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyRepoAsADirectory() {       //Check if its a directory
        Assertions.assertTrue(repo.isDirectory());
    }

    @Test   
    public void verifySrcAsADirectory() {        //Check if Src Directory instances as directories
        Assertions.assertTrue(src.isDirectory());
    }

    @Test
    public void verifyTestAsADirectory() {       //Check if test Directory instances as directories
        Assertions.assertTrue(test.isDirectory());
    }

    @Test
    public void verifySrcTestAsADirectory() {    //Check if Src under Test Directory instances as directories
        Assertions.assertTrue(srcTest.isDirectory());
    }

    @Test
    public void verifyCountFilesInRepoAs3() {          // Count the number of child nodes
        int expected = 3;
        Assertions.assertEquals(expected, repo.countChildren());
    }

    @Test
    public void verifyCountFilesInSrcAs2() {
        int expected = 2;
        Assertions.assertEquals(expected, src.countChildren());
    }

    @Test
    public void verifyCountFilesInTestAs1() {
        int expected = 1;
        Assertions.assertEquals(expected, test.countChildren());
    }

    @Test
    public void verifyCountFilesInTestSrcAs2() {
        int expected = 2;
        Assertions.assertEquals(expected, srcTest.countChildren());
    }
}