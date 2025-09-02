package ca.tetervak.dicecube.model

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class DiceCubeTest {
    private val random: Random = Random(seed = 3)
    private val diceCube: DiceCube = DiceCube(random = random)

    @Before
    fun setUp() {
        println("--- testing case ---")
    }

    @After
    fun tearDown() {
        println("--- ------- ---- ---")
    }

    @Test
    fun setValue_Valid() {
        println("set value 3")
        diceCube.value = 3
        println("diceCube = $diceCube")
        assertEquals(3, diceCube.value)
    }

    @Test
    fun setValue_Illegal() {
        println("set value 0, check throwing exception")
        assertThrows(IllegalArgumentException::class.java) {
            diceCube.value = 0
        }
    }


    @Test
    fun roll() {
        for(repetition: Int in 1..20 ){
            print("repetition %02d ".format(repetition))
            diceCube.roll()
            val value = diceCube.value
            println("value = $value")
            assertTrue(value > 0)
            assertTrue(value <= 6)
        }
    }

    @Test
    fun reset() {
        diceCube.roll()
        println("before reset value = ${diceCube.value}")
        diceCube.reset()
        println("after reset value = ${diceCube.value}")
        assertEquals(DiceCube.DEFAULT_INIT_VALUE, diceCube.value)
    }

}