package ca.tetervak.dicecube.model

import java.lang.IllegalArgumentException
import kotlin.random.Random


// One die object, for random values from 1 to 6
class DiceCube(
    private val random: Random = Random.Default
) {

    companion object {
        const val DEFAULT_INIT_VALUE: Int = 1
    }

    var value: Int = DEFAULT_INIT_VALUE
        set(n) {
            if (n in 1..6) {
                field = n
            } else {
                throw IllegalArgumentException("Illegal die value $n")
            }
        }

    fun roll() {
        value = random.nextInt(1,7)
    }

    fun reset() {
        value = DEFAULT_INIT_VALUE
    }

    override fun toString(): String = "DiceCube(value = $value)"
}