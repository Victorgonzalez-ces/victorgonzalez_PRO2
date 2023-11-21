import java.lang.Exception
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

fun main() {
    try{
        val datagrama = DatagramSocket(6000)
        val buffer = ByteArray(1024)
        val paquete = DatagramPacket(buffer,buffer.size)
        datagrama.receive(paquete)
        println(String(paquete.data,0,paquete.length))
        val respuesta = "hola cliente, como estas"
        val respuestaBuffer = respuesta.toByteArray()
        val direccion = paquete.address
        val puertorespuesta = paquete.port
        val paquet = DatagramPacket(respuestaBuffer,respuestaBuffer.size,direccion,puertorespuesta)
        datagrama.send(paquet)
    }catch (e: Exception){
        e.printStackTrace()
    }
}