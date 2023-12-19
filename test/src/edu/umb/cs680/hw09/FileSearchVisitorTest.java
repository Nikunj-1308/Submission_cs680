package edu.umb.cs680.hw09;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw09.fs.*;
import edu.umb.cs680.hw09.fs.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

class FileSearchVisitorTest {
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

    @Test
    public void verifyGetFoundFilesForBAs1() {
        int expected = 1;
        FileSearchVisitor visitor = new FileSearchVisitor("B.java");
        b.accept(visitor);
        Assertions.assertEquals(expected, visitor.getFoundFiles().size());
    }
}
