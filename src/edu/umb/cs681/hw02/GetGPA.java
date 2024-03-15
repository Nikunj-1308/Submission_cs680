package edu.umb.cs681.hw02;

import java.util.Map;

public class GetGPA {
    public static void main(String[] args) {
        Transcript transcript = new Transcript();
        transcript.addToTranscript("MT400", "A");
        transcript.addToTranscript("MT410", "A");
        transcript.addToTranscript("CS401", "B");
        transcript.addToTranscript("MT480", "A");
        transcript.addToTranscript("CS682", "A");
        transcript.addToTranscript("CS683", "A");

        System.out.println("Undergraduate:");
        System.out.println("GPA: " + transcript.calculateUndergraduateGPA());
        Map<String, Double> majorUndergradGPA = transcript.calculateMajorUndergradGPA();
        majorUndergradGPA.forEach((major, gpa) -> System.out.println("Major: " + major + ", GPA: " + gpa));
        System.out.println();
        System.out.println("Graduate GPA: " + transcript.calculateGraduateGPA());

        transcript.coursesToImproveForSummaCumLaude();
    }
}
