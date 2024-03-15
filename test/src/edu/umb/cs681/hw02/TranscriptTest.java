package edu.umb.cs681.hw02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranscriptTest {

    private Transcript transcript;

    @BeforeEach
    public void setUp() {
        transcript = new Transcript();
        transcript.addToTranscript("MT400", "A");
        transcript.addToTranscript("CS401", "B");
        transcript.addToTranscript("MT480", "A");
        transcript.addToTranscript("CS682", "A");
        transcript.addToTranscript("CS683", "A");

    }

    @Test
    public void testCalculateUndergraduateGPA() {
        double expected = 3.6666666666666665;
        assertEquals(expected, transcript.calculateUndergraduateGPA());
    }

    @Test
    public void testCalculateGraduateGPA() {
        double expected = 4.0;
        assertEquals(expected, transcript.calculateGraduateGPA());
    }

    @Test
    public void testCalculateMajorUndergradGPA() {
        double expected = 4.0;
        Map<String, Double> majorUndergradGPA = transcript.calculateMajorUndergradGPA();
        assertEquals(expected, majorUndergradGPA.get("MT"));
    }

    @Test
    public void testGetMajor() {
        String expected = "MT";
        assertEquals(expected, transcript.getMajor());
    }

    @Test
    public void testIsUndergraduate() {
        boolean expected = true;
        assertEquals(expected, transcript.isUndergraduate("MT400"));

        expected = false;
        assertEquals(expected, transcript.isUndergraduate("CS682"));
    }
}
