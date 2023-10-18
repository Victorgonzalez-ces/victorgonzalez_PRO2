import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    // Establecemos la comunicación con el proceso padre
    val entradaPadre = BufferedReader(InputStreamReader(System.`in`))
    val salidaPadre = OutputStreamWriter(System.out)

    // Recibimos la pregunta del proceso padre
    val pregunta = entradaPadre.readLine()
    println("Proceso Hijo: Recibí la pregunta \"$pregunta\"")

    // Simulamos buscar el autor y sus 5 libros
    val autor = "Autor Ejemplo"
    val libros = listOf("Libro 1", "Libro 2", "Libro 3", "Libro 4", "Libro 5")

    // Enviamos la respuesta al proceso padre
    salidaPadre.write("$autor\n")
    salidaPadre.write(libros.joinToString("\n"))
    salidaPadre.flush()

    // Cerramos la comunicación
    salidaPadre.close()
    entradaPadre.close()
}