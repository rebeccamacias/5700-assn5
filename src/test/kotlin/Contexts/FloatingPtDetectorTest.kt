package Contexts

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FloatingPtDetectorTest {

    @Test
    fun detect1T() {
        val detector = FloatingPtDetector()
        val result = detector.detect("1.0")
        assertEquals(true, result)
    }

    @Test
    fun detect2T() {
        val detector = FloatingPtDetector()
        val result = detector.detect("123.34")
        assertEquals(true, result)
    }

    @Test
    fun detect3T() {
        val detector = FloatingPtDetector()
        val result = detector.detect("0.20000")
        assertEquals(true, result)
    }

    @Test
    fun detect4T() {
        val detector = FloatingPtDetector()
        val result = detector.detect("12349871234.12340981234098")
        assertEquals(true, result)
    }

    @Test
    fun detect5T() {
        val detector = FloatingPtDetector()
        val result = detector.detect(".123")
        assertEquals(true, result)
    }

    @Test
    fun detect1F() {
        val detector = FloatingPtDetector()
        val result = detector.detect("123")
        assertEquals(false, result)
    }

    @Test
    fun detect2F() {
        val detector = FloatingPtDetector()
        val result = detector.detect("123.123.")
        assertEquals(false, result)
    }

    @Test
    fun detect3F() {
        val detector = FloatingPtDetector()
        val result = detector.detect("123.02a")
        assertEquals(false, result)
    }

    @Test
    fun detect4F() {
        val detector = FloatingPtDetector()
        val result = detector.detect("123.")
        assertEquals(false, result)
    }

    @Test
    fun detect5F() {
        val detector = FloatingPtDetector()
        val result = detector.detect("012.4")
        assertEquals(false, result)
    }
}