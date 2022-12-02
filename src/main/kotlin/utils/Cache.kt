package utils

import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.notExists
import kotlin.io.path.readLines

private val SESSION = System.getenv("AOC_SESSION")

private val PATH = Path.of(".cache").also { path ->
    if (path.notExists()) {
        path.createDirectory()
    }
}

private const val TEST_EXTENSION = ".txt"

private const val INPUT_URL = "https://adventofcode.com/2022/day/{day}/input"

public fun input(day: Int): List<String> {
    val inputFile = PATH.resolve("$day$TEST_EXTENSION")

    if (inputFile.notExists()) {
        println("downloading day $day")
        downloadInput(inputFile, day)
    } else {
        println("loading day $day from cache")
    }

    return inputFile.readLines()
}

private fun downloadInput(path: Path, day: Int) {
    val templatedUrl = INPUT_URL.replace("{day}", day.toString())

    val conn = URL(templatedUrl)
        .openConnection()

    conn.setRequestProperty("Cookie", "session=$SESSION")

    conn.getInputStream().use { stream ->
        Files.copy(stream, path)
    }
}


