package ca.tetervak.dicecube

import ca.tetervak.dicecube.model.DiceCube
import kotlin.random.Random

fun main() {
    val cube1 = DiceCube()
    cube1.roll()

    println("value1 = ${cube1.value}")
    println("cube1 = $cube1")

    repeat(5) {
        cube1.roll()
        println("value1 = ${cube1.value}")
    }

    // providing the seed value makes the roll value sequence always the same
    println("Using the seed value")
    val random2 = Random(12)
    val cube2 = DiceCube(random2)
    repeat(5) {
        cube2.roll()
        println("value = ${cube2.value}")
    }

    println("Using 'run':")
    cube1.run {
        reset()
        roll()
    }
    println("cube1 = $cube1")
    println("value2 = " + cube1.run { reset(); roll(); value})

    // Scope function demos

    println("Using 'with':")
    with(cube1) {
        reset()
        roll()
    }
    println("cube1 = $cube1")
    println("value2 = " + with(cube1) { reset(); roll(); value})

    println("Using 'let':")
    cube1.let {
        it.reset()
        it.roll()
    }
    println("cube1 = $cube1")
    println("value2 = " + cube1.let { it.reset(); it.roll(); it.value})

    println("Using 'apply':")
    cube1.apply {
        reset()
        roll()
    }
    println("cube1 = $cube1")
    println("cube1 = " + cube1.apply { reset(); roll()})

    println("Using 'also':")
    cube1.also {
        it.reset()
        it.roll()
    }
    println("cube1 = $cube1")
    println("cube1 = " + cube1.also { it.reset(); it.roll()})

}