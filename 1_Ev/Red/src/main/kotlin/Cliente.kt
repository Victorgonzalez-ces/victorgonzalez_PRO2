import java.lang.Exception
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
fun main() {
    try{
        val conexion = DatagramSocket()
        val mensaje = "hola servidor UDP"
        val mensajeByte = mensaje.toByteArray()
        val ip = InetAddress.getByName("127.0.0.1")
        val buffer = ByteArray(1024)
        val paquete = DatagramPacket(mensajeByte,mensajeByte.size,ip,6000)
        conexion.send(paquete)

        val paquet = DatagramPacket(buffer,buffer.size)
        conexion.receive(paquet)
        println(String(paquet.data,0,paquet.length))
    }catch (e: Exception){
        e.printStackTrace()
    }
}