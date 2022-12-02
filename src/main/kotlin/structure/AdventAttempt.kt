package structure

import utils.input

public abstract class AdventAttempt(
    private val day: Int
) {

    public abstract fun partOne(data: List<String>)

    public abstract fun partTwo(data: List<String>)

    public fun run() {
        val input = input(day)

        println(input)

        partOne(input)
        partTwo(input)
    }

}