package Contexts

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PasswordDetectorTest {

    @Test
    fun detect1T() {
        val passwordDetector = PasswordDetector()
        assertTrue(passwordDetector.detect("aaaaH!aa"))
    }

    @Test
    fun detect2T() {
        val passwordDetector = PasswordDetector()
        assertTrue(passwordDetector.detect("1234567*9"))
    }

    @Test
    fun detect3T() {
        val passwordDetector = PasswordDetector()
        assertTrue(passwordDetector.detect("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH"))
    }

    @Test
    fun detect1F() {
        val passwordDetector = PasswordDetector()
        assertFalse(passwordDetector.detect("a"))
    }

    @Test
    fun detect2F() {
        val passwordDetector = PasswordDetector()
        assertFalse(passwordDetector.detect("aaaaaaa!"))
    }

    @Test
    fun detect3F() {
        val passwordDetector = PasswordDetector()
        assertFalse(passwordDetector.detect("aaaHaaaaa"))
    }

    @Test
    fun detect4F() {
        val passwordDetector = PasswordDetector()
        assertFalse(passwordDetector.detect("Abbbbbbb!"))
    }
}