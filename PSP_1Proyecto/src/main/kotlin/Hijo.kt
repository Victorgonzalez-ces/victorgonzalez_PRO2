import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    // Crear el proceso hijo
    val processBuilder = ProcessBuilder("java", "-cp", ".", "HijoProceso")
    val procesoHijo = processBuilder.start()

    // Obtener el stream de salida del proceso hijo
    val inputStream = BufferedReader(InputStreamReader(procesoHijo.inputStream))

    // Leer la respuesta del proceso hijo
    val respuesta = inputStream.readLine()

    // Imprimir la respuesta del proceso hijo
    println("Padre: El hijo prefiere $respuesta")

    // Esperar a que el proceso hijo termine
    val exitCode = procesoHijo.waitFor()
    println("Padre: El proceso hijo ha terminado con código de salida $exitCode")
}
