package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class FileTest {
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

	private String[] FileToStringArray(File F) {
		String file[] = { F.getName(), Integer.toString(F.getSize()), F.getParent().getName() };
		return file;
	}

	@Test
	public void verifyFileEqualityOfAAsAJava1Src() {
		String[] expected = { "A.java", "1", "src" };
		String[] actual = FileToStringArray(a);
		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyFileEqualityOfBAsBJava1Src() {
		String[] expected = { "B.java", "1", "src" };
		String[] actual = FileToStringArray(b);
		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyFileEqualityOfATestAsATestJava1Src() {
		String[] expected = { "ATest.java", "1", "src" };
		String[] actual = FileToStringArray(aTest);
		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyFileEqualityOfBTestAsBTestJava1Src() {
		String[] expected = { "BTest.java", "1", "src" };
		String[] actual = FileToStringArray(bTest);
		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyFileEqualityOfReadmeAsReadmeMd11Repo() {
		String[] expected = { "readme.md", "1", "repo" };
		String[] actual = FileToStringArray(readme);
		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	public void verifyAAsAFile() {
		Assertions.assertTrue(a.isFile());
	}

	@Test
	public void verifyBAsAFile() {
		Assertions.assertTrue(b.isFile());
	}

	@Test
	public void verifyATestAsAFile() {
		Assertions.assertTrue(aTest.isFile());
	}

	@Test
	public void verifyBTestAsAFile() {
		Assertions.assertTrue(bTest.isFile());
	}

	@Test
	public void verifyReadmeAsAFile() {
		Assertions.assertTrue(readme.isFile());
	}

	@Test
	public void verifyRepoAsNotAFile() {
		Assertions.assertFalse(repo.isFile());
	}

	@Test
	public void verifySrcAsNotAFile() {
		Assertions.assertFalse(src.isFile());
	}

	@Test
	public void verifyTestAsNotAFile() {
		Assertions.assertFalse(test.isFile());
	}

	@Test
	public void verifySrcTestAsNotAFile() {
		Assertions.assertFalse(srcTest.isFile());
	}
}