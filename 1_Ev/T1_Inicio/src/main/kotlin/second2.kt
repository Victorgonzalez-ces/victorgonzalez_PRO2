var nombre: String = "Borja"
    get() {
        return field
    }


var edad: Int = 39
    get() {
        return field
    }

    set(value) {
        field = field+value
    }

fun estructuraWhen(): Unit {
    var numero: Int = 7
    when(numero){
        1->{
            println("caso 1")
        }
        2->{}
        3->{}
        in 4..10 ->{println("caso 4- 10")}
        else ->{
            println("caso resto")
        }
    }
}
fun estructuraFor(): Unit{
    /*for (i in 0..10 step 1){
        println(i)
    }*/
    //(1..10).forEach{ println(it) }
    (5..20).forEachIndexed{posicion, elemento -> println("El elemento $elemento en la posicion $posicion")}

}
fun aleatorio(): Unit{
    (1..100).forEach { println("El generado es ${(0..50).random()}") }
}

fun main(args: Array<String>) {

    edad = 1
    println("El nombre guarado es $nombre $edad")
    //estructuraFor()
    //aleatorio()
    estructuraWhen()
}

fun estructuraIf(): Unit {
    var numero: Int = 6
    if (numero>0){

    }
}