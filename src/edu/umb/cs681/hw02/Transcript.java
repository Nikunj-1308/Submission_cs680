package edu.umb.cs681.hw02;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Transcript {
	private final Map<String, String> transcript;

	public Transcript() {
		transcript = new HashMap<>();
	}

	public void addToTranscript(String courseCode, String grade) {
		transcript.put(courseCode, grade);
	}

	public double calculateUndergraduateGPA() {
		return calculateGPA(true);
	}

	public double calculateGraduateGPA() {
		return calculateGPA(false);
	}

	public String getMajor() {
		Map<String, Long> majorFreqMap = transcript.keySet().stream()
				.filter(this::isUndergraduate) // Filter out only undergraduate courses
				.map(courseCode -> courseCode.substring(0, 2)) // Extract first two characters
				.collect(Collectors.groupingBy(major -> major, Collectors.counting()));

		// Find the major(s) with the highest frequency
		long maxFrequency = majorFreqMap.values().stream().max(Long::compare).orElse(0L);
		return majorFreqMap.entrySet().stream()
				.filter(entry -> entry.getValue() == maxFrequency)
				.map(Map.Entry::getKey)
				.findFirst()
				.orElseThrow(); // If no major is found, throw an exception
	}

	public Map<String, Double> calculateMajorUndergradGPA() {
		String major = getMajor(); // Determine the major

		return transcript.keySet().stream()
				.filter(courseCode -> courseCode.startsWith(major)) // Filter courses by major
				.collect(Collectors.groupingBy(courseCode -> major, // Group courses by major
						Collectors.averagingDouble(courseCode -> gradeToPoint(transcript.get(courseCode))))); // Calculate
																												// GPA
	}

	// Method to calculate GPA
	private double calculateGPA(boolean isUndergraduate) {
		return transcript.entrySet().stream()
				.filter(entry -> isUndergraduate == isUndergraduate(entry.getKey()))
				.collect(Collectors.averagingDouble(entry -> gradeToPoint(entry.getValue())));
	}

	// Helper method to check if the course is undergraduate
	public boolean isUndergraduate(String courseCode) {
		return courseCode.charAt(2) == '4'; // Assuming undergraduate courses start with "CS6"
	}

	// Helper method to extract major from the course code
	public String getMajor(String courseCode) {
		return courseCode.substring(0, 2); // Assuming major is represented by the third and fourth characters of the
											// course code
	}

	public void coursesToImproveForSummaCumLaude() {
		double targetGPA = 3.9; // GPA threshold for Summa cum laude
		double originalGPA = calculateUndergraduateGPA(); // Calculate original GPA

		// Filter courses where the grade is not "A"
		long countNonA = transcript.entrySet().stream()
				.filter(entry -> !entry.getValue().equals("A"))
				.count();

		if (countNonA == 0.0) {
			System.out.println("No courses need improvement for Summa cum laude.");
			return;
		}

		// Iterate over courses where improvement is needed
		transcript.entrySet().stream()
				.filter(entry -> !entry.getValue().equals("A"))
				.forEach(entry -> {
					String courseCode = entry.getKey();
					String grade = entry.getValue();
					double gradePoint = gradeToPoint(grade);
					double improvement = gradeToPoint("A") - gradePoint; // Calculate improvement if an "A" grade was
																			// obtained
					double newGPA = (originalGPA * transcript.size() + improvement) / transcript.size(); // Calculate
																											// new GPA

					// Check if new GPA meets the threshold for Summa cum laude
					if (newGPA >= targetGPA) {
						System.out.println("To achieve Summa cum laude, improve in course: " + courseCode);
					}
				});
	}

	// Helper method to convert grade to point
	private double gradeToPoint(String grade) {
		switch (grade) {
			case "A":
				return 4.0;
			case "B":
				return 3.0;
			case "C":
				return 2.0;
			case "D":
				return 1.0;
			default:
				return 0.0;
		}
	}

	// Add any additional methods for extra data processing
}
