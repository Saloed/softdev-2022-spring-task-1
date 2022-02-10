package task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

internal class UnsignedBigIntegerTest {

    @Test
    @Tag("8")
    fun plus() {
        assertEquals(UnsignedBigInteger(4), UnsignedBigInteger(2) + UnsignedBigInteger(2))
        assertEquals(
            UnsignedBigInteger(mutableListOf(9u, 0u, 8u, 7u, 6u, 5u, 4u, 3u, 2u, 10u)),
            UnsignedBigInteger("9087654329") + UnsignedBigInteger(1)
        )
    }

    @Test
    @Tag("8")
    fun minus() {
        assertEquals(UnsignedBigInteger(2), UnsignedBigInteger(4) - UnsignedBigInteger(2))
        assertEquals(UnsignedBigInteger("233200"), UnsignedBigInteger("235544") - UnsignedBigInteger("2344"))
        assertThrows(ArithmeticException::class.java) {
            UnsignedBigInteger(2) - UnsignedBigInteger(4)
        }
    }

    @Test
    @Tag("12")
    fun times() {
        assertEquals(
            UnsignedBigInteger("5"),
            UnsignedBigInteger("1") * UnsignedBigInteger("5")
        )
        assertEquals(UnsignedBigInteger(mutableListOf(7u, 14u)), UnsignedBigInteger("7") * UnsignedBigInteger("12"))
        assertEquals(
            UnsignedBigInteger(mutableListOf(1u, UInt.MAX_VALUE - 1u)),
            UnsignedBigInteger(mutableListOf(UInt.MAX_VALUE)) * UnsignedBigInteger(2)
        ) // (верхние два проходят, потому что там мы не выходим за границы системы счисления). Здесь мы вышли за границы и нужно добавлять в memory полученное число / base, но не понятно как это сделать не нарушив типы данных
    }

    @Test
    @Tag("16")
    fun div() {
        assertEquals(
            UnsignedBigInteger("11"), UnsignedBigInteger("23") / UnsignedBigInteger("2")
        )
        // деление работает, но очень медленно. на этом примере можно убедиться что действительно работает, но не пойму как оптимизировать правильно работу
    }

    @Test
    @Tag("16")
    fun rem() {
        assertEquals(UnsignedBigInteger(0), UnsignedBigInteger(20) % UnsignedBigInteger(2)) // то же самое, из-за деления работает медленно
    }

    @Test
    @Tag("8")
    fun equals() {
        assertEquals(UnsignedBigInteger(123456789), UnsignedBigInteger("123456789"))
    }

    @Test
    @Tag("8")
    fun compareTo() {
        assertTrue(UnsignedBigInteger(123456789) < UnsignedBigInteger("9876543210"))
        assertTrue(UnsignedBigInteger("9876543210") > UnsignedBigInteger(123456789))
        assertTrue(UnsignedBigInteger(mutableListOf(1u, 23u)) < UnsignedBigInteger(mutableListOf(1u, 2u, 3u)))
    }

    @Test
    @Tag("8")
    fun toInt() {
        assertEquals(123456789, UnsignedBigInteger("123456789").toInt())
        assertThrows(ArithmeticException::class.java){UnsignedBigInteger("29399034899349349938493392932893").toInt()}
    }
}