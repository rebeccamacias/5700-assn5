package Contexts

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EmailDetectorTest {

    @Test
    fun detect1T() {
        val detector = EmailDetector()
        assertTrue(detector.detect("a@b.c"))
    }

    @Test
    fun detect2T() {
        val detector = EmailDetector()
        assertTrue(detector.detect("joseph.ditton@usu.edu"))
    }

    @Test
    fun detect3T() {
        val detector = EmailDetector()
        assertTrue(detector.detect("{}*$.&$*(@*$%&.*&*"))
    }

    @Test
    fun detect1F() {
        val detector = EmailDetector()
        assertFalse(detector.detect("@b.c"))
    }

    @Test
    fun detect2F() {
        val detector = EmailDetector()
        assertFalse(detector.detect("a@b@c.com"))
    }

    @Test
    fun detect3F() {
        val detector = EmailDetector()
        assertFalse(detector.detect("a.b@b.b.c"))
    }

    @Test
    fun detect4F() {
        val detector = EmailDetector()
        assertFalse(detector.detect("joseph ditton@usu.edu"))
    }
}