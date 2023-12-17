package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LinkTest {
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

    private String[] LinkToStringArray(Link link) {
        String linkStr[] = { link.getName(), Integer.toString(link.getSize()), link.getParent().getName() };
        return linkStr;
    }

    @Test
    public void verifyLinkListAsRmmd0Src() {
        String expected[] = { "rm.md", "0", "src" };
        String[] actual = LinkToStringArray(linkToReadMe);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyLinkEqualityWithGetTarget() {
        File expected = readme;
        FSElement actual = linkToReadMe.getTarget();
        Assertions.assertSame(expected, actual);
    }

}