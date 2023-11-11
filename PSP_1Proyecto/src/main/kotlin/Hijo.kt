import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val inputReader = BufferedReader(InputStreamReader(System.`in`))
    val outputWriter = OutputStreamWriter(System.out)

    val parentMessage = inputReader.readLine()

    outputWriter.write("$parentMessage\n")
    outputWriter.flush()
}