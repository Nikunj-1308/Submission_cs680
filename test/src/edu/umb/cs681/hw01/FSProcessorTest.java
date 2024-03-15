package edu.umb.cs681.hw01;

import edu.umb.cs681.hw01.FileSystemProcessor;
import edu.umb.cs681.hw01.fs.*;
import edu.umb.cs681.hw01.fs.util.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LongSummaryStatistics;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FSProcessorTest {

	static LocalDateTime time = LocalDateTime.now();
	static Directory repo;
	static Directory src;
	static File a;
	static File b;
	static Directory bin;
	static File aclass;
	static File bclass;
	static Directory test;
	static Directory test_src;
	static File atest;
	static File btest;
	static Directory test_bin;
	static File atestclass;
	static File btestclass;
	static File readme;

	@BeforeAll
	static void setUpFileSystemStructureBeforeTest() {
		repo = new Directory(null, "root", 0, time);

		src = new Directory(repo, "src", 0, time);
		a = new File(src, "A.java", 1, time);
		b = new File(src, "B.java", 1, time);

		bin = new Directory(repo, "bin", 0, time);
		aclass = new File(bin, "A.class", 1, time);
		bclass = new File(bin, "B.class", 1, time);

		test = new Directory(repo, "test", 0, time);
		test_src = new Directory(test, "src", 0, time);
		atest = new File(test_src, "ATest.java", 1, time);
		btest = new File(test_src, "BTest.java", 1, time);

		test_bin = new Directory(test, "bin", 0, time);
		atestclass = new File(test_bin, "ATest.class", 1, time);
		btestclass = new File(test_bin, "BTest.class", 1, time);

		readme = new File(repo, "readme.md", 1, time);
	}

	@Test
	public void testFilesAfterForPreviousDayJavaFilesAs4() {
		LocalDateTime time = LocalDateTime.now();
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		repo.accept(visitor);

		long countAfterTime = FileSystemProcessor.filesAfter(visitor, time.minusDays(1), ".java");
		long expected = 4;

		assertEquals(expected, countAfterTime);
	}

	@Test
	public void testFilesAfterForPreviousDayClassFilesAs4() {

		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		repo.accept(visitor);

		long countAfterTime = FileSystemProcessor.filesAfter(visitor, time.minusDays(1), ".class");
		long expected = 4;

		assertEquals(expected, countAfterTime);
	}

	@Test
	public void testFilesAfterForNowDayClassFilesAs4() {

		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		repo.accept(visitor);

		long countAfterTime = FileSystemProcessor.filesAfter(visitor, time, ".class");
		long expected = 0;

		assertEquals(expected, countAfterTime);
	}

	@Test
	public void testSummaryAverageForJavaAs1() {
		// Create a mock FileCrawlingVisitor with the predefined set of files
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		repo.accept(visitor);

		// Create a FileSystemProcessor and call the summary method
		FileSystemProcessor processor = new FileSystemProcessor(visitor.files());
		Map<String, LongSummaryStatistics> summary = processor.summary(visitor);

		long expected = 1;

		// Compare the actual and expected summary statistics
		assertEquals(expected, summary.get("java").getAverage());
	}

	@Test
	public void testSummaryTotalForJavaAs4() {
		// Create a mock FileCrawlingVisitor with the predefined set of files
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		repo.accept(visitor);

		// Create a FileSystemProcessor and call the summary method
		FileSystemProcessor processor = new FileSystemProcessor(visitor.files());
		Map<String, LongSummaryStatistics> summary = processor.summary(visitor);

		long expected = 4;

		// Compare the actual and expected summary statistics
		assertEquals(expected, summary.get("java").getSum());
	}

	@Test
	public void testSummaryAverageForClassAs1() {
		// Create a mock FileCrawlingVisitor with the predefined set of files
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		repo.accept(visitor);

		// Create a FileSystemProcessor and call the summary method
		FileSystemProcessor processor = new FileSystemProcessor(visitor.files());
		Map<String, LongSummaryStatistics> summary = processor.summary(visitor);

		long expected = 1;

		// Compare the actual and expected summary statistics
		assertEquals(expected, summary.get("class").getAverage());
	}

	@Test
	public void testSummaryTotalForClassAs4() {
		// Create a mock FileCrawlingVisitor with the predefined set of files
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		repo.accept(visitor);

		// Create a FileSystemProcessor and call the summary method
		FileSystemProcessor processor = new FileSystemProcessor(visitor.files());
		Map<String, LongSummaryStatistics> summary = processor.summary(visitor);

		long expected = 4;

		// Compare the actual and expected summary statistics
		assertEquals(expected, summary.get("class").getSum());
	}
}
