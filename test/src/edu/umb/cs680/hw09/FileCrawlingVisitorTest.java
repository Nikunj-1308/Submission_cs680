package edu.umb.cs680.hw09;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw09.fs.*;
import edu.umb.cs680.hw09.fs.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;

class FileCrawlingVisitorTest {
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
	}

	@Test
	public void verifyFileSizeAAs5() {
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		a.accept(visitor);
		Assertions.assertEquals(visitor.getFiles().stream().count(), 1);
	}

	@Test
	public void verifyFileSizeRepoAs5() {
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		repo.accept(visitor);
		Assertions.assertEquals(visitor.getFiles().stream().count(), 5);
	}
}