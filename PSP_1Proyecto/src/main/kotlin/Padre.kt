import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val procesoPadre = ProcessBuilder("java", "-jar", "ProcesoPadre.jar").start()
    val entradaPadre = BufferedReader(InputStreamReader(procesoPadre.inputStream))
    val salidaPadre = OutputStreamWriter(procesoPadre.outputStream)

    println("Proceso Padre: ¿Quién es el autor de tu libro favorito?")
    val libroFavorito = readLine()

    salidaPadre.write(libroFavorito + "\n")
    salidaPadre.flush()

    val respuestaHijo = entradaPadre.readLine()
    println("Proceso Padre: El autor de $libroFavorito ha escrito los siguientes 5 libros:")
    println(respuestaHijo)

    salidaPadre.close()
    entradaPadre.close()
}