package Contexts

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BinaryDetectorTest {

    @Test
    fun detect1() {
        val detector = BinaryDetector()
        assertTrue(detector.detect("1"))
    }

    @Test
    fun detect11() {
        val detector = BinaryDetector()
        assertTrue(detector.detect("11"))
    }

    @Test
    fun detect101() {
        val detector = BinaryDetector()
        assertTrue(detector.detect("101"))
    }

    @Test
    fun detect111111() {
        val detector = BinaryDetector()
        assertTrue(detector.detect("111111"))
    }

    @Test
    fun detect10011010001() {
        val detector = BinaryDetector()
        assertTrue(detector.detect("10011010001"))
    }

    @Test
    fun detect01() {
        val detector = BinaryDetector()
        assertFalse(detector.detect("01"))
    }

    @Test
    fun detect10() {
        val detector = BinaryDetector()
        assertFalse(detector.detect("10"))
    }

    @Test
    fun detect1000010() {
        val detector = BinaryDetector()
        assertFalse(detector.detect("1000010"))
    }

    @Test
    fun detect100a01() {
        val detector = BinaryDetector()
        assertFalse(detector.detect("100a01"))
    }
}