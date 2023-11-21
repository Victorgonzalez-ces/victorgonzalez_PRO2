import java.io.File
import java.io.PrintWriter
import java.util.concurrent.CountDownLatch
import kotlin.concurrent.thread

class Hilos {
    var mensajes: ArrayList<String> = ArrayList()

    fun enviarMensaje(mensaje: String) {
        synchronized(this) {
            mensajes.add(mensaje)
        }
    }

    fun recibirMensaje() {
        synchronized(this) {
            for (mensaj in mensajes){
                println("Mensaje recibido: $mensaj")
                Thread.sleep(1000)
            }
        }
    }
}

fun main() {
    val hilo = Hilos()
    val latch = CountDownLatch(1)
    val hiloEnviar = thread {
        println("Ingrese mensajes (escriba fin para finalizar) : ")
        var mensaje = ""

        while (mensaje != "fin") {
            mensaje = readln()
            hilo.enviarMensaje(mensaje)
            Thread.sleep(1000)
        }
        latch.countDown()
    }

    val hiloRecibir = thread {
        latch.await()
        hilo.recibirMensaje()
        var letrasTotales = 0
        val archivo = File("mensaje.txt")
        PrintWriter(archivo).use { writer ->
            for (palabra in hilo.mensajes){
                writer.println("El numero de caracteres de la frase $palabra es de = ${palabra.length}")
                letrasTotales+=palabra.length
            }
            writer.println("El número de carácteres totales es de: $letrasTotales")
        }

        val procesoBuilder = ProcessBuilder("notepad.exe", "mensaje.txt")
        val proceso = procesoBuilder.start()
        proceso.waitFor()
    }
    hiloEnviar.join()
    hiloRecibir.join()
}