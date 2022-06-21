package Contexts

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IntegerDetectorTest {

//    @Test
//    fun getState() {
//    }

    @Test
    fun detect123() {
        val detector = IntegerDetector()
        val result = detector.detect("123")
        assertEquals(true, result)
    }

    @Test
    fun detect1() {
        val detector = IntegerDetector()
        val result = detector.detect("1")
        assertEquals(true, result)
    }

    @Test
    fun detect345345() {
        val detector = IntegerDetector()
        val result = detector.detect("345345")
        assertEquals(true, result)
    }

    @Test
    fun detectEmptyString() {
        val detector = IntegerDetector()
        val result = detector.detect("")
        assertEquals(false, result)
    }

    @Test
    fun detect0123() {
        val detector = IntegerDetector()
        val result = detector.detect("0123")
        assertEquals(false, result)
    }

    @Test
    fun detect132a() {
        val detector = IntegerDetector()
        val result = detector.detect("132a")
        assertEquals(false, result)
    }

    @Test
    fun detect0() {
        val detector = IntegerDetector()
        val result = detector.detect("0")
        assertEquals(false, result)
    }
}