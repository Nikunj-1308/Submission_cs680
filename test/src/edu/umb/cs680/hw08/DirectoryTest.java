package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DirectoryTest {
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

    private String[] dirToStringArray(Directory d) {
        Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
        String[] dirInfo = { d.getName(), Integer.toString(d.getSize()),
                optionalDirectory.isPresent() ? d.getParent().getName() : null };
        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityRepoAsRepoZeroNull() {
        String expected[] = { "repo", "0", null };
        String[] actual = dirToStringArray(repo);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualitySrcAsSrcZeroRepo() {
        String[] expected = { "src", "0", "repo" };
        String[] actual = dirToStringArray(src);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityTestAsTestZeroRepo() {
        String expected[] = { "test", "0", "repo" };
        String[] actual = dirToStringArray(test);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityTestSrcAsSrcZeroTest() {
        String expected[] = { "src", "0", "test" };
        String[] actual = dirToStringArray(srcTest);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyRepoAsADirectory() {      
        Assertions.assertTrue(repo.isDirectory());
    }

    @Test   
    public void verifySrcAsADirectory() {        
        Assertions.assertTrue(src.isDirectory());
    }

    @Test
    public void verifyTestAsADirectory() {      
        Assertions.assertTrue(test.isDirectory());
    }

    @Test
    public void verifySrcTestAsADirectory() {  
        Assertions.assertTrue(srcTest.isDirectory());
    }

    
    @Test
    public void verifyCountFilesInRepoAs3() {
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
    public void verifyCountFilesInTestSrcAs3() {
        int expected = 3;
        Assertions.assertEquals(expected, srcTest.countChildren());
    }
}