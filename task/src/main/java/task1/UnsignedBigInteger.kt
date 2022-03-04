package task1

/**
 * Класс "беззнаковое большое целое число".
 *
 * Общая сложность задания -- очень сложная, общая ценность в баллах -- 32.
 * Объект класса содержит целое число без знака произвольного размера
 * и поддерживает основные операции над такими числами, а именно:
 * сложение, вычитание (при вычитании большего числа из меньшего бросается исключение),
 * умножение, деление, остаток от деления,
 * преобразование в строку/из строки, преобразование в целое/из целого,
 * сравнение на равенство и неравенство
 */

class UnsignedBigInteger(
    private val number: MutableList<UInt> = mutableListOf()
) : Comparable<UnsignedBigInteger> {

    companion object {
        private val BASE = UInt.MAX_VALUE.toULong() + 1UL

        private const val WRONG_FORMAT = "wrong number format"
        private const val OUT_OF_BOUNDS = "number is out of bounds Int"
        private const val DIVISION_BY_ZERO = "Division by zero"
        private const val CALCULATED_LESS = "Calculated less than reduced"

        private fun fromString(s: String): MutableList<UInt> {
            if (!s.matches(Regex("""\d+""")))
                throw NumberFormatException(WRONG_FORMAT)
            var res = UnsignedBigInteger(0)
            for (digit in s) {
                res *= UnsignedBigInteger(10)
                res += UnsignedBigInteger(digit.digitToInt())
            }
            return res.number
        }

        private fun fromInt(i: Int): MutableList<UInt> =
            mutableListOf<UInt>().apply { add(i.toUInt()) }

        fun max(a: UnsignedBigInteger, b: UnsignedBigInteger) =
            if (a > b) a else b

        fun min(a: UnsignedBigInteger, b: UnsignedBigInteger) =
            if (a < b) a else b

        private fun buildUnsignedBigInteger(
            action: MutableList<UInt>.() -> Unit,
            reverse: Boolean = true
        ): UnsignedBigInteger {
            val list = mutableListOf<UInt>().apply(action)
            return if (reverse) UnsignedBigInteger(list.asReversed()) else UnsignedBigInteger(list)
        }
    }

    init {
        if (number.size != 0) {
            while (number[0] == 0u && number.size != 1) {
                number.removeFirst()
            }
        }
    }

    /**
     * Конструктор из строки
     */
    constructor(s: String) : this(fromString(s))

    /**
     * Конструктор из целого
     */
    constructor(i: Int) : this(fromInt(i))

    /**
     * Сложение
     */
    operator fun plus(other: UnsignedBigInteger): UnsignedBigInteger {
        val big = max(this, other).number
        val small = min(this, other).number
        return buildUnsignedBigInteger({
            var memory = 0u
            for (i in big.lastIndex downTo 0) {
                val otherDigit = small.getOrElse(i - (big.size - small.size)) { 0u }
                val d = big[i] + otherDigit + memory
                add(d)
                memory = if (d < big[i] && memory == 0u || d <= big[i] && memory == 1u) {
                    1u
                } else {
                    0u
                }
            }
            if (memory > 0u)
                add(memory)
        })
    }

    /**
     * Вычитание (бросить ArithmeticException, если this < other)
     */
    operator fun minus(other: UnsignedBigInteger): UnsignedBigInteger =
        when {
            this < other -> throw ArithmeticException(CALCULATED_LESS)
            else ->
                buildUnsignedBigInteger({
                    var memory = 0u
                    for (i in number.lastIndex downTo 0) {
                        val otherDigit = other.number.getOrElse(i - (number.size - other.number.size)) { 0u }
                        val d = number[i] - otherDigit - memory
                        memory = if (d > number[i] && memory == 0u || d >= number[i] && memory == 1u) 1u else 0u
                        add(d)
                    }
                })
        }

    /**
     * Умножение
     */
    operator fun times(other: UnsignedBigInteger): UnsignedBigInteger {
        val big = max(this, other).number
        val small = min(this, other).number
        var result = UnsignedBigInteger(0)
        var countOfZeros = 0
        for (i in small.lastIndex downTo 0) {
            result += buildUnsignedBigInteger({
                var memory = 0u
                for (j in big.lastIndex downTo 0) {
                    val d = big[j].toULong() * small.getOrElse(i) { 0u }.toULong() + memory.toULong()
                    add((d % BASE).toUInt())
                    memory = (d / BASE).toUInt()
                }
                if (memory > 0u)
                    add(memory)
                reverse()
                repeat(countOfZeros) { add(0u) }
                countOfZeros++
            }, reverse = false)
        }
        return result
    }

    /**
     * Деление
     */
    operator fun div(other: UnsignedBigInteger): UnsignedBigInteger =
        when {
            other > this -> UnsignedBigInteger(0)
            other == UnsignedBigInteger(0) -> throw ArithmeticException(DIVISION_BY_ZERO)
            number.size == 1 && other.number.size == 1 -> UnsignedBigInteger(
                mutableListOf(number[0] / other.number[0])
            )
            else -> {
                buildUnsignedBigInteger(
                    {
                        var temporary = UnsignedBigInteger()
                        var afterFirstDivision = false
                        for (i in 0 until number.size + 1) {
                            if (temporary < other) {
                                number.getOrNull(i)?.let { temporary.number.add(it) }
                                if (afterFirstDivision)
                                    add(0u)
                            } else {
                                var minDigit = 0UL
                                var maxDigit = BASE - 1UL
                                var digit = 0u
                                while (minDigit <= maxDigit) {
                                    val middle = (minDigit + maxDigit) / 2UL
                                    val curSubtrahend = UnsignedBigInteger(mutableListOf(middle.toUInt())) * other
                                    if (curSubtrahend < temporary) {
                                        digit = middle.toUInt()
                                        minDigit = middle + 1UL
                                    } else if (curSubtrahend == temporary) {
                                        digit = middle.toUInt()
                                        break
                                    } else {
                                        maxDigit = middle - 1UL
                                    }
                                }
                                val subtrahend = UnsignedBigInteger(mutableListOf(digit)) * other
                                temporary -= subtrahend
                                if (temporary == UnsignedBigInteger(mutableListOf(0u)))
                                    temporary.number.clear()
                                add(digit)
                                number.getOrNull(i)?.let { temporary.number.add(it) }
                                afterFirstDivision = true
                            }
                        }
                    }, reverse = false
                )
            }
        }


    /**
     * Взятие остатка
     */
    operator fun rem(other: UnsignedBigInteger): UnsignedBigInteger = this - this / other * other

    /**
     * Сравнение на равенство (по контракту Any.equals)
     */
    override fun equals(other: Any?): Boolean = other is UnsignedBigInteger && this.compareTo(other) == 0

    /**
     * Сравнение на больше/меньше (по контракту Comparable.compareTo)
     */
    override fun compareTo(other: UnsignedBigInteger): Int {
        when {
            number.size > other.number.size -> return 1
            number.size < other.number.size -> return -1
            else -> {
                number.forEachIndexed { index, digit ->
                    if (digit > other.number[index]) return 1
                    if (digit < other.number[index]) return -1
                }
            }
        }
        return 0
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String =
        buildString {
            var temp = this@UnsignedBigInteger
            if (temp == UnsignedBigInteger(0))
                append("0")
            while (temp != UnsignedBigInteger(0)) {
                append((temp % UnsignedBigInteger(10)).number[0])
                temp /= UnsignedBigInteger(10)
            }
        }.reversed()

    /**
     * Преобразование в целое
     * Если число не влезает в диапазон Int, бросить ArithmeticException
     */
    fun toInt(): Int = this.toString().toIntOrNull() ?: throw ArithmeticException(OUT_OF_BOUNDS)

    override fun hashCode(): Int = number.hashCode()
}