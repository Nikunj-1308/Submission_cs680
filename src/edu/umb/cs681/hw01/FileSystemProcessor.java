package edu.umb.cs681.hw01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.umb.cs681.hw01.fs.*;
import edu.umb.cs681.hw01.fs.util.FileCrawlingVisitor;

public class FileSystemProcessor {

    Stream<File> files;

    FileSystemProcessor(Stream<File> files) {
        this.files = files;
    }

    public static long filesAfter(FileCrawlingVisitor visitor, ChronoLocalDateTime<?> time, String ext) {
        long countNumberOfAfterDate = visitor.files()
                .filter(file -> file.getCreationTime().isAfter(time) && file.getName().endsWith(ext))
                .count();

        return countNumberOfAfterDate;
    }

    public Map<String, LongSummaryStatistics> summary(FileCrawlingVisitor visitor) {
        return visitor.files()
                .collect(Collectors.groupingBy(file -> getFileExtension(file.getName()),
                        Collectors.summarizingLong(File::getSize)));
    }

    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return ""; // If there's no extension, return an empty string
    }

    public static void main(String args[]) {
        LocalDateTime time = LocalDateTime.now();

        Directory repo = new Directory(null, "root", 0, time);

        Directory src = new Directory(repo, "src", 0, time);
        File a = new File(src, "A.java", 1, time);
        File b = new File(src, "B.java", 1, time);

        Directory bin = new Directory(repo, "bin", 0, time);
        File aclass = new File(bin, "A.class", 1, time);
        File bclass = new File(bin, "B.class", 1, time);

        Directory test = new Directory(repo, "test", 0, time);
        Directory test_src = new Directory(test, "src", 0, time);
        File atest = new File(test_src, "ATest.java", 1, time);
        File btest = new File(test_src, "BTest.java", 1, time);

        Directory test_bin = new Directory(test, "bin", 0, time);
        File atestclass = new File(test_bin, "ATest.class", 1, time);
        File btestclass = new File(test_bin, "BTest.class", 1, time);

        File readme = new File(repo, "readme.md", 1, time);

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        repo.accept(visitor);

        LocalDateTime time_ = LocalDateTime.of(2023, 11, 21, 15, 30);
        var fp = new FileSystemProcessor(visitor.files());

        long countFilesAfter = fp.filesAfter(visitor, time_, ".java");

        System.out.println("Number of matching java files created after 11/21/2023 15:30(24H): " + countFilesAfter);

        Map<String, LongSummaryStatistics> sumFiles = fp.summary(visitor);
        System.out.println(
                "The average size of java files in the file structure: " + sumFiles.get("java").getAverage());
        System.out
                .println("The total size of java files in the file structure: " + sumFiles.get("java").getSum());

        System.out.println(
                "The average size of java files in the file structure: " + sumFiles.get("class").getAverage());
        System.out
                .println("The total size of java files in the file structure: " + sumFiles.get("class").getSum());

    }
}
