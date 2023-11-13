import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread

fun main() {
    val processBuilder = ProcessBuilder("java","-cp","C:\\Program Files\\Java\\jdk-16.0.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.3\\lib\\idea_rt.jar=51385:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.3\\bin\" -Dfile.encoding=UTF-8 -classpath C:\\Users\\victor\\Documents\\GitHub\\victorgonzalez_PRO2\\PSP_1Proyecto\\out\\production\\PSP_1Proyecto;C:\\Users\\victor\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-jdk8\\1.7.10\\kotlin-stdlib-jdk8-1.7.10.jar;C:\\Users\\victor\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\1.7.10\\kotlin-stdlib-1.7.10.jar;C:\\Users\\victor\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-common\\1.7.10\\kotlin-stdlib-common-1.7.10.jar;C:\\Users\\victor\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar;C:\\Users\\victor\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-jdk7\\1.7.10\\kotlin-stdlib-jdk7-1.7.10.jar HijoKt")
    processBuilder.redirectErrorStream(true)
    val process = processBuilder.start()

    val inputReader = BufferedReader(InputStreamReader(System.`in`))
    val outputWriter = OutputStreamWriter(process.outputStream)
    val inputChild = BufferedReader(InputStreamReader(process.inputStream))

    val dateTime = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a"))
    val childMessage = "hoy es $dateTime"

    outputWriter.write("$childMessage\n")
    outputWriter.flush()

    val responseMessage = inputChild.readLine()
    println("el mensaje del proceso hijo es: $responseMessage")

    process.waitFor()
}
